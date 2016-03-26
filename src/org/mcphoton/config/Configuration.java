package org.mcphoton.config;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import org.mcphoton.config.ConfigurationSpecification.KeySpecification;

public interface Configuration {
	
	// NOTE: null values are NOT supported
	
	/**
	 * Gets a map that represents this configuration object. Any change to the map is reflected in the configuration,
	 * and vice-versa.
	 */
	Map<String, Object> asMap();
	
	boolean contains(String key);
	
	boolean containsBoolean(String key);
	
	boolean containsDouble(String key);
	
	boolean containsInt(String key);
	
	boolean containsList(String key);
	
	boolean containsLong(String key);
	
	boolean containsString(String key);
	
	boolean containsTable(String key);
	
	Object get(String key);
	
	boolean getBoolean(String key);
	
	double getDouble(String key);
	
	int getInt(String key);
	
	long getLong(String key);
	
	List<?> getList(String key);
	
	String getString(String key);
	
	Configuration getTable(String key);
	
	Optional<Configuration> getDefaults();
	
	void setDefaults(Configuration config);
	
	void set(String key, Object value);
	
	void setBoolean(String key, boolean value);
	
	void setDouble(String key, double value);
	
	void setInt(String key, int value);
	
	void setList(String key, List<?> value);
	
	void setLong(String key, long value);
	
	void setString(String key, String value);
	
	void setTable(String key, Configuration value);
	
	void readFrom(InputStream in) throws IOException;
	
	default void readFrom(File file) throws IOException {
		try (FileInputStream fis = new FileInputStream(file)) {
			readFrom(fis);
		} // fis is closed here
	}
	
	void writeTo(OutputStream out) throws IOException;
	
	default void writeTo(File file) throws IOException {
		try (FileOutputStream fos = new FileOutputStream(file)) {
			writeTo(fos);
		} // fos is closed here
	}
	
	/**
	 * Corrects this configuration based on the given one. Any key that is in <code>expectedConf</code> but not in this
	 * one will be added with the value of <code>expectedConf</code>. Any key that is present in this configuration, but
	 * not present in <code>expectedConf</code> will be removed. And any key that has not the same type as in
	 * <code>expectedConf</code>, will be set to the value of <code>expectedConf</code>.
	 * 
	 * @param expectedConf the expected configuration
	 */
	default void correct(Configuration expectedConf) {
		// Removes all unexpected keys and correct data types:
		Iterator<Entry<String, Object>> it = asMap().entrySet().iterator();
		while (it.hasNext()) {
			Entry<String, Object> currentEntry = it.next();
			if (!expectedConf.contains(currentEntry.getKey())) {
				it.remove();
			} else {
				Object expectedValue = expectedConf.get(currentEntry.getKey());
				if (!expectedValue.getClass().isAssignableFrom(currentEntry.getValue().getClass())) {
					currentEntry.setValue(expectedValue);
				}
			}
		}
		// Adds all nonexistant expected keys:
		it = expectedConf.asMap().entrySet().iterator();
		while (it.hasNext()) {
			Entry<String, Object> expectedEntry = it.next();
			if (!this.contains(expectedEntry.getKey())) {
				this.set(expectedEntry.getKey(), expectedEntry.getValue());
			}
		}
	}
	
	/**
	 * Makes this configuration conform to the given specification. Any invalid value is replaced by the specification's
	 * default value.
	 * 
	 * @param spec the specification this configuration must conform to
	 */
	default void correct(ConfigurationSpecification spec) {
		Iterator<Entry<String, Object>> it = asMap().entrySet().iterator();
		while (it.hasNext()) {
			Entry<String, Object> entry = it.next();
			Optional<KeySpecification> keySpec = spec.getSpecification(entry.getKey());
			if (!keySpec.isPresent())
				it.remove();
			else {
				if (!keySpec.get().validator.apply(entry.getValue()))
					entry.setValue(keySpec.get().defaultValue);
			}
		}
	}
	
}

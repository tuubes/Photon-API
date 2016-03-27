package org.mcphoton.config;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.Optional;
import java.util.function.BiConsumer;

/**
 * A configuration that contains key-value pairs. Configurations are thread-safe.
 * <h1>Null</h2>
 * <p>
 * Null keys or values aren't allowed. Attempting to add a null key or value to a configuration should throw an
 * Exception.
 * </p>
 * 
 * @author TheElectronWill
 * 		
 */
public interface Configuration {
	
	boolean contains(String key);
	
	boolean containsBoolean(String key);
	
	boolean containsDouble(String key);
	
	boolean containsInt(String key);
	
	boolean containsList(String key);
	
	boolean containsLong(String key);
	
	boolean containsString(String key);
	
	boolean containsTable(String key);
	
	void forEach(BiConsumer<? super String, ? super Object> action);
	
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
	 * Makes this configuration conform to the given specification. Any invalid value is replaced by the specification's
	 * default value. Any entry present in the configuration but not in the specification is removed.
	 * 
	 * @param spec the specification this configuration must conform to
	 */
	void correct(ConfigurationSpecification spec);
	
}

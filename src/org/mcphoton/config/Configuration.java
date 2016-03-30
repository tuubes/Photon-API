package org.mcphoton.config;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Function;

/**
 * A configuration that contains key-value mappings. Configurations are thread-safe.
 * <p>
 * Configuration extends {@code Map<String, Object>}, so all the Map's methods are available. But they may act in a
 * slightly different manner, especially regarding compound keys.
 * </p>
 * <h1>Compound keys</h1>
 * <p>
 * Compound keys may be used to access values that aren't directly in the first level of the Configuration. Each part is
 * separated by a dot. For example, the key "map.key1" refers to the key "key1" which is inside the map in the entry
 * "map". <code>Config = { map = { key1
 * = value1, key2 = value2} }</code>
 * </p>
 * 
 * @author TheElectronWill
 * 		
 */
public interface Configuration extends Map<String, Object> {
	/**
	 * Removes all key-value mappings from this configuration, that is, make this configuration empty.
	 */
	void clear();
	
	/**
	 * {@inheritDoc}
	 * 
	 * @param key the key (may be compound)
	 */
	Object compute(String key, BiFunction<? super String, ? super Object, ? extends Object> remappingFunction);
	
	/**
	 * {@inheritDoc}
	 * 
	 * @param key the key (may be compound)
	 */
	Object computeIfAbsent(String key, Function<? super String, ? extends Object> mappingFunction);
	
	/**
	 * {@inheritDoc}
	 * 
	 * @param key the key (may be compound)
	 */
	Object computeIfPresent(String key, BiFunction<? super String, ? super Object, ? extends Object> remappingFunction);
	
	/**
	 * Checks if the key exists and refers to a boolean value.
	 * 
	 * @param key the key key the key (may be compound)
	 * @return true if the key refers to a boolean
	 */
	boolean containsBoolean(String key);
	
	/**
	 * Checks if the key exists and refers to a double value.
	 * 
	 * @param key the key key the key (may be compound)
	 * @return true if the key refers to a double
	 */
	boolean containsDouble(String key);
	
	/**
	 * Checks if the key exists and refers to an int value.
	 * 
	 * @param key the key key the key (may be compound)
	 * @return true if the key refers to an int
	 */
	boolean containsInt(String key);
	
	/**
	 * Checks if this configuration contains a first-level key. This method is different from
	 * {@link #containsKey(String)}, because it does not support compound values, and because it accepts any Object as a
	 * parameter.
	 * 
	 * @return true if it contains this key
	 */
	boolean containsKey(Object key);
	
	/**
	 * Checks if this configuration contains the key.
	 * 
	 * @param key the key (may be compound)
	 * @return true if it contains this key
	 */
	boolean containsKey(String key);
	
	/**
	 * Checks if the key exists and refers to a List value.
	 * 
	 * @param key the key key the key (may be compound)
	 * @return true if the key refers to a list
	 */
	boolean containsList(String key);
	
	/**
	 * Checks if the key exists and refers to a long value.
	 * 
	 * @param key the key key the key (may be compound)
	 * @return true if the key refers to a long
	 */
	boolean containsLong(String key);
	
	/**
	 * Checks if the key exists and refers to a Map value.
	 * 
	 * @param key the key key the key (may be compound)
	 * @return true if the key refers to a map
	 */
	boolean containsMap(String key);
	
	/**
	 * Checks if the key exists and refers to a String value.
	 * 
	 * @param key the key key the key (may be compound)
	 * @return true if the key refers to a string
	 */
	boolean containsString(String key);
	
	/**
	 * Checks if this configuration contains a first-level mapping with the specified value. For example, if the
	 * configuration is like this: <code>Config = { map = { key1
	 * = value1, key2 = value2} }</code>, only "map" will be checked, not its content.
	 * 
	 * @return true if it contains this value
	 */
	boolean containsValue(Object value);
	
	/**
	 * Makes this configuration conform to the given specification. Any invalid value is replaced by the specification's
	 * default value. Any entry present in the configuration but not in the specification is removed. Any missing value
	 * is added, with the specification's default value.
	 * 
	 * @param spec the specification this configuration must conform to
	 * @return the number of entries modified, added and removed.
	 */
	int correct(ConfigurationSpecification spec);
	
	/**
	 * Returns a Set view of the mappings contained in the first level of this configuration.
	 * 
	 * @see {@link Map#entrySet()}
	 */
	Set<java.util.Map.Entry<String, Object>> entrySet();
	
	/**
	 * Checks if this configuration is equal to the given object. It returns true if and only if the object is an
	 * implementation of Map which contains exactly the same key-value pairs as this configuration.
	 */
	boolean equals(Object o);
	
	/**
	 * Performs the given action for each last-level entry of this configuration, that is, for each entry that doesn't
	 * refer to a <b>non-empty</b> Map value. The String passed to the BiConsumer is a compound key.
	 * <p>
	 * For example, if the config is like this: <code>Config = { map = { key1
	 * = value1, key2 = value2}, map 2 = {} }</code>, the forEach method will perform an action for "map.key1",
	 * "map.key2" and "map2", but not for "map".
	 * </p>
	 */
	void deepForEach(BiConsumer<? super String, ? super Object> action);
	
	/**
	 * Performs the given action for each first-level entry of this configuration. For example, if the config is like
	 * this: <code>Config = { map = { key1
	 * = value1, key2 = value2} }</code>, the forEach method will perform an action for "map" only, not for its content.
	 */
	void forEach(BiConsumer<? super String, ? super Object> action);
	
	/**
	 * Gets the value mapped to this first-level key. This method is different from {@link #get(String)}, because it
	 * does not support compound values, and because it accepts any Object as a parameter.
	 */
	Object get(Object key);
	
	/**
	 * Gets the value mapped to this key.
	 * 
	 * @param key the key (may be compound)
	 * @return the mapped value, or null if there is none. Note that null may also be returned if the value exists and
	 *         is null.
	 */
	Object get(String key);
	
	/**
	 * Gets the boolean value mapped to this key.
	 * 
	 * @param key the key (may be compound)
	 * @return the mapped value, converted to a boolean.
	 */
	boolean getBoolean(String key);
	
	/**
	 * Gets the double value mapped to this key.
	 * 
	 * @param key the key (may be compound)
	 * @return the mapped value, converted to a double.
	 */
	double getDouble(String key);
	
	/**
	 * Gets the int value mapped to this key.
	 * 
	 * @param key the key (may be compound)
	 * @return the mapped value, converted to an int.
	 */
	int getInt(String key);
	
	/**
	 * Gets the List value mapped to this key.
	 * 
	 * @param key the key (may be compound)
	 * @return the mapped value, converted to a List.
	 */
	List<?> getList(String key);
	
	/**
	 * Gets the long value mapped to this key.
	 * 
	 * @param key the key (may be compound)
	 * @return the mapped value, converted to a long.
	 */
	long getLong(String key);
	
	/**
	 * Gets the Map value mapped to this key.
	 * 
	 * @param key the key (may be compound)
	 * @return the mapped value, converted to a Map.
	 */
	Map<String, Object> getMap(String key);
	
	/**
	 * Gets the value mapped to this first-level key. This method is different from
	 * {@link #getOrDefault(String, Object)}, because it does not support compound values, and because it accepts any
	 * Object as a parameter.
	 */
	Object getOrDefault(Object key, Object defaultValue);
	
	/**
	 * Gets the value mapped to this key, or the default one if there is no mapped value.
	 * 
	 * @param key key the key (may be compound)
	 * @param defaultValue the default value to return if there is no mapped value
	 * @return the mapped value, or the default one if there is no mapped value.
	 */
	Object getOrDefault(String key, Object defaultValue);
	
	/**
	 * Gets the String value mapped to this key.
	 * 
	 * @param key the key (may be compound)
	 * @return the mapped value, converted to a String.
	 */
	String getString(String key);
	
	/**
	 * Checks if this configuration is empty.
	 * 
	 * @return true if it is empty, false otherwise
	 */
	boolean isEmpty();
	
	/**
	 * Returns a Set view of the keys contained in the first level of this configuration.
	 * 
	 * @see {@link Map#keySet()}
	 */
	Set<String> keySet();
	
	/**
	 * {@inheritDoc}
	 * 
	 * @param the key (may be compound)
	 */
	Object merge(String key, Object value, BiFunction<? super Object, ? super Object, ? extends Object> remappingFunction);
	
	/**
	 * Associates the specified value with the specified key in this configuration. If the configuration previously
	 * contained a mapping for the key, the old value is replaced by the specified value. If the key is a compound key,
	 * any missing Map is created. For example, if the config is empty and you do a
	 * {@code put("map1.map2.key", "String value")}, the config will be like this:<br />
	 * <code>Config = { map1 = { map2 = { key = "String value"} } }</code>
	 * 
	 * @param key the key (may be compound)
	 */
	Object put(String key, Object value);
	
	@Override
	default void putAll(Map<? extends String, ? extends Object> m) {
		// TODO Auto-generated method stub
		
	}
	
	/**
	 * {@inheritDoc}
	 * 
	 * @param key the key (may be compound)
	 */
	Object putIfAbsent(String key, Object value);
	
	/**
	 * Reads this configuration from a file. The configuration's content is replaced by the parsed content of the file.
	 */
	default void readFrom(File file) throws IOException {
		try (FileInputStream fis = new FileInputStream(file)) {
			readFrom(fis);
		} // fis is closed here
	}
	
	/**
	 * Reads this configuration from an InputStream. The configuration's content is replaced by the parsed content of
	 * the file.
	 */
	void readFrom(InputStream in) throws IOException;
	
	/**
	 * Removes the mapping for a first-level key from this configuration. This method is different from
	 * {@link #remove(String)}, because it does not support compound values, and because it accepts any Object as a
	 * parameter.
	 */
	Object remove(Object key);
	
	/**
	 * Removes the mapping for the specified first-level key from this configuration, only if it is currently mapped to
	 * the specified value. This method is different from {@link #remove(String, Object)}, because it does not support
	 * compound values, and because it accepts any Object as a parameter.
	 * 
	 * @param key the key (may be compound)
	 * @param value the value
	 * @return true if it was removed, false otherwise
	 */
	boolean remove(Object key, Object value);
	
	/**
	 * Removes the mapping for a key from this configuration.
	 * 
	 * @param key the key (may be compound)
	 * @return the value previously mapped to the key
	 */
	Object remove(String key);
	
	/**
	 * Removes the mapping for the specified key from this configuration, only if it is currently mapped to the
	 * specified value.
	 * 
	 * @param key the key (may be compound)
	 * @param value the value
	 * @return true if it was removed, false otherwise
	 */
	boolean remove(String key, Object value);
	
	/**
	 * {@inheritDoc}
	 * 
	 * @param key the key (may be compound)
	 */
	Object replace(String key, Object value);
	
	/**
	 * {@inheritDoc}
	 * 
	 * @param key the key (may be compound)
	 */
	boolean replace(String key, Object oldValue, Object newValue);
	
	/**
	 * Replaces each first-level entry's value with the result of invoking the given function on that entry until all
	 * entries have been processed or the function throws an exception
	 * 
	 * @see {@link Map#replaceAll(BiFunction)}
	 */
	void replaceAll(BiFunction<? super String, ? super Object, ? extends Object> function);
	
	/**
	 * Returns the number of first-level mappings in this configuraiton. For example, if the configuration is like this:
	 * <code>Config = { map = { key1
	 * = value1, key2 = value2} }</code>, size() returns 1 because only "map" is in the first level,
	 */
	int size();
	
	/**
	 * Returns a Collection view of the values contained in the first level of this configuration.
	 * 
	 * @see {@link Map#values()}
	 */
	Collection<Object> values();
	
	/**
	 * Writes this configuration to a file. The file's content is replaced.
	 */
	default void writeTo(File file) throws IOException {
		try (FileOutputStream fos = new FileOutputStream(file)) {
			writeTo(fos);
		} // fos is closed here
	}
	
	/**
	 * Writes this configuration to an OutputStream.
	 */
	void writeTo(OutputStream out) throws IOException;
	
}

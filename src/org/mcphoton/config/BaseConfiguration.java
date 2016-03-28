package org.mcphoton.config;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.function.BiConsumer;
import org.mcphoton.config.ConfigurationSpecification.KeySpecification;
import com.electronwill.utils.StringUtils;

/**
 * Base class for Configuration's implementation.
 * 
 * @author TheElectronWill
 * 		
 */
public abstract class BaseConfiguration implements Configuration {
	
	protected Map<String, Object> map;
	
	public BaseConfiguration() {
		this.map = new HashMap<>();
	}
	
	public BaseConfiguration(Map<String, Object> map) {
		this.map = map;
	}
	
	@Override
	public synchronized int size() {
		return map.size();
	}
	
	@Override
	public Object put(String key, Object value) {
		List<String> parts = StringUtils.split(key, '.');
		Iterator<String> it = parts.iterator();
		synchronized (this) {
			Map<String, Object> currentMap = map;
			while (it.hasNext()) {// for each part...
				String part = it.next();
				if (it.hasNext()) {// not the last part: get the inner map
					Map<String, Object> innerMap = (Map) map.get(part);
					if (innerMap == null) {
						innerMap = new HashMap<>();// create the inner map if needed
						currentMap.put(part, innerMap);
					}
					currentMap = innerMap;
				} else// last part: get the value
					return currentMap.put(part, value);
			}
		}
		return null;
	}
	
	@Override
	public synchronized void putAll(Map<? extends String, ? extends Object> m) {
		map.putAll(m);
	}
	
	@Override
	public synchronized Set<String> keySet() {
		return map.keySet();
	}
	
	@Override
	public synchronized Collection<Object> values() {
		return map.values();
	}
	
	@Override
	public synchronized Set<java.util.Map.Entry<String, Object>> entrySet() {
		return map.entrySet();
	}
	
	@Override
	public synchronized void clear() {
		map.clear();
	}
	
	@Override
	public synchronized boolean containsKey(Object key) {
		return map.containsKey(key);
	}
	
	@Override
	public boolean containsKey(String key) {
		List<String> parts = StringUtils.split(key, '.');
		Iterator<String> it = parts.iterator();
		synchronized (this) {
			Map<String, Object> currentMap = map;
			while (it.hasNext()) {
				String part = it.next();
				if (it.hasNext()) {// not the last part: check if it contains the inner map
					currentMap = (Map) map.get(part);
					if (currentMap == null)// if there is no inner map
						return false;
				} else// last part: check if it contains the value
					return currentMap.containsKey(part);
			}
		}
		return false;
	}
	
	@Override
	public boolean containsBoolean(String key) {
		return get(key) instanceof Boolean;
	}
	
	@Override
	public boolean containsDouble(String key) {
		return get(key) instanceof Double;
	}
	
	@Override
	public boolean containsInt(String key) {
		return get(key) instanceof Integer;
	}
	
	@Override
	public boolean containsList(String key) {
		return get(key) instanceof List;
	}
	
	@Override
	public boolean containsLong(String key) {
		return get(key) instanceof Long;
	}
	
	@Override
	public boolean containsString(String key) {
		return get(key) instanceof String;
	}
	
	@Override
	public boolean containsMap(String key) {
		return get(key) instanceof Map;
	}
	
	@Override
	public synchronized boolean containsValue(Object value) {
		return map.containsValue(value);
	}
	
	@Override
	public synchronized int correct(ConfigurationSpecification spec) {
		return correct(map, spec, new LinkedList<>(), new StringBuilder());
	}
	
	protected int correct(Map<String, Object> map, ConfigurationSpecification spec, LinkedList<String> keyParts, StringBuilder keyBuilder) {
		int modCount = 0;
		Iterator<Entry<String, Object>> it = map.entrySet().iterator();
		while (it.hasNext()) {
			Entry<String, Object> entry = it.next();
			String key = entry.getKey();
			Object value = entry.getValue();
			keyParts.addLast(key);
			if (value instanceof Map && !((Map) value).isEmpty()) {// intermediate level entry
				Map<String, Object> valueMap = (Map) value;
				modCount += correct(valueMap, spec, keyParts, keyBuilder);
				if (valueMap.isEmpty())// empty useless map
					it.remove();
			} else {// last-level entry
				String compoundKey = buildCompoundKeyName(keyParts, keyBuilder);
				Optional<KeySpecification> optKeySpec = spec.getSpecification(compoundKey);
				if (optKeySpec.isPresent()) {// specified key -> check
					KeySpecification keySpec = optKeySpec.get();
					if (!keySpec.validator.apply(value)) {// invalid value -> set to default
						entry.setValue(keySpec.defaultValue);
						modCount++;
					}
				} else {// unspecified key -> remove
					it.remove();
					modCount++;
				}
			}
			keyParts.removeLast();
		}
		return modCount;
	}
	
	@Override
	public synchronized void forEach(BiConsumer<? super String, ? super Object> action) {
		map.forEach(action);
	}
	
	@Override
	public synchronized void deepForEach(BiConsumer<? super String, ? super Object> action) {
		deepForEach(map, action, new LinkedList<>(), new StringBuilder());
	}
	
	protected void deepForEach(Map<String, Object> map, BiConsumer<? super String, ? super Object> action, LinkedList<String> keyParts,
			StringBuilder keyBuilder) {
		for (Entry<String, Object> entry : map.entrySet()) {
			String key = entry.getKey();
			Object value = entry.getValue();
			if (value instanceof Map && !((Map) value).isEmpty()) {// intermediate level entry
				keyParts.addLast(key);
				deepForEach((Map) value, action, keyParts, keyBuilder);
				keyParts.removeLast();
			} else {// last-level entry
				String compoundKey = buildCompoundKeyName(keyParts, keyBuilder);
				action.accept(compoundKey, value);
			}
		}
	}
	
	protected String buildCompoundKeyName(LinkedList<String> keyParts, StringBuilder keyBuilder) {
		keyBuilder.setLength(0);
		Iterator<String> it = keyParts.iterator();
		while (it.hasNext()) {
			String keyPart = it.next();
			keyBuilder.append(keyPart);
			if (it.hasNext())
				keyBuilder.append('.');
		}
		return keyBuilder.toString();
	}
	
	@Override
	public synchronized Object get(Object key) {
		return map.get(key);
	}
	
	@Override
	public Object get(String key) {
		List<String> parts = StringUtils.split(key, '.');
		Iterator<String> it = parts.iterator();
		synchronized (this) {
			Map<String, Object> currentMap = map;
			while (it.hasNext()) {
				String part = it.next();
				if (it.hasNext()) {// not the last part: get the inner map
					currentMap = (Map) map.get(part);
					if (currentMap == null)// if there is no inner map
						return null;
				} else// last part: get the value
					return currentMap.get(part);
			}
		}
		return null;
	}
	
	@Override
	public synchronized Object getOrDefault(Object key, Object defaultValue) {
		return map.getOrDefault(key, defaultValue);
	}
	
	@Override
	public Object getOrDefault(String key, Object defaultValue) {
		List<String> parts = StringUtils.split(key, '.');
		Iterator<String> it = parts.iterator();
		synchronized (this) {
			Map<String, Object> currentMap = map;
			while (it.hasNext()) {
				String part = it.next();
				if (it.hasNext()) {// not the last part: get the inner map
					currentMap = (Map) map.get(part);
					if (currentMap == null)// if there is no inner map
						return defaultValue;
				} else {// last part: get the value
					return currentMap.getOrDefault(part, defaultValue);
				}
			}
		}
		return defaultValue;
	}
	
	@Override
	public boolean getBoolean(String key) {
		return (boolean) get(key);
	}
	
	@Override
	public double getDouble(String key) {
		return (double) get(key);
	}
	
	@Override
	public int getInt(String key) {
		return (int) get(key);
	}
	
	@Override
	public List<?> getList(String key) {
		return (List) get(key);
	}
	
	@Override
	public long getLong(String key) {
		return (long) get(key);
	}
	
	@Override
	public String getString(String key) {
		return (String) get(key);
	}
	
	@Override
	public Map<String, Object> getMap(String key) {
		return (Map) get(key);
	}
	
	@Override
	public synchronized boolean isEmpty() {
		return map.isEmpty();
	}
	
	@Override
	public synchronized Object remove(Object key) {
		return map.remove(key);
	}
	
	@Override
	public Object remove(String key) {
		List<String> parts = StringUtils.split(key, '.');
		Iterator<String> it = parts.iterator();
		synchronized (this) {
			Map<String, Object> currentMap = map;
			while (it.hasNext()) {
				String part = it.next();
				if (it.hasNext()) {// not the last part: get the inner map
					currentMap = (Map) map.get(part);
					if (currentMap == null)// if there is no inner map
						return null;
				} else {// last part: remove the value
					return currentMap.remove(part);
				}
			}
		}
		return null;
	}
	
	@Override
	public synchronized boolean remove(Object key, Object value) {
		return map.remove(key, value);
	}
	
	@Override
	public boolean remove(String key, Object value) {
		List<String> parts = StringUtils.split(key, '.');
		Iterator<String> it = parts.iterator();
		synchronized (this) {
			Map<String, Object> currentMap = map;
			while (it.hasNext()) {
				String part = it.next();
				if (it.hasNext()) {// not the last part: get the inner map
					currentMap = (Map) map.get(part);
					if (currentMap == null)// if there is no inner map
						return false;
				} else {// last part: remove the value
					return currentMap.remove(part, value);
				}
			}
		}
		return false;
	}
	
	@Override
	public String toString() {
		return "Configuration: " + map.toString();
	}
	
}

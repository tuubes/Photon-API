package org.mcphoton.config;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.function.BiConsumer;
import org.mcphoton.config.ConfigurationSpecification.KeySpecification;
import com.electronwill.utils.TextUtils;

/**
 * An configuration based on a simple {@code Map<String, Object>}.
 * 
 * @author TheElectronWill
 * 		
 */
public class JavaMapConfiguration implements Configuration {
	
	protected Map<String, Object> map;
	protected Optional<Configuration> defaults = Optional.empty();
	
	public JavaMapConfiguration() {
		map = new HashMap<>(4);
	}
	
	public JavaMapConfiguration(Map<String, Object> map) {
		this.map = map;
	}
	
	@Override
	public synchronized boolean contains(String key) {
		List<CharSequence> parts = new ArrayList<>(1);
		TextUtils.split(key, '.', parts);
		
		if (parts.size() == 1)
			return map.containsKey(key);
			
		Configuration currentTable = this;
		for (Iterator<CharSequence> it = parts.iterator(); it.hasNext();) {
			String part = it.next().toString();
			
			if (!it.hasNext())// last
				return currentTable.contains(part);
				
			currentTable = currentTable.getTable(part);
			if (currentTable == null)
				return false;
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
		Object value = get(key);
		if (value instanceof Long) {
			long l = (long) value;
			return (Integer.MIN_VALUE >= l) && (l <= Integer.MAX_VALUE);
		}
		return false;
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
	public boolean containsTable(String key) {
		Object value = get(key);
		return (value instanceof Map) || (value instanceof Configuration);
	}
	
	public synchronized void correct(ConfigurationSpecification spec) {
		Iterator<Entry<String, Object>> it = map.entrySet().iterator();
		while (it.hasNext()) {
			Entry<String, Object> entry = it.next();
			Optional<KeySpecification> keySpec = spec.getSpecification(entry.getKey());
			if (keySpec.isPresent()) {
				if (!keySpec.get().validator.apply(entry.getValue()))
					entry.setValue(keySpec.get().defaultValue);
			} else {
				it.remove();
			}
		}
	}
	
	@Override
	public synchronized void forEach(BiConsumer<? super String, ? super Object> action) {
		map.forEach(action);
	}
	
	@Override
	public synchronized Object get(String key) {
		List<CharSequence> parts = new ArrayList<>(1);
		TextUtils.split(key, '.', parts);
		
		if (parts.size() == 1)
			return map.get(key);
			
		Configuration currentTable = this;
		for (Iterator<CharSequence> it = parts.iterator(); it.hasNext();) {
			String part = it.next().toString();
			
			if (!it.hasNext())// last
				return currentTable.get(part);
				
			currentTable = currentTable.getTable(part);
			if (currentTable == null)
				return null;
		}
		
		return null;
	}
	
	@Override
	public synchronized void set(String key, Object value) {
		List<CharSequence> parts = new ArrayList<>(1);
		TextUtils.split(key, '.', parts);
		
		if (parts.size() == 1)
			map.put(key, value);
			
		Configuration currentTable = this;
		for (Iterator<CharSequence> it = parts.iterator(); it.hasNext();) {
			String part = it.next().toString();
			
			if (!it.hasNext())// last
				currentTable.set(part, value);
				
			Configuration innerTable = currentTable.getTable(part);
			if (innerTable == null) {
				innerTable = new TomlConfiguration();
				currentTable.set(part, innerTable);
			}
			currentTable = innerTable;
		}
	}
	
	@Override
	public synchronized Optional<Configuration> getDefaults() {
		return defaults;
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
	public Configuration getTable(String key) {
		return (Configuration) get(key);
	}
	
	@Override
	public synchronized void setDefaults(Configuration defaults) {
		this.defaults = Optional.ofNullable(defaults);
	}
	
	@Override
	public void setBoolean(String key, boolean value) {
		set(key, value);
	}
	
	@Override
	public void setDouble(String key, double value) {
		set(key, value);
	}
	
	@Override
	public void setInt(String key, int value) {
		set(key, value);
	}
	
	@Override
	public void setList(String key, List<?> value) {
		set(key, value);
	}
	
	@Override
	public void setLong(String key, long value) {
		set(key, value);
	}
	
	@Override
	public void setString(String key, String value) {
		set(key, value);
	}
	
	@Override
	public void setTable(String key, Configuration value) {
		set(key, value);
	}
	
	@Override
	public synchronized void readFrom(InputStream in) throws IOException {
		ObjectInputStream ois = new ObjectInputStream(in);
		try {
			this.map = (Map) ois.readObject();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public synchronized void writeTo(OutputStream out) throws IOException {
		ObjectOutputStream oos = new ObjectOutputStream(out);
		oos.writeObject(map);
	}
	
}

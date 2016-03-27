package org.mcphoton.config;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class JsonConfiguration implements Configuration {
	
	public JsonConfiguration() {}
	
	public JsonConfiguration(Map<String, Object> data) {
		// defined by the photon's implementation
	}
	
	@Override
	public boolean contains(String key) {
		// defined by the photon's implementation
		return false;
	}
	
	@Override
	public boolean containsBoolean(String key) {
		// defined by the photon's implementation
		return false;
	}
	
	@Override
	public boolean containsDouble(String key) {
		// defined by the photon's implementation
		return false;
	}
	
	@Override
	public boolean containsInt(String key) {
		// defined by the photon's implementation
		return false;
	}
	
	@Override
	public boolean containsList(String key) {
		// defined by the photon's implementation
		return false;
	}
	
	@Override
	public boolean containsLong(String key) {
		// defined by the photon's implementation
		return false;
	}
	
	@Override
	public boolean containsString(String key) {
		// defined by the photon's implementation
		return false;
	}
	
	@Override
	public boolean containsTable(String key) {
		// defined by the photon's implementation
		return false;
	}
	
	@Override
	public Object get(String key) {
		// defined by the photon's implementation
		return null;
	}
	
	@Override
	public void set(String key, Object value) {
		// defined by the photon's implementation
		
	}
	
	@Override
	public Optional<Configuration> getDefaults() {
		// defined by the photon's implementation
		return null;
	}
	
	@Override
	public boolean getBoolean(String key) {
		// defined by the photon's implementation
		return false;
	}
	
	@Override
	public double getDouble(String key) {
		// defined by the photon's implementation
		return 0;
	}
	
	@Override
	public int getInt(String key) {
		// defined by the photon's implementation
		return 0;
	}
	
	@Override
	public List<?> getList(String key) {
		// defined by the photon's implementation
		return null;
	}
	
	@Override
	public long getLong(String key) {
		// defined by the photon's implementation
		return 0;
	}
	
	@Override
	public String getString(String key) {
		// defined by the photon's implementation
		return null;
	}
	
	@Override
	public Configuration getTable(String key) {
		// defined by the photon's implementation
		return null;
	}
	
	@Override
	public void setDefaults(Configuration config) {
		// defined by the photon's implementation
		
	}
	
	@Override
	public void setBoolean(String key, boolean value) {
		// defined by the photon's implementation
		
	}
	
	@Override
	public void setDouble(String key, double value) {
		// defined by the photon's implementation
		
	}
	
	@Override
	public void setInt(String key, int value) {
		// defined by the photon's implementation
		
	}
	
	@Override
	public void setList(String key, List<?> value) {
		// defined by the photon's implementation
		
	}
	
	@Override
	public void setLong(String key, long value) {
		// defined by the photon's implementation
		
	}
	
	@Override
	public void setString(String key, String value) {
		// defined by the photon's implementation
		
	}
	
	@Override
	public void setTable(String key, Configuration value) {
		// defined by the photon's implementation
		
	}
	
	@Override
	public void readFrom(InputStream in) throws IOException {
		// defined by the photon's implementation
		
	}
	
	@Override
	public void writeTo(OutputStream out) throws IOException {
		// defined by the photon's implementation
	}
	
	public String writeToString() throws IOException {
		return null;
		// defined by the photon's implementation
	}
	
}

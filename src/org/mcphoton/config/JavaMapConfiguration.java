package org.mcphoton.config;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * An implementation of Configuration that is based on a simple {@code Map<String, Object>}.
 * 
 * @author TheElectronWill
 * 		
 */
public class JavaMapConfiguration implements Configuration {
	
	protected Map<String, Object> map;
	
	public JavaMapConfiguration() {
		map = new HashMap<>();
	}
	
	public JavaMapConfiguration(Map<String, Object> map) {
		this.map = map;
	}
	
	@Override
	public Map<String, Object> asMap() {
		return map;
	}
	
	@Override
	public boolean contains(String key) {
		// TODO Auto-generated method stub
		return false;
	}
	
	@Override
	public boolean containsBoolean(String key) {
		// TODO Auto-generated method stub
		return false;
	}
	
	@Override
	public boolean containsDouble(String key) {
		// TODO Auto-generated method stub
		return false;
	}
	
	@Override
	public boolean containsInt(String key) {
		// TODO Auto-generated method stub
		return false;
	}
	
	@Override
	public boolean containsList(String key) {
		// TODO Auto-generated method stub
		return false;
	}
	
	@Override
	public boolean containsLong(String key) {
		// TODO Auto-generated method stub
		return false;
	}
	
	@Override
	public boolean containsString(String key) {
		// TODO Auto-generated method stub
		return false;
	}
	
	@Override
	public boolean containsTable(String key) {
		// TODO Auto-generated method stub
		return false;
	}
	
	@Override
	public Object get(String key) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public void set(String key, Object value) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public Optional<Configuration> getDefaults() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public boolean getBoolean(String key) {
		// TODO Auto-generated method stub
		return false;
	}
	
	@Override
	public double getDouble(String key) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	@Override
	public int getInt(String key) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	@Override
	public List<?> getList(String key) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public long getLong(String key) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	@Override
	public String getString(String key) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public Configuration getTable(String key) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public void setDefaults(Configuration config) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void setBoolean(String key, boolean value) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void setDouble(String key, double value) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void setInt(String key, int value) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void setList(String key, List<?> value) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void setLong(String key, long value) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void setString(String key, String value) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void setTable(String key, Configuration value) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void readFrom(InputStream in) throws IOException {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void writeTo(OutputStream out) throws IOException {
		// TODO Auto-generated method stub
		
	}
	
}

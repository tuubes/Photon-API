package org.mcphoton.config;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.time.temporal.TemporalAccessor;
import java.util.Map;

public class TomlConfiguration extends BaseConfiguration {
	
	public TomlConfiguration() {
		// defined by the photon's implementation
	}
	
	public TomlConfiguration(Map<String, Object> map) {
		// defined by the photon's implementation
	}
	
	/**
	 * Checks if the key exists and refers to a {@link TemporalAccessor} (basically Date or DateTime) value.
	 * 
	 * @param key the key key the key (may be compound)
	 * @return true if the key refers to a Date or DateTime
	 */
	public boolean containsTemporal(String key) {
		return get(key) instanceof TemporalAccessor;
	}
	
	/**
	 * Gets the {@link TemporalAccessor} value mapped to this key.
	 * 
	 * @param key the key (may be compound)
	 * @return the mapped value, converted to a TemporalAccessor.
	 */
	public TemporalAccessor getTemporal(String key) {
		return (TemporalAccessor) get(key);
	}
	
	@Override
	public void readFrom(InputStream in) throws IOException {
		// defined by the photon's implementation
	}
	
	@Override
	public void writeTo(OutputStream out) throws IOException {
		// defined by the photon's implementation
	}
	
}

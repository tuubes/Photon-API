package org.mcphoton.config;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Map;

public class TomlConfiguration extends BaseConfiguration {
	
	public TomlConfiguration() {
		// defined by the photon's implementation
	}
	
	public TomlConfiguration(Map<String, Object> map) {
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
	
}

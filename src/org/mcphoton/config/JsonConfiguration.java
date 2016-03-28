package org.mcphoton.config;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Map;

public class JsonConfiguration extends MemoryConfiguration {
	
	public JsonConfiguration() {
		// defined by the photon's implementation
	}
	
	public JsonConfiguration(Map<String, Object> data) {
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

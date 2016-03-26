package org.mcphoton.plugin;

public interface SharedClassLoader {
	
	Class<?> findClass(String name, boolean checkShared) throws ClassNotFoundException;
	
	ClassSharer getSharer();
	
}

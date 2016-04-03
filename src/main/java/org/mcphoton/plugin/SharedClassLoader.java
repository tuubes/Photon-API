package org.mcphoton.plugin;

/**
 * @see {@link ClassSharer}
 * @author TheElectronWill
 *		
 */
public interface SharedClassLoader {
	
	Class<?> findClass(String name, boolean checkShared) throws ClassNotFoundException;
	
	ClassSharer getSharer();
	
}

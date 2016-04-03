package org.mcphoton.plugin;

/**
 * A ClassSharer allows to share java classes across the different plugins.
 * <h2>How class sharing works</h2>
 * <p>
 * A SharedClassLoader is a plugin's ClassLoader with an additional public method
 * {@link SharedClassLoader#findClass(String, boolean)}. It is associated with a ClassSharer. When asked for a class by
 * the plugin, a SharedClassFinder asks the ClassSharer via {@link #getClass(String)}. The {@link #getClass(String)}
 * method loops though all SharedClassFinder to find the corresponding class. In that way, when a plugin needs a class,
 * it may be located in another plugin. Provided that the two plugins' ClassLoaders are SharedClassFinder and have the
 * same ClassSharer, and were added to it with {@link #addClassLoader(SharedClassLoader)}.
 * </p>
 * 
 * @author TheElectronWill
 * 		
 */
public interface ClassSharer {
	
	Class<?> getClass(String name);
	
	void addClassLoader(SharedClassLoader finder);
	
	void removeClassLoader(SharedClassLoader finder);
	
}

package org.mcphoton.plugin;

import java.io.File;
import java.util.List;

/**
 * A PluginLoader loads and unloads a specific type of plugins.
 * 
 * @author TheElectronWill
 * 		
 * @param <T> the type of plugins this PluginLoader deals with
 */
public interface PluginLoader<T extends Plugin> {
	
	/**
	 * Loads a single plugin from a file. If its dependancies are not satisfied, an exception is thrown.
	 */
	T loadPlugin(File file) throws PluginLoadingException;
	
	/**
	 * Loads all the plugins from the specified files. The load order is calculated so that all dependancies (if
	 * possible) are resolved.
	 */
	List<T> loadPlugins(File[] files);
	
	/**
	 * Unloads a plugin previously loaded by this PluginLoader.
	 */
	void unloadPlugin(T plugin);
	
}

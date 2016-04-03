package org.mcphoton.plugin;

import java.io.File;
import java.util.List;

/**
 * Manages every plugin.
 * 
 * @author TheElectronWill
 */
public interface PluginsManager {
	
	Plugin getPlugin(String name);
	
	default Plugin loadPlugin(File file) throws PluginLoadingException {
		return loadPlugin(file, getDefaultPluginLoader());
	}
	
	<T extends Plugin> T loadPlugin(File file, PluginLoader<T> loader) throws PluginLoadingException;
	
	default List<Plugin> loadPlugins(File[] files) {
		return loadPlugins(files, getDefaultPluginLoader());
	}
	
	<T extends Plugin> List<T> loadPlugins(File[] files, PluginLoader<T> loader);
	
	void unloadPlugin(Plugin plugin);
	
	void unloadPlugin(String name);
	
	boolean isPluginLoaded(String name);
	
	PluginLoader getDefaultPluginLoader();
	
	void setDefaultPluginLoader(PluginLoader loader);
	
	ClassSharer getClassSharer();
	
}

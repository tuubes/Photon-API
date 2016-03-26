package org.mcphoton.plugin;

import java.io.File;
import org.slf4j.Logger;

public interface Plugin {
	
	String name();
	
	String author();
	
	String version();
	
	String dependancies();
	
	File directory();
	
	File configFile();
	
	Logger logger();
	
	/**
	 * Gets the {@link PluginLoader} that loaded this plugin.
	 */
	PluginLoader loader();
	
	/**
	 * Called when the plugin is loaded, just after its constructor is called.
	 */
	void onLoad();
	
	/**
	 * Called when the plugin is unloaded, just after it is removed from the PluginsManager.
	 */
	void onUnload();
	
}

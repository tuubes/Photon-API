package org.mcphoton.plugin;

import java.io.File;
import org.slf4j.Logger;

/**
 * A plugin that may be loaded and unloaded.
 */
public interface Plugin {

	/**
	 * Gets the plugin's name.
	 */
	String name();

	/**
	 * Gets the plugin's author(s)
	 */
	String author();

	/**
	 * Gets the plugin's version. The version should follow the principles of
	 * <a href="http://semver.org/">Semantic versioning</a>.
	 */
	String version();

	/**
	 * Gets the plugin's required dependencies. May return null if there is no dependency.
	 */
	String[] requiredDependencies();

	/**
	 * Gets the plugin's optional dependencies. May return null if there is no dependency.
	 */
	String[] optionalDependencies();

	/**
	 * Gets the directory this plugin may use to store files.
	 */
	File directory();

	/**
	 * Gets the plugin's main config file.
	 */
	File configFile();

	/**
	 * Gets the plugin's logger.
	 */
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

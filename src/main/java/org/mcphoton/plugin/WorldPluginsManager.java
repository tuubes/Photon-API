/*
 * Copyright (c) 2016 MCPhoton <http://mcphoton.org> and contributors.
 *
 * This file is part of the Photon API <https://github.com/mcphoton/Photon-API>.
 *
 * The Photon API is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * The Photon API is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>.
 */
package org.mcphoton.plugin;

import java.io.File;
import java.util.List;

/**
 * Manages plugins for one world.
 *
 * @author TheElectronWill
 */
public interface WorldPluginsManager {

	/**
	 * Gets a plugin by its name. If the plugin is not loaded by this manager, this method returns
	 * <code>null</code>. The returned plugin may be of any type (WorldPlugin, ServerPlugin, or any other
	 * Plugin implementation).
	 */
	Plugin getPlugin(String name);

	/**
	 * Loads a plugin from a file with the default plugin loader.
	 */
	default Plugin loadPlugin(File file) throws PluginLoadingException {
		return loadPlugin(file, getDefaultPluginLoader());
	}

	/**
	 * Loads a plugin from a file with the specified plugin loader.
	 */
	<T extends Plugin> T loadPlugin(File file, PluginLoader<T> loader) throws PluginLoadingException;

	/**
	 * Loads multiple plugins from multiple files, with the default plugin loader.
	 */
	default List<Plugin> loadPlugins(File[] files) {
		return loadPlugins(files, getDefaultPluginLoader());
	}

	/**
	 * Loads multiple plugins from multiple files, with the specified plugin loader.
	 */
	<T extends Plugin> List<T> loadPlugins(File[] files, PluginLoader<T> loader);

	/**
	 * Unload a plugin. If the plugin is a ServerPlugin, it isn't disabled entirely, but everything it
	 * registered in the manager's world is unregistered.
	 *
	 * @param plugin the plugin to unload.
	 */
	void unloadPlugin(Plugin plugin);

	/**
	 * Unload a plugin. If the plugin is a ServerPlugin, it isn't disabled entirely, but everything it
	 * registered in the manager's world is unregistered.
	 */
	void unloadPlugin(String name);

	/**
	 * Checks if a plugin with that name is loaded by this WorldPluginsManager.
	 */
	boolean isPluginLoaded(String name);

	/**
	 * Gets the default plugin loader.
	 */
	PluginLoader getDefaultPluginLoader();

	/**
	 * Sets the default plugin loader.
	 */
	void setDefaultPluginLoader(PluginLoader loader);

	/**
	 * Gets the ClassSharer, which is used to share Java classes across plugins of the same world.
	 */
	ClassSharer getClassSharer();

}

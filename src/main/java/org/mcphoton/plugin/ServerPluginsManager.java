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
import org.mcphoton.world.World;

/**
 * Manages ServerPlugins. It can load WorldPlugins (see the documentation of the loadPlugin methods), but can
 * only unload and get ServerPlugins.
 *
 * @author TheElectronWill
 */
public interface ServerPluginsManager {

	/**
	 * Gets a ServerPlugin by its name.
	 *
	 * @return the ServerPlugin with that name, or <code>null</code>.
	 */
	ServerPlugin getServerPlugin(String name);

	/**
	 * Loads a plugin from a file with the default plugin loader and in every server's world.
	 * <p>
	 * If the plugin is a WorldPlugin, then one instance of the plugin is created per world, and the instance
	 * assigned to the default world is returned. If the plugin is a ServerPlugin, only one instance of the
	 * plugin is created and returned.
	 * </p>
	 *
	 * @return the loaded plugin.
	 */
	default Plugin loadPlugin(File file) throws PluginLoadingException {
		return loadPlugin(file, getDefaultPluginLoader());
	}

	/**
	 * Loads a plugin from a file with the specified plugin loader and in every server's world.
	 * <p>
	 * If the plugin is a WorldPlugin, then one instance of the plugin is created per world, and the instance
	 * assigned to the default world is returned. If the plugin is a ServerPlugin, only one instance of the
	 * plugin is created and returned.
	 * </p>
	 *
	 * @return the loaded plugin.
	 */
	<T extends Plugin> T loadPlugin(File file, PluginLoader<T> loader) throws PluginLoadingException;

	/**
	 * Loads a plugin from a file with the default plugin loader and in the specified worlds.
	 * <p>
	 * If the plugin is a WorldPlugin, then one instance of the plugin is created per world, and the instance
	 * assigned to the first specified world (the first parameter) is returned. If the plugin is a
	 * ServerPlugin, only one instance of the plugin is created and returned.
	 * </p>
	 *
	 * @return the loaded plugin.
	 */
	default Plugin loadPlugin(File file, World... worlds) throws PluginLoadingException {
		return loadPlugin(file, getDefaultPluginLoader(), worlds);
	}

	/**
	 * Loads a plugin from a file with the specified plugin loader and in the specified worlds.
	 * <p>
	 * If the plugin is a WorldPlugin, then one instance of the plugin is created per world, and the instance
	 * assigned to the first specified world (the first parameter) is returned. If the plugin is a
	 * ServerPlugin, only one instance of the plugin is created and returned.
	 * </p>
	 *
	 * @return the loaded plugin.
	 */
	<T extends Plugin> T loadPlugin(File file, PluginLoader<T> loader, World... worlds) throws PluginLoadingException;

	/**
	 * Unloads a ServerPlugin completely (from all worlds).
	 */
	void unloadServerPlugin(ServerPlugin plugin);

	/**
	 * Unloads a ServerPlugin completely (from all worlds).
	 */
	void unloadServerPlugin(String name);

	/**
	 * Checks if a ServerPlugin with the specified name is loaded by this ServerPluginsManager.
	 *
	 * @return <code>true</code> if a ServerPlugin with that name is loaded, <true>false</false> otherwise.
	 */
	boolean isServerPluginLoaded(String name);

	/**
	 * Gets the current default plugin loader.
	 */
	PluginLoader getDefaultPluginLoader();

	/**
	 * Sets the default plugin loader.
	 */
	void setDefaultPluginLoader(PluginLoader<? extends Plugin> loader);

	/**
	 * Gets the class sharer used by the ServerPluginsManagers to share classes across the ServerPlugins.
	 */
	ClassSharer getClassSharer();

}

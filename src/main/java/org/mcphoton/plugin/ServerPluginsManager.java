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
 * Manages ServerPlugins.
 *
 * @author TheElectronWill
 */
public interface ServerPluginsManager {

	/**
	 * Gets a ServerPlugin by its name.
	 */
	ServerPlugin getPlugin(String name);

	/**
	 * Loads a plugin from a file with the default plugin loader. The plugin must be a ServerPlugin. The
	 * plugin is loaded in every server's world.
	 */
	default ServerPlugin loadPlugin(File file) throws PluginLoadingException {
		return loadPlugin(file, getDefaultPluginLoader());
	}

	/**
	 * Loads a plugin from a file with the specified plugin loader. The plugin must be a ServerPlugin. The
	 * plugin is loaded in every server's world.
	 */
	<T extends ServerPlugin> T loadPlugin(File file, PluginLoader<T> loader) throws PluginLoadingException;

	/**
	 * Loads a plugin from a file with the default plugin loader. The plugin must be a ServerPlugin. The
	 * plugin is loaded in every specified world.
	 */
	default Plugin loadPlugin(File file, World... worlds) throws PluginLoadingException {
		return loadPlugin(file, getDefaultPluginLoader(), worlds);
	}

	/**
	 * Loads a plugin from a file with the specified plugin loader. The plugin must be a ServerPlugin. The
	 * plugin is loaded in every specified world.
	 */
	<T extends ServerPlugin> T loadPlugin(File file, PluginLoader<T> loader, World... worlds) throws PluginLoadingException;

	/**
	 * Unloads a ServerPlugin completely (from all worlds).
	 */
	void unloadPlugin(ServerPlugin plugin);

	/**
	 * Unloads a ServerPlugin completely (from all worlds).
	 */
	void unloadPlugin(String name);

	/**
	 * Checks if a ServerPlugin with that name is loaded by this ServerPluginsManager.
	 */
	boolean isPluginLoaded(String name);

	/**
	 * Gets the default plugin loader.
	 */
	PluginLoader<? extends ServerPlugin> getDefaultPluginLoader();

	/**
	 * Sets the default plugin loader.
	 */
	void setDefaultPluginLoader(PluginLoader<? extends ServerPlugin> loader);

	ClassSharer getClassSharer();

}

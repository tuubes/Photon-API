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

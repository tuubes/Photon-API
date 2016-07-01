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

import com.electronwill.utils.Constant;
import java.io.File;
import java.util.Collection;
import org.mcphoton.Photon;
import org.mcphoton.world.World;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A ServerPlugin is loaded for the entire server (unlike a WorldPlugin).
 *
 * @author TheElectronWill
 */
public abstract class ServerPlugin implements Plugin {

	protected final Logger logger = LoggerFactory.getLogger(getName());
	private final File directory = new File(Photon.getPluginsDirectory(), getName());
	private final File configFile = new File(directory, "config.toml");
	private final Constant<PluginLoader> loader = new Constant<>();
	private final Constant<Collection<World>> worlds = new Constant<>();

	@Override
	public final File getDirectory() {
		return directory;
	}

	@Override
	public final File getConfigFile() {
		return configFile;
	}

	@Override
	public final Logger getLogger() {
		return logger;
	}

	/**
	 * Gets the PluginLoader that loaded this plugin.
	 */
	public final PluginLoader getLoader() {
		return loader.get();
	}

	/**
	 * Gets the worlds where this plugin is loaded.
	 */
	public final Collection<World> getActiveWorlds() {
		return worlds.get();
	}

	public final void init(PluginLoader loader, Collection<World> worlds) {
		this.loader.init(loader);
		this.worlds.init(worlds);
	}

}

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
import org.mcphoton.Photon;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Abstract class for every plugin written in Java.
 *
 * @author TheElectronWill
 *
 */
public abstract class JavaPlugin implements Plugin {

	protected final File directory = new File(Photon.getPluginsDirectory(), getName());
	protected final File configFile = new File(directory, "config.toml");
	protected final Logger logger = LoggerFactory.getLogger(getName());
	private final Constant<PluginLoader> loader = new Constant<>();

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

	@Override
	public final PluginLoader getLoader() {
		return loader.get();
	}

	public final void init(PluginLoader loader) {
		this.loader.init(loader);
	}

	@Override
	public String[] getRequiredDependencies() {
		return null;
	}

	@Override
	public String[] getOptionalDependencies() {
		return null;
	}

}

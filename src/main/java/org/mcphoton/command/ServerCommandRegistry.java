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
package org.mcphoton.command;

import org.mcphoton.plugin.ServerPlugin;

/**
 * Registers commands for the ServerPlugins.
 *
 * @author TheElectronWill
 */
public interface ServerCommandRegistry {

	/**
	 * Registers a command. The command is registered in every world where the ServerPlugin is loaded.
	 *
	 * @param cmd the command to register.
	 * @param plugin the plugin that registers the command.
	 */
	void register(Command cmd, ServerPlugin plugin);

	/**
	 * Unregister a command.
	 *
	 * @param cmd the command to unregister.
	 * @param plugin the plugin that previously registered the command.
	 */
	void unregister(Command cmd, ServerPlugin plugin);

}

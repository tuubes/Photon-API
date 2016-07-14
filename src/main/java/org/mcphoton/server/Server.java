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
package org.mcphoton.server;

import java.awt.image.BufferedImage;
import java.net.InetSocketAddress;
import java.util.Collection;
import java.util.UUID;
import org.mcphoton.command.ServerCommandRegistry;
import org.mcphoton.entity.living.Player;
import org.mcphoton.network.PacketsManager;
import org.mcphoton.plugin.ServerPluginsManager;
import org.mcphoton.world.Location;
import org.mcphoton.world.World;

public interface Server {

	// === Players ===
	Collection<Player> getOnlinePlayers();

	int getMaxPlayers();

	Player getPlayer(UUID id);

	Player getPlayer(String name);

	//=== Managers & Registries ===
	PacketsManager getPacketsManager();

	ServerPluginsManager getPluginsManager();

	BansManager getBansManager();

	WhitelistManager getWhitelistManager();

	ServerCommandRegistry getCommandRegistry();

	// === Network ===
	InetSocketAddress getBoundAddress();

	boolean isOnlineMode();

	// === Worlds ===
	Collection<World> getWorlds();

	World getWorld(String name);

	void registerWorld(World w);

	void unregisterWorld(World w);

	Location getSpawn();

	void setSpawn(Location spawn);

	//=== Misc ===
	void setFavicon(BufferedImage icon) throws Exception;

}

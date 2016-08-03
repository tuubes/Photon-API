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
package org.mcphoton.world;

import java.io.File;
import java.util.Collection;
import java.util.Optional;
import org.mcphoton.command.WorldCommandRegistry;
import org.mcphoton.entity.living.Player;
import org.mcphoton.event.WorldEventsManager;
import org.mcphoton.plugin.WorldPluginsManager;
import org.mcphoton.world.areas.Area;
import org.mcphoton.world.protection.CheckedWorldAccess;
import org.mcphoton.world.protection.UnlockedAreaAccess;
import org.mcphoton.world.protection.UnlockedWorldAccess;
import org.mcphoton.world.protection.WorldAccessManager;

/**
 * A game world.
 *
 * @author TheElectronWill
 */
public interface World {

	// === Properties ===
	String getName();

	void renameTo(String name);

	File getDirectory();

	WorldType getType();

	Location getSpawn();

	void setSpawn(int x, int y, int z);

	void setSpawn(Location spawn);

	// === Misc ===
	Collection<Player> getPlayers();

	void save();

	void delete();

	// === Registries and Managers ===
	WorldCommandRegistry getCommandRegistry();

	WorldEventsManager getEventsManager();

	WorldPluginsManager getPluginsManager();

	// === Block Access ===
	WorldAccessManager getAccessManager();

	void setAccessManager(WorldAccessManager manager);

	default CheckedWorldAccess access() {
		return getAccessManager().getAccess();
	}

	default Optional<UnlockedAreaAccess> accessArea(Area area, Object accessor) {
		return getAccessManager().unlockArea(area, accessor);
	}

	default Optional<ChunkColumn> accessChunk(int x, int z, Object accessor) {
		return getAccessManager().unlockChunk(x, z, accessor);
	}

	default Optional<UnlockedWorldAccess> accessAll(Object accessor) {
		return getAccessManager().unlockWorld(accessor);
	}

}

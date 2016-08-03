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
package org.mcphoton.world.protection;

import java.util.Optional;
import org.mcphoton.world.ChunkColumn;
import org.mcphoton.world.World;
import org.mcphoton.world.areas.Area;

/**
 * Manages accesses.
 *
 * @author TheElectronWill
 */
public interface WorldAccessManager {

	World getWorld();

	/**
	 * Gets a CheckedWorldAccess to the world. The WorldAccessManager's implementation my return the same
	 * CheckedWorldAccess for different invocations of this method.
	 */
	CheckedWorldAccess getAccess();

	/**
	 * Tries to unlock an area.
	 *
	 * @param area the area to unlock.
	 * @param accessor the object that would like to unlock the area.
	 * @return an UnlockedAreaAccess, which does not check every modification.
	 */
	Optional<UnlockedAreaAccess> unlockArea(Area area, Object accessor);

	/**
	 * Tries to unlock a chunk column.
	 *
	 * @param x the x chunk coordinate
	 * @param z the z chunk coordinate
	 * @param accessor the object that would like to unlock the area.
	 * @return an ChunkColumn, which does not check every modification.
	 */
	Optional<ChunkColumn> unlockChunk(int x, int z, Object accessor);

}

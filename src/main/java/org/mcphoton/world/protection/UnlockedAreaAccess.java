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

import org.mcphoton.block.BlockType;
import org.mcphoton.utils.Location;
import org.mcphoton.world.BiomeType;
import org.mcphoton.world.areas.Area;

/**
 * An unlocked access to a world area.
 *
 * @author TheElectronWill
 */
public interface UnlockedAreaAccess extends ReadOnlyBlockAccess {

	Area getArea();

	boolean breakBlock(int x, int y, int z);

	default boolean breakBlock(Location loc) {
		return breakBlock(loc.getBlockX(), loc.getBlockY(), loc.getBlockZ());
	}

	boolean setBlockType(int x, int y, int z, BlockType type);

	default boolean setBlockType(Location loc, BlockType type) {
		return setBlockType(loc.getBlockX(), loc.getBlockY(), loc.getBlockZ(), type);
	}

	boolean setBiomeType(int x, int z, BiomeType type);

	default boolean setBiomeType(Location loc, BiomeType type) {
		return setBiomeType(loc.getBlockX(), loc.getBlockZ(), type);
	}

	boolean fill(BlockType blockType);

	boolean replaceAll(BlockType toReplace, BlockType replacement);

}

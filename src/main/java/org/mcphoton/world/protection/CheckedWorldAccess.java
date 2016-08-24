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
import org.mcphoton.world.BiomeType;
import org.mcphoton.utils.Location;

/**
 * A checked area access. Every action is checked.
 *
 * @author TheElectronWill
 */
public interface CheckedWorldAccess extends ReadOnlyBlockAccess, QueryableBlockAccess {

	boolean breakBlock(int x, int y, int z, Object breaker);

	default boolean breakBlock(Location loc, Object breaker) {
		return breakBlock(loc.getBlockX(), loc.getBlockY(), loc.getBlockZ(), breaker);
	}

	boolean setBlockType(int x, int y, int z, BlockType type, Object setter);

	default boolean setBlockType(Location loc, BlockType type, Object setter) {
		return setBlockType(loc.getBlockX(), loc.getBlockY(), loc.getBlockZ(), type, setter);
	}

	boolean setBiomeType(int x, int z, BiomeType type, Object setter);

	default boolean setBiomeType(Location loc, BiomeType type, Object setter) {
		return setBiomeType(loc.getBlockX(), loc.getBlockZ(), type, setter);
	}

}

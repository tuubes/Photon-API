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

/**
 * A QueryableBlockAccess provides methods to check if a specific action is allowed.
 *
 * @author TheElectronWill
 */
public interface QueryableBlockAccess {

	/**
	 * Checks if a block may be broken.
	 *
	 * @param x the block's x coordinate.
	 * @param y the block's y coordinate.
	 * @param z the block's z coordinate.
	 * @param breaker the block's breaker.
	 * @return true if it may be broken, false otherwise.
	 */
	boolean mayBreakBlock(int x, int y, int z, Object breaker);

	/**
	 * Checks if a block may be broken.
	 *
	 * @param x the block's x coordinate.
	 * @param y the block's y coordinate.
	 * @param z the block's z coordinate.
	 * @param breaker the block's breaker.
	 * @return true if it may be broken, false otherwise.
	 */
	default boolean mayBreakBlock(Location loc, Object breaker) {
		return mayBreakBlock(loc.getBlockX(), loc.getBlockY(), loc.getBlockZ(), breaker);
	}

	/**
	 * Checks if a block may be set.
	 *
	 * @param x the block's x coordinate.
	 * @param y the block's y coordinate.
	 * @param z the block's z coordinate.
	 * @param breaker the block's setter.
	 * @return true if it may be set, false otherwise.
	 */
	boolean maySetBlockType(int x, int y, int z, BlockType type, Object setter);

	default boolean maySetBlockType(Location loc, BlockType type, Object setter) {
		return maySetBlockType(loc.getBlockX(), loc.getBlockY(), loc.getBlockZ(), type, setter);
	}

	boolean maySetBiomeType(int x, int z, BiomeType type, Object setter);

	default boolean maySetBiomeType(Location loc, BiomeType type, Object setter) {
		return maySetBiomeType(loc.getBlockX(), loc.getBlockZ(), type, setter);
	}

}

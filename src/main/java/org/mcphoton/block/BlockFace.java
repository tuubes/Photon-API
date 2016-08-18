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
package org.mcphoton.block;

import org.mcphoton.utils.IntVector;
import org.mcphoton.world.Location;

/**
 * A block face.
 *
 * @author TheElectronWill
 */
public enum BlockFace {

	/**
	 * Special BlockFace with modX = modY = modZ = 0.
	 */
	SELF(0, 0, 0) {
		public BlockFace getOppositeFace() {
			return SELF;
		}
	},
	NORTH(0, 0, -1) {
		public BlockFace getOppositeFace() {
			return SOUTH;
		}
	},
	SOUTH(0, 0, 1) {
		public BlockFace getOppositeFace() {
			return NORTH;
		}
	},
	EAST(1, 0, 0) {
		public BlockFace getOppositeFace() {
			return WEST;
		}
	},
	WEST(-1, 0, 0) {
		public BlockFace getOppositeFace() {
			return EAST;
		}
	},
	UP(0, 1, 0) {
		public BlockFace getOppositeFace() {
			return DOWN;
		}
	},
	DOWN(0, -1, 0) {
		public BlockFace getOppositeFace() {
			return UP;
		}
	},
	NORTH_EAST(1, 0, -1) {
		public BlockFace getOppositeFace() {
			return SOUTH_WEST;
		}
	},
	NORTH_WEST(-1, 0, -1) {
		public BlockFace getOppositeFace() {
			return SOUTH_EAST;
		}
	},
	SOUTH_EAST(1, 0, 1) {
		public BlockFace getOppositeFace() {
			return NORTH_WEST;
		}
	},
	SOUTH_WEST(-1, 0, 1) {
		public BlockFace getOppositeFace() {
			return NORTH_EAST;
		}
	};

	private final int modX, modY, modZ;

	private BlockFace(int modX, int modY, int modZ) {
		this.modX = modX;
		this.modY = modY;
		this.modZ = modZ;
	}

	/**
	 * Gets the modification to apply on the x coordinate to get the corresponding block.
	 */
	public int getModX() {
		return modX;
	}

	/**
	 * Gets the modification to apply on the y coordinate to get the corresponding block.
	 */
	public int getModY() {
		return modY;
	}

	/**
	 * Gets the modification to apply on the z coordinate to get the corresponding block.
	 */
	public int getModZ() {
		return modZ;
	}

	/**
	 * Gets the opposite BlockFace.
	 */
	public abstract BlockFace getOppositeFace();

	/**
	 * Creates a new location by adding modX, modY and modZ to the specified location.
	 */
	public Location getModifiedLocation(Location loc) {
		return loc.add(modX, modY, modZ);
	}

	/**
	 * Creates a new IntVector (modX, modY, modZ).
	 */
	public IntVector toIntVector() {
		return new IntVector(modX, modY, modZ);
	}

}

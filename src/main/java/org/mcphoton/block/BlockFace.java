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

public enum BlockFace {
	SELF(0, 0, 0),
	NORTH(0, 0, -1),
	SOUTH(0, 0, 1),
	EAST(1, 0, 0),
	WEST(-1, 0, 0),
	UP(0, 1, 0),
	DOWN(0, -1, 0),
	NORTH_EAST(1, 0, -1),
	NORTH_WEST(-1, 0, -1),
	SOUTH_EAST(1, 0, 1),
	SOUTH_WEST(-1, 0, 1);
	
	private int modX;
	private int modY;
	private int modZ;
	
	private BlockFace(int modX, int modY, int modZ){
		this.modX = modX;
		this.modY = modY;
		this.modZ = modZ;
	}
	
	public int getModX() {
		return modX;
	}
	
	public int getModY() {
		return modY;
	}
	
	public int getModZ() {
		return modZ;
	}
	
	public BlockFace getOppositeFace() {
		switch (this) {
			case SELF:
				return BlockFace.SELF;
			
			case NORTH:
				return BlockFace.SOUTH;
			
			case SOUTH:
				return BlockFace.NORTH;
			
			case EAST:
				return BlockFace.WEST;
			
			case WEST:
				return BlockFace.EAST;
			
			case UP:
				return BlockFace.DOWN;
			
			case DOWN:
				return BlockFace.UP;
			
			case NORTH_EAST:
				return BlockFace.SOUTH_WEST;
			
			case NORTH_WEST:
				return BlockFace.SOUTH_EAST;
			
			case SOUTH_EAST:
				return BlockFace.NORTH_WEST;
			
			case SOUTH_WEST:
				return BlockFace.NORTH_EAST;
		}
		return BlockFace.SELF;		
	}
	
}

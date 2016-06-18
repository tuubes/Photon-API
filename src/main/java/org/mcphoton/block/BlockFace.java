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

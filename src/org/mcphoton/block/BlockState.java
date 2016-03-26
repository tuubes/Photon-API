package org.mcphoton.block;

import org.mcphoton.world.Location;

public interface BlockState {
	
	BlockType getType();
	
	Location getLocation();
	
	BlockEntity getBlockEntity();
	
	boolean hasBlockEntity();
}

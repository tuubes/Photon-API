package org.mcphoton.block;

import org.mcphoton.network.ProtocolWriteable;
import org.mcphoton.world.Location;

public interface BlockEntity extends ProtocolWriteable {
	
	Location getLocation();
	
	BlockType getBlockType();
	
}

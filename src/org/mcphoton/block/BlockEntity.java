package org.mcphoton.block;

import org.mcphoton.world.Location;
import com.electronwill.streams.Writeable;

public interface BlockEntity extends Writeable {
	
	Location getLocation();
	
	BlockType getBlockType();
	
}

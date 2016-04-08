package org.mcphoton.world.protection;

import org.mcphoton.block.BlockType;
import org.mcphoton.world.BiomeType;
import org.mcphoton.world.Location;

public interface ReadOnlyBlockAccess {

	BlockType getBlockType(int x, int y, int z);

	default BlockType getBlockType(Location loc) {
		return getBlockType(loc.getBlockX(), loc.getBlockY(), loc.getBlockZ());
	}

	BiomeType getBiomeType(int x, int z);

	default BiomeType getBiomeType(Location loc) {
		return getBiomeType(loc.getBlockX(), loc.getBlockZ());
	}

}

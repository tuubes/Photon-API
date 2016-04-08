package org.mcphoton.world.protection;

import org.mcphoton.block.BlockType;
import org.mcphoton.world.Area;
import org.mcphoton.world.BiomeType;
import org.mcphoton.world.Location;

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

	boolean setBiomeType(int x, int y, int z, BiomeType type);

	default boolean setBiomeType(Location loc, BiomeType type) {
		return setBiomeType(loc.getBlockX(), loc.getBlockY(), loc.getBlockZ(), type);
	}

	boolean fill(int blockId);

	boolean replaceAll(int toReplaceId, int replacementId);

}

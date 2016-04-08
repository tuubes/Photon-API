package org.mcphoton.world.protection;

import org.mcphoton.block.BlockType;
import org.mcphoton.world.BiomeType;
import org.mcphoton.world.Location;

public interface QueryableBlockAccess {

	boolean mayBreakBlock(int x, int y, int z, Object breaker);

	default boolean mayBreakBlock(Location loc, Object breaker) {
		return mayBreakBlock(loc.getBlockX(), loc.getBlockY(), loc.getBlockZ(), breaker);
	}

	boolean maySetBlockType(int x, int y, int z, BlockType type, Object setter);

	default boolean maySetBlockType(Location loc, BlockType type, Object setter) {
		return maySetBlockType(loc.getBlockX(), loc.getBlockY(), loc.getBlockZ(), type, setter);
	}

	boolean maySetBiomeType(int x, int z, BiomeType type, Object setter);

	default boolean maySetBiomeType(Location loc, BiomeType type, Object setter) {
		return maySetBiomeType(loc.getBlockX(), loc.getBlockZ(), type, setter);
	}

}

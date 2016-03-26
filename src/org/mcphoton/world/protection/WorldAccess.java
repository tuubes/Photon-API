package org.mcphoton.world.protection;

import org.mcphoton.block.BlockType;
import org.mcphoton.world.BiomeType;
import org.mcphoton.world.Location;

public interface WorldAccess extends ReadOnlyBlockAccess, QueryableBlockAccess {
	
	boolean breakBlock(int x, int y, int z, Object breaker);
	
	default boolean breakBlock(Location loc, Object breaker) {
		return breakBlock(loc.getBlockX(), loc.getBlockY(), loc.getBlockZ(), breaker);
	}
	
	boolean setBlockType(int x, int y, int z, BlockType type, Object setter);
	
	default boolean setBlockType(Location loc, BlockType type, Object setter) {
		return setBlockType(loc.getBlockX(), loc.getBlockY(), loc.getBlockZ(), type, setter);
	}
	
	boolean setBlockEmittedLight(int x, int y, int z, byte light, Object setter);
	
	default boolean setBlockEmittedLight(Location loc, byte light, Object setter) {
		return setBlockEmittedLight(loc.getBlockX(), loc.getBlockY(), loc.getBlockZ(), light, setter);
	}
	
	boolean setBlockSkylight(int x, int y, int z, byte skylight, Object setter);
	
	default boolean setBlockSkylight(Location loc, byte skylight, Object setter) {
		return setBlockSkylight(loc.getBlockX(), loc.getBlockY(), loc.getBlockZ(), skylight, setter);
	}
	
	boolean setBiomeType(int x, int z, BiomeType type, Object setter);
	
	default boolean setBiomeType(Location loc, BiomeType type, Object setter) {
		return setBiomeType(loc.getBlockX(), loc.getBlockZ(), type, setter);
	}
	
}

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
	
	boolean maySetBlockEmittedLight(int x, int y, int z, byte light, Object setter);
	
	default boolean maySetBlockEmittedLight(Location loc, byte light, Object setter) {
		return maySetBlockEmittedLight(loc.getBlockX(), loc.getBlockY(), loc.getBlockZ(), light, setter);
	}
	
	boolean maySetBlockSkylight(int x, int y, int z, byte skylight, Object setter);
	
	default boolean maySetBlockSkylight(Location loc, byte skylight, Object setter) {
		return maySetBlockSkylight(loc.getBlockX(), loc.getBlockY(), loc.getBlockZ(), skylight, setter);
	}
	
	boolean maySetBiomeType(int x, int z, BiomeType type, Object setter);
	
	default boolean maySetBiomeType(Location loc, BiomeType type, Object setter) {
		return maySetBiomeType(loc.getBlockX(), loc.getBlockZ(), type, setter);
	}
	
}

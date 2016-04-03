package org.mcphoton.world;

public interface Area extends Iterable<Location> {
	
	boolean contains(int x, int y, int z);
	
	default boolean contains(Location loc) {
		return loc.getWorld() == getWorld() && contains(loc.getBlockX(), loc.getBlockY(), loc.getBlockZ());
	}
	
	World getWorld();
	
	int size();
	
}

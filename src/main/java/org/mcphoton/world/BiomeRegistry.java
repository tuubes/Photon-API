package org.mcphoton.world;

public interface BiomeRegistry {
	
	void register(BiomeType type);
	
	void register(BiomeType type, int id);
	
	BiomeType getRegistered(int id);
	
	BiomeType getRegistered(String name);
	
	boolean isRegistered(int id);
	
	boolean isRegistered(String name);
	
}

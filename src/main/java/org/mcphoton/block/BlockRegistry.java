package org.mcphoton.block;

public interface BlockRegistry {
	
	void register(BlockType type);
	
	void register(BlockType type, int id);
	
	BlockType getRegistered(int id);
	
	BlockType getRegistered(String name);
	
	boolean isRegistered(int id);
	
	boolean isRegistered(String name);
	
}

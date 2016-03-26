package org.mcphoton.item;

public interface ItemRegistry {
	
	void register(ItemType type);
	
	void register(ItemType type, int id);
	
	ItemType getRegistered(int id);
	
	ItemType getRegistered(String name);
	
	boolean isRegistered(int id);
	
	boolean isRegistered(String name);
	
}

package org.mcphoton.entity;

public interface EntityRegistry {
	
	void register(EntityType type);
	
	void register(EntityType type, int id);
	
	EntityType getRegistered(int id);
	
	EntityType getRegistered(String name);
	
	boolean isRegistered(int id);
	
	boolean isRegistered(String name);
	
}

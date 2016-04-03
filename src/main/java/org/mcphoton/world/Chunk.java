package org.mcphoton.world;

public interface Chunk {
	
	int getX();
	
	int getZ();
	
	World getWorld();
	
	int getBlockId(int x, int z);
	
	void setBlockId(int x, int z, int blockId);
	
	int getBiomeId(int x, int z);
	
	void setBiomeId(int x, int z, int biomeId);
	
	byte getBlockEmittedLight(int x, int z);
	
	void setBlockEmittedLight(int x, int z);
	
	byte getBlockSkylight(int x, int z);
	
	void setBlockSkylight(int x, int z);
	
}

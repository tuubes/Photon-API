package org.mcphoton.world;

import java.io.File;
import java.util.Collection;
import java.util.Optional;
import org.mcphoton.entity.living.player.Player;
import org.mcphoton.world.protection.UnlockedAreaAccess;
import org.mcphoton.world.protection.WorldAccess;
import org.mcphoton.world.protection.WorldAccessManager;

public interface World {
	
	// === Properties ===
	
	String getName();
	
	void renameTo(String name);
	
	File getDirectory();
	
	int getType();
	
	Location getSpawn();
	
	void setSpawn(int x, int y, int z);
	
	void setSpawn(Location spawn);
	
	// === Misc ===
	
	Collection<Player> getPlayers();
	
	void save();
	
	void delete();
	
	// === Block Access ===
	
	WorldAccessManager getAccessManager();
	
	void setAccessManager(WorldAccessManager manager);
	
	default WorldAccess access() {
		return getAccessManager().getAccess();
	}
	
	default Optional<UnlockedAreaAccess> accessArea(Area area, Object accessor) {
		return getAccessManager().unlockArea(area, accessor);
	}
	
	default Optional<Chunk> accessChunk(int x, int z, Object accessor) {
		return getAccessManager().unlockChunk(x, z, accessor);
	}
	
}

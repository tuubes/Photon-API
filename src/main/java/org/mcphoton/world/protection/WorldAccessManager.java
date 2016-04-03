package org.mcphoton.world.protection;

import java.util.Optional;
import org.mcphoton.world.Area;
import org.mcphoton.world.Chunk;
import org.mcphoton.world.World;

public interface WorldAccessManager {
	
	World getWorld();
	
	WorldAccess getAccess();
	
	Optional<UnlockedAreaAccess> unlockArea(Area area, Object accessor);
	
	Optional<Chunk> unlockChunk(int x, int z, Object accessor);
	
}

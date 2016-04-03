package org.mcphoton.entity.living.player;

import org.mcphoton.world.Location;

public interface Player extends OfflinePlayer {
	
	@Override
	default boolean isOnline() {
		return true;
	}
	
	Location getLocation();
	
}

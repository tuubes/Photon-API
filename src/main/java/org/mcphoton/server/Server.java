package org.mcphoton.server;

import java.net.InetSocketAddress;
import java.util.Collection;
import java.util.UUID;
import org.mcphoton.entity.living.player.Player;
import org.mcphoton.world.Location;
import org.mcphoton.world.World;

public interface Server {
	
	// === Players ===
	Collection<Player> getOnlinePlayers();
	
	int getMaxPlayers();
	
	Player getPlayer(UUID id);
	
	Player getPlayer(String name);
	
	BansManager getBansManager();
	
	WhitelistManager getWhitelistManager();
	
	// === Network ===
	InetSocketAddress getBoundAddress();
	
	boolean isOnlineMode();
	
	// === Worlds ===
	Collection<World> getWorlds();
	
	World getWorld(String name);
	
	void registerWorld(World w);
	
	void unregisterWorld(World w);
	
	Location getSpawn();
	
	void setSpawn(Location spawn);
	
}

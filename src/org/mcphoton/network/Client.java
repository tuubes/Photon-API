package org.mcphoton.network;

import java.net.InetSocketAddress;
import java.util.Optional;
import org.mcphoton.entity.living.player.Player;

public interface Client {
	
	InetSocketAddress getAddress();
	
	Optional<Player> getPlayer();
	
	ConnectionState getConnectionState();
	
	void setConnectionState(ConnectionState newState);
	
}

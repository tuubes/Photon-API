package org.mcphoton.server;

import java.net.InetAddress;
import java.util.Collection;
import java.util.UUID;

public interface BansManager {
	
	boolean isBanned(UUID accountId);
	
	boolean isBanned(InetAddress ip);
	
	void ban(UUID accountId);
	
	void ban(InetAddress ip);
	
	void unban(UUID accountId);
	
	void unban(InetAddress ip);
	
	Collection<UUID> getBannedAccounts();
	
	Collection<InetAddress> getBannedIPs();
	
}

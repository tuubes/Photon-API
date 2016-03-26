package org.mcphoton.entity.living.player;

import java.util.UUID;
import org.mcphoton.permissions.Permissible;

public interface OfflinePlayer extends Permissible {
	
	String getName();
	
	UUID getAccountId();
	
	boolean isOnline();
	
}

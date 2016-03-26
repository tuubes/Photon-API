package org.mcphoton.server;

import java.util.UUID;

public interface WhitelistManager {
	
	boolean isEnabled();
	
	void setEnabled(boolean enabled);
	
	void allow(UUID accountId);
	
	void deny(UUID accountId);
	
	boolean isAllowed(UUID accountId);
	
}

package org.mcphoton.permissions;

import java.util.Collection;

public interface PermissionsManager {
	
	void addSetting(PermissionSetting setting);
	
	void removeSetting(PermissionSetting setting);
	
	void set(String permission, Permissible permissible, boolean granted);
	
	void reset(String permission, Permissible permissible);
	
	boolean isLoaded(Permissible permissible);
	
	void load(Permissible permissible);
	
	boolean hasPermission(String permission, Permissible permissible);
	
	Collection<Permissible> getWithPermission(String permission, boolean granted);
	
}

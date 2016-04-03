package org.mcphoton.permissions;

import org.mcphoton.plugin.Plugin;

public final class PermissionSetting {
	
	private final Permissible permissible;
	private final String permission;
	private final boolean permissionGranted;
	private final Plugin setter;
	
	public PermissionSetting(Permissible permissible, String permission, boolean permissionGranted, Plugin setter) {
		this.permissible = permissible;
		this.permission = permission;
		this.permissionGranted = permissionGranted;
		this.setter = setter;
	}
	
	public Permissible getPlayer() {
		return permissible;
	}
	
	public String getPermission() {
		return permission;
	}
	
	public boolean isPermissionGranted() {
		return permissionGranted;
	}
	
	public Plugin getSetter() {
		return setter;
	}
	
}

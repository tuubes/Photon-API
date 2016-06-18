/*
 * Copyright (c) 2016 MCPhoton <http://mcphoton.org> and contributors.
 *
 * This file is part of the Photon API <https://github.com/mcphoton/Photon-API>.
 *
 * The Photon API is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * The Photon API is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>.
 */
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

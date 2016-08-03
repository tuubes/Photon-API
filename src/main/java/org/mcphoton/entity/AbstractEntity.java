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
package org.mcphoton.entity;

import java.util.UUID;
import org.mcphoton.world.Location;
import org.mcphoton.world.World;

/**
 * Abstract base class for entities.
 *
 * @author TheElectronWill
 */
public abstract class AbstractEntity implements Entity {

	private int entityId = -1;
	private UUID uniqueId;
	private double x, y, z;
	private World world;
	private String customName;
	private boolean customNameVisible = true;

	@Override
	public int getEntityId() {
		return entityId;
	}

	@Override
	public UUID getUniqueId() {
		return uniqueId;
	}

	@Override
	public String getCustomName() {
		return customName;
	}

	@Override
	public Location getLocation() {
		return new Location(x, y, z, world);
	}

	@Override
	public void initEntityId(int id) {
		if (entityId != -1) {
			throw new IllegalStateException("Entity id already initialized!");
		}
		this.entityId = id;
		this.uniqueId = new UUID(0, entityId);
	}

	@Override
	public void setCustomName(String customName) {
		this.customName = customName;
	}

	@Override
	public void setCustomNameVisible(boolean visibility) {
		this.customNameVisible = visibility;
	}

	@Override
	public boolean isCustomNameVisible() {
		return customNameVisible;
	}

}

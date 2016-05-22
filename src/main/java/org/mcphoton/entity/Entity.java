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

import com.electronwill.utils.IntConstant;
import org.mcphoton.network.ProtocolOutputStream;
import org.mcphoton.world.World;

/**
 * Base class for entites. Entities normally don't need to be thread-safe, because the photon's implementation
 * takes care of this.
 *
 * @author TheElectronWill
 * @author DJmaxZPLAY
 */
public abstract class Entity {

	private final IntConstant entityId = new IntConstant();

	protected String customName = "";
	protected double x, y, z;
	protected World world;

	public int getEntityId() {
		return entityId.get();
	}

	public void initializeEntityId(int id) {
		this.entityId.init(id);
	}

	public abstract EntityType getType();

	public String getCustomName() {
		return customName;
	}

	public void setCustomName(String customName) {
		this.customName = customName;
	}

	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}

	public double getZ() {
		return z;
	}

	public World getWorld() {
		return world;
	}
	
	/**
	 * Gets the primary passenger of a vehicle. Vehicle which can have multiple passengers,
	 * it return only the primary passenger.
	 */
	public abstract Entity getPassenger();
	
	/**
	 * Return if the entity has a passenger.
	 */
	public abstract boolean hasPassenger();
	
	/**
	 * Set the passenger of the entity.
	 * 
	 * @param passenger The new passenger.
	 * @return false if it couldn't be done.
	 */
	public abstract boolean setPassenger(Entity passenger);

	/**
	 * Writes this entity to a ProtocolOutputStream.
	 */
	public abstract void writeTo(ProtocolOutputStream out);

}

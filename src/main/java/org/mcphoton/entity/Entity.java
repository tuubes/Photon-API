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

import java.util.Optional;
import java.util.UUID;

import org.mcphoton.network.ProtocolOutputStream;
import org.mcphoton.world.Location;

/**
 * Base class for entites. Entities normally don't need to be thread-safe, because the photon's implementation
 * takes care of this.
 *
 * @author TheElectronWill
 * @author DJmaxZPLAY
 */
public interface Entity {


	int getEntityId();
	
	UUID getEntityUniqueId();

	void initializeEntityId(int id);

	EntityType getType();

	String getCustomName();

	void setCustomName(String customName);
	
	void setCustomNameVisible(boolean visibility);
	
	boolean isCustomNameVisible();

	Location getLocation();
	
	boolean isOnGround();
	
	boolean teleport(Location location);
	
	int getFireTicks();
	
	int getMaxFireTicks();
	
	void setFireTicks(int ticks);
	
	/**
	 * Gets the primary passenger of a vehicle. Vehicle which can have multiple passengers,
	 * it return only the primary passenger.
	 */
	Optional<Entity> getPassenger();
	
	/**
	 * Return if the entity has a passenger.
	 */
	boolean hasPassenger();
	
	/**
	 * Set the passenger of the entity.
	 * 
	 * @param passenger The new passenger.
	 * @return false if it couldn't be done.
	 */
	boolean setPassenger(Entity passenger);

	boolean ejectPassenger();
	
	boolean isInVehicle();
	
	boolean leaveVehicle();
	
	Entity getVehicle();
	
	void playEffect();
	
	void setGravity(boolean gravity);
	
	boolean hasGravity();
	
	void setGlowing(boolean glow);
	
	boolean isGlowing();
	
	void setSilent(boolean silent);
	
	boolean isSilent();
	
	/**
	 * Writes this entity to a ProtocolOutputStream.
	 */
	void writeTo(ProtocolOutputStream out);

}

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

	/**
	 * Gets the id of the entity.
	 * 
	 * @return Entity Id
	 */
	int getEntityId();
	
	/**
	 * Gets the unique id of the entity.
	 * 
	 * @return Entity unique Id
	 */
	UUID getEntityUniqueId();

	void initializeEntityId(int id);

	/**
	 * Gets the type of the entity.
	 * 
	 * @return EntityType of the entity
	 */
	EntityType getType();

	/**
	 * Gets the custom name of the entity.
	 * 
	 * @return custom name of the entity
	 */
	String getCustomName();

	/**
	 * Sets the custom name of the entity.
	 * 
	 * @param customName the customName
	 */
	void setCustomName(String customName);
	
	/**
	 * Sets if the custom name of the entity is visible.
	 * 
	 * @param visibility true if custom name must be shown.
	 */
	void setCustomNameVisible(boolean visibility);
	
	/**
	 * Return if the custom name of the entity is visible.
	 * 
	 * @return true if custom name is visible
	 */
	boolean isCustomNameVisible();

	/**
	 * Gets the location of the entity.
	 * 
	 * @return Location of the entity
	 */
	Location getLocation();
	
	/**
	 * Return if the entity is on ground.
	 * 
	 * @return true if the entity is on ground
	 */
	boolean isOnGround();
	
	/**
	 * Teleport the entity to the location
	 * 
	 * @param location location where the entity must be teleport.
	 * @return true if teleport success
	 */
	boolean teleport(Location location);
	
	/**
	 * Return the ticks before the entity stops being on fire.
	 */
	int getFireTicks();
	
	/**
	 * Return the entity's maximum fire ticks.
	 */
	int getMaxFireTicks();
	
	/**
	 * Sets the ticks before the entity stops being on fire.
	 * 
	 * @param ticks ticks before the entity stops being on fire
	 */
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

	/**
	 * Eject the passenger of this entity.
	 * 
	 * @return true if there was a passenger
	 */
	boolean ejectPassenger();
	
	/**
	 * Return if the entity is in a vehicle.
	 */
	boolean isInVehicle();
	
	/**
	 * Eject the entity of his vehicle.
	 * 
	 * @return true if the entity was ejected.
	 */
	boolean leaveVehicle();
	
	/**
	 * Return the vehicle of the entity.
	 */
	Optional<Entity> getVehicle();
	
	/**
	 * Sets if gravity is applied on the entity.
	 * 
	 * @param gravity gravity applied
	 */
	void setGravity(boolean gravity);
	
	/**
	 * Return if gravity is applied on the entity.
	 * 
	 * @return true if gravity is applied
	 */
	boolean hasGravity();
	
	/**
	 * Sets if the entity glow. (Color belong on Team Color).
	 * 
	 * @param glow entity must glow
	 */
	void setGlowing(boolean glow);
	
	/**
	 * Return if the entity glow.
	 * 
	 * @return entity is glowing
	 */
	boolean isGlowing();
	
	/**
	 * Sets if the entity is silent.
	 * 
	 * @param silent if entity is silent
	 */
	void setSilent(boolean silent);
	
	/**
	 * Return if the entity is silent.
	 * 
	 * @return if entity is silent
	 */
	boolean isSilent();
	
	/**
	 * Writes this entity to a ProtocolOutputStream.
	 */
	void writeTo(ProtocolOutputStream out);

}

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

import org.mcphoton.world.Location;

/**
 * Crystal in end that heals the EnderDragon.
 * 
 * @author DJmaxZPLAY
 */
public interface EnderCrystal extends Entity{

	/**
	 * Return true if the ender crystal show his bedrock slate.
	 * 
	 * @return true if bedrock slate is showed
	 */
	boolean isShowingSlate();
	
	/**
	 * Sets if the ender crystal show his bedrock slate.
	 * 
	 * @param show show the bedrock slate
	 */
	void setShowingSlate(boolean show);
	
	/**
	 * Gets the location that the ender crystal is pointing his beam to.
	 * 
	 * @return the location that the beam of the ender crystal is pointed 
	 */
	Optional<Location> getBeamTarget();
	
	/**
	 * Sets the location that the ender crystal is pointing his beam to.
	 * 
	 * @param location the location that the beam of the ender crystal must point 
	 */
	void setBeamTarget(Optional<Location> location);
	
}

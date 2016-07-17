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

/**
 * The interface for the explosive entity.
 * 
 * @author DJmaxZPLAY
 */
public interface Explosive {

	/**
	 * Gets the radius of the explosion.
	 * 
	 * @return radius of the explosion
	 */
	float getRadius();
	
	/**
	 * Sets the radius of the explosion.
	 * 
	 * @param radius radius of the explosion
	 */
	void setRadius(float radius);
	
	/**
	 * Return if the explosion makes near blocks on fire.
	 * 
	 * @return true if explosion makes near blocks on fire
	 */
	boolean isIncendiary();
	
	/**
	 * Sets if the explosion makes near blocks on fire.
	 * 
	 * @param incendiary make near blocks on fire
	 */
	void setIncendiary(boolean incendiary);
	
}

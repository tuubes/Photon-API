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

import org.mcphoton.entity.projectile.Shooter;

/**
 * A cloud of a Lingering Potion.
 * 
 * @author DJmaxZPLAY
 */

public interface AreaEffectCloud extends Entity {
	
	/**
	 * Gets the radius of the cloud.
	 * 
	 * @return cloud radius
	 */
	float getRadius();
	
	/**
	 * Sets the radius of the cloud.
	 * 
	 * @param radius cloud radius
	 */
	void setRadius(float radius);
	
	/**
	 * Gets the duration in ticks of the existence of the cloud.
	 * 
	 * @return cloud duration
	 */
	int getDuration();
	
	/**
	 * Sets the duration in ticks of the existence of the cloud.
	 * 
	 * @param duration cloud duration
	 */
	void setDuration(int duration);
	
	/**
	 * Gets the source of this cloud
	 * 	
	 * @return the Shooter of the Lingering Potion
	 */
	Shooter getSource();
	
	/**
	 * Sets the source of this cloud
	 * 	
	 * @param source the Shooter of the Lingering Potion
	 */
	void setSource(Shooter source);
	
}

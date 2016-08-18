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
 * A cloud created by a lingering Potion.
 * 
 * @author DJmaxZPLAY
 * @author TheElectronWill
 */

public interface AreaEffectCloud extends Entity {
	
	/**
	 * Gets the cloud's radius.
	 */
	float getRadius();
	
	/**
	 * Sets the cloud's radius.
	 */
	void setRadius(float radius);
	
	/**
	 * Gets the duration (in ticks) which the cloud will exist for.
	 */
	int getDuration();
	
	/**
	 * Sets the duration (in ticks) which the cloud will exist for.
	 */
	void setDuration(int duration);
	
	/**
	 * Gets the cloud's source.
	 * 	
	 * @return the shooter of the lingering Potion.
	 */
	Shooter getSource();
	
	/**
	 * Sets the cloud's source.
	 * 	
	 * @param source the shooter of the lingering Potion.
	 */
	void setSource(Shooter source);
	
}

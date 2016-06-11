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
package org.mcphoton.entity.projectile;

import org.mcphoton.entity.Entity;

/**
 * 
 * @author DJmaxZPLAY
 */
public interface Projectile extends Entity{
	
	/**
	 * Get the shooter of this projectile.
	 * 
	 * @return a Shooter who has shoot this projectile.
	 */
	Shooter getShooter();
	
	/**
	 * Set the shooter of this projectile.
	 * 
	 * @param shooter the Shooter that shot this projectile.
	 */
	void setShooter(Shooter shooter);
	
	/**
	 * Determine if this projectile should bounce when it hits.
	 * If a fireball does bounce it would'nt set the target on fire.
	 * 
	 * @returne true if it should bounce on hits.
	 */
	boolean doesBounce();
	
	/**
	 * Set if this projectile should bounce when it hits something.
	 * 
	 * @param bounce true if it should bounce.
	 */
	void setBounce(boolean bounce);

}

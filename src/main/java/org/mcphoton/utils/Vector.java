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
package org.mcphoton.utils;

import org.mcphoton.world.Location;
import org.mcphoton.world.World;

/**
 * 
 * @author DJmaxZPLAY
 */
public class Vector {

	protected double x, y, z;
	
	/**
	 * Create a vector with all components as 0.
	 */
	public Vector() {
		this.x = 0;
		this.y = 0;
		this.z = 0;
	}
	
	/**
	 * Create a vector with integer components.
	 * 
	 * @param x X component;
	 * @param y Y component;
	 * @param z Z component;
	 */
	public Vector(int x, int y, int z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	/**
	 * Create a vector with double components.
	 * 
	 * @param x X component;
	 * @param y Y component;
	 * @param z Z component;
	 */
	public Vector(double x, double y, double z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	/**
	 * Get a location from this vector.
	 * 
	 * @param w The world of the location.
	 * @return the location.
	 */
	public Location toLocation(World w) {
		return new Location(x, y, z, w);
	}
	
	/**
	 * Return the components of this vector in a string.
	 */
	public String toString() {
		return "x=" + x + ", y=" + y + ", z=";
	}
	
}

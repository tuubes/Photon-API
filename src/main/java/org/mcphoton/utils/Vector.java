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
 * A spatial vector defined by 3 coordinates.
 *
 * @author DJmaxZPLAY
 * @author TheElectronWill
 */
public class Vector {

	protected double x, y, z;

	/**
	 * Creates a new vector (0,0,0).
	 */
	public Vector() {
		this(0, 0, 0);
	}

	/**
	 * Creates a new vector with the specified coordinates.
	 */
	public Vector(double x, double y, double z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}

	/**
	 * Creates a Location with this vector's coordinates.
	 *
	 * @param w The world of the location.
	 * @return the location.
	 */
	public Location toLocation(World w) {
		return new Location(x, y, z, w);
	}

	@Override
	public String toString() {
		return "Vector(" + x + ", " + y + ", " + z + ')';
	}

	@Override
	public int hashCode() {
		int hash = 5;
		hash = 29 * hash + (int) (Double.doubleToLongBits(this.x) ^ (Double.doubleToLongBits(this.x) >>> 32));
		hash = 29 * hash + (int) (Double.doubleToLongBits(this.y) ^ (Double.doubleToLongBits(this.y) >>> 32));
		hash = 29 * hash + (int) (Double.doubleToLongBits(this.z) ^ (Double.doubleToLongBits(this.z) >>> 32));
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj instanceof Vector) {
			Vector v = (Vector) obj;
			return v.x == x && v.y == y && v.z == z;
		}
		return false;
	}

}

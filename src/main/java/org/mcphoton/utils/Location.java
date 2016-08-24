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

import java.util.Objects;
import org.mcphoton.world.World;

/**
 * A location is a precise point defined by 3 coordinates (x,y,z) and one World. A Location is immutable, so
 * thread-safe. The methods {@link #withX(double)}, {@link #withY(double)}, {@link #withZ(double)} and
 * {@link #withWorld(World)} create a new Location object.
 *
 * @author TheElectronWill
 */
public final class Location implements Cloneable {

	private final double x, y, z;
	private final World w;

	public Location(double x, double y, double z, World w) {
		this.x = x;
		this.y = y;
		this.z = z;
		this.w = w;
	}

	/**
	 * Creates a new location that is the result of adding the vector v to this location.
	 */
	public Location add(DoubleVector v) {
		return new Location(x + v.x, y + v.y, z + v.z, w);
	}

	/**
	 * Creates a new location that is the result of adding the vector v to this location.
	 */
	public Location add(IntVector v) {
		return new Location(x + v.x, y + v.y, z + v.z, w);
	}

	/**
	 * Creates a new location that is the result of adding the location l to this location.
	 */
	public Location add(Location l) {
		return new Location(x + l.x, y + l.y, z + l.z, w);
	}

	/**
	 * Creates a new location that is the result of adding the specified numbers to this location.
	 */
	public Location add(double dx, double dy, double dz) {
		return new Location(x + dx, y + dy, z + dz, w);
	}

	@Override
	public Location clone() {
		return new Location(x, y, z, w);
	}

	public World getWorld() {
		return w;
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

	public int getBlockX() {
		return (int) x;
	}

	public int getBlockY() {
		return (int) y;
	}

	public int getBlockZ() {
		return (int) z;
	}

	/**
	 * Calculates the squared distance between this location and the l location. This is faster than manually
	 * multiplying the distance by itself.
	 */
	public double squaredDistance(Location l) {
		final double deltaX = l.x - x, deltaY = l.y - y, deltaZ = l.z - z;
		return deltaX * deltaX + deltaY * deltaY + deltaZ * deltaZ;
	}

	/**
	 * Calculates the distance between this location and the l location.
	 */
	public double distance(Location l) {
		final double deltaX = l.x - x, deltaY = l.y - y, deltaZ = l.z - z;
		return Math.sqrt(deltaX * deltaX + deltaY * deltaY + deltaZ * deltaZ);
	}

	/**
	 * Creates a new Location with the specified x coordinate and the same y, z and World as this Location.
	 */
	public Location withX(double x) {
		return new Location(x, y, z, w);
	}

	/**
	 * Creates a new Location with the specified y coordinate and the same x, z and World as this Location.
	 */
	public Location withY(double y) {
		return new Location(x, y, z, w);
	}

	/**
	 * Creates a new Location with the specified z coordinate and the same x, y and World as this Location.
	 */
	public Location withZ(double z) {
		return new Location(x, y, z, w);
	}

	/**
	 * Creates a new Location with the specified world and the same x, y and z as this Location.
	 */
	public Location withWorld(World w) {
		return new Location(x, y, z, w);
	}

	/**
	 * Creates a new IntVector with the coordinates of this location. Each coordinate is converted to an int.
	 */
	public IntVector toIntVector() {
		return new IntVector((int) x, (int) y, (int) z);
	}

	/**
	 * Creates a new DoubleVector with the coordinates of this location.
	 */
	public DoubleVector toDoubleVector() {
		return new DoubleVector(x, y, z);
	}

	@Override
	public int hashCode() {
		int hash = 5;
		hash = 89 * hash + (int) (Double.doubleToLongBits(this.x) ^ (Double.doubleToLongBits(this.x) >>> 32));
		hash = 89 * hash + (int) (Double.doubleToLongBits(this.y) ^ (Double.doubleToLongBits(this.y) >>> 32));
		hash = 89 * hash + (int) (Double.doubleToLongBits(this.z) ^ (Double.doubleToLongBits(this.z) >>> 32));
		hash = 89 * hash + Objects.hashCode(this.w);
		return hash;
	}

	@Override
	public String toString() {
		return "Location{" + "x=" + x + ", y=" + y + ", z=" + z + ", world=" + w + '}';
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj instanceof Location) {
			Location l = (Location) obj;
			return w == l.w && x == l.x && y == l.y && z == l.z;
		}
		return false;
	}

	/**
	 * Creates a location in the middle of the two specified locations.
	 */
	public static Location middle(Location l1, Location l2) {
		if (l1.w != l2.w) {
			throw new IllegalArgumentException("The two locations must be in the same world.");
		}
		double x = (l1.x + l2.x) / 2d, y = (l1.y + l2.y) / 2d, z = (l1.z + l2.z) / 2d;
		return new Location(x, y, z, l1.w);
	}
}

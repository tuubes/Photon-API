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
package org.mcphoton.world;

/**
 * A location is defined by 3 coordinates (x,y,z) and one World. A Location is immutable, so thread-safe. The
 * methods {@link #withX(double)}, {@link #withY(double)}, {@link #withZ(double)} and
 * {@link #withWorld(World)} create a new Location object.
 *
 * @author TheElectronWill
 *
 */
public final class Location {

	private final double x, y, z;
	private final World w;

	public Location(double x, double y, double z, World w) {
		this.x = x;
		this.y = y;
		this.z = z;
		this.w = w;
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
}

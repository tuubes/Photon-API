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

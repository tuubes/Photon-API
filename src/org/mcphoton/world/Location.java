package org.mcphoton.world;

/**
 * A location in a World, as 3 coordinates (x,y,z). Location is immutable. The methods "with..." create a new Location
 * object.
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
	
	public Location withX(double x) {
		return new Location(x, y, z, w);
	}
	
	public Location withY(double y) {
		return new Location(x, y, z, w);
	}
	
	public Location withZ(double z) {
		return new Location(x, y, z, w);
	}
	
	public Location withWorld(World w) {
		return new Location(x, y, z, w);
	}
}

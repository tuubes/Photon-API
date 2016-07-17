package org.mcphoton.utils;

/**
 * An EulerAngle is composed of three rotation (yaw, pitch, roll) based on three axis. Angles are in radians.
 * 
 * @author DJmaxZPLAY
 */
public class EulerAngles {

	private float yaw, pitch, roll;
	
	/**
	 * Creates an EulerAngle(0F, 0F, 0F)
	 */
	public EulerAngles() {
		this(0F, 0F, 0F);
	}
	
	/**
	 * Creates an EulerAngle with the three axis. Angles are in radians.
	 */
	public EulerAngles(float yaw, float pitch, float roll) {	
		this.yaw = yaw;
		this.pitch = pitch;
		this.roll = roll;		
	}
	
	public EulerAngles add(float yaw, float pitch, float roll) {
		this.yaw += yaw;
		this.pitch += pitch;
		this.roll += roll;
		return this;
	}
	
	public EulerAngles subtract(float yaw, float pitch, float roll) {
		this.yaw -= yaw;
		this.pitch -= pitch;
		this.roll -= roll;
		return this;
	}
	
	@Override
	public String toString() {
		return "EulerAngles(" + yaw + ", " + pitch + ", " + roll + ')';
	}	
}

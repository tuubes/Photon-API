package org.mcphoton.entity;

import org.mcphoton.network.ProtocolOutputStream;
import org.mcphoton.world.World;
import com.electronwill.utils.IntConstant;

/**
 * Base class for entites. Entities normally don't need to be thread-safe, because the photon's implementation take care
 * of this.
 * 
 * @author TheElectronWill
 * 		
 */
public abstract class Entity {
	
	private final IntConstant entityId = new IntConstant();
	
	protected String customName = "";
	protected double x, y, z;
	protected World world;
	
	public int getEntityId() {
		return entityId.get();
	}
	
	public void initializeEntityId(int id) {
		this.entityId.init(id);
	}
	
	public abstract EntityType getType();
	
	public String getCustomName() {
		return customName;
	}
	
	public void setCustomName(String customName) {
		this.customName = customName;
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
	
	public World getWorld() {
		return world;
	}
	
	/**
	 * Writes this entity to a ProtocolOutputStream.
	 */
	public abstract void writeTo(ProtocolOutputStream out);
	
}

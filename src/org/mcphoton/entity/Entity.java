package org.mcphoton.entity;

import org.mcphoton.network.ProtocolOutputStream;
import org.mcphoton.world.World;
import com.electronwill.utils.IntConstant;

public abstract class Entity {
	
	private final IntConstant entityId = new IntConstant();
	
	protected volatile String customName = "";
	protected volatile double x, y, z;
	protected volatile World world;
	
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

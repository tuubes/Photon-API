package org.mcphoton.entity;

import org.mcphoton.world.World;
import com.electronwill.concurrent.IntConstant;
import com.electronwill.streams.Writeable;

public abstract class Entity implements Writeable {
	
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
	
}

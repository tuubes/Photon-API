package org.mcphoton.entity.living;

import org.mcphoton.entity.Entity;

public abstract class TameableEntity extends AgeableEntity implements Tameable {
	
	protected volatile Entity tamer = null;
	
	@Override
	public Entity getTamer() {
		return tamer;
	}
	
	@Override
	public void setTamer(Entity tamer) {
		this.tamer = tamer;
	}
	
	@Override
	public boolean isTamed() {
		return tamer != null;
	}
	
}

package org.mcphoton.entity.living;

import org.mcphoton.entity.Entity;

public abstract class LivingEntity extends Entity implements Living, HeadRotateable {
	
	private volatile float hp;
	
	@Override
	public float getHealth() {
		return hp;
	}
	
	@Override
	public void setHealth(float health) {
		this.hp = health;
	}
	
	@Override
	public void damage(float damage) {
		hp -= damage;
	}
	
	@Override
	public void kill() {
		hp = 0;
	}
	
	@Override
	public boolean isAlive() {
		return hp > 0;
	}
	
}

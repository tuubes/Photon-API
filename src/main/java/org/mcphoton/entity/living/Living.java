package org.mcphoton.entity.living;

public interface Living {
	
	float getHealth();
	
	void setHealth(float health);
	
	void damage(float damage);
	
	void kill();
	
	default boolean isAlive() {
		return getHealth() > 0;
	}
	
}

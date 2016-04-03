package org.mcphoton.entity.living;

import org.mcphoton.entity.Entity;

public interface Tameable {
	
	Entity getTamer();
	
	void setTamer(Entity tamer);
	
	boolean isTamed();
	
}

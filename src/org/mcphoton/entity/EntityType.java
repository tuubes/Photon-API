package org.mcphoton.entity;

import com.electronwill.concurrent.IntConstant;

public abstract class EntityType {
	
	private final IntConstant id = new IntConstant();
	
	public int getId() {
		return id.get();
	}
	
	public void initializeId(int id) {
		this.id.init(id);
	}
	
	public abstract String getName();
	
}

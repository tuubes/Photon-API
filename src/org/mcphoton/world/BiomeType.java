package org.mcphoton.world;

import com.electronwill.concurrent.IntConstant;

public abstract class BiomeType {
	
	private final IntConstant id = new IntConstant();
	
	public int getId() {
		return id.get();
	}
	
	public void initializeId(int id) {
		this.id.init(id);
	}
	
	public abstract String getName();
	
}

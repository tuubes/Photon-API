package org.mcphoton.item;

import com.electronwill.concurrent.IntConstant;

public abstract class ItemType {
	
	private final IntConstant id = new IntConstant();
	
	public int getId() {
		return id.get();
	}
	
	public void initializeId(int id) {
		this.id.init(id);
	}
	
	public abstract String getName();
	
}

package org.mcphoton.item;

public interface ItemStack {
	
	int getSize();
	
	void setSize();
	
	int getMaxSize();
	
	ItemType getType();
	
	Inventory getInventory();
	
	void setInventory(Inventory inventory);
	
	int getDamage();
	
	void setDamage();
	
}

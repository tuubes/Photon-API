package org.mcphoton.entity;

import org.mcphoton.item.ItemStack;

public interface Equipable {
	
	ItemStack getItemInHand();
	
	ItemStack getHeadWear();
	
	ItemStack getChestplate();
	
	ItemStack getLeggings();
	
	ItemStack getBoots();
	
	void setItemInHand(ItemStack itemInHand);
	
	void setHeadWear(ItemStack headWear);
	
	void setChestplate(ItemStack chestPlate);
	
	void getLeggings(ItemStack leggings);
	
	void setBoots(ItemStack boots);
	
}

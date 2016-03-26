package org.mcphoton.item;

import java.util.Collection;

public interface Inventory extends Iterable<ItemStack> {
	
	int capacity();
	
	Collection<ItemStack> getContent();
	
	ItemStack getStack(int index);
	
	boolean setStack(int index, ItemStack stack);
	
	boolean addStack(ItemStack stack);
	
	ItemStack removeStack(int index);
	
}

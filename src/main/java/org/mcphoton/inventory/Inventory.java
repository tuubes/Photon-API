/*
 * Copyright (c) 2016 MCPhoton <http://mcphoton.org> and contributors.
 *
 * This file is part of the Photon API <https://github.com/mcphoton/Photon-API>.
 *
 * The Photon API is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * The Photon API is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>.
 */
package org.mcphoton.inventory;

import java.util.Collection;

import org.mcphoton.item.ItemStack;

/**
 * An inventory, which contains some ItemStacks.
 *
 * @author TheElectronWill
 * @author DJmaxZPLAY
 */
public interface Inventory extends Iterable<ItemStack> {

	/**
	 * Gets the inventory's capacity.
	 */
	int capacity();

	/**
	 * Returns a Collection object that contains the ItemStacks or this inventory. Any modification to this
	 * collection is reflected in the inventory, and vice-versa.
	 */
	Collection<ItemStack> getContent();

	/**
	 * Gets the stack at the specified index, or null if there is none.
	 */
	ItemStack getStack(int index);
	
	/**
	 * Gets the title of the inventory.
	 */
	String getTitle();
	
	/**
	 * Gets the type of the inventory.
	 */
	InventoryType getType();

	/**
	 * Sets the stack at the specified index.
	 *
	 * @return the stack that was at this index, if any, or null.
	 */
	ItemStack setStack(int index, ItemStack stack);

	/**
	 * Sets the title of the inventory.
	 */
	void setTitle(String title);
	
	/**
	 * Adds a stack to this inventory. The ItemStack is placed in the first available slot.
	 *
	 * @return true if the stack was added
	 */
	boolean addStack(ItemStack stack);

	/**
	 * Removes the stack at the specified index.
	 *
	 * @return the removed stack
	 */
	ItemStack removeStack(int index);

}

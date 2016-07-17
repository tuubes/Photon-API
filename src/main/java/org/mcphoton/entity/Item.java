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
package org.mcphoton.entity;

import org.mcphoton.item.ItemStack;

/**
 * A dropped ItemStack.
 * 
 * @author DJmaxZPLAY
 */
public interface Item extends Entity {

	/**
	 * Gets the ItemStack of the dropped item.
	 * 
	 * @return itemstack of the dropped item
	 */
	ItemStack getItemStack();
	
	/**
	 * Sets the ItemStack of the dropped item.
	 * 
	 * @param itemStack itemStack of the dropped item
	 */
	void setItemStack(ItemStack itemStack);
	
	/**
	 * Gets the delay before the dropped item can be picked up.
	 * 
	 * @return delay before the dropped item can be picked up
	 */
	int getPickupDelay();
	
	/**
	 * Sets the delay before the dropped item can be picked up.
	 * 
	 * @param delay delay before the dropped item can be picked up
	 */
	void setPickupDelay(int delay);
	
}

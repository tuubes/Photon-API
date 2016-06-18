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

import java.util.Optional;

import org.mcphoton.item.ItemStack;

/**
 * 
 * @author DJmaxZPLAY
 */
public interface ItemFrame extends Entity, Hangeable {

	/**
	 * Get the item in this ItemFrame.
	 * 
	 * @return the item in this ItemFrame.
	 */
	Optional<ItemStack> getItem();
	
	/**
	 * Set the item in this ItemFrame.
	 * 
	 * @param item the item to set in this ItemFrame.
	 */
	void setItem(ItemStack item);
	
	/**
	 * Get the rotation (between 0 and 7) of this ItemFrame.
	 * 
	 * @return the rotation of this ItemFrame.
	 */
	int getRotation();
	
	/**
	 * Set the rotation (between 0 and 7) of this ItemFrame.
	 * 
	 * @param rotation the rotation to set (between 0 and 7).
	 */
	void setRotation(int rotation);
	
}

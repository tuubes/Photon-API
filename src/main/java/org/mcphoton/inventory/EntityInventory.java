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
import org.mcphoton.entity.Entity;
import org.mcphoton.item.ItemStack;

/**
 * The inventory of an entity.
 *
 * @author DJmaxZPLAY
 */
public interface EntityInventory extends Inventory {

	/**
	 * Gets the entity wich holds the inventory.
	 */
	Entity getHolder();

	/**
	 * Returns a Collection object that contains the ItemStacks from the armor slots. Any modification to this
	 * collection is reflected in the armor slots, and vice-versa.
	 */
	Collection<ItemStack> getArmorContents();

	/**
	 * Gets the ItemStack from the boots slot of an entity.
	 */
	ItemStack getBoots();

	/**
	 * Gets the ItemStack from the chestplate slot of an entity.
	 */
	ItemStack getChestplate();

	/**
	 * Gets the ItemStack from the helmet slot of an entity.
	 */
	ItemStack getHelmet();

	/**
	 * Gets the ItemStack from the main hand of an entity.
	 */
	ItemStack getItemInMainHand();

	/**
	 * Gets the ItemStack from the off hand of an entity.
	 */
	ItemStack getItemInOffHand();

	/**
	 * Gets the ItemStack from the leggings slot of an entity.
	 */
	ItemStack getLeggings();

	/**
	 * Sets the ItemStack in the boots slot of an entity.
	 */
	void setBoots(ItemStack stack);

	/**
	 * Sets the ItemStack in the chestplate slot of an entity.
	 */
	void setChestplate(ItemStack stack);

	/**
	 * Sets the ItemStack in the helmet slot of an entity.
	 */
	void setHelmet(ItemStack stack);

	/**
	 * Sets the ItemStack in the main hand of an entity.
	 */
	void setItemInMainHand(ItemStack stack);

	/**
	 * Sets the ItemStack in the off hand of an entity.
	 */
	void setItemInOffHand(ItemStack stack);

	/**
	 * Sets the ItemStack in the leggings slot of an entity.
	 */
	void setLeggings(ItemStack stack);

}

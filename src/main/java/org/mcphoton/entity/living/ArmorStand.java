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
package org.mcphoton.entity.living;

import org.mcphoton.item.ItemStack;

/**
 * 
 * @author DJmaxZPLAY
 */
public interface ArmorStand extends LivingEntity {

	ItemStack getItemInHand();
	
	ItemStack getBoots();
	
	ItemStack getLeggings();
	
	ItemStack getChestplate();
	
	ItemStack getHelmet();
	
	void setItemInHand(ItemStack itemStack);
	
	void setBoots(ItemStack itemStack);
	
	void setLeggings(ItemStack itemStack);
	
	void setChestplate(ItemStack itemStack);
	
	void setHelmet(ItemStack itemStack);
	
	boolean isSmall();
	
	boolean hasArms();
	
	boolean hasBasePlate();
	
	boolean isMarker();
	
	void setSmall(boolean small);
	
	void setArms(boolean arms);
	
	void setBasePlate(boolean baseplate);
	
	void setMarker(boolean marker);
	
}

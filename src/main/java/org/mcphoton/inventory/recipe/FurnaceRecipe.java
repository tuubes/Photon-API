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
package org.mcphoton.inventory.recipe;

import org.mcphoton.item.ItemStack;

/**
 * @author DJmaxZPLAY
 */
public class FurnaceRecipe implements Recipe{

	private ItemStack result, input;
	private float experience;
	
	public FurnaceRecipe(ItemStack result, ItemStack input) {
		this(result, input, 0);
	}
	
	public FurnaceRecipe(ItemStack result, ItemStack input, float exp) {
		this.result = result;
		this.input = input;
		this.experience = exp;
	}
	
	public FurnaceRecipe setInput(ItemStack input) {
		this.input = input;
		return this;
	}
	
	public ItemStack getInput() {
		return input;
	}
	
	@Override
	public ItemStack getResult() {
		return result;
	}
	
	public void setExperience(float exp) {
		this.experience = exp;
	}
	
	public float getExperience() {
		return experience;
	}
}

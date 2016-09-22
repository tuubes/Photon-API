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

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.mcphoton.item.ItemStack;

/**
 * @author DJmaxZPLAY
 */
public class ShapelessRecipe implements Recipe {

	private ItemStack result;
	private List<ItemStack> ingredients = new ArrayList<ItemStack>();
	
	public ShapelessRecipe(ItemStack result, List<ItemStack> ingredients) {
		this.result = result;
		if(ingredients.size() < 10) {
			this.ingredients = ingredients;
		}
	}
	
	public ShapelessRecipe addIngredient(ItemStack ingredient) {
		return addIngredient(1, ingredient);
	}
	
	public ShapelessRecipe addIngredient(int count, ItemStack ingredient) {
		if(ingredients.size() + count > 9) {
			throw new ArithmeticException("Shapeless recipes can'\t have more than 9 ingredients");
		}else {
			while (count-- > 0) {
				ingredients.add(ingredient);
			}
			return this;
		}	
	}
	
	public ShapelessRecipe removeIngredient(ItemStack ingredient) {
		return removeIngredient(1, ingredient);
	}
	
	public ShapelessRecipe removeIngredient(int count, ItemStack ingredient) {
        Iterator<ItemStack> iterator = ingredients.iterator();
        while (count > 0 && iterator.hasNext()) {
            ItemStack stack = iterator.next();
            if (stack == ingredient) {
                iterator.remove();
                count--;
            }
        }
        return this;
    }

	public List<ItemStack> getIngredients() {
		return ingredients;
	}
	
	@Override
	public ItemStack getResult() {
		return result;
	}
}

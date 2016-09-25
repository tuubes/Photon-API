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

import java.util.HashMap;
import java.util.Map;

import org.mcphoton.item.ItemStack;

/**
 * @author DJmaxZPLAY
 */
public class ShapedRecipe implements Recipe {

	private ItemStack result;
	private String[] shape;
	private Map<Character, ItemStack> ingredients = new HashMap<Character, ItemStack>();
	
	public ShapedRecipe(ItemStack result) {
		this.result = result;
	}
	
	public ShapedRecipe setShape(final String... shape) {
		if(shape == null) {
			throw new NullPointerException();
		}
		if(shape.length < 0 || shape.length > 4) {
			throw new ArithmeticException("Shaped recipes should have 1, 2 or 3 rows");
		}
		for(String row : shape) {
			if(row.length() < 0 && row.length() > 4){
				throw new ArithmeticException("Shaped recipes rows should have 1, 2 or 3 characters");
			}
		}
		this.shape = new String[shape.length];
		for(int i = 0; i < shape.length; i++) {
			this.shape[i] = shape[i];
		}	
		HashMap<Character, ItemStack> newIngredients = new HashMap<Character, ItemStack>();
        for (String row : shape) {
            for (Character c : row.toCharArray()) {
                newIngredients.put(c, ingredients.get(c));
            }
        }
        this.ingredients = newIngredients;
		return this;
	}
	
	public ShapedRecipe setIngredient(char character, ItemStack ingredient) {
		if(!ingredients.containsKey(ingredient)){
			throw new IllegalArgumentException("This character does not appear in the shape");
		} else {
			ingredients.put(character, ingredient);
			return this;
		}
	}
	
	public Map<Character, ItemStack> getIngredients() {
		return ingredients;
	}
	
	public String[] getShape() {
		return shape.clone();
	}
	
	@Override
	public ItemStack getResult() {
		return result;
	}
}

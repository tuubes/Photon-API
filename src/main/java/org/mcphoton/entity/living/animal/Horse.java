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
package org.mcphoton.entity.living.animal;

import org.mcphoton.entity.vehicle.Vehicle;
import org.mcphoton.inventory.HorseInventory;
import org.mcphoton.inventory.InventoryHolder;

/**
 * 
 * @author DJmaxZPLAY
 */
public interface Horse extends TameableAnimal, Vehicle, InventoryHolder {

	boolean isCarryingChest();
	
	void setCarryingChest(boolean chest);
	
	int getDomestication();
	
	void setDomestication(int level);
	
	int getMaxDomestication();
	
	void setMaxDomestication(int maxLevel);
	
	double getJumpStrength();
	
	void setJumpStrength(double strength);
	
	@Override
	HorseInventory getInventory();
	
	Variant getVariant();
	
	void setVariant(Variant variant);
	
	Color getColor();
	
	void setColor(Color color);
	
	Style getStyle();
	
	void setStyle(Style style);
	
	public enum Variant {
		HORSE,
		DONKEY,
		MULE,
		ZOMBIFIED,
		SKELETON;
	}
	
	public enum Color {
		WHITE,
		CREAMY,
		CHESTNUT,
		BROWN,
		BLACK,
		GRAY,
		DARK_BROWN;
	}
	
	public enum Style {
		NONE,
		WHITE,
		WHITEFIELD,
		WHITE_DOTS,
		BLACK_DOTS;
	}
	
}

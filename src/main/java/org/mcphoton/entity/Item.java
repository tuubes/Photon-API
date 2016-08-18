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
 * @author TheElectronWill
 */
public interface Item extends Entity, Rotateable {

	/**
	 * Gets the corresponding ItemStack.
	 */
	ItemStack getItemStack();

	/**
	 * Sets the corresponding ItemStack.
	 */
	void setItemStack(ItemStack itemStack);

}

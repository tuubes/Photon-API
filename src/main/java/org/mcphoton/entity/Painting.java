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

import org.mcphoton.block.BlockFace;

/**
 * A painting hung on a wall.
 *
 * @author TheElectronWill
 */
public interface Painting extends Entity {

	/**
	 * Gets the painting's title.
	 */
	String getTitle();

	/**
	 * Sets the painting's title. You cannot write the title you want: there are only some values that are recognized by the game client.
	 */
	void setTitle(String title);

	/**
	 * Gets the direction the painting faces. Possible values are north, south, east, west.
	 */
	BlockFace getDirection();

	/**
	 * Sets the direction the painting faces. Possible values are north, south, east, west.
	 */
	void setDirection(BlockFace dir);

}

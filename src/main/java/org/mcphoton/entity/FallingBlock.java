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

import org.mcphoton.block.BlockType;

/**
 * A Falling Block
 * 
 * @author DJmaxZPLAY
 */
public interface FallingBlock extends Entity {

	/**
	 * Gets the BlockType of the falling block.
	 * 
	 * @return BlockType of the falling block
	 */
	BlockType getBlockType();
	
	/**
	 * Return if the falling block drops an item if it can't be placed.
	 * 
	 * @return true if it will drop an item if it can't be placed
	 */
	boolean dropItem();
	
	/**
	 * Sets if the falling block drops an item if it can't be placed.
	 * 
	 * @param drop drop an item if it can't be placed
	 */
	void setDropItem(boolean drop);
	
	/**
	 * Return if the falling block can hurt entities.
	 * 
	 * @return true if the falling block can hurt entities
	 */
	boolean canHurtEntities();
	
	/**
	 * Sets if the falling block can hurt entities.
	 * 
	 * @param hurt hurt the entities
	 */
	void setHurtEntities(boolean hurt);
	
}

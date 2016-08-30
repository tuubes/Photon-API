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
package org.mcphoton.block;

/**
 * Represents the data that defines a block: its BlockType + its additional data.
 *
 * @author TheElectronWill
 */
public final class BlockData {

	private final BlockType type;
	private final byte additional;

	/**
	 * Creates a new BlockData.
	 *
	 * @param type the block's type.
	 * @param additional the block's additional data, maximum value = 15.
	 */
	public BlockData(BlockType type, byte additional) {
		this.type = type;
		this.additional = additional;
	}

	/**
	 * Creates a new BlockData with an additional data of 0.
	 *
	 * @param type the block's type.
	 */
	public BlockData(BlockType type) {
		this.type = type;
		this.additional = 0;
	}

	/**
	 * @return the block's type.
	 */
	public BlockType getType() {
		return type;
	}

	/**
	 * @return the block's type id, without the additional data.
	 */
	public int getTypeId() {
		return type.getId();
	}

	/**
	 * @return the block's additional data
	 */
	public byte getAdditionalData() {
		return additional;
	}

	/**
	 * Calculates and returns the "full" block id: its type id + its additional data, constructed like this:
	 * {@code int fullId = type.getUniqueId() << 4 | (additional & 15)}
	 *
	 * @return the block's full id.
	 */
	public int getFullId() {
		return type.getId() << 4 | (additional & 15);
	}

}

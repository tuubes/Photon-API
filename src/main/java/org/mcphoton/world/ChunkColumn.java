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
package org.mcphoton.world;

import java.util.Collection;

/**
 * A chunk column: up to 16 chunk sections aligned vertically, for a total of 16x256x16 = 65536 blocks.
 *
 * @author TheElectronWill
 */
public interface ChunkColumn {

	/**
	 * Gets the chunk x coordinate, which isn't the x coordinate of the first block in this chunk! The first
	 * chunk is (0,0), the adjacent one is (0,1) etc.
	 *
	 * @return the chunk x coordinate.
	 */
	int getX();

	/**
	 * Gets the chunk z coordinate, which isn't the z coordinate of the first block in this chunk! The first
	 * chunk is (0,0), the adjacent one is (0,1) etc.
	 *
	 * @return the chunk z coordinate.
	 */
	int getZ();

	/**
	 * @return the world this chunk is in.
	 */
	World getWorld();

	/**
	 * @return an unmodifiable collection containing the chunk sections.
	 */
	Collection<ChunkSection> getSections();

	/**
	 * Gets the biome's id of a given XZ column.
	 *
	 * @param x the column's x coordinate in the chunk.
	 * @param z the column's z coordinate in the chunk.
	 * @return the biome's id of the given column.
	 */
	int getBiomeId(int x, int z);

	/**
	 * Sets the biome's id of a given XZ column.
	 *
	 * @param x the column's x coordinate in the chunk.
	 * @param z the column's z coordinate in the chunk.
	 * @param biomeId the biome's id to set.
	 */
	void setBiomeId(int x, int z, int biomeId);

	/**
	 * @param x X coordinate in the chunk column.
	 * @param y Y coordinate in the chunk column.
	 * @param z Z coordinate in the chunk column.
	 * @return the block's simple id (without its metadata).
	 */
	int getBlockId(int x, int y, int z);

	/**
	 * Sets a block's id (simple id, without the metadata).
	 *
	 * @param x X coordinate in the chunk column.
	 * @param y Y coordinate in the chunk column.
	 * @param z Z coordinate in the chunk column.
	 * @param blockId the block's simple id (without its metadata).
	 */
	void setBlockId(int x, int y, int z, int blockId);

	/**
	 * @param x X coordinate in the chunk column.
	 * @param y Y coordinate in the chunk column.
	 * @param z Z coordinate in the chunk column.
	 * @return the block's full id (with its metadata).
	 */
	int getBlockFullId(int x, int y, int z);

	/**
	 * Sets a block's full id (with the metadata).
	 *
	 * @param x X coordinate in the chunk column.
	 * @param y Y coordinate in the chunk column.
	 * @param z Z coordinate in the chunk column.
	 * @param blockFullId the block's full id (with its metadata).
	 */
	void setBlockFullId(int x, int y, int z, int blockFullId);

	/**
	 * @param x X coordinate in the chunk column.
	 * @param y Y coordinate in the chunk column.
	 * @param z Z coordinate in the chunk column.
	 * @return the block's metadata (without its id).
	 */
	int getBlockMetadata(int x, int y, int z);

	/**
	 * Sets a block's metadata (without the id).
	 *
	 * @param x X coordinate in the chunk column.
	 * @param y Y coordinate in the chunk column.
	 * @param z Z coordinate in the chunk column.
	 * @param blockMetadata the block's metadata (without its id).
	 */
	void setBlockMetadata(int x, int y, int z, int blockMetadata);

	/**
	 * Fills a part of this chunk column with the specified block type.
	 *
	 * @param x0 initial x coordinate in the chunk column.
	 * @param y0 initial y coordinate in the chunk column.
	 * @param z0 initial z coordinate in the chunk column.
	 * @param x1 final x coordinate in the chunk column.
	 * @param y1 final y coordinate in the chunk column.
	 * @param z1 final z coordinate in the chunk column.
	 * @param blockFullId the block's simple id (without its metadata).
	 */
	void fillBlockId(int x0, int y0, int z0, int x1, int y1, int z1, int blockId);

	/**
	 * Fills a part of this chunk column with the specified block type.
	 *
	 * @param x0 initial x coordinate in the chunk column.
	 * @param y0 initial y coordinate in the chunk column.
	 * @param z0 initial z coordinate in the chunk column.
	 * @param x1 final x coordinate in the chunk column.
	 * @param y1 final y coordinate in the chunk column.
	 * @param z1 final z coordinate in the chunk column.
	 * @param blockFullId the block's full id (with its metadata).
	 */
	void fillBlockFullId(int x0, int y0, int z0, int x1, int y1, int z1, int blockFullId);

	/**
	 * Replaces every occurence of a block's id.
	 *
	 * @param toReplace the id (without metadata) to replace.
	 * @param replacement the replacement.
	 */
	void replaceBlockId(int toReplace, int replacement);

	/**
	 * Replaces every occurence of a block's full id.
	 *
	 * @param toReplace the full id to replace.
	 * @param replacement the replacement.
	 */
	void replaceBlockFullId(int toReplace, int replacement);

}

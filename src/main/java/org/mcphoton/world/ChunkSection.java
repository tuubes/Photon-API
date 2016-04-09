package org.mcphoton.world;

/**
 * A chunk section: 16x16x16 blocks.
 *
 * @author TheElectronWill
 */
public interface ChunkSection {

	int getBlockId(int x, int z);

	void setBlockId(int x, int z, int blockId);

}

package org.mcphoton.world;

import java.util.Collection;

/**
 * A chunk column: 16 chunk sections aligned vertically, ie 16x256x16 blocks.
 *
 * @author TheElectronWill
 */
public interface ChunkColumn {

	int getX();

	int getZ();

	World getWorld();

	Collection<ChunkSection> getSections();

}

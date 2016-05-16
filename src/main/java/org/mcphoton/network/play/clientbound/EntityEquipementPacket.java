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
package org.mcphoton.network.play.clientbound;

import java.io.IOException;
import java.nio.ByteBuffer;
import org.mcphoton.item.ItemStack;
import org.mcphoton.network.Packet;
import org.mcphoton.network.ProtocolOutputStream;

/**
 *
 * @author DJmaxZPL4Y
 * @author TheElectronWill
 */
public class EntityEquipementPacket implements Packet {

	public static final int SLOT_MAIN_HAND = 0, SLOT_OFF_HAND = 1, SLOT_BOOTS = 2, SLOT_LEGGINGS = 3, SLOT_CHESTPLATE = 4, SLOT_HELMET = 5;
	public int entityId, slot;
	public ItemStack item;

	@Override
	public int getId() {
		return 0x3C;
	}

	@Override
	public boolean isServerBound() {
		return false;
	}

	@Override
	public void writeTo(ProtocolOutputStream out) throws IOException {
		out.writeVarInt(entityId);
		out.writeVarInt(slot);
		item.writeTo(out);
	}

	@Override
	public Packet readFrom(ByteBuffer buff) {
		throw new UnsupportedOperationException("Not implemented yet, because it's useless for the server.");
	}

	@Override
	public String toString() {
		return "EntityEquipementPacket{" + "entityId=" + entityId + ", slot=" + slot + ", item=" + item + '}';
	}

}

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
public class SetSlotPacket implements Packet {

	/**
	 * Standard window id.
	 */
	public static final int PLAYER_INVENTORY = 0;

	/**
	 * To set the item under the cursor (dragged with the mouse), set windowId and slot to this value.
	 */
	public static final int MOUSE_CURSOR = -1;

	public int windowId, slot;
	public ItemStack item;

	@Override
	public int getId() {
		return 0x16;
	}

	@Override
	public boolean isServerBound() {
		return false;
	}

	@Override
	public void writeTo(ProtocolOutputStream out) throws IOException {
		out.writeByte(windowId);
		out.writeShort(slot);
		item.writeTo(out);
	}

	@Override
	public Packet readFrom(ByteBuffer buff) {
		throw new UnsupportedOperationException("Not implemented yet, because it's useless for the server.");
	}

	@Override
	public String toString() {
		return "SetSlotPacket{" + "windowId=" + windowId + ", slot=" + slot + ", item=" + item + '}';
	}

}

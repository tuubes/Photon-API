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
package org.mcphoton.network.play.serverbound;

import java.nio.ByteBuffer;
import org.mcphoton.network.Packet;
import org.mcphoton.network.ProtocolHelper;
import org.mcphoton.network.ProtocolOutputStream;

/**
 *
 * @author DJmaxZPLAY
 */
public class ClickWindowPacket implements Packet {

	public int windowId, mode;
	public byte button;
	public short slot, action;

	@Override
	public int getId() {
		return 0x07;
	}

	@Override
	public boolean isServerBound() {
		return true;
	}

	@Override
	public void writeTo(ProtocolOutputStream out) {
		out.writeByte(windowId);
		out.writeShort(slot);
		out.writeByte(button);
		out.writeShort(action);
		out.writeVarInt(mode);
		//TODO Write Slot
	}

	@Override
	public Packet readFrom(ByteBuffer buff) {
		windowId = ProtocolHelper.readUnsignedByte(buff.get());
		slot = buff.getShort();
		button = buff.get();
		action = buff.getShort();
		mode = ProtocolHelper.readVarInt(buff);
		//TODO Read Slot
		return this;
	}

	@Override
	public String toString() {
		return "ClickWindowPacket{" + "windowId=" + windowId + ", slot=" + slot + ", button=" + button + ", action=" + action + ", mode=" + mode + '}';
	}
}

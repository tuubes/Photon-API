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
public class PlayerBlockPlacementPacket implements Packet {

	public int x, y, z, face, hand, cursorPositionX, cursorPositionY, cursorPositionZ;

	@Override
	public int getId() {
		return 0x1C;
	}

	@Override
	public boolean isServerBound() {
		return true;
	}

	@Override
	public void writeTo(ProtocolOutputStream out) {;
		out.writeLong(ProtocolHelper.encodePosition(x, y, z));
		out.writeVarInt(face);
		out.writeVarInt(hand);
		out.writeByte(cursorPositionX);
		out.writeByte(cursorPositionY);
		out.writeByte(cursorPositionZ);
	}

	@Override
	public Packet readFrom(ByteBuffer buff) {
		long pos = buff.getLong();
		x = ProtocolHelper.decodePositionX(pos);
		y = ProtocolHelper.decodePositionX(pos);
		z = ProtocolHelper.decodePositionX(pos);
		face = ProtocolHelper.readVarInt(buff);
		hand = ProtocolHelper.readVarInt(buff);
		cursorPositionX = ProtocolHelper.readUnsignedByte(buff.get());
		cursorPositionY = ProtocolHelper.readUnsignedByte(buff.get());
		cursorPositionZ = ProtocolHelper.readUnsignedByte(buff.get());
		return this;
	}

	@Override
	public String toString() {
		return "PlayerBlockPlacementPacket{" + "x=" + x + ", y=" + y + ", z=" + z + ", face=" + face + ", hand=" + hand + ", cursorPositionX=" + cursorPositionX + ", cursorPositionY=" + cursorPositionY + ", cursorPositionZ=" + cursorPositionZ + '}';
	}
}

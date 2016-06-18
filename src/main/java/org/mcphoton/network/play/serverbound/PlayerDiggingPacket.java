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
public class PlayerDiggingPacket implements Packet {

	public int status, x, y, z;
	public byte face;

	@Override
	public int getId() {
		return 0x13;
	}

	@Override
	public boolean isServerBound() {
		return true;
	}

	@Override
	public void writeTo(ProtocolOutputStream out) {;
		out.writeVarInt(status);
		out.writeLong(ProtocolHelper.encodePosition(x, y, z));
		out.writeByte(face);
	}

	@Override
	public Packet readFrom(ByteBuffer buff) {
		status = ProtocolHelper.readVarInt(buff);
		long pos = buff.getLong();
		x = ProtocolHelper.decodePositionX(pos);
		y = ProtocolHelper.decodePositionY(pos);
		z = ProtocolHelper.decodePositionZ(pos);
		face = buff.get();
		return this;
	}

	@Override
	public String toString() {
		return "PlayerDiggingPacket{" + "status=" + status + ", x=" + x + ", y=" + y + ", z=" + z + ", face=" + face + '}';
	}
}

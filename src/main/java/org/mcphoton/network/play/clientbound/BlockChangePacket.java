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

import java.nio.ByteBuffer;
import org.mcphoton.network.Packet;
import org.mcphoton.network.ProtocolHelper;
import org.mcphoton.network.ProtocolOutputStream;

/**
 * @author Maaattt
 */
public class BlockChangePacket implements Packet {

	public int x, y, z;
	public int blockId;

	@Override
	public int getId() {
		return 0x0B;
	}

	@Override
	public boolean isServerBound() {
		return false;
	}

	@Override
	public void writeTo(ProtocolOutputStream out) {
		out.writeLong(ProtocolHelper.encodePosition(x, y, z));
		out.writeVarInt(blockId);

	}

	@Override
	public Packet readFrom(ByteBuffer buff) {
		long pos = buff.getLong();
		x = ProtocolHelper.decodePositionX(pos);
		y = ProtocolHelper.decodePositionY(pos);
		z = ProtocolHelper.decodePositionZ(pos);
		blockId = ProtocolHelper.readVarInt(buff);
		return this;
	}

	@Override
	public String toString() {
		return "BlockChangePacket{" + "x=" + x + ", y=" + y + ", z=" + z + ", blockId=" + blockId + '}';
	}
}

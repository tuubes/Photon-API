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
import java.util.UUID;
import org.mcphoton.network.Packet;
import org.mcphoton.network.ProtocolHelper;
import org.mcphoton.network.ProtocolOutputStream;

/**
 * @author Maaattt
 */
public class SpawnPaintingPacket implements Packet {

	public int entityId;
	public UUID entityUUID;
	public String title;
	public int x, y, z;
	public byte direction;

	@Override
	public int getId() {
		return 0x04;
	}

	@Override
	public boolean isServerBound() {
		return false;
	}

	@Override
	public void writeTo(ProtocolOutputStream out) {
		out.writeVarInt(entityId);
		out.writeLong(entityUUID.getMostSignificantBits());
		out.writeLong(entityUUID.getLeastSignificantBits());
		out.writeString(title);
		long pos = ProtocolHelper.encodePosition(x, y, z);
		out.writeLong(pos);
		out.writeByte(direction);
	}

	@Override
	public Packet readFrom(ByteBuffer buff) {
		entityId = ProtocolHelper.readVarInt(buff);
		long MSB = buff.getLong();
		long LSB = buff.getLong();
		entityUUID = new UUID(MSB, LSB);
		title = ProtocolHelper.readString(buff);
		long pos = buff.getLong();
		x = ProtocolHelper.decodePositionX(pos);
		y = ProtocolHelper.decodePositionY(pos);
		z = ProtocolHelper.decodePositionZ(pos);
		direction = buff.get();
		return this;
	}

	@Override
	public String toString() {
		return "SpawnPaintingPacket{" + "entityId=" + entityId + ", entityUUID=" + entityUUID + ", title='" + title + '\'' + ", x=" + x + ", y=" + y + ", z=" + z + ", direction=" + direction + '}';
	}
}

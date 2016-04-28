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
 *
 * @author Maaattt
 */
public class SpawnMobPacket implements Packet {

	public int entityId;
	public UUID entityUUID;
	public int type;
	public double x, y, z;
	public byte yaw, pitch, headPitch;
	public short velocityX, velocityY, velocityZ;
	public byte metadata;

	@Override
	public int getId() {
		return 0x03;
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
		out.writeByte(type);
		out.writeDouble(x);
		out.writeDouble(y);
		out.writeDouble(z);
		out.writeByte(yaw);
		out.writeByte(pitch);
		out.writeByte(headPitch);
		out.writeShort(velocityX);
		out.writeShort(velocityY);
		out.writeShort(velocityZ);
		out.writeByte(metadata);
	}

	@Override
	public Packet readFrom(ByteBuffer buff) {
		entityId = ProtocolHelper.readVarInt(buff);
		long MSB = buff.getLong();
		long LSB = buff.getLong();
		entityUUID = new UUID(MSB, LSB);
		type = ProtocolHelper.readUnsignedByte(buff.get());
		x = buff.getDouble();
		y = buff.getDouble();
		z = buff.getDouble();
		yaw = buff.get();
		pitch = buff.get();
		headPitch = buff.get();
		velocityX = buff.getShort();
		velocityY = buff.getShort();
		velocityZ = buff.getShort();
		metadata = buff.get();
		return this;
	}

	@Override
	public String toString() {
		return "SpawnMobPacket{" + "entityId=" + entityId + ", entityUUID=" + entityUUID + ", type=" + type + ", x=" + x + ", y=" + y + ", z=" + z + ", yaw=" + yaw + ", pitch=" + pitch + ", headPitch=" + headPitch + ", velocityX=" + velocityX + ", velocityY=" + velocityY + ", velocityZ=" + velocityZ + ", metadata=" + metadata + '}';
	}
}

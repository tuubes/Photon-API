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
import java.util.Arrays;
import org.mcphoton.network.Packet;
import org.mcphoton.network.ProtocolHelper;
import org.mcphoton.network.ProtocolOutputStream;

/**
 *
 * @author DJmaxZPL4Y
 */
public class ParticlePacket implements Packet {

	public int particleId;
	public boolean longDistance;
	public float x, y, z, offsetX, offsetY, offsetZ, particleData;
	public int data[];

	@Override
	public int getId() {
		return 0x22;
	}

	@Override
	public boolean isServerBound() {
		return false;
	}

	@Override
	public void writeTo(ProtocolOutputStream out) {
		out.writeInt(particleId);
		out.writeBoolean(longDistance);
		out.writeFloat(x);
		out.writeFloat(y);
		out.writeFloat(z);
		out.writeFloat(offsetX);
		out.writeFloat(offsetY);
		out.writeFloat(offsetZ);
		out.writeFloat(particleData);
		out.writeInt(data.length);
		for (int i : data) {
			out.writeVarInt(i);
		}
	}

	@Override
	public Packet readFrom(ByteBuffer buff) {
		particleId = buff.getInt();
		longDistance = ProtocolHelper.readBoolean(buff);
		x = buff.getFloat();
		y = buff.getFloat();
		z = buff.getFloat();
		offsetX = buff.getFloat();
		offsetY = buff.getFloat();
		offsetZ = buff.getFloat();
		particleData = buff.getFloat();
		data = new int[buff.getInt()];
		for (int i = 0; i < data.length; i++) {
			data[i] = ProtocolHelper.readVarInt(buff);
		}
		return this;
	}

	@Override
	public String toString() {
		return "ParticlePacket{" + "particleId=" + particleId + ", longDistance=" + longDistance + ", x=" + x + ", y=" + y + ", z=" + z + ", offsetX=" + offsetX + ", offsetY=" + offsetY + ", offsetZ=" + offsetZ + ", particleData=" + particleData + ", data=" + Arrays.toString(data) + '}';
	}

}

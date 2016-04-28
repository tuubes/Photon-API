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
import org.mcphoton.network.ProtocolOutputStream;

/**
 *
 * @author DJmaxZPL4Y
 */
public class ExplosionPacket implements Packet {

	public float x, y, z, radius, playerMotionX, playerMotionY, playerMotionZ;
	public Records[] records;

	@Override
	public int getId() {
		return 0x1C;
	}

	@Override
	public boolean isServerBound() {
		return false;
	}

	@Override
	public void writeTo(ProtocolOutputStream out) {
		out.writeFloat(x);
		out.writeFloat(y);
		out.writeFloat(z);
		out.writeFloat(radius);
		out.writeInt(records.length);
		for(Records record : records){
			out.writeByte(record.getXOffset());
			out.writeByte(record.getYOffset());
			out.writeByte(record.getZOffset());
		}
		out.writeFloat(playerMotionX);
		out.writeFloat(playerMotionY);
		out.writeFloat(playerMotionZ);
	}

	@Override
	public Packet readFrom(ByteBuffer buff) {
		x = buff.getFloat();
		y = buff.getFloat();
		z = buff.getFloat();
		radius = buff.getFloat();
		records = new Records[buff.getInt()];
		for(int i = 0; i < records.length; i++){
			records[i] = new Records(buff.get(), buff.get(), buff.get());
		}
		playerMotionX = buff.getFloat();
		playerMotionY = buff.getFloat();
		playerMotionZ = buff.getFloat();
		return this;
	}

	@Override
	public String toString() {
		return "ExplosionPacket{" + "x=" + x + ", y=" + y + ", z=" + z + ", radius=" + radius + ", records=" + Arrays.toString(records) + "playerMotionX=" + playerMotionX + ", playerMotionY=" + playerMotionY + ", playerMotionZ=" + playerMotionZ + '}';
	}

	public class Records{

		private byte xOffset, yOffset, zOffset;
		
		public Records(byte xOffset, byte yOffset, byte zOffset){
			this.xOffset = xOffset;
			this.yOffset = yOffset;
			this.zOffset = zOffset;
		}
		
		public byte getXOffset() {
			return xOffset;
		}

		public byte getZOffset() {
			return yOffset;
		}

		public byte getYOffset() {
			return zOffset;
		}
	}
}

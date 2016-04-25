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
 * @author Maaattt
 */
public class MultiBlockChangePacket implements Packet {

	public int chunkX;
	public int chunkZ;
	public BlockUpdateData[] record;

	@Override
	public int getId() {
		return 0x10;
	}

	@Override
	public boolean isServerBound() {
		return false;
	}

	@Override
	public void writeTo(ProtocolOutputStream out) {
		out.writeInt(chunkX);
		out.writeInt(chunkZ);
		out.writeVarInt(record.length);
		for (BlockUpdateData blocks : record) {
			out.writeByte(blocks.getHorizontalPos());
			out.writeByte(blocks.getYCoord());
			out.writeVarInt(blocks.getBlockId());
		}
	}

	@Override
	public Packet readFrom(ByteBuffer buff) {
		chunkX = buff.getInt();
		chunkZ = buff.getInt();
		record = new BlockUpdateData[ProtocolHelper.readVarInt(buff)];
		for (int i = 0; i < record.length; i++) {
			record[i] = new BlockUpdateData(ProtocolHelper.readUnsignedByte(buff.get()), ProtocolHelper.readUnsignedByte(buff.get()), ProtocolHelper.readVarInt(buff));
		}

		return this;
	}

	class BlockUpdateData {

		private int horizontalPos;
		private int yCoord;
		private int blockId;

		public BlockUpdateData(Integer horizontalPos, Integer yCoord, Integer blockId) {
			this.horizontalPos = horizontalPos;
			this.yCoord = yCoord;
			this.blockId = blockId;
		}

		public Integer getHorizontalPos() {
			return horizontalPos;
		}

		public Integer getYCoord() {
			return yCoord;
		}

		public Integer getBlockId() {
			return blockId;
		}
	}

	@Override
	public String toString() {
		return "MultiBlockChangePacket{" + "chunkX=" + chunkX + ", chunkZ=" + chunkZ + ", record=" + Arrays.toString(record) + '}';
	}
}

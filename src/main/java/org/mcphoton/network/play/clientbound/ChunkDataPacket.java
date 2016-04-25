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
import org.mcphoton.world.ChunkSection;

/**
 *
 * @author TheElectronWill
 */
public class ChunkDataPacket implements Packet {

	public int chunkX, chunkZ;
	public boolean groundUpContinuous;
	public int bitMask;
	public ChunkSection[] sections;
	public byte[] biomes;

	@Override
	public int getId() {
		return 0x20;
	}

	@Override
	public boolean isServerBound() {
		return false;
	}

	@Override
	public void writeTo(ProtocolOutputStream out) {
		; //TODO
	}

	@Override
	public Packet readFrom(ByteBuffer buff) {
		chunkX = buff.getInt();
		chunkZ = buff.getInt();
		groundUpContinuous = ProtocolHelper.readBoolean(buff);
		bitMask = ProtocolHelper.readVarInt(buff);
		int dataSize = ProtocolHelper.readVarInt(buff);
		byte[] data = new byte[dataSize];
		buff.get(data);
		return this;
	}

	@Override
	public String toString() {
		return "ChunkDataPacket{" + "chunkX=" + chunkX + ", chunkZ=" + chunkZ + ", groundUpContinuous=" + groundUpContinuous + ", bitMask=" + bitMask + ", sections=" + sections + ", biomes=" + biomes + '}';
	}

}

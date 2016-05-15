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
package org.mcphoton.entity;

import java.util.UUID;
import org.mcphoton.messaging.ChatMessage;
import org.mcphoton.network.ByteArrayProtocolOutputStream;
import org.mcphoton.network.ProtocolHelper;
import org.mcphoton.network.ProtocolOutputStream;

/**
 *
 * @author TheElectronWill
 */
public class MetadataBuilder {

	protected final ProtocolOutputStream out;

	public MetadataBuilder() {
		this(16);
	}

	public MetadataBuilder(int initialCapacity) {
		this.out = new ByteArrayProtocolOutputStream(initialCapacity);
	}

	public void putByte(byte b) {
		out.writeByte(out.size());//index
		out.writeByte(0);//type
		out.writeByte(b);//data
	}

	public void putVarInt(int i) {
		out.writeByte(out.size());
		out.writeByte(1);
		out.writeVarInt(i);
	}

	public void putFloat(float f) {
		out.writeByte(out.size());
		out.writeByte(2);
		out.writeFloat(f);
	}

	public void putString(String s) {
		out.writeByte(out.size());
		out.writeByte(3);
		out.writeString(s);
	}

	public void putChatMessage(ChatMessage msg) {
		out.writeByte(out.size());
		out.writeByte(4);
		out.writeString(msg.toString());
	}

	//TODO putSlot
	//
	public void putBoolean(boolean b) {
		out.writeByte(out.size());
		out.writeByte(6);
		out.writeBoolean(b);
	}

	public void putRotation(float rx, float ry, float rz) {
		out.writeByte(out.size());
		out.writeByte(7);
		out.writeFloat(rx);
		out.writeFloat(ry);
		out.writeFloat(rz);
	}

	public void putPosition(int x, int y, int z) {
		out.writeByte(out.size());
		out.writeByte(8);
		out.writeLong(ProtocolHelper.encodePosition(x, y, z));
	}

	public void putOptionalPosition(int x, int y, int z) {
		out.writeByte(out.size());
		out.writeByte(9);
		out.writeBoolean(true);
		out.writeLong(ProtocolHelper.encodePosition(x, y, z));
	}

	public void putDirection(int d) {
		out.writeByte(out.size());
		out.writeByte(10);
		out.writeVarInt(d);
	}

	public void putOptionalUUID(UUID uuid) {
		out.writeByte(out.size());
		out.writeByte(11);
		out.writeBoolean(true);
		out.writeLong(uuid.getMostSignificantBits());
		out.writeLong(uuid.getLeastSignificantBits());
	}

	public void putBlockId(int id) {
		out.writeByte(out.size());
		out.writeByte(12);
		out.writeVarInt(id);
	}

}

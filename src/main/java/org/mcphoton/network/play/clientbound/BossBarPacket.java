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
public class BossBarPacket implements Packet {

	public UUID barUUID;
	public int action;
	public String chat;
	public float health;
	public int color;
	public int division;
	public byte flags;

	@Override
	public int getId() {
		return 0x0C;
	}

	@Override
	public boolean isServerBound() {
		return false;
	}

	@Override
	public void writeTo(ProtocolOutputStream out) {
		out.writeLong(barUUID.getMostSignificantBits());
		out.writeLong(barUUID.getLeastSignificantBits());
		out.writeVarInt(action);
		switch (action) {
			case 0:
				out.writeString(chat);
				out.writeFloat(health);
				out.writeVarInt(color);
				out.writeVarInt(division);
				out.writeByte(flags);
				break;
			case 2:
				out.writeFloat(health);
				break;
			case 3:
				out.writeString(chat);
				break;
			case 4:
				out.writeVarInt(color);
				out.writeVarInt(division);
				break;
			case 5:
				out.writeByte(flags);
				break;
			default:
				break;
		}
	}

	@Override
	public Packet readFrom(ByteBuffer buff) {
		long MSB = buff.getLong();
		long LSB = buff.getLong();
		barUUID = new UUID(MSB, LSB);
		action = ProtocolHelper.readUnsignedByte(buff.get());
		switch (action) {
			case 0:
				chat = ProtocolHelper.readString(buff);
				health = buff.getFloat();
				color = ProtocolHelper.readVarInt(buff);
				division = ProtocolHelper.readVarInt(buff);
				flags = buff.get();
				break;
			case 2:
				health = buff.getFloat();
				break;
			case 3:
				color = ProtocolHelper.readVarInt(buff);
				break;
			case 4:
				color = ProtocolHelper.readVarInt(buff);
				division = ProtocolHelper.readVarInt(buff);
				break;
			case 5:
				flags = buff.get();
				break;
			default:
				break;
		}
		return this;
	}

	@Override
	public String toString() {
		return "BossBarPacket{" + "barUUID=" + barUUID + ", action=" + action + ", chat='" + chat + '\'' + ", health=" + health + ", color=" + color + ", division=" + division + ", flags=" + flags + '}';
	}
}

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
 *
 * @author DJmaxZPL4Y
 */
public class UpdateScorePacket implements Packet {

	public String scoreName, objectiveName;
	public byte action;
	public int value;

	@Override
	public int getId() {
		return 0x42;
	}

	@Override
	public boolean isServerBound() {
		return false;
	}

	@Override
	public void writeTo(ProtocolOutputStream out) {
		out.writeString(scoreName);
		out.writeByte(action);
		out.writeString(objectiveName);
		if(action != 1){
			out.writeVarInt(value);
		}
	}

	@Override
	public Packet readFrom(ByteBuffer buff) {
		scoreName = ProtocolHelper.readString(buff);
		action = buff.get();
		objectiveName = ProtocolHelper.readString(buff);
		if(action != 1){
			value = ProtocolHelper.readVarInt(buff);
		}		
		return this;
	}

	@Override
	public String toString() {
		return "UpdateScorePacket{" + "scoreName=" + scoreName + ", action=" + action + ", objectiveName=" + objectiveName + ", value=" + value + '}';
	}
}
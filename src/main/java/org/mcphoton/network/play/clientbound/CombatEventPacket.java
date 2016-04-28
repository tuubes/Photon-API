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
public class CombatEventPacket implements Packet {

	public int event, duration, entityId, playerId;;
	public String message;

	@Override
	public int getId() {
		return 0x2C;
	}

	@Override
	public boolean isServerBound() {
		return false;
	}

	@Override
	public void writeTo(ProtocolOutputStream out) {
		out.writeVarInt(event);
		switch (event) {
			case 1:
				out.writeVarInt(duration);
				out.writeInt(entityId);
				break;
			case 2:
				out.writeVarInt(playerId);
				out.writeInt(entityId);
				out.writeString(message);
				break;
		}
		
	}

	@Override
	public Packet readFrom(ByteBuffer buff) {
		event = ProtocolHelper.readVarInt(buff);
		switch (event) {
			case 1:
				duration = ProtocolHelper.readVarInt(buff);
				entityId = buff.getInt();
				break;
			case 2:
				playerId = ProtocolHelper.readVarInt(buff);
				entityId = buff.getInt();
				message = ProtocolHelper.readString(buff);
				break;
		}
		return this;
	}

	@Override
	public String toString() {
		return "CombatEvent{" + "event=" + event + ", duration=" + duration + ", entityId=" + entityId + ", playerId=" + playerId + ", message='" + message + '\'' + '}';
	}

}

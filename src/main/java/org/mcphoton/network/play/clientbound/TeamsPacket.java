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
public class TeamsPacket implements Packet {

	public String teamName, teamDisplayName, teamPrefix, teamSuffix, nameTagVisibility, collisionRule;
	public byte mode, friendlyFlags, color;
	public String players[];

	@Override
	public int getId() {
		return 0x41;
	}

	@Override
	public boolean isServerBound() {
		return false;
	}

	@Override
	public void writeTo(ProtocolOutputStream out) {
		out.writeString(teamName);
		out.writeByte(mode);
		switch (mode) {
			case 0:
				out.writeString(teamDisplayName);
				out.writeString(teamPrefix);
				out.writeString(teamSuffix);
				out.writeByte(friendlyFlags);
				out.writeString(nameTagVisibility);
				out.writeString(collisionRule);
				out.writeByte(color);
				out.writeVarInt(players.length);
				for (String player : players) {
					out.writeString(player);
				}
				break;
			case 2:
				out.writeString(teamDisplayName);
				out.writeString(teamPrefix);
				out.writeString(teamSuffix);
				out.writeByte(friendlyFlags);
				out.writeString(nameTagVisibility);
				out.writeString(collisionRule);
				out.writeByte(color);
				break;
			case 3:
				out.writeVarInt(players.length);
				for (String player : players) {
					out.writeString(player);
				}
				break;
			case 4:
				out.writeVarInt(players.length);
				for (String player : players) {
					out.writeString(player);
				}
				break;
		}
	}

	@Override
	public Packet readFrom(ByteBuffer buff) {
		teamName = ProtocolHelper.readString(buff);
		mode = buff.get();
		switch (mode) {
			case 0:
				teamDisplayName = ProtocolHelper.readString(buff);
				teamPrefix = ProtocolHelper.readString(buff);
				teamSuffix = ProtocolHelper.readString(buff);
				friendlyFlags = buff.get();
				nameTagVisibility = ProtocolHelper.readString(buff);
				collisionRule = ProtocolHelper.readString(buff);
				color = buff.get();
				players = new String[ProtocolHelper.readVarInt(buff)];
				for (int i = 0; i < players.length; i++) {
					players[i] = ProtocolHelper.readString(buff);
				}
				break;
			case 2:
				teamDisplayName = ProtocolHelper.readString(buff);
				teamPrefix = ProtocolHelper.readString(buff);
				teamSuffix = ProtocolHelper.readString(buff);
				friendlyFlags = buff.get();
				nameTagVisibility = ProtocolHelper.readString(buff);
				collisionRule = ProtocolHelper.readString(buff);
				color = buff.get();
				break;
			case 3:
				players = new String[ProtocolHelper.readVarInt(buff)];
				for (int i = 0; i < players.length; i++) {
					players[i] = ProtocolHelper.readString(buff);
				}
				break;
			case 4:
				players = new String[ProtocolHelper.readVarInt(buff)];
				for (int i = 0; i < players.length; i++) {
					players[i] = ProtocolHelper.readString(buff);
				}
				break;
		}
		return this;
	}

	@Override
	public String toString() {
		return "TeamsPacket{" + "teamName='" + teamName + "', mode=" + mode + ", teamDisplayName='" + teamDisplayName + "', teamPrefix='" + teamPrefix + "', teamSuffix='" + teamSuffix + "', friendlyFlags=" + friendlyFlags + ", nameTagVisibility='" + nameTagVisibility + "', collisionRule='" + collisionRule + "', color=" + color + ", players=" + Arrays.toString(players) + '}';
	}

}

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
 * @author TheElectronWill
 * @author DJmaxZPLAY
 */
public class JoinGamePacket implements Packet {

	public int entityId, gamemode, worldType, difficulty, maxPlayers;
	public String levelType;
	public boolean reducedDebugInfo;

	@Override
	public int getId() {
		return 0x23;
	}

	@Override
	public boolean isServerBound() {
		return false;
	}

	@Override
	public void writeTo(ProtocolOutputStream out) {
		out.writeInt(entityId);
		out.writeByte(gamemode);
		out.writeInt(worldType);
		out.writeByte(difficulty);
		out.writeByte(maxPlayers);
		out.writeString(levelType);
		out.writeBoolean(reducedDebugInfo);
	}

	@Override
	public Packet readFrom(ByteBuffer buff) {
		entityId = buff.getInt();
		gamemode = ProtocolHelper.readUnsignedByte(buff.get());
		worldType = buff.getInt();
		difficulty = ProtocolHelper.readUnsignedByte(buff.get());
		maxPlayers = ProtocolHelper.readUnsignedByte(buff.get());
		levelType = ProtocolHelper.readString(buff);
		reducedDebugInfo = ProtocolHelper.readBoolean(buff);
		return this;
	}

	@Override
	public String toString() {
		return "JoinGamePacket{" + "entityId=" + entityId + ", gamemode=" + gamemode + ", worldType=" + worldType + ", difficulty=" + difficulty + ", maxPlayers=" + maxPlayers + ", levelType=" + levelType + ", reducedDebugInfo=" + reducedDebugInfo + '}';
	}
}

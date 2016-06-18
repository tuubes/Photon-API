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
package org.mcphoton.network.login.clientbound;

import java.nio.ByteBuffer;
import org.mcphoton.network.Packet;
import org.mcphoton.network.ProtocolHelper;
import org.mcphoton.network.ProtocolOutputStream;

/**
 *
 * @author TheElectronWill
 */
public class EncryptionRequestPacket implements Packet {

	public String serverId;
	public byte[] publicKey, verifyToken;

	@Override
	public int getId() {
		return 0x01;
	}

	@Override
	public boolean isServerBound() {
		return false;
	}

	@Override
	public void writeTo(ProtocolOutputStream out) {
		out.writeString(serverId);
		out.writeVarInt(publicKey.length);
		out.write(publicKey);
		out.writeVarInt(verifyToken.length);
		out.write(verifyToken);
	}

	@Override
	public Packet readFrom(ByteBuffer buff) {
		serverId = ProtocolHelper.readString(buff);

		int keyLength = ProtocolHelper.readVarInt(buff);
		publicKey = new byte[keyLength];
		buff.get(publicKey);

		int tokenLength = ProtocolHelper.readVarInt(buff);
		verifyToken = new byte[tokenLength];
		buff.get(verifyToken);
		return this;
	}

	@Override
	public String toString() {
		return "EncryptionRequestPacket{" + "serverId=" + serverId + ", publicKey=" + publicKey + ", verifyToken=" + verifyToken + '}';
	}

}

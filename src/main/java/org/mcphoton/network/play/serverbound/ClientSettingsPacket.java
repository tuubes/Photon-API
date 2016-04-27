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
package org.mcphoton.network.play.serverbound;

import java.nio.ByteBuffer;
import org.mcphoton.network.Packet;
import org.mcphoton.network.ProtocolHelper;
import org.mcphoton.network.ProtocolOutputStream;

/**
 *
 * @author DJmaxZPLAY
 */
public class ClientSettingsPacket implements Packet {

	public String locale;
	public byte viewDistance;
	public int chatMode, displayedSkinParts, mainHand;
	public boolean chatColors;

	@Override
	public int getId() {
		return 0x04;
	}

	@Override
	public boolean isServerBound() {
		return true;
	}

	@Override
	public void writeTo(ProtocolOutputStream out) {
		out.writeString(locale);
		out.writeByte(viewDistance);
		out.writeVarInt(chatMode);
		out.writeBoolean(chatColors);
		out.writeByte(displayedSkinParts);
		out.writeVarInt(mainHand);
	}

	@Override
	public Packet readFrom(ByteBuffer buff) {
		locale = ProtocolHelper.readString(buff);
		viewDistance = buff.get();
		chatMode = ProtocolHelper.readVarInt(buff);
		chatColors = ProtocolHelper.readBoolean(buff);
		displayedSkinParts = ProtocolHelper.readUnsignedByte(buff.get());
		mainHand = ProtocolHelper.readVarInt(buff);
		return this;
	}

	@Override
	public String toString() {
		return "ClientSettingsPacket{" + "locale=" + locale + ", viewDistance=" + viewDistance + ", chatMode=" + chatMode + ", chatColors=" + chatColors + ", displayedSkinParts=" + displayedSkinParts + ", mainHand=" + mainHand + '}';
	}
}

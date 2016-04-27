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
public class SoundEffectPacket implements Packet {

	public int soundID, soundCategory, effectPositionX, effectPositionY, effectPositionZ;
	public float volume;
	public int pitch; //Unsigned Byte

	@Override
	public int getId() {
		return 0x47;
	}

	@Override
	public boolean isServerBound() {
		return false;
	}

	@Override
	public void writeTo(ProtocolOutputStream out) {
		out.writeVarInt(soundID);
		out.writeVarInt(soundCategory);
		out.writeInt(effectPositionX);
		out.writeInt(effectPositionY);
		out.writeInt(effectPositionZ);
		out.writeFloat(volume);
		out.writeByte(pitch);
	}

	@Override
	public Packet readFrom(ByteBuffer buff) {
		soundID = ProtocolHelper.readVarInt(buff);
		soundCategory = ProtocolHelper.readVarInt(buff);
		effectPositionX = buff.getInt();
		effectPositionY = buff.getInt();
		effectPositionZ = buff.getInt();
		volume = buff.getFloat();
		pitch = ProtocolHelper.readUnsignedByte(buff.get());
		return this;
	}

	@Override
	public String toString() {
		return "SoundEffectPacket{" + "soundID=" + soundID + ", soundCategory=" + soundCategory + ", effectPositionX=" + effectPositionX + ", effectPositionY=" + effectPositionY + ", effectPositionZ=" + effectPositionZ + ", volume=" + volume + ", pitch=" + pitch + '}';
	}
}
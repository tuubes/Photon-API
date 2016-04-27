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
public class EntityLookAndRelativeMovePacket implements Packet {

	public int entityID;
	public short xDelta, yDelta, zDelta;
	public float yaw, pitch;
	public boolean onGround;

	@Override
	public int getId() {
		return 0x26;
	}

	@Override
	public boolean isServerBound() {
		return false;
	}

	@Override
	public void writeTo(ProtocolOutputStream out) {
		out.writeVarInt(entityID);
		out.writeShort(xDelta);
		out.writeShort(yDelta);
		out.writeShort(zDelta);
		out.writeByte(ProtocolHelper.toRotationStep(yaw));
		out.writeByte(ProtocolHelper.toRotationStep(pitch));
		out.writeBoolean(onGround);
	}

	@Override
	public Packet readFrom(ByteBuffer buff) {
		entityID = ProtocolHelper.readVarInt(buff);
		xDelta = buff.getShort();
		yDelta = buff.getShort();
		zDelta = buff.getShort();
		yaw = ProtocolHelper.toDegrees(buff.get());
		pitch = ProtocolHelper.toDegrees(buff.get());
		onGround = ProtocolHelper.readBoolean(buff);
		return this;
	}

	@Override
	public String toString() {
		return "EntityLookAndRelativeMovePacket{" + "entityID=" + entityID + ", xDelta=" + xDelta + ", yDelta=" + yDelta + ", zDelta=" + zDelta + ", yaw=" + yaw + ", pitch=" + pitch + ", onGround=" + onGround + '}';
	}

}

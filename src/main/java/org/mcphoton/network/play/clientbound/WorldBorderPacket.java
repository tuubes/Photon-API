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
public class WorldBorderPacket implements Packet {

	public int action, portalTeleportBoundary, warningTime, warningBlocks;
	public double diameter, oldDiameter, newDiameter, x, z;
	public long speed;

	@Override
	public int getId() {
		return 0x35;
	}

	@Override
	public boolean isServerBound() {
		return false;
	}

	@Override
	public void writeTo(ProtocolOutputStream out) {
		out.writeVarInt(action);
		switch(action){
			case 0:
				out.writeDouble(diameter);
				break;
			case 1:
				out.writeDouble(oldDiameter);
				out.writeDouble(newDiameter);
				out.writeVarLong(speed);
				break;
			case 2:
				out.writeDouble(x);
				out.writeDouble(z);
				break;
			case 3:
				out.writeDouble(x);
				out.writeDouble(z);
				out.writeDouble(oldDiameter);
				out.writeDouble(newDiameter);
				out.writeVarLong(speed);
				out.writeVarInt(portalTeleportBoundary);
				out.writeVarInt(warningTime);
				out.writeVarInt(warningBlocks);
				break;
			case 4:
				out.writeVarInt(warningTime);
				break;
			case 5:
				out.writeVarInt(warningBlocks);
				break;
		}
	}

	@Override
	public Packet readFrom(ByteBuffer buff) {
		action = ProtocolHelper.readVarInt(buff);
		switch(action){
			case 0:
				diameter = buff.getDouble();
				break;
			case 1:
				oldDiameter = buff.getDouble();
				newDiameter = buff.getDouble();
				speed = ProtocolHelper.readVarLong(buff);
				break;
			case 2:
				x = buff.getDouble();
				z = buff.getDouble();
				break;
			case 3:
				x = buff.getDouble();
				z = buff.getDouble();
				oldDiameter = buff.getDouble();
				newDiameter = buff.getDouble();
				speed = ProtocolHelper.readVarLong(buff);
				portalTeleportBoundary = ProtocolHelper.readVarInt(buff);
				warningTime = ProtocolHelper.readVarInt(buff);
				warningBlocks = ProtocolHelper.readVarInt(buff);
				break;
			case 4:
				warningTime = ProtocolHelper.readVarInt(buff);
				break;
			case 5:
				warningBlocks = ProtocolHelper.readVarInt(buff);
				break;
		}
		return this;
	}

	@Override
	public String toString() {
		return "WorldBorderPacket{" + "action=" + action + ", x=" + x + ", z=" + z + ", diameter=" + diameter + ", oldDiameter=" + oldDiameter + ", newDiameter=" + newDiameter + ", speed=" + speed + ", portalTeleportBoundary=" + portalTeleportBoundary + ", warningTime=" + warningTime + ", warningBlocks=" + warningBlocks + '}';
	}

}

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
public class SteerBoatPacket implements Packet {

	public boolean rightPaddleTurning, leftPaddleTurning;

	@Override
	public int getId() {
		return 0x11;
	}

	@Override
	public boolean isServerBound() {
		return true;
	}

	@Override
	public void writeTo(ProtocolOutputStream out) {;
		out.writeBoolean(rightPaddleTurning);
		out.writeBoolean(leftPaddleTurning);
	}

	@Override
	public Packet readFrom(ByteBuffer buff) {
		rightPaddleTurning = ProtocolHelper.readBoolean(buff);
		leftPaddleTurning = ProtocolHelper.readBoolean(buff);
		return this;
	}

	@Override
	public String toString() {
		return "SteerBoatPacket{" + "rightPaddleTurning=" + rightPaddleTurning + ", leftPaddleTurning=" + leftPaddleTurning + '}';
	}
}

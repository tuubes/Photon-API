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
package org.mcphoton.network;

import java.io.IOException;
import java.nio.ByteBuffer;

/**
 * A network packet that can be sent and received.
 *
 * @author TheElectronWill
 *
 */
public interface Packet {

	/**
	 * Gets the unique id of this packet's type.
	 */
	int getId();

	/**
	 * Returns true if this packet is bound to the server, false if it's bound to the client.
	 */
	boolean isServerBound();

	/**
	 * Writes this packet to a ProtocolOutputStream.
	 */
	void writeTo(ProtocolOutputStream out) throws IOException;

	/**
	 * Reads data from a ByteBuffer, and modify this packet objet according to the data.
	 *
	 * @return this packet
	 */
	Packet readFrom(ByteBuffer buff) throws IOException;

}

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

import java.nio.ByteBuffer;
import java.util.Collection;

/**
 * Manages the registration of Packets and PacketHandlers. The PacketsManager can also send and parse packets.
 *
 * @author TheElectronWill
 */
public interface PacketsManager {

	void registerPacket(ConnectionState state, boolean serverBound, int packetId, Class<? extends Packet> packetClass);

	void registerHandler(ConnectionState state, boolean serverBound, int packetId, PacketHandler<? extends Packet> handler);

	void unregisterPacket(ConnectionState state, boolean serverBound, int packetId);

	void unregisterHandler(ConnectionState state, boolean serverBound, int packetId, PacketHandler<? extends Packet> handler);

	Class<? extends Packet> getRegisteredPacket(ConnectionState state, boolean serverBound, int packetId);

	Collection<PacketHandler> getRegisteredHandlers(ConnectionState state, boolean serverBound, int packetId);

	void sendPacket(Packet packet, Client client);

	void sendPacket(Packet packet, Client... clients);

	void sendPacket(Packet packet, Client client, Runnable onSendingCompleted);

	Packet parsePacket(ByteBuffer data, ConnectionState connState, boolean serverBound);

	void handle(Packet packet, Client client);

}

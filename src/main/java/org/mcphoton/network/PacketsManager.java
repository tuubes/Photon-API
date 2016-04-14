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

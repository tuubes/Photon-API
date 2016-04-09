package org.mcphoton.network;

@FunctionalInterface
public interface PacketHandler<P extends Packet> {

	/**
	 * Handles a packet that is being sent to a client, or that has just been received by the server.
	 *
	 * @param packet the packet that will be sent, or that has been received
	 * @param client the client who will receive the packet, or the client who sent it.
	 */
	void handle(P packet, Client client);

}

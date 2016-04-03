package org.mcphoton.network;

import java.nio.ByteBuffer;

/**
 * A PacketService has several capabilities regarding packets. It is able to send packets to clients, and to parse
 * received packets.
 * 
 * @author TheElectronWill
 * 		
 */
public interface PacketService {
	
	void send(Packet packet, Client client);
	
	void send(Packet packet, Client... clients);
	
	void send(Packet packet, Client client, Runnable onSendingCompleted);
	
	Packet parse(ByteBuffer data, ConnectionState connState);
	
}

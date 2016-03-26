package org.mcphoton.network;

public interface PacketRegistry {
	
	void register(Class<? extends Packet> packetClass, ConnectionState state, boolean serverBound, int id);
	
	boolean isRegistered(ConnectionState state, boolean serverBound, int id);
	
	boolean isRegistered(ConnectionState state, boolean serverBound, Class<? extends Packet> packetClass);
	
	Class<? extends Packet> getRegistered(ConnectionState state, boolean serverBound, int id);
}

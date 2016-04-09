package org.mcphoton.network;

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
	int id();

	/**
	 * Writes this packet to a ProtocolOutputStream. This method is called in the network output thread.
	 */
	void writeTo(ProtocolOutputStream out);

	/**
	 * Reads data from a ByteBuffer. This method is called in the network input thread.
	 *
	 * @return this packet
	 */
	Packet readFrom(ByteBuffer buff);

}

package org.mcphoton.network.handshaking.serverbound;

import java.nio.ByteBuffer;
import org.mcphoton.network.Packet;
import org.mcphoton.network.ProtocolHelper;
import org.mcphoton.network.ProtocolOutputStream;

/**
 *
 * @author TheElectronWill
 */
public class HandshakePacket implements Packet {

	public static final int CURRENT_PROTOCOL_VERSION = 109;
	public int protocolVersion, serverPort, nextState;
	public String serverAddress;

	@Override
	public int id() {
		return 0x00;
	}

	@Override
	public void writeTo(ProtocolOutputStream out) {
		out.writeVarInt(protocolVersion);
		out.writeString(serverAddress);
		out.writeShort(serverPort);
		out.writeVarInt(nextState);
	}

	@Override
	public Packet readFrom(ByteBuffer buff) {
		protocolVersion = ProtocolHelper.readVarInt(buff);
		serverAddress = ProtocolHelper.readString(buff);
		serverPort = buff.getShort();
		nextState = ProtocolHelper.readVarInt(buff);
		return this;
	}

	@Override
	public String toString() {
		return "HandshakePacket{" + "protocolVersion=" + protocolVersion + ", serverPort=" + serverPort + ", nextState=" + nextState + ", serverAddress=" + serverAddress + '}';
	}

}

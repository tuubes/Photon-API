package org.mcphoton.network.login.clientbound;

import java.nio.ByteBuffer;
import org.mcphoton.network.Packet;
import org.mcphoton.network.ProtocolHelper;
import org.mcphoton.network.ProtocolOutputStream;

/**
 *
 * @author TheElectronWill
 */
public class SetCompressionPacket implements Packet {

	public int compressionThreshold;

	@Override
	public int id() {
		return 0x03;
	}

	@Override
	public void writeTo(ProtocolOutputStream out) {
		out.writeVarInt(compressionThreshold);
	}

	@Override
	public Packet readFrom(ByteBuffer buff) {
		compressionThreshold = ProtocolHelper.readVarInt(buff);
		return this;
	}

	@Override
	public String toString() {
		return "SetCompressionPacket{" + "compressionThreshold=" + compressionThreshold + '}';
	}

}

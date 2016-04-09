package org.mcphoton.network.status.clientbound;

import java.nio.ByteBuffer;
import org.mcphoton.network.Packet;
import org.mcphoton.network.ProtocolOutputStream;

/**
 *
 * @author TheElectronWill
 */
public class PongPacket implements Packet {

	public long payload;

	@Override
	public int id() {
		return 0x01;
	}

	@Override
	public void writeTo(ProtocolOutputStream out) {
		out.writeLong(payload);
	}

	@Override
	public Packet readFrom(ByteBuffer buff) {
		payload = buff.getLong();
		return this;
	}

	@Override
	public String toString() {
		return "PongPacket{" + "payload=" + payload + '}';
	}

}

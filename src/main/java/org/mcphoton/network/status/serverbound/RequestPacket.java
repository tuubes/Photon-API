package org.mcphoton.network.status.serverbound;

import java.nio.ByteBuffer;
import org.mcphoton.network.Packet;
import org.mcphoton.network.ProtocolOutputStream;

/**
 *
 * @author TheElectronWill
 */
public class RequestPacket implements Packet {

	@Override
	public int getId() {
		return 0x00;
	}

	@Override
	public boolean isServerBound() {
		return true;
	}

	@Override
	public void writeTo(ProtocolOutputStream out) {
	}

	@Override
	public Packet readFrom(ByteBuffer buff) {
		return this;
	}

	@Override
	public String toString() {
		return "RequestPacket{" + '}';
	}

}

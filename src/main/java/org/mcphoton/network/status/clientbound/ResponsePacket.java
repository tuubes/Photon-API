package org.mcphoton.network.status.clientbound;

import java.nio.ByteBuffer;
import org.mcphoton.network.Packet;
import org.mcphoton.network.ProtocolHelper;
import org.mcphoton.network.ProtocolOutputStream;

/**
 *
 * @author TheElectronWill
 */
public class ResponsePacket implements Packet {

	public String jsonResponse;

	@Override
	public int getId() {
		return 0x00;
	}

	@Override
	public boolean isServerBound() {
		return false;
	}

	@Override
	public void writeTo(ProtocolOutputStream out) {
		out.writeString(jsonResponse);
	}

	@Override
	public Packet readFrom(ByteBuffer buff) {
		jsonResponse = ProtocolHelper.readString(buff);
		return this;
	}

	@Override
	public String toString() {
		return "ResponsePacket{" + "jsonResponse=" + jsonResponse + '}';
	}

}

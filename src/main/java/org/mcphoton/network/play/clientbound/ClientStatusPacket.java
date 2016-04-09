package org.mcphoton.network.play.clientbound;

import java.nio.ByteBuffer;
import org.mcphoton.network.Packet;
import org.mcphoton.network.ProtocolHelper;
import org.mcphoton.network.ProtocolOutputStream;

/**
 *
 * @author TheElectronWill
 */
public class ClientStatusPacket implements Packet {

	public int actionId;

	@Override
	public int id() {
		return 0x03;
	}

	@Override
	public void writeTo(ProtocolOutputStream out) {
		out.writeVarInt(actionId);
	}

	@Override
	public Packet readFrom(ByteBuffer buff) {
		actionId = ProtocolHelper.readVarInt(buff);
		return this;
	}

	@Override
	public String toString() {
		return "ClientStatusPacket{" + "actionId=" + actionId + '}';
	}

}

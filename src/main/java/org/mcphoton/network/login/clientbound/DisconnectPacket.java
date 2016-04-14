package org.mcphoton.network.login.clientbound;

import java.nio.ByteBuffer;
import org.mcphoton.messaging.ChatMessage;
import org.mcphoton.messaging.TextChatMessage;
import org.mcphoton.network.Packet;
import org.mcphoton.network.ProtocolHelper;
import org.mcphoton.network.ProtocolOutputStream;

/**
 *
 * @author TheElectronWill
 */
public class DisconnectPacket implements Packet {

	public ChatMessage reason;

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
		out.writeString(reason.toString());
	}

	@Override
	public Packet readFrom(ByteBuffer buff) {
		String jsonString = ProtocolHelper.readString(buff);
		reason = TextChatMessage.parse(jsonString);
		return this;
	}

	@Override
	public String toString() {
		return "DisconnectPacket{" + "reason=" + reason + '}';
	}

}

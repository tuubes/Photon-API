package org.mcphoton.network.play.clientbound;

import java.nio.ByteBuffer;
import org.mcphoton.network.Packet;
import org.mcphoton.network.ProtocolHelper;
import org.mcphoton.network.ProtocolOutputStream;

/**
 *
 * @author TheElectronWill
 */
public class PluginMessagePacket implements Packet {

	public String channel;
	public byte[] data;

	@Override
	public int getId() {
		return 0x18;
	}

	@Override
	public boolean isServerBound() {
		return false;
	}

	@Override
	public void writeTo(ProtocolOutputStream out) {
		out.writeString(channel);
		out.write(data);
	}

	@Override
	public Packet readFrom(ByteBuffer buff) {
		channel = ProtocolHelper.readString(buff);
		data = new byte[buff.remaining()];
		buff.get(data);
		return this;
	}

	@Override
	public String toString() {
		return "PluginMessagePacket{" + "channel=" + channel + ", data=" + data + '}';
	}

}

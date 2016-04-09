package org.mcphoton.network.login.serverbound;

import java.nio.ByteBuffer;
import org.mcphoton.network.Packet;
import org.mcphoton.network.ProtocolHelper;
import org.mcphoton.network.ProtocolOutputStream;

/**
 *
 * @author TheElectronWill
 */
public class LoginStartPacket implements Packet {

	public String username;

	@Override
	public int id() {
		return 0x00;
	}

	@Override
	public void writeTo(ProtocolOutputStream out) {
		out.writeString(username);
	}

	@Override
	public Packet readFrom(ByteBuffer buff) {
		username = ProtocolHelper.readString(buff);
		return this;
	}

	@Override
	public String toString() {
		return "LoginStartPacket{" + "username=" + username + '}';
	}

}

package org.mcphoton.network.login.clientbound;

import java.nio.ByteBuffer;
import org.mcphoton.network.Packet;
import org.mcphoton.network.ProtocolHelper;
import org.mcphoton.network.ProtocolOutputStream;

/**
 *
 * @author TheElectronWill
 */
public class LoginSuccessPacket implements Packet {

	public String uuid, username;

	@Override
	public int getId() {
		return 0x02;
	}

	@Override
	public boolean isServerBound() {
		return false;
	}

	@Override
	public void writeTo(ProtocolOutputStream out) {
		out.writeString(uuid);
		out.writeString(username);
	}

	@Override
	public Packet readFrom(ByteBuffer buff) {
		uuid = ProtocolHelper.readString(buff);
		username = ProtocolHelper.readString(buff);
		return this;
	}

	@Override
	public String toString() {
		return "LoginSuccessPacket{" + "uuid=" + uuid + ", username=" + username + '}';
	}

}

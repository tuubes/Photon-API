package org.mcphoton.network.login.clientbound;

import java.nio.ByteBuffer;
import org.mcphoton.network.Packet;
import org.mcphoton.network.ProtocolHelper;
import org.mcphoton.network.ProtocolOutputStream;

/**
 *
 * @author TheElectronWill
 */
public class EncryptionRequestPacket implements Packet {

	public String serverId;
	public byte[] publicKey, verifyToken;

	@Override
	public int id() {
		return 0x01;
	}

	@Override
	public void writeTo(ProtocolOutputStream out) {
		out.writeString(serverId);
		out.writeVarInt(publicKey.length);
		out.write(publicKey);
		out.writeVarInt(verifyToken.length);
		out.write(verifyToken);
	}

	@Override
	public Packet readFrom(ByteBuffer buff) {
		serverId = ProtocolHelper.readString(buff);

		int keyLength = ProtocolHelper.readVarInt(buff);
		publicKey = new byte[keyLength];
		buff.get(publicKey);

		int tokenLength = ProtocolHelper.readVarInt(buff);
		verifyToken = new byte[tokenLength];
		buff.get(verifyToken);
		return this;
	}

	@Override
	public String toString() {
		return "EncryptionRequestPacket{" + "serverId=" + serverId + ", publicKey=" + publicKey + ", verifyToken=" + verifyToken + '}';
	}

}

package org.mcphoton.network.login.serverbound;

import java.nio.ByteBuffer;
import org.mcphoton.network.Packet;
import org.mcphoton.network.ProtocolHelper;
import org.mcphoton.network.ProtocolOutputStream;

/**
 *
 * @author TheElectronWill
 */
public class EncryptionResponsePacket implements Packet {

	public byte[] sharedKey, verifyToken;

	@Override
	public int id() {
		return 0x01;
	}

	@Override
	public void writeTo(ProtocolOutputStream out) {
		out.writeVarInt(sharedKey.length);
		out.write(sharedKey);
		out.writeVarInt(verifyToken.length);
		out.write(verifyToken);

	}

	@Override
	public Packet readFrom(ByteBuffer buff) {
		int keyLength = ProtocolHelper.readVarInt(buff);
		sharedKey = new byte[keyLength];
		buff.get(sharedKey);

		int tokenLength = ProtocolHelper.readVarInt(buff);
		verifyToken = new byte[tokenLength];
		buff.get(verifyToken);
		return this;
	}

	@Override
	public String toString() {
		return "EncryptionResponsePacket{" + "sharedKey=" + sharedKey + ", verifyToken=" + verifyToken + '}';
	}

}

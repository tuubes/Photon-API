package org.mcphoton.network.play.clientbound;

import java.nio.ByteBuffer;
import org.mcphoton.network.Packet;
import org.mcphoton.network.ProtocolOutputStream;

/**
 *
 * @author TheElectronWill
 */
public class ServerDifficultyPacket implements Packet {

	public byte difficulty;

	@Override
	public int id() {
		return 0x0D;
	}

	@Override
	public void writeTo(ProtocolOutputStream out) {
		out.writeByte(difficulty);
	}

	@Override
	public Packet readFrom(ByteBuffer buff) {
		difficulty = buff.get();
		return this;
	}

	@Override
	public String toString() {
		return "ServerDifficultyPacket{" + "difficulty=" + difficulty + '}';
	}

}

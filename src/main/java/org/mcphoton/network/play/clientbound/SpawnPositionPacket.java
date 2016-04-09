package org.mcphoton.network.play.clientbound;

import java.nio.ByteBuffer;
import org.mcphoton.network.Packet;
import org.mcphoton.network.ProtocolHelper;
import org.mcphoton.network.ProtocolOutputStream;

/**
 *
 * @author TheElectronWill
 */
public class SpawnPositionPacket implements Packet {

	public int x, y, z;

	@Override
	public int id() {
		return 0x43;
	}

	@Override
	public void writeTo(ProtocolOutputStream out) {
		long pos = ProtocolHelper.encodePosition(x, y, z);
		out.writeLong(pos);
	}

	@Override
	public Packet readFrom(ByteBuffer buff) {
		long pos = buff.getLong();
		x = ProtocolHelper.decodePositionX(pos);
		y = ProtocolHelper.decodePositionY(pos);
		z = ProtocolHelper.decodePositionZ(pos);
		return this;
	}

	@Override
	public String toString() {
		return "SpawnPositionPacket{" + "x=" + x + ", y=" + y + ", z=" + z + '}';
	}

}

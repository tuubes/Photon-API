package org.mcphoton.network.play.clientbound;

import java.nio.ByteBuffer;
import org.mcphoton.network.Packet;
import org.mcphoton.network.ProtocolHelper;
import org.mcphoton.network.ProtocolOutputStream;

/**
 *
 * @author TheElectronWill
 */
public class PlayerPositionAndLookPacket implements Packet {

	public double x, y, z;
	public float yaw, pitch;
	public byte flags;
	public int teleportId;

	@Override
	public int getId() {
		return 0x2E;
	}

	@Override
	public boolean isServerBound() {
		return false;
	}

	@Override
	public void writeTo(ProtocolOutputStream out) {
		out.writeDouble(x);
		out.writeDouble(y);
		out.writeDouble(z);
		out.writeFloat(yaw);
		out.writeFloat(pitch);
		out.writeByte(flags);
		out.writeVarInt(teleportId);
	}

	@Override
	public Packet readFrom(ByteBuffer buff) {
		x = buff.getDouble();
		y = buff.getDouble();
		z = buff.getDouble();
		yaw = buff.getFloat();
		pitch = buff.getFloat();
		flags = buff.get();
		teleportId = ProtocolHelper.readVarInt(buff);
		return this;
	}

	@Override
	public String toString() {
		return "PlayerPositionAndLookPacket{" + "x=" + x + ", y=" + y + ", z=" + z + ", yaw=" + yaw + ", pitch=" + pitch + ", flags=" + flags + ", teleportId=" + teleportId + '}';
	}

}

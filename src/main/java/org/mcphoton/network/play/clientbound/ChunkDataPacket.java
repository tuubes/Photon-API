package org.mcphoton.network.play.clientbound;

import java.nio.ByteBuffer;
import org.mcphoton.network.Packet;
import org.mcphoton.network.ProtocolHelper;
import org.mcphoton.network.ProtocolOutputStream;
import org.mcphoton.world.ChunkSection;

/**
 *
 * @author TheElectronWill
 */
public class ChunkDataPacket implements Packet {

	public int chunkX, chunkZ;
	public boolean groundUpContinuous;
	public int bitMask;
	public ChunkSection[] sections;
	public byte[] biomes;

	@Override
	public int id() {
		return 0x20;
	}

	@Override
	public void writeTo(ProtocolOutputStream out) {
		; //TODO
	}

	@Override
	public Packet readFrom(ByteBuffer buff) {
		chunkX = buff.getInt();
		chunkZ = buff.getInt();
		groundUpContinuous = ProtocolHelper.readBoolean(buff);
		bitMask = ProtocolHelper.readVarInt(buff);
		int dataSize = ProtocolHelper.readVarInt(buff);
		byte[] data = new byte[dataSize];
		buff.get(data);
		return this;
	}

	@Override
	public String toString() {
		return "ChunkDataPacket{" + "chunkX=" + chunkX + ", chunkZ=" + chunkZ + ", groundUpContinuous=" + groundUpContinuous + ", bitMask=" + bitMask + ", sections=" + sections + ", biomes=" + biomes + '}';
	}

}

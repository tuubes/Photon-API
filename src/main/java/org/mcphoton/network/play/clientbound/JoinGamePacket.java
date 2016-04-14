package org.mcphoton.network.play.clientbound;

import java.nio.ByteBuffer;
import org.mcphoton.network.Packet;
import org.mcphoton.network.ProtocolHelper;
import org.mcphoton.network.ProtocolOutputStream;

/**
 *
 * @author TheElectronWill
 */
public class JoinGamePacket implements Packet {

	public int entityId;
	public byte gamemode;
	public int worldType;
	public byte difficulty;
	public byte maxPlayers;
	public String levelType;
	public boolean reducedDebugInfo;

	@Override
	public int getId() {
		return 0x23;
	}

	@Override
	public boolean isServerBound() {
		return false;
	}

	@Override
	public void writeTo(ProtocolOutputStream out) {
		out.writeInt(entityId);
		out.writeByte(gamemode);
		out.writeInt(worldType);
		out.writeByte(difficulty);
		out.writeByte(maxPlayers);
		out.writeString(levelType);
		out.writeBoolean(reducedDebugInfo);
	}

	@Override
	public Packet readFrom(ByteBuffer buff) {
		entityId = buff.getInt();
		gamemode = buff.get();
		worldType = buff.getInt();
		difficulty = buff.get();
		maxPlayers = buff.get();
		levelType = ProtocolHelper.readString(buff);
		reducedDebugInfo = ProtocolHelper.readBoolean(buff);
		return this;
	}

	@Override
	public String toString() {
		return "JoinGamePacket{" + "entityId=" + entityId + ", gamemode=" + gamemode + ", worldType=" + worldType + ", difficulty=" + difficulty + ", maxPlayers=" + maxPlayers + ", levelType=" + levelType + ", reducedDebugInfo=" + reducedDebugInfo + '}';
	}

}

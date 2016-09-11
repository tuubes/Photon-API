/*
 * Copyright (c) 2016 MCPhoton <http://mcphoton.org> and contributors.
 *
 * This file is part of the Photon API <https://github.com/mcphoton/Photon-API>.
 *
 * The Photon API is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * The Photon API is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>.
 */
package org.mcphoton.network.play.clientbound;

import java.nio.ByteBuffer;
import java.util.UUID;
import java.util.function.Consumer;
import org.mcphoton.entity.living.Player;
import org.mcphoton.network.Packet;
import org.mcphoton.network.ProtocolHelper;
import org.mcphoton.network.ProtocolOutputStream;

/**
 * @author Maaattt
 * @author TheElectronWill
 */
public class SpawnPlayerPacket implements Packet {

	public int entityId;
	public UUID playerUUID;
	public double x, y, z;
	public float yaw, pitch;//in radians
	public Consumer<ProtocolOutputStream> metadataWriter;

	public SpawnPlayerPacket(Player p) {
		this.entityId = p.getEntityId();
		this.playerUUID = p.getAccountId();
		this.x = p.getLocation().getX();
		this.y = p.getLocation().getY();
		this.z = p.getLocation().getZ();
		this.yaw = p.getYaw();
		this.pitch = p.getPitch();
		this.metadataWriter = p::writeMetadata;
	}

	@Override
	public int getId() {
		return 0x05;
	}

	@Override
	public boolean isServerBound() {
		return false;
	}

	@Override
	public void writeTo(ProtocolOutputStream out) {
		out.writeVarInt(entityId);
		out.writeLong(playerUUID.getMostSignificantBits());
		out.writeLong(playerUUID.getLeastSignificantBits());
		out.writeDouble(x);
		out.writeDouble(y);
		out.writeDouble(z);
		out.writeByte(ProtocolHelper.toRotationStep(yaw));
		out.writeByte(ProtocolHelper.toRotationStep(pitch));
		metadataWriter.accept(out);
	}

	@Override
	public Packet readFrom(ByteBuffer buff) {
		throw new UnsupportedOperationException();
	}

	@Override
	public String toString() {
		return "SpawnPlayerPacket{" + "entityId=" + entityId + ", playerUUID=" + playerUUID + ", x=" + x + ", y=" + y + ", z=" + z + ", yaw=" + yaw + ", pitch=" + pitch + ", metadataWriter (function) =" + metadataWriter + '}';
	}
}

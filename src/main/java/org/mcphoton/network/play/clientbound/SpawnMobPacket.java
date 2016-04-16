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

import org.mcphoton.network.Packet;
import org.mcphoton.network.ProtocolOutputStream;

import java.nio.ByteBuffer;
import java.util.UUID;

/**
 *
 * @author Maaattt
 */
public class SpawnMobPacket implements Packet {

    public int entityId;
    public UUID entityUUID;
    public byte type;
    public double x, y, z;
    public byte yaw, pitch, headPitch;
    public short xVelocity, yVelocity, zVelocity;
    public byte metadata;

    @Override
    public int getId() { return 0x03; }

    @Override
    public boolean isServerBound() {
        return false;
    }

    @Override
    public void writeTo(ProtocolOutputStream out) {
        out.writeInt(entityId);
        out.writeLong(entityUUID.getMostSignificantBits());
        out.writeLong(entityUUID.getLeastSignificantBits());
        out.writeByte(type);
        out.writeDouble(x);
        out.writeDouble(y);
        out.writeDouble(z);
        out.write(yaw);
        out.write(pitch);
        out.write(headPitch);
        out.writeShort(xVelocity);
        out.writeShort(yVelocity);
        out.writeShort(zVelocity);
        out.write(metadata);
    }

    @Override
    public Packet readFrom(ByteBuffer buff) {
        entityId = buff.getInt();
        long MSB = buff.getLong();
        long LSB = buff.getLong();
        entityUUID = new UUID(MSB, LSB);
        type = buff.get();
        x = buff.getDouble();
        y = buff.getDouble();
        z = buff.getDouble();
        yaw = buff.get();
        pitch = buff.get();
        headPitch = buff.get();
        xVelocity = buff.getShort();
        yVelocity = buff.getShort();
        zVelocity = buff.getShort();
        metadata = buff.get();
        return this;
    }

    @Override
    public String toString() {
        return "SpawnMobPacket{" + "entityId=" + entityId + ", entityUUID=" + entityUUID + ", type=" + type + ", x=" + x + ", y=" + y + ", z=" + z + ", yaw=" + yaw + ", pitch=" + pitch + ", headPitch=" + headPitch + ", xVelocity=" + xVelocity + ", yVelocity=" + yVelocity + ", zVelocity=" + zVelocity + ", metadata=" + metadata + '}';
    }
}

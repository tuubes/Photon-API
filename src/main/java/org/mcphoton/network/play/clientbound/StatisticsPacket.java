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
import org.mcphoton.network.ProtocolHelper;
import org.mcphoton.network.ProtocolOutputStream;

import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Maaattt
 */
public class StatisticsPacket implements Packet {

    public Map<String, Integer> statistics;

    @Override
    public int getId() { return 0x07; }

    @Override
    public boolean isServerBound() { return false; }

    @Override
    public void writeTo(ProtocolOutputStream out) {
        out.writeVarInt(statistics.size());
        for (Map.Entry<String, Integer> entry : statistics.entrySet())
        {
            out.writeString(entry.getKey().toString());
            out.writeVarInt((Integer)entry.getValue());
        }
    }

    @Override
    public Packet readFrom(ByteBuffer buff) {
        int count = ProtocolHelper.readVarInt(buff);
        statistics = new HashMap<String, Integer>();

        for(int i = 0; i < count; i++)
        {
            String stat = ProtocolHelper.readString(buff);
            int k = ProtocolHelper.readVarInt(buff);

            statistics.put(stat, k);
        }
        return this;
    }
}

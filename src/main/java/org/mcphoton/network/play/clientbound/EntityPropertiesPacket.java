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
import java.util.Arrays;
import java.util.UUID;
import org.mcphoton.network.Packet;
import org.mcphoton.network.ProtocolHelper;
import org.mcphoton.network.ProtocolOutputStream;

/**
 *
 * @author DJmaxZPL4Y
 * @author TheElectronWill
 */
public class EntityPropertiesPacket implements Packet {

	public int entityId;
	public EntityProperty[] properties;

	@Override
	public int getId() {
		return 0x4A;
	}

	@Override
	public boolean isServerBound() {
		return false;
	}

	@Override
	public void writeTo(ProtocolOutputStream out) {
		out.writeVarInt(entityId);
		out.writeInt(properties.length);
		for (EntityProperty property : properties) {
			out.writeString(property.getKey());
			out.writeDouble(property.getValue());
			out.writeVarInt(property.getModifierData().length);
			for (ModifierData modifier : property.getModifierData()) {
				out.writeLong(modifier.getUUID().getMostSignificantBits());
				out.writeLong(modifier.getUUID().getLeastSignificantBits());
				out.writeDouble(modifier.getAmount());
				out.writeByte(modifier.getOperation());
			}
		}
	}

	@Override
	public Packet readFrom(ByteBuffer buff) {
		entityId = ProtocolHelper.readVarInt(buff);
		properties = new EntityProperty[buff.getInt()];
		for (int i = 0; i < properties.length; i++) {
			String key = ProtocolHelper.readString(buff);
			double value = buff.getDouble();
			ModifierData[] modifierData = new ModifierData[ProtocolHelper.readVarInt(buff)];
			for (int imodifier = 0; imodifier < modifierData.length; imodifier++) {
				UUID uuid = new UUID(buff.getLong(), buff.getLong());
				double amount = buff.getDouble();
				byte operation = buff.get();
				modifierData[imodifier] = new ModifierData(uuid, amount, operation);
			}
			properties[i] = new EntityProperty(key, value, modifierData);
		}
		return this;
	}

	@Override
	public String toString() {
		return "EntityPropertiesPacket{" + "entityId=" + entityId + ", property='" + Arrays.toString(properties) + '\'' + '}';
	}

	public class EntityProperty {

		private String key;
		private double value;
		private ModifierData[] modifierData;

		public EntityProperty(String key, double value, ModifierData[] modifierData) {
			this.key = key;
			this.value = value;
			this.modifierData = modifierData;
		}

		public String getKey() {
			return this.key;
		}

		public double getValue() {
			return this.value;
		}

		public ModifierData[] getModifierData() {
			return this.modifierData;
		}
	}

	public class ModifierData {

		private UUID uuid;
		private double amount;
		private byte operation;

		public ModifierData(UUID uuid, double amount, byte operation) {
			this.uuid = uuid;
			this.amount = amount;
			this.operation = operation;
		}

		public UUID getUUID() {
			return this.uuid;
		}

		public double getAmount() {
			return this.amount;
		}

		public byte getOperation() {
			return this.operation;
		}
	}
}

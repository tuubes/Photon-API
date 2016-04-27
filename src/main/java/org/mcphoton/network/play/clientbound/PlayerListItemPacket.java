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
 */
public class PlayerListItemPacket implements Packet {

	public int action;
	public Player[] players;

	@Override
	public int getId() {
		return 0x2D;
	}

	@Override
	public boolean isServerBound() {
		return false;
	}

	@Override
	public void writeTo(ProtocolOutputStream out) {
		out.writeVarInt(action);
		out.writeVarInt(players.length);
		for(Player player : players){
			out.writeLong(player.getUUID().getMostSignificantBits());
			out.writeLong(player.getUUID().getLeastSignificantBits());
			switch (action) {
			case 0:
				out.writeString(player.getName());
				out.writeVarInt(player.getPlayerProperties().length);
				for(PlayerProperty property : player.getPlayerProperties()){
					out.writeString(property.getName());
					out.writeString(property.getValue());
					out.writeBoolean(property.isSigned());
					if(property.isSigned()){
						out.writeString(property.getSignature());
					}
				}
				out.writeVarInt(player.getGamemode());
				out.writeVarInt(player.getPing());
				out.writeBoolean(player.hasDisplayName());
				if(player.hasDisplayName()){
					out.writeString(player.getDisplayName());
				}
				break;
			case 1:
				out.writeVarInt(player.getGamemode());
				break;
			case 2:
				out.writeVarInt(player.getGamemode());
				break;
			case 3:
				out.writeBoolean(player.hasDisplayName());
				if(player.hasDisplayName()){
					out.writeString(player.getDisplayName());
				}
				break;
			}	
		}
	}

	@Override
	public Packet readFrom(ByteBuffer buff) {
		action = ProtocolHelper.readVarInt(buff);
		players = new Player[ProtocolHelper.readVarInt(buff)];
		for(int iplayer = 0; iplayer < players.length; iplayer++){
			UUID uuid = new UUID(buff.getLong(), buff.getLong());
			switch (action) {
			case 0:
				String name = ProtocolHelper.readString(buff);
				PlayerProperty[] playersProperties = new PlayerProperty[ProtocolHelper.readVarInt(buff)];
				for(int iproperty = 0; iproperty < playersProperties.length; iproperty++){
					String propertyName = ProtocolHelper.readString(buff);
					String value = ProtocolHelper.readString(buff);
					String signature = null;
					if(ProtocolHelper.readBoolean(buff))signature = ProtocolHelper.readString(buff);
					playersProperties[iproperty] = new PlayerProperty(propertyName, value, signature);
				}
				int gamemode = ProtocolHelper.readVarInt(buff);
				int ping = ProtocolHelper.readVarInt(buff);
				String displayName0 = null;
				if(ProtocolHelper.readBoolean(buff))displayName0 = ProtocolHelper.readString(buff);
				players[iplayer] = new Player(uuid, name, playersProperties, gamemode, ping, displayName0);
				break;
			case 1:
				players[iplayer] = new Player(uuid, "Gamemode", ProtocolHelper.readVarInt(buff));
				break;
			case 2:
				players[iplayer] = new Player(uuid, "Ping", ProtocolHelper.readVarInt(buff));
				break;
			case 3:
				String displayName3 = null;
				if(ProtocolHelper.readBoolean(buff))displayName3 = ProtocolHelper.readString(buff);
				players[iplayer] = new Player(uuid, displayName3);
				break;
			case 4:
				players[iplayer] = new Player(uuid);
				break;
			}	
			
		}
		return this;
	}

	@Override
	public String toString() {
		return "PlayerListItemPacket{" + "action=" + action + ", players='" + Arrays.toString(players) + '\'' + '}';
	}

	public class Player{

		private UUID uuid;
		private String name, displayName;
		private boolean hasDisplayName;
		private int gamemode, ping;
		private PlayerProperty[] properties;
		
		
		public Player(UUID uuid) {
			this.uuid = uuid;
		}
		
		public Player(UUID uuid, String name, PlayerProperty[] properties, int gamemode, int ping, String displayName) {
			this.uuid = uuid;
			this.name = name;
			this.properties = properties;
			this.gamemode = gamemode;
			this.ping = ping;
			if(displayName != null) {
				this.hasDisplayName = true;
				this.displayName = displayName;
			}else {
				this.hasDisplayName = false;
			}	
		}
		
		public Player(UUID uuid,String type, int value) {
			this.uuid = uuid;
			if(type.equalsIgnoreCase("Gamemode")) {
				this.gamemode = value;
			}else if(type.equalsIgnoreCase("Ping")) {
				this.ping = value;
			}
		}

		public Player(UUID uuid,String displayName) {
			this.uuid = uuid;
			if(displayName != null) {
				this.hasDisplayName = true;
				this.displayName = displayName;
			}else {
				this.hasDisplayName = false;
			}
		}
		
		public UUID getUUID() {
			return this.uuid;
		}
		
		public String getName() {
			return this.name;
		}
		
		public String getDisplayName() {
			return this.displayName;
		}
		
		public int getGamemode() {
			return this.gamemode;
		}
		
		public int getPing() {
			return this.ping;
		}
		
		public PlayerProperty[] getPlayerProperties(){
			return this.properties;
		}
		

		
		public boolean hasDisplayName(){
			return this.hasDisplayName;
		}
		
	}
	
	public class PlayerProperty{
		
		private String name, value, signature;
		private boolean signed;
		
		public PlayerProperty(String name, String value, String signature){
			this.name = name;
			this.value = value;
			if(signature != null) {
				this.signed = true;
				this.signature = signature;
			}else {
				this.signed = false;
			}
		}
		
		public String getName() {
			return this.name;
		}
		
		public String getValue() {
			return this.value;
		}
		
		public String getSignature() {
			return this.signature;
		}
		
		public boolean isSigned(){
			return this.signed;
		}
	}
}

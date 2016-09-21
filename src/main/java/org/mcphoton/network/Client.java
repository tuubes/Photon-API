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
package org.mcphoton.network;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.Optional;
import java.util.concurrent.ScheduledFuture;

import org.mcphoton.entity.living.Player;

/**
 * A client that is connected to a server.
 *
 * @author TheElectronWill
 */
public interface Client {

	/**
	 * Gets the client's IP address.
	 */
	InetSocketAddress getAddress();

	/**
	 * Gets the Player associated with this client, if any.
	 *
	 * @return an Optional that contains the player, or an empty optional if there is no player.
	 */
	Optional<Player> getPlayer();

	/**
	 * Gets the current client's connection state.
	 */
	ConnectionState getConnectionState();

	/**
	 * Sets the client's connection state.
	 */
	void setConnectionState(ConnectionState newState);

	/**
	 * Closes the client's connection, without warning it.
	 */
	void closeConnection() throws IOException;

	/**
	 * @return if the client connection is closed.
	 */
	boolean isClosed();
	
	/**
	 * @return if the client is locally connected or not.
	 */
	boolean isLocal();
	
	ScheduledFuture<?> getKeepClientRunnable();
	
}

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

/**
 * Interface for handling packets of some type.
 *
 * @author TheElectronWill
 * @param <P> the packet's type
 */
@FunctionalInterface
public interface PacketHandler<P extends Packet> {

	/**
	 * Handles a packet that is being sent to a client, or that has just been received by the server. This
	 * method should only perform very quick tasks, because it may block the processing of other packets. Any
	 * big or slow task must be delegated to another thread, for example to the Photon's ExecutorService.
	 *
	 * @param packet the packet that will be sent, or that has been received
	 * @param client the client who will receive the packet, or the client who sent it.
	 */
	void handle(P packet, Client client);

}

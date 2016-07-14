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
package org.mcphoton;

import java.io.File;
import java.util.concurrent.ScheduledExecutorService;
import org.mcphoton.block.BlockRegistry;
import org.mcphoton.entity.EntityRegistry;
import org.mcphoton.item.ItemRegistry;
import org.mcphoton.network.PacketsManager;
import org.mcphoton.permissions.PermissionsManager;
import org.mcphoton.server.Server;
import org.mcphoton.world.BiomeRegistry;

/**
 * The centralized API core. Gives access to many core points of the API, like the {@link PermissionsManager}.
 *
 * @author TheElectronWill
 * @author Maaattt
 */
public final class Photon {

	/*
	 * Every method here returns null and it's completely normal. Actually the photon implementation redefines
	 * this class and completes its methods.
	 */
	private Photon() {
	}

	/**
	 * Gets the Photon's ScheduledExecutorService, which is used to schedule tasks across multiple
	 * threads.
	 * <h2>What kind of task may be submitted to this ExecutorService?</h2>
	 * <p>
	 * To achieve better performance, the submitted tasks:
	 * <ol>
	 * <li>Musn't be IO-bound, in order to avoid delaying the other tasks. Use an asynchronous IO API
	 * instead of the ExecutorService.</li>
	 * <li>Musn't be too short, in order to avoid creating too much overhead. It is advised to group many
	 * small tasks together into one bigger task.</li>
	 * </ol>
	 * </p>
	 */
	public static ScheduledExecutorService getExecutorService() {
		return null;
	}

	public static PacketsManager getPacketsManager() {
		return null;
	}

	public static PermissionsManager getPermissionsManager() {
		return null;
	}

	public static EntityRegistry getEntityRegistry() {
		return null;
	}

	public static BlockRegistry getBlockRegistry() {
		return null;
	}

	public static ItemRegistry getItemRegistry() {
		return null;
	}

	public static BiomeRegistry getBiomeRegistry() {
		return null;
	}

	public static boolean isClient() {
		return false;
	}

	public static boolean isServer() {
		return false;
	}

	public static boolean isConsoleAdvanced() {
		return false;
	}

	public static String getVersion() {
		return "dev-alpha";
	}

	public static String getMinecraftVersion() {
		return "1.10";
	}

	public static File getMainDirectory() {
		return null;
	}

	public static File getPluginsDirectory() {
		return null;
	}

	public static Server getServer() {
		return null;
	}

}

package org.mcphoton;

import java.io.File;
import org.mcphoton.block.BlockRegistry;
import org.mcphoton.command.CommandsRegistry;
import org.mcphoton.entity.EntityRegistry;
import org.mcphoton.event.EventsManager;
import org.mcphoton.item.ItemRegistry;
import org.mcphoton.network.PacketsManager;
import org.mcphoton.plugin.PluginsManager;
import org.mcphoton.world.BiomeRegistry;

/**
 * The centralized API core. Gives access to many core points of the API, like the {@link PluginsManager} and
 * the {@link EventManager}.
 *
 * @author TheElectronWill
 *
 */
public final class Photon {

	private Photon() {
	}

	public static PacketsManager getPacketsManager() {
		return null;
	}

	public static PluginsManager getPluginsManager() {
		return null;
	}

	public static EventsManager getEventsManager() {
		return null;
	}

	public static CommandsRegistry getCommandsRegistry() {
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

	public static String getVersion() {
		return "0.2.0-alpha";
	}

	public static String getMinecraftVersion() {
		return "1.9";
	}

	public static File getMainDirectory() {
		return null;
	}

	public static File getPluginsDirectory() {
		return null;
	}

}

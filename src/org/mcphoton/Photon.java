package org.mcphoton;

import java.io.File;
import org.mcphoton.block.BlockRegistry;
import org.mcphoton.entity.EntityRegistry;
import org.mcphoton.event.EventsManager;
import org.mcphoton.item.ItemRegistry;
import org.mcphoton.network.PacketRegistry;
import org.mcphoton.network.PacketService;
import org.mcphoton.plugin.PluginsManager;
import org.mcphoton.world.BiomeRegistry;

/**
 * The centralized API core. Gives access to many core points of the API, like the {@link PluginsManager} and the
 * {@link EventManager}.
 * 
 * @author TheElectronWill
 * 		
 */
public final class Photon {
	
	private Photon() {}
	
	public static PluginsManager pluginsManager() {
		return null;
	}
	
	public static EventsManager eventsManager() {
		return null;
	}
	
	public static EntityRegistry entityRegistry() {
		return null;
	}
	
	public static BlockRegistry blockRegistry() {
		return null;
	}
	
	public static ItemRegistry itemRegistry() {
		return null;
	}
	
	public static BiomeRegistry biomeRegistry() {
		return null;
	}
	
	public static PacketRegistry packetRegistry() {
		return null;
	}
	
	public static PacketService packetService() {
		return null;
	}
	
	public static boolean isClient() {
		return false;
	}
	
	public static boolean isServer() {
		return false;
	}
	
	public static String version() {
		return "0.2.0-alpha";
	}
	
	public static String minecraftVersion() {
		return "1.9";
	}
	
	public static File mainDirectory() {
		return null;
	}
	
	public static File pluginsDirectory() {
		return null;
	}
	
}

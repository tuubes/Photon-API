package org.mcphoton.command;

import org.mcphoton.plugin.Plugin;

/**
 *
 * @author TheElectronWill
 */
public interface CommandsRegistry {

	void register(Command cmd, Plugin plugin);

	void unregister(Command cmd, Plugin plugin);

	Command get(String cmdName);

}

package org.mcphoton.command;

import java.util.List;
import org.mcphoton.plugin.Plugin;

/**
 *
 * @author TheElectronWill
 */
public interface CommandsRegistry {

	void register(Command cmd, Plugin plugin);

	void unregister(Command cmd, Plugin plugin);

	Command getRegistered(String cmdName);

	List<Command> getAllRegistered(Plugin plugin);

}

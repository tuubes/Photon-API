package org.mcphoton.command;

import com.electronwill.utils.StringUtils;
import java.util.List;
import org.mcphoton.messaging.Messageable;

/**
 * A command that can be executed.
 *
 * @author TheElectronWill
 */
public interface Command {

	/**
	 * Executes this command.
	 *
	 * @param source the person or thing that executes this command
	 * @param argString the string that contains all the characters except the command name
	 */
	default void execute(Messageable source, String argString) {
		List<String> parts = StringUtils.split(argString, ' ');
		String[] array = new String[parts.size()];
		execute(source, parts.toArray(array));
	}

	/**
	 * Executes this command.
	 *
	 * @param source the person or thing that executes this command
	 * @param args the array that contains the command's arguments
	 */
	void execute(Messageable source, String[] args);

	/**
	 * Gets the name of this command.
	 */
	String getName();

}

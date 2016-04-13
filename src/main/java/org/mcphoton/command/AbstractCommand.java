package org.mcphoton.command;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

/**
 * Base class for commands.
 *
 * @author TheElectronWill
 */
public abstract class AbstractCommand implements Command {

	protected final Options options;

	public AbstractCommand(Options options) {
		this.options = options;
	}

	@Override
	public void execute(Object source, String[] args) {
		CommandLineParser parser = new DefaultParser();
		try {
			CommandLine cmdLine = parser.parse(options, args);
			execute(source, cmdLine);
		} catch (ParseException ex) {
			ex.printStackTrace();
		}
	}

	/**
	 * Executes this command.
	 *
	 * @param source the person or thing that executes this command
	 * @param cmd the CommandLine objet that contains the parsed arguments of this command
	 */
	public abstract void execute(Object source, CommandLine cmd);

}

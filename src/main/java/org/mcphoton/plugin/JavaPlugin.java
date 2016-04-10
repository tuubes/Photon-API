package org.mcphoton.plugin;

import com.electronwill.utils.Constant;
import java.io.File;
import org.mcphoton.Photon;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Abstract class for every plugin written in Java.
 *
 * @author TheElectronWill
 *
 */
public abstract class JavaPlugin implements Plugin {

	// These fields are private, they are not required by the API and may be deleted at any time.
	private final File directory = new File(Photon.pluginsDirectory(), name());
	private final File configFile = new File(directory, "config.yml");
	private final Logger logger = LoggerFactory.getLogger("plugin." + name());
	private final Constant<PluginLoader> loader = new Constant<>();

	@Override
	public final File directory() {
		return directory;
	}

	@Override
	public final File configFile() {
		return configFile;
	}

	@Override
	public final Logger logger() {
		return logger;
	}

	@Override
	public final PluginLoader loader() {
		return loader.get();
	}

	public final void init(PluginLoader loader) {
		this.loader.init(loader);
	}

	@Override
	public String[] requiredDependencies() {
		return null;
	}

	@Override
	public String[] optionalDependencies() {
		return null;
	}

}

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

	protected final File directory = new File(Photon.getPluginsDirectory(), getName());
	protected final File configFile = new File(directory, "config.yml");
	protected final Logger logger = LoggerFactory.getLogger(getName());
	private final Constant<PluginLoader> loader = new Constant<>();

	@Override
	public final File getDirectory() {
		return directory;
	}

	@Override
	public final File getConfigFile() {
		return configFile;
	}

	@Override
	public final Logger getLogger() {
		return logger;
	}

	@Override
	public final PluginLoader getLoader() {
		return loader.get();
	}

	public final void init(PluginLoader loader) {
		this.loader.init(loader);
	}

	@Override
	public String[] getRequiredDependencies() {
		return null;
	}

	@Override
	public String[] getOptionalDependencies() {
		return null;
	}

}

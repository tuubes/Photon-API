package org.mcphoton.plugin;

import java.io.File;
import org.slf4j.Logger;

/**
 * A plugin that may be loaded and unloaded.
 * <h1>Dependency format</h1>
 * Each string defines a dependency like this: <code>dependency:versionRequirement</code><br />
 * The version requirement describes the version of the dependency that is needed by this plugin. It has two
 * parts: a condition, and a version number.
 * <h2>Conditions</h2>
 * The following conditions may be used:
 * <ul>
 * <li><code>==</code> strictly equal</li>
 * <li><code>!=</code> non equal</li>
 * <li><code>~=</code> compatible</li>
 * <li>{@code >=} greater or equal</li>
 * <li>{@code > } strictly greater</li>
 * <li>{@code <=} smaller or equal</li>
 * <li>{@code < } strictly smaller</li>
 * </ul>
 * <h2>Version number</h2>
 * This system is based on <a href="http://semver.org/">Semantic Versioning</a>. A version number consists of
 * 3 integers (major, minor and patch number), separated by a dot, like for example "1.3.15". You can use less
 * than 3 numbers, in which case any missing number will be replaced by a zero. For example, "1.3" is the same
 * as "1.3.0".<br />
 * You may also add a supplementary char sequence to the end of the version number, prefixed by an hyphen
 * (minus sign). For example: "1.2.1-alpha"
 * <h2>Wildcard requirements with '*'</h2>
 * The character '*' replaces an integer. It allows for any version at its position.<br />
 * For example, "== 1.2.*" allows any version that starts with "1.2", like "1.2.0", "1.2.21", etc. And "==
 * 1.*.3" allows for any version that has a major version of 1 and a patch version of 3, like "1.0.3",
 * "1.17.3", etc.<br />
 * <b>The wildcard may only be used with a "strictly equal" or "non equal" condition.</b>
 * <h2>Minimum requirements with '+'</h2>
 * The character '+' goes to the end of an integer. It allows for any version that is greater or equal to the
 * specified one.<br />
 * For example, "== 1.2.3+" allow any version that has a major of 1, a minor of 2 and a
 * patch greater or equal to 3, like "1.2.3" and "1.2.14". And "== 1.2+.3" allows for any version that has a
 * major of 1, a minor greater or equal to 2 and a patch of 3, like "1.2.3" and "1.25.3".<br />
 * <b>The + may only be used with a "strictly equal" or "non equal" condition.</b>
 * <h2>Compatible condition</h2>
 * The "compatible" condition allows for any version that is compatible to the specified one according to the
 * semantic versioning. There are two cases:
 * <ul>
 * <li>The major version is 0: in that case, two versions are considered compatible if and only if
 * they have the same supplementary char sequence
 * AND they have the same minor version number
 * </li>
 * <li>The major version isn't 0: in that case, two versions are considered compatible if and only if
 * they have the same supplementary char sequence
 * AND they have the same major version number
 * </li>
 * </ul>
 *
 *
 */
public interface Plugin {

	/**
	 * Gets the plugin's name.
	 */
	String name();

	/**
	 * Gets the plugin's author(s).
	 */
	String author();

	/**
	 * Gets the plugin's version. The version should follow the principles of
	 * <a href="http://semver.org/">Semantic versioning</a>.
	 */
	String version();

	/**
	 * Gets the plugin's required dependencies. May return null if there is no dependency.
	 *
	 * @see Plugin the dependency format
	 */
	String[] requiredDependencies();

	/**
	 * Gets the plugin's optional dependencies. May return null if there is no dependency.
	 *
	 * @see Plugin the dependency format
	 */
	String[] optionalDependencies();

	/**
	 * Gets the directory this plugin may use to store files.
	 */
	File directory();

	/**
	 * Gets the plugin's main config file.
	 */
	File configFile();

	/**
	 * Gets the plugin's logger.
	 */
	Logger logger();

	/**
	 * Gets the {@link PluginLoader} that loaded this plugin.
	 */
	PluginLoader loader();

	/**
	 * Called when the plugin is loaded, just after its constructor is called.
	 */
	void onLoad();

	/**
	 * Called when the plugin is unloaded, just after it is removed from the PluginsManager.
	 */
	void onUnload();

}

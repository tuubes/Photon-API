package org.mcphoton.messaging;

/**
 *
 * @author TheElectronWill
 */
public enum Color {

	/**
	 * dark black.
	 */
	BLACK("\u001B[2m\u001B[30m"),
	/**
	 * light blue.
	 */
	BLUE("\u001B[34m"),
	/**
	 * aqua, i.e. light cyan.
	 */
	AQUA("\u001B[36m"),
	/**
	 * dark blue.
	 */
	DARK_BLUE("\u001B[2m\u001B[34m"),
	/**
	 * dark aqua, i.e dark cyan
	 */
	DARK_AQUA("\u001B[2m\u001B[36m"),
	/**
	 * dark green.
	 */
	DARK_GREEN("\u001B[2m\u001B[32m"),
	/**
	 * Dark grey, i.e. light black.
	 */
	DARK_GREY("\u001B[30m"),
	/**
	 * dark purple, i.e. dark magenta.
	 */
	DARK_PURPLE("\u001B[2m\u001B[35m"),
	/**
	 * dark red.
	 */
	DARK_RED("\u001B[2m\u001B[31m"),
	/**
	 * Dark yellow, also called "gold" or "orange".
	 */
	GOLD("\u001B[2m\u001B[33m"),
	/**
	 * light green
	 */
	GREEN("\u001B[32m"),
	/**
	 * Grey, i.e. dark white.
	 */
	GREY("\u001B[37m"),
	/**
	 * purple, i.e. light magenta.
	 */
	LIGHT_PURPLE("\u001B[35m"),
	/**
	 * light red.
	 */
	RED("\u001B[31m"),
	/**
	 * light white.
	 */
	WHITE("\u001B[37m"),
	/**
	 * light yellow.
	 */
	YELLOW("\u001B[33m");

	/**
	 * The ansi code for printing this color in a terminal (works well on Mac, Linux and Solaris).
	 */
	public final String ansi;

	private Color(String ansi) {
		this.ansi = ansi;
	}

	@Override
	public String toString() {
		return name().toLowerCase();
	}

}

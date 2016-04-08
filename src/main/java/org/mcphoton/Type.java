package org.mcphoton;

/**
 * Inteface for types (EntityType, ItemType, etc.)
 *
 * @author TheElectronWill
 */
public interface Type {

	/**
	 * Gets the localized name of this type. For example: "Dirt".
	 */
	String getLocalizedName();

	/**
	 * Gets the unique and unlocalized name of this type. For example: "minecraft.dirt".
	 */
	String getUniqueName();

	/**
	 * Gets the unique id of this type. For example: 2
	 */
	int getUniqueId();

}

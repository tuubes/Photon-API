package org.mcphoton.plugin;

/**
 * An exception that occurs in the loading of a plugin.
 * 
 * @author TheElectronWill
 * 		
 */
public class PluginLoadingException extends Exception {
	
	private static final long serialVersionUID = 1L;
	
	public PluginLoadingException() {
		super();
	}
	
	public PluginLoadingException(String message, Throwable cause) {
		super(message, cause);
		
	}
	
	public PluginLoadingException(String message) {
		super(message);
		
	}
	
	public PluginLoadingException(Throwable cause) {
		super(cause);
		
	}
	
}

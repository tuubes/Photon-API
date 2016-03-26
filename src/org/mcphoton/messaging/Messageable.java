package org.mcphoton.messaging;

/**
 * Interface for objects which can receive messages.
 * 
 * @author TheElectronWill
 */
public interface Messageable {
	
	void sendMessage(CharSequence msg);
	
	void sendMessage(ChatMessage msg);
	
}

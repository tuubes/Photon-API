package org.mcphoton.messaging;

/**
 * Interface for objects that can receive messages.
 *
 * @author TheElectronWill
 */
public interface Messageable {

	void sendMessage(CharSequence msg);

	void sendMessage(ChatMessage msg);

}

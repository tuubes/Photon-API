package org.mcphoton.event;

public interface EventsManager {
	
	void registerAll(Object listener);
	
	<E extends Event> void register(Class<E> eventClass, EventHandler<? super E> eventHandler, ListenOrder listenOrder);
	
	<E extends Event> void unregister(Class<E> eventClass, EventHandler<? super E> eventHandler, ListenOrder listenOrder);
	
	<E extends Event> void unregister(Class<E> eventClass, EventHandler<? super E> eventHandler);
	
	void unregisterAll(Object listener);
	
	void post(Event event);
	
}

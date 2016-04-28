# TODO
Here are the tasks to do for the next API version (or a future one). Update this file when you start working on something,
and when you're done.
- [x] **Implement all the network packets**. You can find a description of each packet [here](http://wiki.vg/Protocol).
The packets are sorted in different subpackages of `org.mcphoton.network`. A packet's class must have public fields that defines
the data that will be sent or that has been received. For this task, you don't have to implement all the packets at once. You can
implement some packets, make a pull request, implement more and so on.
- [x] Remove `EventsManager.unregister(Class<E>, EventHandler<? super E>)` and `EventsManager.unregisterAll(Object)`
- [x] Add `EventsManager.unregisterAll(Plugin)`
- [x] Create a `WorldType`
- [x] Refractor the `World` interface: `getType()` should return a `WorldType` 
- [ ] Allow object creation with a type, for example an entity should be created by calling `MyEntityType.create(some parameters to determine)`
- [ ] In `org.mcphoton.messaging.TextChatMessage.toConsoleString()`, check if the colors are supported by the console. Generally,
the colors are supported on Linux and OSX, but not on Windows.
- [ ] Talk about the protection API (AccessManager, etc.): how to make it better? What are its goals?
- [ ] Talk about the entities multi-thread system: how to ensure thread-safety without too much effort from the plugin dev? An idea of TheElectronWill is to interact with entities with a SafeRef<Entity> or EntityRef object, instead of directly using the Entity object.
There is a discussion group here (french) : https://groups.google.com/forum/#!forum/photon-api-fr/

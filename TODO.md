# TODO
Here are the tasks to do for the next API version (or a future one). Update this file when you start working on something,
and when you're done.
- [ ] Refractor the EventsManager to record the plugin that registers an event listener.
- [x] Update the network packets to support Minecraft 1.9.4. You can find a description of each packet [here](http://wiki.vg/Protocol).
The packets are sorted in different subpackages of `org.mcphoton.network`. A packet's class must have public fields that defines
the data that will be sent or that has been received. For this task, you don't have to implement all the packets at once. You can
implement some packets, make a pull request, implement more and so on.
- [ ] Allow object creation with a type, for example an entity should be created by calling `MyEntityType.create(some parameters to determine)`.
- [ ] Add something like a "metadata" or "data container" API to attach additional data to objects like entities. A piece of data would be identified by its name.
- [ ] Use "User" instead of "OfflinePlayer".
- [ ] Add an API to get informations about the offline users
- [x] In `org.mcphoton.messaging.TextChatMessage.toConsoleString()`, check if the colors are supported by the console. Generally,
the colors are supported on Linux and OSX, but not on Windows.
- [ ] Talk about the protection API (AccessManager, etc.): how to make it better? What are its goals?  
**There is a discussion group [here (french)](https://groups.google.com/forum/#!forum/mcphoton-fr).**

package org.mediaplayer;


public class PluginCreatorManager {

    IMediaPlayerPlugin createConnection(final ICreatorPlugin ICreatorPlugin) {
        return ICreatorPlugin.createPlugin();
    }
}

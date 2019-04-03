package org.mediaplayer.creators;

import org.mediaplayer.ICreatorPlugin;
import org.mediaplayer.IMediaPlayerPlugin;
import org.mediaplayer.products.PluginMusic;

public class CreatorPluginMusic implements ICreatorPlugin {
    @Override
    public IMediaPlayerPlugin createPlugin() {
        return new PluginMusic();
    }
}

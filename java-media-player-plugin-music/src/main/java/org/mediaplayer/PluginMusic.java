package org.mediaplayer;

public class PluginMusic implements IMediaPlayerPlugin {
    @Override
    public boolean isSupported(IMediaPlayerFile IMediaPlayerFile) {
        return IMediaPlayerFile.getFile().contains("mp3");
    }

    @Override
    public String play() {
        return "Playing Music";
    }

    @Override
    public String stop() {
        return "Stopping Music";
    }

    @Override
    public String getDuration() {
        return "Duration Music";
    }

    @Override
    public String getType() {
        return "mp3";
    }
}

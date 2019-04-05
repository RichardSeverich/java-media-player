package org.mediaplayer;

/**
 * MediaPlayerPluginMusic.
 */
public class MediaPlayerPluginMusic implements IMediaPlayerPlugin {

    /**
     * [@inheritDoc]
     */
    @Override
    public boolean isSupported(IMediaPlayerFile mediaPlayerFile) {
        return mediaPlayerFile.getFile().contains("mp3");
    }

    /**
     * [@inheritDoc]
     */
    @Override
    public String play() {
        return "Playing Music";
    }

    /**
     * [@inheritDoc]
     */
    @Override
    public String stop() {
        return "Stopping Music";
    }

    /**
     * [@inheritDoc]
     */
    @Override
    public String getDuration() {
        return "60";
    }

    /**
     * [@inheritDoc]
     */
    @Override
    public String getFileType() {
        return "mp3";
    }
}

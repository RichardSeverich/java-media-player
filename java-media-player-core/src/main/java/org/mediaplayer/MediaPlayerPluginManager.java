package org.mediaplayer;

/**
 * Class.
 */
public class MediaPlayerPluginManager {

    private IMediaPlayerPlugin mediaPlayerPlugin;

    /**
     * @param mediaPlayerPlugin mediaPlayerPlugin.
     */
    MediaPlayerPluginManager(final IMediaPlayerPlugin mediaPlayerPlugin) {
        this.mediaPlayerPlugin = mediaPlayerPlugin;
    }

    /**
     * @param mediaPlayerFile mediaPlayerFile.
     * @return true if is supported.
     */
    public boolean isSupported(final IMediaPlayerFile mediaPlayerFile) {
        return this.mediaPlayerPlugin.isSupported(mediaPlayerFile);
    }

    /**
     * @return Playing.
     */
    public String play() {
        return this.mediaPlayerPlugin.play();
    }

    /**
     * @return Stopping.
     */
    public String stop() {
        return this.mediaPlayerPlugin.stop();
    }

    /**
     * @return Duration in seg.
     */
    public String getDuration() {
        return this.mediaPlayerPlugin.getDuration();
    }

    /**
     * @return File type.
     */
    public String getFileType() {
        return this.mediaPlayerPlugin.getFileType();
    }

}

package org.mediaplayer;

/**
 * IMediaPlayerPlugin.
 */
public interface IMediaPlayerPlugin {

    /**
     * @param mediaPlayerFile Media file.
     * @return true if plugin supports file.
     */
    public boolean isSupported(IMediaPlayerFile mediaPlayerFile);

    /**
     * @return playing media player.
     */
    public String play();

    /**
     * @return stopping media player.
     */
    public String stop();

    /**
     * @return duranto in seg.
     */
    public String getDuration();

    /**
     * @return file type for example: mp3 or mp4.
     */
    public String getFileType();

}

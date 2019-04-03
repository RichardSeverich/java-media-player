package org.mediaplayer;

public interface IMediaPlayerPlugin {

    public boolean isSupported(IMediaPlayerFile IMediaPlayerFile);

    public String play();

    public String stop();

    public String getDuration();

    public String getType();

}


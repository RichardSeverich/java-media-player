package org.mediaplayer;

import java.util.*;

/**
 * Service Loader.
 */
public class LoadPlugins {

    private ServiceLoader<IMediaPlayerPlugin> serviceLoader;
    private List<IMediaPlayerPlugin> listPlugins;

    LoadPlugins() {
        // Found IMediaPlayerPlugin in classpath.
        this.serviceLoader = ServiceLoader.load(IMediaPlayerPlugin.class);
        this.listPlugins = new ArrayList<>();
    }

    /**
     * Load all plugins classes found in classpath that implements IMediaPlayerPlugin.
     */
    private void loadAllPlugins() {
        this.serviceLoader.reload();
    }

    /**
     * Add each plugin class to List.
     */
    private void addEachPluginToList() {
        for (IMediaPlayerPlugin plugin : this.serviceLoader) {
            listPlugins.add(plugin);
        }
    }

    /**
     * @return list of plugins found in classpath.
     */
    public IMediaPlayerPlugin[] getListPlugins() {
        this.loadAllPlugins();
        this.addEachPluginToList();
        return listPlugins.toArray(new IMediaPlayerPlugin[0]);
    }
}

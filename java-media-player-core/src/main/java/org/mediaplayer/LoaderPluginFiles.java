package org.mediaplayer;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Class.
 */
public class LoaderPluginFiles {

    private static final String EXTENSION_PLUGINS = ".jar";
    private static final String PATH_PLUGINS = "plugins/";
    private File filePluginsPath; //good
    private List<File> listPluginsFiles;
    private File[] arrayPluginsFile;

    /**
     * Constructor.
     */
    LoaderPluginFiles() {
        this.filePluginsPath = new File(PATH_PLUGINS);
        this.listPluginsFiles = new ArrayList<>();
    }

    /**
     * searchPluginsFiles.
     */
    private void searchPluginsFiles() {
        this.arrayPluginsFile = filePluginsPath.listFiles((dir, name) -> name.endsWith(EXTENSION_PLUGINS));
    }

    /**
     * Add plugins Files To List.
     */
    private void addPluginsFileToList() {
        if (this.arrayPluginsFile != null) {
            Collections.addAll(this.listPluginsFiles, this.arrayPluginsFile);
        }
    }

    /**
     * @return is valid plugins path.
     */
    private boolean isValidPluginsPath() {
        final boolean dirPluginsExist = this.filePluginsPath.exists();
        final boolean dirPluginsIsDirectory = this.filePluginsPath.isDirectory();
        return dirPluginsExist && dirPluginsIsDirectory;

    }

    /**
     * @return getPluginFiles.
     */
    public File[] getPluginFiles() {
        if (isValidPluginsPath()) {
            this.searchPluginsFiles();
            this.addPluginsFileToList();
        }
        return listPluginsFiles.toArray(new File[0]);
    }
}


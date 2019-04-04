package org.mediaplayer;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Class.
 */
public class LoadPluginFiles {

    private static final String EXTENSION_PLUGINS = ".jar";
    private static final String PATH_PLUGINS = "plugins/";
    private File filePluginsPath; //good
    private List<File> listPluginsFiles;
    private File[] arrayPluginsFile;

    /**
     * Constructor.
     */
    LoadPluginFiles() {
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
            listPluginsFiles.addAll(Collections.singletonList(filePluginsPath));
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
     * @return Plugin Files.
     */
    public File[] getPluginFiles() {
        if (isValidPluginsPath()) {
            searchPluginsFiles();
            addPluginsFileToList();
        }
        return listPluginsFiles.toArray(new File[0]);
    }

    public File[] searchPlugins() {
        boolean dirPluginsExist = filePluginsPath.exists();
        boolean dirPluginsIsDirectory = filePluginsPath.isDirectory();
        if (dirPluginsExist && dirPluginsIsDirectory) {
            this.arrayPluginsFile = filePluginsPath.listFiles((dir, name) -> name.endsWith(EXTENSION_PLUGINS));
            Collections.addAll(this.listPluginsFiles, this.arrayPluginsFile);
        }
        return listPluginsFiles.toArray(new File[0]);
    }

}


package org.mediaplayer;


import java.io.File;

/**
 * Class.
 */
public class LoaderClassPath {

    private File[] arrayPluginsFiles;
    private LoaderClassPathModifier loaderClassPathModifier;
    private boolean isPluginsFilesAdded;

    /**
     * @param loaderPluginFiles loaderPluginFiles.
     */
    public LoaderClassPath(LoaderPluginFiles loaderPluginFiles) {
        this.arrayPluginsFiles = loaderPluginFiles.getPluginFiles();
        this.loaderClassPathModifier = new LoaderClassPathModifier();
    }

    /**
     * addPluginsFilesToClassPath.
     */
    public void addPluginsFilesToClassPath() {
        this.isPluginsFilesAdded = false;
        if (arrayPluginsFiles.length > 0) {
            addEachPluginFileToClassPath();
            this.isPluginsFilesAdded = true;
        }
    }

    /**
     * @return true, if all plugins files are added to class path.
     */
    public boolean isPluginsFilesAdded() {
        return isPluginsFilesAdded;
    }

    /**
     * add Each Plugin to ClassPath.
     */
    private void addEachPluginFileToClassPath() {
        for (File pluginFile : arrayPluginsFiles) {
            loaderClassPathModifier.addFile(pluginFile);
        }
    }

}

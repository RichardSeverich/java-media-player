package org.mediaplayer;


import java.io.File;


/**
 * Class.
 */
public class LoaderClassPath {

    private File[] arrayPluginsFiles;
    private ClassPathModifier classPathModifier;
    private boolean isPluginsFilesAdded;

    public LoaderClassPath(LoaderPluginFiles loaderPluginFiles) {
        this.arrayPluginsFiles = loaderPluginFiles.getPluginFiles();
        this.classPathModifier = new ClassPathModifier();
    }

    /**
     *
     */
    public void addPluginsFilesToClassPath() {
        this.isPluginsFilesAdded = false;
        if (arrayPluginsFiles.length > 0) {
            addEachPluginFileToClassPath();
            this.isPluginsFilesAdded = true;
        }
    }

    public boolean isPluginsFilesAdded() {
        return isPluginsFilesAdded;
    }

    /**
     * add Each Plugin to ClassPath.
     */
    private void addEachPluginFileToClassPath() {
        for (File pluginFile : arrayPluginsFiles) {
            classPathModifier.addFile(pluginFile);
        }
    }

}

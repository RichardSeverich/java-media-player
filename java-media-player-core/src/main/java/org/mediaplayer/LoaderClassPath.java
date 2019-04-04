package org.mediaplayer;


import java.io.File;


/**
 * Class.
 */
public class LoaderClassPath {

    private File[] arrayPluginsFiles;
    private ClassPathModifier classPathModifier;

    public LoaderClassPath(LoaderPluginFiles loaderPluginFiles) {
        this.arrayPluginsFiles = loaderPluginFiles.getPluginFiles();
        this.classPathModifier = new ClassPathModifier();
    }


    /**
     * Carga los plugins encontrados al classpath
     *
     * @return true si se cargaron los plugins,
     * false en caso de existir algun error
     */
    public boolean addPluginsFilesToClassPath() {
        boolean flag = false;
        if (arrayPluginsFiles.length > 0) {
            addEachPluginToClassPath();
            flag = true;
        }
        return flag;
    }

    /**
     * add Each Plugin to ClassPath.
     */
    public void addEachPluginToClassPath9() {
        for (File jarFile : arrayPluginsFiles) {
            classPathModifier.addFile(jarFile);
        }
    }

    /**
     *
     */
    public void addPluginsClassPath() {
        if (this.arrayPluginsFiles.length > 0) {
            addEachPluginToClassPath();
        }

    }

    /**
     * add Each Plugin to ClassPath.
     */
    private void addEachPluginToClassPath() {
        for (File pluginFile : arrayPluginsFiles) {
            classPathModifier.addFile(pluginFile);
        }
    }

}

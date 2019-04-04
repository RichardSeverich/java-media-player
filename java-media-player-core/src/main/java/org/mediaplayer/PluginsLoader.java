package org.mediaplayer;

import org.apache.log4j.Logger;

import java.io.File;
import java.io.FilenameFilter;
import java.net.MalformedURLException;
import java.util.*;

/**
 * Class.
 */
public class PluginsLoader {
    
    private File[] listPluginFiles;
    private ClassPathModifier classPathModifier;

    public PluginsLoader() {
        LoadPluginFiles loadPluginFiles = new LoadPluginFiles();
        this.listPluginFiles = loadPluginFiles.searchPlugins();
        this.classPathModifier = new ClassPathModifier();
    }

    /**
     * Carga los plugins encontrados al classpath
     *
     * @return true si se cargaron los plugins,
     * false en caso de existir algun error
     */
    public boolean loadPlugins() {
        boolean flag = false;
        if (listPluginFiles.length > 0) {
            addEachPluginToClassPath();
            flag = true;
        }
        return flag;
    }

    /**
     * add Each Plugin to ClassPath.
     */
    public void addEachPluginToClassPath() {
        for (File jarFile : listPluginFiles) {
            classPathModifier.addFile(jarFile);
        }
    }

}

package org.mediaplayer;

public class Main {

    public static void main(String[] args) {
        System.out.println("-------------------------------");
        LoaderPluginFiles loaderPluginFiles = new LoaderPluginFiles();
        LoaderClassPath loaderClassPath = new LoaderClassPath(loaderPluginFiles);
        loaderClassPath.addPluginsFilesToClassPath();
        // Verifica si se cargaron jar al class path.
        if (loaderClassPath.isPluginsFilesAdded()) {
            //obtiene una instancia de cada plugin IMediaPlayerPlugin encontrado.
            LoaderPlugins loaderPlugins = new LoaderPlugins();
            IMediaPlayerPlugin[] arrayDePlugins = loaderPlugins.getListPlugins();
            if (arrayDePlugins.length > 0) {
                for (IMediaPlayerPlugin a : arrayDePlugins) {
                    //por cada plugin muestra la clase y el mensaje que devuelve
                    System.out.println("Plugin: \t" + a.getClass().getCanonicalName());
                    System.out.println("Mensaje:\t" + a.getType());
                    System.out.println();
                }
            } else {
                System.out.println("No se Encontraron Plugins");
            }
        } else {
            System.out.println("Plugins No Cargados");
        }

        System.out.println("-------------------------------");
    }
}

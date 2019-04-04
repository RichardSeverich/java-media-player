package org.mediaplayer;

public class Main {

    public static void main(String[] args) {
        System.out.println("-------------------------------");
        LoaderPluginFiles loaderPluginFiles = new LoaderPluginFiles();
        LoaderClassPath loaderClassPath = new LoaderClassPath(loaderPluginFiles);
        //se cargan los jars del directorio "plugins" al classpath
        loaderClassPath.addPluginsFilesToClassPath();
        boolean cargados = loaderClassPath.isPluginsFilesAdded();

        if (cargados) {
            try {
                //obtiene una instancia de cada plugin IPluginMensaje encontrado
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
            } catch (Exception ex) {
                System.err.println("Excepcion: " + ex.getMessage());
                ex.printStackTrace();
            }
        } else {
            System.out.println("Plugins No Cargados");
        }

        System.out.println("-------------------------------");
    }
}

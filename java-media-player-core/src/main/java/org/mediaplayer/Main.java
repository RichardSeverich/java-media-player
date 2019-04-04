package org.mediaplayer;

public class Main {

    public static void main(String[] args) {
        System.out.println("-------------------------------");
        PluginsLoader pluginsLoader = new PluginsLoader();

        //se cargan los jars del directorio "plugins" al classpath
        boolean cargados = pluginsLoader.loadPlugins();

        if (cargados) {
            try {
                //obtiene una instancia de cada plugin IPluginMensaje encontrado
                LoadPlugins loadPlugins = new LoadPlugins();
                IMediaPlayerPlugin[] arrayDePlugins = loadPlugins.getListPlugins();

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

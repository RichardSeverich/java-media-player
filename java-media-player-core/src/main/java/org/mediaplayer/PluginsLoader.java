package org.mediaplayer;

import java.io.File;
import java.io.FilenameFilter;
import java.net.MalformedURLException;
import java.util.Iterator;
import java.util.ServiceLoader;
import java.util.Vector;

public class PluginsLoader {

    private static final String EXTENSION_JAR = ".jar";
    private static final String DIRECTORIO_PLUGINS = "plugins/";

    /**
     * carga los plugins encontrados al classpath
     *
     * @return true si se cargaron los plugins,
     * false en caso de existir algun error
     */
    public static boolean cargarPlugins() {
        boolean cargados = true;
        try {
            //obtiene el listado de archivos .jar dentro del directorio
            File[] jars = buscarPlugins();

            if (jars.length > 0) {
                ClassPathModifier cp = new ClassPathModifier();

                //a cada jar lo incluye al classpath
                for (File jar : jars) {
                    try {
                        cp.addArchivo(jar);
                    } catch (MalformedURLException ex) {
                        System.err.println("URL incorrecta: " +
                                ex.getMessage());
                    }
                }
            }
        } catch (Exception ex) {
            cargados = false;
            System.err.println(ex.getMessage());
        }
        return cargados;
    }

    /**
     * Busca todos los jars de en el directorio de plugins
     *
     * @return jars del directorio de plugins
     */
    private static File[] buscarPlugins() {
        //crea lista vacia de archivos
        Vector<File> vUrls = new Vector<File>();
        //si existe el directorio "plugins" continua
        File directorioPlugins = new File(DIRECTORIO_PLUGINS);
        boolean dirPluginsExist = directorioPlugins.exists();
        boolean dirPluginsIsDirectory = directorioPlugins.isDirectory();
        if (dirPluginsExist && dirPluginsIsDirectory) {

            //obtiene todos los archivos con la extension .jar
            File[] jars = directorioPlugins.listFiles(new FilenameFilter() {

                @Override
                public boolean accept(File dir, String name) {
                    return name.endsWith(EXTENSION_JAR);
                }
            });

            //los agrega a la lista de archivos
            for (File jar : jars) {
                vUrls.add(jar);
            }
        }

        //retorna todos los archivos encontrados
        return vUrls.toArray(new File[0]);
    }

    /**
     * Obtiene todos los plugins IPluginMensaje encontrados en el classpath
     *
     * @return lista de plugins encontrados e instanciados
     */
    public static IMediaPlayerPlugin[] getPlugins() {
        //cargamos todas las implementaciones de IMediaPlayerPlugin
        //encontradas en el classpath
        ServiceLoader<IMediaPlayerPlugin> sl = ServiceLoader.load(IMediaPlayerPlugin.class);
        sl.reload();

        //crea una lista vacia de plugins IPluginMensaje
        Vector<IMediaPlayerPlugin> vAv = new Vector<IMediaPlayerPlugin>();

        //cada plugin encontrado es agregado a la lista
        for (Iterator<IMediaPlayerPlugin> it = sl.iterator(); it.hasNext(); ) {
            try {
                IMediaPlayerPlugin pl = it.next();
                vAv.add(pl);
            } catch (Exception ex) {
                System.err.println("Excepcion al obtener plugin: " +
                        ex.getMessage());
            }
        }

        //retorna los plugins encontrados y cargados
        return vAv.toArray(new IMediaPlayerPlugin[0]);
    }
}

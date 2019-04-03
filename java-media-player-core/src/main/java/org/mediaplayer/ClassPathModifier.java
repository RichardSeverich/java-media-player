package org.mediaplayer;

import java.io.File;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;

import org.apache.log4j.Logger;

/**
 * Class.
 */
public class ClassPathModifier {

    private static final String ADD_URL = "addURL";
    private static final Class[] PARAMETER_METHOD = new Class[]{URL.class};
    private Method methodAdd;
    private URLClassLoader loader;
    private static final Logger LOGGER = Logger.getLogger(ClassPathModifier.class);

    /**
     * ClassPathModifier.
     */
    public ClassPathModifier() {
        try {
            this.loader = (URLClassLoader) ClassLoader.getSystemClassLoader();
            this.methodAdd = URLClassLoader.class.getDeclaredMethod(ADD_URL, PARAMETER_METHOD);
        } catch (Exception ex) {
            String message = "Error ".concat(ex.getMessage());
            LOGGER.error(message);
        }
        this.methodAdd.setAccessible(true);
    }

    /**
     * @return URL.
     */
    public URL[] getURLs() {
        return loader.getURLs();
    }

    /**
     * @param url url.
     */
    public void addURL(URL url) {
        if (url != null) {
            try {
                methodAdd.invoke(loader, url);
            } catch (Exception ex) {
                String message = "Exception add URL: ".concat(ex.getLocalizedMessage());
                LOGGER.error(message);
            }
        }
    }

    /**
     * @param urls urls.
     */
    public void addURLs(URL[] urls) {
        if (urls != null) {
            for (URL url : urls) {
                addURL(url);
            }
        }
    }

    /**
     * @param file file.
     */
    public void addFile(final File file) {
        if (file != null) {
            try {
                addURL(file.toURI().toURL());
            } catch (MalformedURLException ex) {
                String message = "Add Exception: ".concat(ex.getMessage());
                LOGGER.error(message);
            }
        }

    }

    /**
     * @param filePath filePath.
     */
    public void addFile(String filePath) {
        addFile(new File(filePath));
    }
}

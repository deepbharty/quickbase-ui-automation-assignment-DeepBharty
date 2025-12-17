package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * ConfigReader loads values from config.properties and provides them through a static get() method.
 * It follows lazy loading: file is read only once when needed.
 */
public final class ConfigReader {

    private static Properties properties;

    // private constructor → prevents instantiation
    private ConfigReader(){}

    /**
     * Loads config.properties file only once.
     */
    private static void loadProperties() {
        if (properties == null) {
            properties = new Properties();
            try {
                FileInputStream fis = new FileInputStream(FrameworkConstants.CONFIG_PATH);
                properties.load(fis);
            } catch (IOException e) {
                throw new RuntimeException("❌ Failed to load config.properties file", e);
            }
        }
    }

    /**
     * Returns property value for a given key.
     */
    public static String get(String key) {
        loadProperties(); // ensures properties are loaded
        return properties.getProperty(key).trim();
    }
}

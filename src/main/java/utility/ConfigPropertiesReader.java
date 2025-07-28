package utility;

import org.apache.logging.log4j.Logger;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigPropertiesReader {

    private static Properties properties;
    private static final Logger log = LoggerHelper.getLogger(ConfigPropertiesReader.class);

    static
    {
        try
        {
            String configPath = "src/main/java/properties/config.properties";
            log.info("Loading configuration from: " + configPath);

            FileInputStream fis = new FileInputStream(configPath);
            properties = new Properties();
            properties.load(fis);
            log.info("Configuration loaded successfully.");
        }
        catch (IOException e)
        {
            log.error("Failed to load configuration file.", e);
        }
    }

    public static String getProperty(String key)
    {
        String value = properties.getProperty(key);
        if (value == null)
        {
            log.warn("Property for key '" + key + "' is not found in config file.");
        }
        else
        {
            log.debug("Property fetched: " + key + " = " + value);
        }
        return value;
    }
}

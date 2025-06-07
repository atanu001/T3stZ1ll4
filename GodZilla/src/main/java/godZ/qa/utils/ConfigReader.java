package godZ.qa.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    private static final Logger logger = LogManager.getLogger(ConfigReader.class);
    private static final Properties prop = new Properties();

    static {
        try {
            FileInputStream fis = new FileInputStream(Constants.CONFIG_PROPERTIES_PATH);
            prop.load(fis);
            logger.info("Config properties loaded successfully.");
        } catch (IOException e) {
            logger.error("Failed to load config.properties file!", e);
            throw new RuntimeException("Failed to load config.properties file!", e);
        }
    }

    public static String getProperty(String key) {
        return prop.getProperty(key);
    }
}

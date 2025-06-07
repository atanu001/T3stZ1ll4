package godZ.qa.utils;

public class ConfigHelper {
    public static boolean isHeadless() {
        return Boolean.parseBoolean(ConfigReader.getProperty("headless"));
    }
}

package godZ.qa.hooks;

import godZ.qa.driver.DriverManager;
import godZ.qa.enums.BrowserType;
import godZ.qa.utils.ConfigReader;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {
    @Before
    public void setup() {
        String browser = ConfigReader.getProperty("browser");
        DriverManager.initializeDriver(BrowserType.valueOf(browser.toUpperCase()));
    }

    @After
    public void tearDown() {
        DriverManager.quitDriver();
    }
}

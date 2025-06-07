package godZ.qa.driver;

import godZ.qa.enums.BrowserType;
import godZ.qa.utils.ConfigHelper;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class DriverManager {
    private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public static void initializeDriver(BrowserType browserType) {
        boolean isHeadless = ConfigHelper.isHeadless();
        switch (browserType) {
            case CHROME -> {
                WebDriverManager.chromedriver().setup();
                ChromeOptions options = new ChromeOptions();
                if(isHeadless) {
                    options.addArguments("--headless=new");
                    options.addArguments("--disable-gpu", "--window-size=1920,1080");
                }
                driver.set(new ChromeDriver(options));
            }
            case FIREFOX -> {
                WebDriverManager.firefoxdriver().setup();
                FirefoxOptions options = new FirefoxOptions();
                if(isHeadless) {
                    options.addArguments("--headless");
                }
                driver.set(new FirefoxDriver(options));
            }
            case EDGE -> {
                WebDriverManager.edgedriver().setup();
                EdgeOptions options = new EdgeOptions();
                if (isHeadless) {
                    options.addArguments("--headless");
                    options.addArguments("--disable-gpu", "--window-size=1920,1080");
                }
                driver.set(new EdgeDriver(options));
            }
            default -> throw new IllegalArgumentException("Unsupported Browser:" + browserType);
        }
        getDriver().manage().window().maximize();
    }

    public static WebDriver getDriver() {
        return driver.get();
    }

    public static void quitDriver() {
        if (driver.get() != null){
            driver.get().quit();
            driver.remove();
        }
    }
}

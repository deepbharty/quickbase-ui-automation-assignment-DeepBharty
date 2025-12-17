package factory;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.safari.SafariDriver;

public final class DriverFactory {

    // Singleton driver instance
    private static WebDriver driver;

    // Private constructor → prevents object creation
    private DriverFactory() {}

    /**
     * Creates Local WebDriver Instance
     */
    public static WebDriver initializeDriver(String browser) {

        if (driver == null) {
            switch (browser.toLowerCase()) {

                case "chrome" -> {
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                }

                case "edge" -> {
                    WebDriverManager.edgedriver().setup();
                    driver = new EdgeDriver();
                }

                case "safari" -> {
                    // Safari driver comes pre-installed in MacOS
                    driver = new SafariDriver();
                }

                default -> throw new IllegalArgumentException("❌ Browser Not Supported: " + browser);
            }

            driver.manage().window().maximize();
        }

        return driver;
    }

    /**
     * Returns the SAME WebDriver instance
     */
    public static WebDriver getDriver() {
        if (driver == null) {
            throw new IllegalStateException("❌ Driver is not initialized. Call initializeDriver() first.");
        }
        return driver;
    }

    /**
     * Quit browser and set driver to null
     */
    public static void quitDriver() {
        if (driver != null) {
           driver.quit();
           driver = null;
        }
    }
}

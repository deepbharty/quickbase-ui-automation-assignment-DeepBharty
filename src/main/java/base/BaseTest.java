package base;

import factory.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import utilities.ConfigReader;



public class BaseTest {

    protected WebDriver driver;

    @BeforeClass(alwaysRun = true)
    public void setup() {
        String browser = ConfigReader.get("browser");
        String url = ConfigReader.get("url");

        driver = DriverFactory.initializeDriver(browser);
        driver.get(url);

        System.out.println("🚀 Browser initialized: " + browser);
        System.out.println("🌍 Opening URL: " + url);
    }

    @AfterClass
    public void tearDown() {
        DriverFactory.quitDriver();
        System.out.println("🛑 Browser closed.");
    }
}

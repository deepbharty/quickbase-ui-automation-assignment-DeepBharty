package utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

/**
 * WaitUtils provides reusable explicit waits used across all pages.
 */
public final class WaitUtils {

    private WaitUtils() {
    }

    /**
     * Wait until element is visible on the page
     */
    public static WebElement waitForVisibility(WebDriver driver, By locator) {
        return new WebDriverWait(driver, Duration.ofSeconds(FrameworkConstants.EXPLICIT_WAIT))
                .until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    /**
     * Wait until element becomes clickable
     *
     * @return
     */
    public static WebElement waitForClickable(WebDriver driver, By locator) {
        return new WebDriverWait(driver, Duration.ofSeconds(FrameworkConstants.EXPLICIT_WAIT))
                .until(ExpectedConditions.elementToBeClickable(locator));

    }

    /**
     * Wait until element is present in DOM
     *
     * @return
     */
    public static WebElement waitForPresence(WebDriver driver, By locator) {
        return new WebDriverWait(driver, Duration.ofSeconds(FrameworkConstants.EXPLICIT_WAIT))
                .until(ExpectedConditions.presenceOfElementLocated(locator));

    }

    public static void waitForInVisibilityWithCustomTimeout(
            WebDriver driver,
            By locator,
            long timeoutInSeconds) {

        new WebDriverWait(driver, Duration.ofSeconds(FrameworkConstants.OTP_TIMEOUT))
                .until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }


}

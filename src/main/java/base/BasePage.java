package base;

import interfaces.IActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.WaitUtils;

import java.time.Duration;

public abstract class BasePage implements IActions {

    protected WebDriver driver;

    public BasePage(WebDriver driver){
        this.driver = driver;
    }

    @Override
    public void click(By locator){
        WebElement element = WaitUtils.waitForClickable(driver, locator);
        element.click();
    }

    @Override
    public void type(By locator, String text){
        WebElement element = WaitUtils.waitForVisibility(driver, locator);
        element.clear();
        element.sendKeys(text);
    }

    @Override
    public String getText(By locator){
        WebElement element = WaitUtils.waitForVisibility(driver, locator);
        return element.getText();
    }

    @Override
    public boolean isItemDisplayed(By locator){
        WebElement element = WaitUtils.waitForVisibility(driver, locator);
        return element.isDisplayed();
    }

}

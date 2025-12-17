package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class AppSettingsPage extends BasePage {

    public final By appSettingsLink = By.xpath("//div[contains(text(),'App settings')]");
    public final By appSettingsButton = By.xpath("//button[@title='App settings']/parent::div");
    public final By settingsTableOption = By.xpath(" (//a[contains(text(),'Tables')]/parent::div)[1]");


    //li[@id='linkListItem-settings']/a/div/div[3]/div/button


    public AppSettingsPage(WebDriver driver) {
        super(driver);
    }

    public void hoverOverAppSettings() {

        Actions action = new Actions(driver);

        WebElement element= driver.findElement(appSettingsLink);
        action.moveToElement(element).build().perform();

    }

    public String getMenuText(){

        return getText(appSettingsLink);

    }

    public void clickOnAppSettings(){

        click(appSettingsButton);
    }

    public String contextMenuFocusSettings(){

        return getText(settingsTableOption);
    }

    public void selectTableOption(){

        click(settingsTableOption);
    }

    public AddNewTablesPage navigateToTablesPage(){
        hoverOverAppSettings();
        clickOnAppSettings();
        selectTableOption();
        return new AddNewTablesPage(driver);

    }

}



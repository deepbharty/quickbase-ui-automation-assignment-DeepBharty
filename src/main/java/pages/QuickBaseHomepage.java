package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class QuickBaseHomepage extends BasePage {

    OTPVerificationPage otpverify;
    private final By homePageTitleText=By.xpath("//div[@class='remixNameIcon']/div/a");
    private final By menuButton=By.xpath("//button[@id='left-section-waffle-menu-button']");
    private final By craftDemo_DeepbhartyLink=By.xpath("//div[contains(text(),'Craft Demo - Deepbharty')]");


    public QuickBaseHomepage(WebDriver driver) {

        super(driver);
    }

    public boolean isHomePageDisplayed() {
        return isItemDisplayed(homePageTitleText);
    }

    public void getHomePageText()   {

        String text=getText(homePageTitleText);

        System.out.println(text);
    }

    public  void clickOnMenu(){

        click(menuButton);
    }

    public void clickOnCraftDemo(){
        click(craftDemo_DeepbhartyLink);
    }


    public  AppSettingsPage navigateToCraftDemo(){

        clickOnMenu();
        clickOnCraftDemo();
        return new AppSettingsPage(driver);
    }

}

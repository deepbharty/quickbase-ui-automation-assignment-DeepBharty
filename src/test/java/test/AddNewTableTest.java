package test;

import base.BaseTest;
import models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.*;
import utilities.ConfigReader;

public class AddNewTableTest extends BaseTest {

    private QuickbaseLoginPage login;
    private OTPVerificationPage otp;
    private QuickBaseHomepage userHome;
    private AppSettingsPage settings;
    private AddNewTablesPage tablePage;

    @BeforeClass

    public void AddTableSetups(){

        User user=new User(ConfigReader.get("username"),ConfigReader.get("password"));

        login =new QuickbaseLoginPage(driver);
        otp=login.login(user.getUsername(),user.getPassword());
        userHome=otp.completeOtpVerification();
        settings=userHome.navigateToCraftDemo();
       tablePage=settings.navigateToTablesPage();
    }

    @Test(priority = 0)

    public void clickOnAddNewButton(){

        tablePage.clickOnAddNewTableButton();
    }

    @Test(priority = 1)

    public void verifyFromScratchOption(){

        String actualText = tablePage.getAddTableOptionText();
        System.out.println("Actual text: " + actualText);
        String expectedText = "From scratch";
        Assert.assertEquals(actualText, expectedText, "❌ 'From scratch' option text does not match");

}

@Test(priority = 2)

    public void launchNewTableFormPage(){

        tablePage.clickOnAddNewTableButton();
}




}

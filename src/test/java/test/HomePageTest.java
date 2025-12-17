package test;

import base.BaseTest;
import models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.AppSettingsPage;
import pages.OTPVerificationPage;
import pages.QuickBaseHomepage;
import pages.QuickbaseLoginPage;
import utilities.ConfigReader;

import static org.bouncycastle.cms.RecipientId.password;

public class HomePageTest extends BaseTest {
    private QuickbaseLoginPage login;
    private OTPVerificationPage otp;
    private QuickBaseHomepage userHome;

    @BeforeClass
    public void homePageSetUp(){

        User user= new User(
                ConfigReader.get("username"),
                ConfigReader.get("password"));

       login=new QuickbaseLoginPage(driver);
       otp=login.login(user.getUsername(),user.getPassword());
       userHome=otp.completeOtpVerification();

    }

    @Test (priority = 0)

    public void verifyHomePageisDisplayed(){

        Assert.assertTrue(userHome.isHomePageDisplayed(),"❌ Quickbase Home Page is not displayed after OTP");

    }

    @Test (priority = 1)

    public void verifyDashboardTitle(){

        userHome.getHomePageText();
    }

    @Test (priority = 2)

    public void verifyMenuSelectionAndNavigationToCraftDemo(){

        userHome.clickOnMenu();
        userHome.clickOnCraftDemo();
    }
}

package test;

import base.BaseTest;
import models.User;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.AppSettingsPage;
import pages.AppSettingsPage;
import pages.OTPVerificationPage;
import pages.QuickBaseHomepage;
import pages.QuickbaseLoginPage;
import utilities.ConfigReader;

public class AppSettingsTest extends BaseTest {

    private QuickbaseLoginPage login;
    private OTPVerificationPage otp;
    private QuickBaseHomepage userHome;
    private AppSettingsPage settings;

    @BeforeClass
    public void AppSettingSetUp(){

        User user=new User(ConfigReader.get("username"),ConfigReader.get("password"));

          login =new QuickbaseLoginPage(driver);
        otp=login.login(user.getUsername(),user.getPassword());
        userHome=otp.completeOtpVerification();
        settings=userHome.navigateToCraftDemo();

        }

     @Test (priority =0)

    public void getAppMenuText(){

        String text=settings.getMenuText();

        System.out.println("Selected menu text is: "+text);
     }

    @Test (priority =1)
     public void mouseHoverAndClickOnAppSettingsMenu(){
        settings.hoverOverAppSettings();
        settings.clickOnAppSettings();
     }

    @Test (priority =2)
    public void getContextMenuText(){

        String text=settings.contextMenuFocusSettings();
        System.out.println("Context menu text is in focus :- "+text);
    }

    @Test (priority =3)
    public void verifyOpeningOfTableAfterSelection(){

     settings.selectTableOption();
    }

    }


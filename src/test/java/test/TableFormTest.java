package test;

import base.BaseTest;
import models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.*;
import utilities.ConfigReader;

public class TableFormTest extends BaseTest {


    private QuickbaseLoginPage login;
    private OTPVerificationPage otp;
    private QuickBaseHomepage userHome;
    private AppSettingsPage settings;
    private AddNewTablesPage tablePage;
    private TableFormPage form;

    @BeforeClass
    public void tableFormSetUp(){

        User user=new User(ConfigReader.get("username"),ConfigReader.get("password"));
        login =new QuickbaseLoginPage(driver);
        otp=login.login(user.getUsername(),user.getPassword());
        userHome=otp.completeOtpVerification();
        settings=userHome.navigateToCraftDemo();
        tablePage=settings.navigateToTablesPage();
        form= tablePage.navigateToTableForm();
    }

    @Test(priority=0)
    public void verifyTableHeaderText(){

        String text=form.getFormTitle();
        System.out.println("Table Header text is :- "+text);
    }

    @Test(priority=1)
    public void verifyTableValidationText(){

        String text=form.getTableValidationText();
        System.out.println("Validation text is :- "+text);
    }

    @Test(priority=2)
    public void verifyThatButtonIsEnabledOrNot(){

        boolean addButtonStatus=form.getCreateTableButtonState();
       Assert.assertTrue(addButtonStatus,"Add New Button is showing disabled when mandatory field left blank");
    }

    @Test(priority=3)
    public void addTableNameInfo(){

        form.enterTableName();
    }

    @Test(priority=4)
    public void addTableTagInfo(){

        form.enterTableTagName();
    }

    @Test(priority=5)
    public void addDescriptionInfo(){

        form.addYourDescription();
    }

    @Test(priority=6)
    public void clickOnCreateTableButton(){

        form.createNewButtonClick();
    }

}

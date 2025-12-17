package test;

import base.BaseTest;
import models.User;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.OTPVerificationPage;
import pages.QuickbaseLoginPage;
import utilities.ConfigReader;

public class LoginTest extends BaseTest {

    User user;
    OTPVerificationPage otpPage;

    @Test (priority = 0)
    public void launchTheLoginPage() {

        user = new User(ConfigReader.get("username"), ConfigReader.get("password"));
        QuickbaseLoginPage quickbaseLoginPage = new QuickbaseLoginPage(driver);

        System.out.println("🧪 Page title is: " + driver.getTitle());

        // Perform login (Username + Password)
        otpPage = quickbaseLoginPage.login(user.getUsername(), user.getPassword());

        // Validate OTP page is displayed
        Assert.assertTrue(otpPage.isOtpPageDisplayed(), "❌ OTP page was not displayed after login!");

        // Wait for manual OTP entry with timeout
        otpPage.completeOtpVerification();

        System.out.println("✅ Login flow completed successfully (OTP entered manually)");
    }
}

package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import utilities.FrameworkConstants;
import utilities.WaitUtils;



public class OTPVerificationPage extends BasePage {

    private final By otpInputField=By.xpath("//input[@id='TwoStepCode']");
    private final By signInButton=By.xpath("//button[@name='SignIn']");

    public OTPVerificationPage(WebDriver driver) {
        super(driver);
    }

    public boolean isOtpPageDisplayed() {
        return isItemDisplayed(otpInputField);
    }

    public void waitForManualOtpEntryWithTimeout() {

        System.out.println("⏳ Waiting for OTP entry (Max "
                + FrameworkConstants.OTP_TIMEOUT + " seconds)...");

        try {
            WaitUtils.waitForInVisibilityWithCustomTimeout(
                    driver,
                    otpInputField,
                    FrameworkConstants.OTP_TIMEOUT);

            System.out.println("✅ OTP entered successfully.");

        } catch (TimeoutException e) {
            throw new RuntimeException(
                    "❌ OTP was not entered within " + FrameworkConstants.OTP_TIMEOUT + " seconds. Login aborted.");
        }
    }

public void submitOtp() {
    click(signInButton);
}

/**
 * Complete OTP flow safely
 */
public QuickBaseHomepage completeOtpVerification() {
    waitForManualOtpEntryWithTimeout();
    //submitOtp();

   return  new QuickBaseHomepage(driver);
}
}



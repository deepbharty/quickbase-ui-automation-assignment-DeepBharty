package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilities.WaitUtils;

import static utilities.WaitUtils.waitForPresence;

public class QuickbaseLoginPage extends BasePage {

        private final By getSignInAlertText1=By.xpath("//div[@class='choiceBox']/div/p");
        private final By selectNoButton=By.xpath("//button[contains(text(),'No')]");
        private final By userNameField=By.name("loginid");

    private final By passwordField=By.name("password");
    private final By signInButton=By.name("SignIn");


        public QuickbaseLoginPage(WebDriver driver) {

                                   super(driver);
        }

   public  void getSignInText(){

           String text= getText(getSignInAlertText1);

           System.out.println(text);
   }


    public void NoButtonClick() {

            WaitUtils.waitForClickable(driver, selectNoButton);
        click(selectNoButton);
    }

        public void enterUserName(String username){
            type(userNameField,username);
        }



    public void enterPassword(String password){

        type(passwordField,password);
    }


    public void clickSignInButton(){

        click(signInButton);
    }

        public OTPVerificationPage login(String username, String password){
            NoButtonClick();
            enterUserName(username);
            enterPassword(password);
            clickSignInButton();

            return new OTPVerificationPage(driver);

        }
    }



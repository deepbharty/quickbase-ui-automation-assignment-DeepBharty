package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TableFormPage extends BasePage {
    private final String tableName="DemoTest Table";
    private final String tableTagName="#test";
    private final String description=" this table is created for testing purpose";

    private final By formTitle=By.xpath("//div[@id='newTableDialogTitle']");
    private final By validationText=By.xpath("//div[contains(text(),'Name your table for what it tracks')]");
    private final By tableNameFieldInputBox=By.xpath("//input[@aria-label='Table name']");
    private final By tableNameTagging=By.xpath("//input[@data-test-id='SingleRecordInput']");
    private final By descriptionTextBox=By.xpath("//textarea[@data-test-id='TableDescription']");
    private final By cancelButton=By.xpath("//button[@data-test-id='dialogCancelButton']");
    private final By createTableButton=By.xpath("//button[@data-test-id='dialogOkButton']");
    private final By closeTableFormButton=By.xpath("//button[@data-test-id='dialog-close-button']");

    public TableFormPage(WebDriver driver) {
        super(driver);
    }


    public String getFormTitle(){

        return getText(formTitle);
    }

    public String getTableValidationText(){

        return getText(validationText);
    }


    public boolean getCreateTableButtonState(){

        WebElement element=driver.findElement(createTableButton);
                element.isDisplayed();
        return element.isEnabled();
    }

    public void enterTableName(){

        type(tableNameFieldInputBox,tableName);
    }


    public void enterTableTagName(){

        type(tableNameTagging,tableTagName);
    }

    public void addYourDescription(){

        type(descriptionTextBox,description);
    }

    public void createNewButtonClick(){

        click(createTableButton);
    }

}

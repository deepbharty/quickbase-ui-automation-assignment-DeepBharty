package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddNewTablesPage extends BasePage {

    private final By addNewButton=By.xpath("//button[@id='newTableMenuButton']");
    private final By newTableFromScratch=By.xpath("//a[@id='btnNewTableAppTables']");

    public AddNewTablesPage(WebDriver driver) {
        super(driver);
    }


    public void clickOnAddNewTableButton(){

                           click(addNewButton);
        }


    public String getAddTableOptionText(){

       return getText(newTableFromScratch);
    }

    public void clickOnCreateFromScratch(){

               click(newTableFromScratch);
    }

    public TableFormPage navigateToTableForm(){
        clickOnAddNewTableButton();
        clickOnCreateFromScratch();
        return new TableFormPage(driver);
    }

    }


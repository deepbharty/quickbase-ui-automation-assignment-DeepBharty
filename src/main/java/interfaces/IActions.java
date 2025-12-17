package interfaces;

import org.openqa.selenium.By;

public interface IActions {


    void click(By locator);

    void type(By locator, String text);

    String getText(By locator);

    boolean isItemDisplayed(By locator);

}

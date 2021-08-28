package Utilities;

import SetupPack.Setup;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class GenericMethod extends Setup {

    public static void holdExecutionForSeconds(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
        public WebElement wait(WebElement element)
        {
            return wait.until(ExpectedConditions.visibilityOf(element));
        }

        public void click(WebElement element)
        {
            try {
                wait(element).click();
            }catch (StaleElementReferenceException e)
            {
                holdExecutionForSeconds(1);
                element.click();
            }
        }
        public void enterText(WebElement element,String Text)
        {
            try {
                wait(element).clear();
                wait(element).sendKeys(Text);
            }catch (StaleElementReferenceException e)
            {
                holdExecutionForSeconds(1);
                element.clear();
                element.sendKeys(Text);
            }
        }

        public void frameSwitchTo(int index)
        {
            driver.switchTo().frame(index);
        }
}

package Utilities;

import SetupPack.Setup;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class GenericMethod extends Setup {
        // Method for Hard wait
        public static void holdExecutionForSeconds(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        }
        //Method for wait till visibility of element
        public WebElement wait(WebElement element)
        {
            return wait.until(ExpectedConditions.visibilityOf(element));
        }
        //Method to click element
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
        //method to enter text
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
        //Method to Switch frame
        public void frameSwitchTo(int index)
        {
            holdExecutionForSeconds(2);
            driver.switchTo().frame(index);
        }
        //Method to find WebElement from list
        public WebElement listHolder(int index , String xpath) {

        List<WebElement> Options = driver.findElements(By.xpath(xpath));
        return Options.get(index);

        }
        //Method to find current Time
        public String currentTime()
        {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("M/dd/yyyy h:mm");
        LocalDateTime now = LocalDateTime.now();
        return dtf.format(now);
        }
}

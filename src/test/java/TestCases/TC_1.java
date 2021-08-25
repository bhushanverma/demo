package TestCases;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.sql.Driver;
import java.util.Set;

public class TC_1 {

    WebDriver driver;

    @BeforeClass
    public void tearUp(){
        driver = Setup.LaunchBrowser("chrome");
    }

    @BeforeMethod
    public void launchWebsite(){
        driver.get("https://the-internet.herokuapp.com/");
        Assert.assertTrue(Setup.isDisplayedElement("//h1[normalize-space()='Welcome to the-internet']"));
    }

    @Test(priority = 1)
    public void verifyClickOnAddButtonIsAddingNewButton(){
        driver.findElement(By.xpath("//a[text()='Add/Remove Elements']")).click();
        Assert.assertTrue(Setup.isDisplayedElement("//button[normalize-space()='Add Element']"));
        Setup.holdExecutionForSeconds(1);
        driver.findElement(By.xpath("//button[normalize-space()='Add Element']")).click();
        Setup.holdExecutionForSeconds(1);
        Assert.assertTrue(Setup.isDisplayedElement("//button[normalize-space()='Delete']"));
    }

    @Test(priority = 2)
    public void verifyClickOnDeleteButtonIsRemovingButton(){
        driver.findElement(By.xpath("//a[text()='Add/Remove Elements']")).click();
        Assert.assertTrue(Setup.isDisplayedElement("//button[normalize-space()='Add Element']"));
        Setup.holdExecutionForSeconds(1);
        driver.findElement(By.xpath("//button[normalize-space()='Add Element']")).click();
        Setup.holdExecutionForSeconds(1);
        driver.findElement(By.xpath("//button[normalize-space()='Delete']")).click();
        Setup.holdExecutionForSeconds(1);
        Assert.assertFalse(Setup.isDisplayedElement("//button[normalize-space()='Delete']"));
    }

    @Test(priority = 3)
    public void dragAndDropTest(){
        driver.get("https://www.globalsqa.com/demo-site/draganddrop/");
        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='demo-frame lazyloaded']")));
        WebElement source = driver.findElement(By.xpath("//img[@alt='On top of Kozi kopka']"));
        WebElement target = driver.findElement(By.xpath("//div[@id='trash']"));
        Actions builder = new Actions(driver);
        Setup.holdExecutionForSeconds(2);
        Action dragAndDrop = builder.clickAndHold(source).moveToElement(target).release(target).build();
        dragAndDrop.perform();
        Setup.holdExecutionForSeconds(2);
    }
    @Test (priority = 4)
    public void checkboxes()
    {
        driver.findElement(By.xpath("//a[text()='Checkboxes']")).click();

        Setup.holdExecutionForSeconds(1);
        Assert.assertTrue(Setup.isDisplayedElement("//h3"));
        driver.findElement(By.xpath("//input[1]")).click();
        Setup.holdExecutionForSeconds(1);
        Assert.assertTrue(Setup.isDisplayedElement("//input[@checked]"));
    }

    @Test (priority = 5)
    public void multipleWindow()
    {
        driver.findElement(By.xpath("//a[text()='Multiple Windows']")).click();
        Setup.holdExecutionForSeconds(1);
        Assert.assertTrue(Setup.isDisplayedElement("//h3"));
        String parentwindow = driver.getWindowHandle();
        Set<String> windows = driver.getWindowHandles();

        //for (String win : windows) {
        //    if ()


      //  }
    }
    @Test
    public void pageLoad()
    {
        driver.get("https://www.phptravels.net/home");
        Setup.holdExecutionForSeconds(1);
        Assert.assertTrue(Setup.isDisplayedElement("//img[contains(@alt,'PHPTRAVELS | Travel Technology Partner')]"));

    }
    @AfterClass
    public void tear(){
    driver.quit();
    }

}


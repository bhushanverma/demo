package TestCases;

import Page.HomePage;
import SetupPack.Setup;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MTestCase {
    public WebDriver driver;
    HomePage homePage;

    @BeforeClass
    public void tearUp() {
        driver = Setup.LaunchBrowser("chrome");
        homePage = new HomePage(driver);
    }

    @BeforeMethod
    public void launchWebsite(){
        driver.get(homePage.properties.getProperty("URL"));
        homePage.holdExecutionForSeconds(1);
        Assert.assertTrue(homePage.homepagelogodisplayed());
    }

    @Test
    public void Check()
    {
        System.out.println(homePage.properties.getProperty("URL"));
    }

    @BeforeMethod
    public void teardown()
    {
        driver.quit();
    }


}

package TestCases;

import Page.HomePage;
import Page.ShoppingCart;
import SetupPack.Setup;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MTestCase {
    public WebDriver driver;
    HomePage homePage;
    ShoppingCart shoppingCart;

    @BeforeClass
    public void tearUp() {
        driver = Setup.LaunchBrowser("chrome");
        homePage = new HomePage(driver);
        shoppingCart = new ShoppingCart(driver);
    }

    @BeforeMethod
    public void launchWebsite(){
        driver.get(homePage.properties.getProperty("URL"));
        homePage.holdExecutionForSeconds(1);
        Assert.assertTrue(homePage.homepagelogodisplayed());
    }

    @Test(priority = 1)
    public void TC_1()
    {
        homePage.clickonBUyNow();
        shoppingCart.checkoutlogovisible();
        shoppingCart.verifymidtransPresent();
        shoppingCart.verifyPillowPrice();

    }

    @Test(priority = 2)
    public void TC_2()
    {
        homePage.clickonBUyNow();
        shoppingCart.checkoutlogovisible();
    }

    @Test(priority = 3)
    public void TC_3()
    {
        homePage.clickonBUyNow();
        shoppingCart.checkoutlogovisible();
        shoppingCart.verifyNameEmailPhoneNoCityAddressPostalCode();

    }
    @Test(priority = 4)
    public void TC_4()
    {
        homePage.clickonBUyNow();
        shoppingCart.checkoutlogovisible();
        shoppingCart.editName();
        shoppingCart.editEmail();
        shoppingCart.editPhoneNo();
        shoppingCart.editCity();
        shoppingCart.editAddress();
        shoppingCart.editPostal();
    }


    @AfterClass
    public void teardown()
    {
        driver.quit();
    }


}

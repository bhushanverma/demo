package TestCases;

import Page.*;
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
    OrderSummary orderSummary;
    SelectPayment selectPayment;
    CreditDebitCard creditDebitCard;

    @BeforeClass
    public void tearUp() {
        driver = Setup.LaunchBrowser("chrome");
        homePage = new HomePage(driver);
        shoppingCart = new ShoppingCart(driver);
        orderSummary  = new OrderSummary(driver);
        selectPayment = new SelectPayment(driver);
        creditDebitCard = new CreditDebitCard(driver);
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
    @Test(priority = 5)
    public void TC_5()
    {
        TC_4();
        shoppingCart.clickOnCheckOutButton();
        Assert.assertTrue(orderSummary.verifyOrderSummaryLogoVisible());
    }

    @Test(priority = 6)
    public void TC_6()
    {
        TC_5();
        orderSummary.clickOnShippingDetails();
        Assert.assertTrue(orderSummary.verifyShippingDetailsName());
        Assert.assertTrue(orderSummary.verifyShippingDetailsPhoneNo());
        Assert.assertTrue(orderSummary.verifyShippingDetailsEmail());
        Assert.assertTrue(orderSummary.verifyShippingDetailsAddress());
    }
    @Test(priority = 7)
    public void TC_7()
    {
        TC_6();
        orderSummary.clickOnContinueButton();
        Assert.assertTrue(selectPayment.selectPaymentLogoVisible());
    }
    @Test(priority = 8)
    public void TC_8()
    {
        homePage.clickonBUyNow();
        shoppingCart.clickOnCheckOutButton();
        Assert.assertTrue(orderSummary.verifyOrderSummaryLogoVisible());
        orderSummary.clickOnContinueButton();
        Assert.assertTrue(selectPayment.selectPaymentLogoVisible());
        Assert.assertTrue(selectPayment.verifyPaymentList());

    }
    @Test(priority = 9)
    public void TC_9()
    {
      homePage.clickonBUyNow();
      shoppingCart.clickOnCheckOutButton();
      Assert.assertTrue(orderSummary.verifyOrderSummaryLogoVisible());
      orderSummary.clickOnContinueButton();
      Assert.assertTrue(selectPayment.selectPaymentLogoVisible());
      selectPayment.clickOnCreditDebitCardPromo();
      Assert.assertTrue(creditDebitCard.verifyCreditDebitCardLogoVisible());
    }
    @Test(priority = 10)
    public void check()
    {
        TC_9();
        Assert.assertTrue(creditDebitCard.verifyOnPotongan10Rupiah());
        Assert.assertTrue(creditDebitCard.verifyON10PercentDiscount());
        Assert.assertTrue(creditDebitCard.verifyDemoMasterCard());
    }

    @AfterClass
    public void teardown()
    {
        driver.quit();
    }

}





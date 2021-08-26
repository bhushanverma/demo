package Page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class ShoppingCart extends HomePage{
    public ShoppingCart(WebDriver driver1) {
        super(driver1);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//span[@data-reactid='.0.0.1.0.0.0']")
    WebElement CheckoutLogo;
    @FindBy(xpath = "//td[@data-reactid='.0.0.1.0.1.0.1.0:$1.0']")
    WebElement Midtrans;
    @FindBy(xpath = "//td[@data-reactid='.0.0.1.0.1.0.1.1.2']")
    WebElement PillowPrice;
    @FindBy(xpath = "//tbody[@data-reactid='.0.0.1.0.3.0.0']")
    WebElement Detailscontainer;
    @FindBy(xpath = "//input[@data-reactid='.0.0.1.0.3.0.0.0.1.0']")
    WebElement NameInput;
    @FindBy(xpath = "//input[@data-reactid='.0.0.1.0.3.0.0.1.1.0']")
    WebElement EmailInput;
    @FindBy(xpath = "//input[@data-reactid='.0.0.1.0.3.0.0.2.1.0']")
    WebElement PhoneInput;
    @FindBy(xpath = "//input[@data-reactid='.0.0.1.0.3.0.0.3.1.0']")
    WebElement CityInput;
    @FindBy(xpath = "//textarea[@data-reactid='.0.0.1.0.3.0.0.4.1.0']")
    WebElement AddressInput;
    @FindBy(xpath = "//input[@data-reactid='.0.0.1.0.3.0.0.5.1.0']")
    WebElement PostalCodeInput;

    public void checkoutlogovisible()
    {
        click(CheckoutLogo);
    }
    public void verifymidtransPresent(){wait(Midtrans).isDisplayed();}
    public void verifyPillowPrice()
    {
        String price = PillowPrice.getText();
        Assert.assertEquals(price,properties.getProperty("Cost"));
    }
    public void verifyNameEmailPhoneNoCityAddressPostalCode()
    {
        String details = wait(Detailscontainer).getText();
        Assert.assertEquals(details , properties.getProperty("CartCustomerDetails"));
    }
    public void editName()
    {
        wait(NameInput).clear();
        wait(NameInput).sendKeys(properties.getProperty("Name"));
    }
    public void editEmail()
    {
        wait(EmailInput).clear();
        wait(EmailInput).sendKeys(properties.getProperty("Email"));
    }
    public void editPhoneNo()
    {
        wait(PhoneInput).clear();
        wait(PhoneInput).sendKeys(properties.getProperty("Phone"));
    }
    public void editCity()
    {
        wait(CityInput).clear();
        wait(CityInput).sendKeys(properties.getProperty("City"));
    }
    public void editAddress()
    {
        wait(AddressInput).clear();
        wait(AddressInput).sendKeys(properties.getProperty("Address"));
    }
    public void editPostal()
    {
        wait(PhoneInput).clear();
        wait(PhoneInput).sendKeys("Phone");
    }

}

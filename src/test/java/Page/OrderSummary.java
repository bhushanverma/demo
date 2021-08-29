package Page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderSummary extends HomePage{
    public OrderSummary(WebDriver driver1) {
        super(driver1);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//p[@class='text-page-title-content']")
    private WebElement OrderSummmaryLogo;
    @FindBy(xpath = "//span[text()='order details']")
    private WebElement OrderDetails;
    @FindBy(xpath = "//span[text()='shipping details']")
     WebElement ShippingDetails;
    @FindBy(xpath = "//span[text()='Midtrans Pillow']")
     WebElement ItemsValue;
    @FindBy(xpath = "//td[@class='table-amount text-body']")
    WebElement AmountValue;
    @FindBy(xpath = "//div[@class='content-text-block']")
     WebElement ShippingDetailsContainer;
    @FindBy(xpath = "//div[text()='Bhushan Verma']")
    WebElement NameValue;
    @FindBy(xpath = "//div[text()='test@gmail.com']")
     WebElement EmailValue;
    @FindBy(xpath = "//div[text()='1111111111']")
     WebElement Phonevalue;
    @FindBy(xpath = "//div[text()='H No 180 Street no 5A Mowa Raipur 492002']")
     WebElement AddressValue;
    @FindBy(xpath = "//a[@class='button-main-content']")
     WebElement ContinueButton;

    public boolean verifyOrderSummaryLogoVisible()
    {
        //frameSwitchTo(0);
        boolean Flag =  wait(OrderSummmaryLogo).isDisplayed();
        return Flag;
    }
    public void clickOnOrderDetails(){click(OrderDetails);}
    public void clickOnShippingDetails(){click(ShippingDetails);holdExecutionForSeconds(2);}
    public boolean verifyAmountValueDetails()
    {
        boolean Flag = (AmountValue.getText()).contains(properties.getProperty("Cost"));
        return Flag;
    }
    public boolean verifyItemName()
    {
        boolean Flag = (ItemsValue.getText()).contains(properties.getProperty("PillowName"));
        return Flag;
    }
    public boolean verifyShippingDetailsName()
    {
      boolean Flag = (getShippingContainerDetails(1)).contains(properties.getProperty("Name"));
      return Flag;
    }
    public boolean verifyShippingDetailsEmail()
    {
        boolean Flag = (getShippingContainerDetails(5)).contains(properties.getProperty("Email"));
        return Flag;
    }
    public boolean verifyShippingDetailsAddress()
    {
        boolean Flag = (getShippingContainerDetails(7)).contains(properties.getProperty("Address")+" "+properties.getProperty("City")+" "+properties.getProperty("Postal"));
        return Flag;
    }
    public boolean verifyShippingDetailsPhoneNo()
    {
        boolean Flag = (getShippingContainerDetails(3)).contains(properties.getProperty("Phone"));
        return Flag;
    }
    public String getShippingContainerDetails(int value)
    {
        String s = ShippingDetailsContainer.getText();
        String[] s1 = s.split("\n");
        return s1[value];
    }
    public void clickOnContinueButton()
    {
        click(ContinueButton);
    }
}

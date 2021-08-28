package Page;

import org.apache.commons.exec.ExecuteWatchdog;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class CreditDebitCard extends BasePage{
    public CreditDebitCard(WebDriver driver1)
    {
        super(driver1);
        PageFactory.initElements(driver , this);
    }
    @FindBy(xpath = "//p[text()='Credit/Debit Card']")
    private WebElement CreditDebitCardLogo;
    @FindBy(xpath = "//input[@name='promo']")
    private WebElement DiscountOption;
    @FindBy(xpath = "//span[@class='text-amount-amount']")
    private WebElement AmountValue;
    private String CardDetailsListPath = "//input[@type='tel']";
    @FindBy(xpath = "//a[@class='button-main-content']")
    private WebElement PayNowButton;
    @FindBy(xpath = "//button[@class='btn btn-sm btn-success']")
    private WebElement OKButton;
    private String MerchantDetails = "//div[@class='col-xs-7']";


    public boolean verifyCreditDebitCardLogoVisible()
    {
        boolean Flag = CreditDebitCardLogo.isDisplayed();
        return Flag;
    }
    public WebElement getdiscountoption(int index)
    {
        List<WebElement> Options = DiscountOption.findElements(By.xpath("//input[@name='promo']"));
        return Options.get(index);
    }

    public boolean verifyON10PercentDiscount()
    {
        click(getdiscountoption(1));
        boolean Flag = (AmountValue.getText()).contains(properties.getProperty("10PercentDiscount"));
        return Flag;
    }
    public boolean verifyOnPotongan10Rupiah()
    {
        click(getdiscountoption(0));
        boolean Flag = (AmountValue.getText()).contains(properties.getProperty("Potongan10Rupiah"));
        return Flag;
    }
    public boolean verifyDemoMasterCard()
    {
        click(getdiscountoption(2));
        boolean Flag = (AmountValue.getText()).contains(properties.getProperty("DemoMasterCard"));
        return Flag;
    }
    public void enterCardNumber()
    {
        enterText(listHolder(0 , CardDetailsListPath) , (properties.getProperty("CardNUmber")));
    }
    public void enteExpiryDate()
    {
        enterText(listHolder(1 , CardDetailsListPath) , (properties.getProperty("CardExpiryDate")));
    }
    public void enterCVV()
    {
        enterText(listHolder(2 , CardDetailsListPath) , (properties.getProperty("CardCVV")));
    }
    public void clickOnPayNow()
    {
      click(PayNowButton);
      holdExecutionForSeconds(10);
        frameSwitchTo(0);
    }
    public boolean verifyMerchantName()
    {

        boolean Flag = (listHolder(0 , MerchantDetails).getText()).contains(properties.getProperty("MerchantName"));
        return Flag;

    }
    public boolean verifyAmount()
    {
       boolean Flag = (listHolder(1 , MerchantDetails)).getText().contains(properties.getProperty("TransactionAmount"));
       return Flag;
    }
    public boolean verifyTransactionTime()
    {
        String s = (listHolder(2 , MerchantDetails)).getText();
        String s2 = currentTime();
        String Time = s.substring(0,14);
        boolean Flag = (listHolder(2 ,MerchantDetails).getText().substring(0,14)).contains(currentTime());
        return Flag;
    }
    public boolean verifyCardNumber()
    {
        boolean Flag = (listHolder(3 , MerchantDetails)).getText().contains(properties.getProperty("TransactionCardNumber"));
        return Flag;
    }
}

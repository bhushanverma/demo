package Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class SelectPayment extends HomePage{
    public SelectPayment(WebDriver driver1)
    {
        super(driver1);
        PageFactory.initElements(driver , this);
    }
    @FindBy(xpath = "//p[@class='text-page-title-content']")
    private WebElement SelectPaymentLogo;
    @FindBy(xpath = "//div[@class='main-container']")
    private  WebElement PaymentList;
    @FindBy(xpath = "//span[text()='promo']")
    private WebElement ClickOnCreditDebitCardPromo;

    public boolean selectPaymentLogoVisible()
    {
        boolean Flag = wait(SelectPaymentLogo).isDisplayed();
        return Flag;
    }
    public boolean verifyPaymentList()
    {
            boolean Flag = PaymentList.getText().contains(properties.getProperty("PaymentListDetails"));
        System.out.println(properties.getProperty("PaymentListDetails"));
        System.out.println(PaymentList.getText());
            return Flag;
    }
    public void clickOnCreditDebitCardPromo()
    {
        click(ClickOnCreditDebitCardPromo);
    }
}

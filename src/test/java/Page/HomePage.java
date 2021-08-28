package Page;

import Utilities.GenericMethod;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Factory;

import java.io.FileInputStream;
import java.util.Properties;

public class HomePage extends BasePage {
    public HomePage(WebDriver driver1)
    {
        super(driver1);
        PageFactory.initElements(driver , this);
    }

    @FindBy(xpath = "//a[@data-reactid='.0.0.0.0.0.0.0']")
    WebElement HomeLogo;
    @FindBy(xpath = "//a[@data-reactid='.0.0.0.2.0.0.5']")
    WebElement BuyNowbutton;
    @FindBy(xpath = "//span[text()='Thank you for your purchase.']")
    private WebElement SuccessMessage;


    public boolean homepagelogodisplayed() {
        boolean Flag = HomeLogo.isDisplayed();
        return Flag;
    }

    public void clickonBUyNow()
    {
        click(BuyNowbutton);
        holdExecutionForSeconds(3);
    }
    public boolean successMessageVisible()
    {
       boolean Flag =  wait(SuccessMessage).isDisplayed();
       return Flag;
    }
}

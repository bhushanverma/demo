package Page;

import Utilities.GenericMethod;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Factory;

import java.io.FileInputStream;
import java.util.Properties;

public class HomePage extends GenericMethod {
    public WebDriver driver;
    public FileInputStream fis;
    public Properties properties;

    public HomePage(WebDriver driver1) {
        this.driver = driver1;
        PageFactory.initElements(driver, this);
        properties = new Properties();
        try {
            fis = new FileInputStream("resources/Config.Properties");
            properties.load(fis);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FindBy(xpath = "//a[@data-reactid='.0.0.0.0.0.0.0']")
    WebElement HomeLogo;


    public boolean homepagelogodisplayed() {
        boolean Flag = HomeLogo.isDisplayed();
        return Flag;
    }

}

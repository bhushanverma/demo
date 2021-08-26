package Page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class ShoppingCart extends HomePage{
    public ShoppingCart(WebDriver driver1) {
        super(driver1);
        PageFactory.initElements(driver, this);
    }
}

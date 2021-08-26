package Page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class SelectPayment extends HomePage{
    public SelectPayment(WebDriver driver1)
    {
        super(driver1);
        PageFactory.initElements(driver , this);
    }
}

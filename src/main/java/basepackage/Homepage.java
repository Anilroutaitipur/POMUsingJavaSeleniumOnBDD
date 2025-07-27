package basepackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Homepage extends BaseClass {

    WebDriver driver = BaseClass.getDriver();

    @FindBy(xpath = "//a[@class='shopping_cart_link']")
    WebElement shoppingcartlink;

    public Homepage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public boolean verifyShoppingCartLink()
    {
        return shoppingcartlink.isDisplayed();
    }

}

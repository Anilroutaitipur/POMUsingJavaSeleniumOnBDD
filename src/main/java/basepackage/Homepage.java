package basepackage;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utility.LoggerHelper;

public class Homepage extends BaseClass {

    private static final Logger log = LoggerHelper.getLogger(Homepage.class);

    WebDriver driver = BaseClass.getDriver();

    @FindBy(xpath = "//a[@class='shopping_cart_link']")
    WebElement shoppingcartlink;

    public Homepage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver,this);
        log.info("Homepage initialized for driver thread: " + Thread.currentThread().getId());
    }

    public boolean verifyShoppingCartLink() {
        try {
            boolean isDisplayed = shoppingcartlink.isDisplayed();
            log.info("Shopping cart link displayed: " + isDisplayed);
            return isDisplayed;
        } catch (Exception e) {
            log.error("Shopping cart link not found", e);
            return false;
        }
    }
}

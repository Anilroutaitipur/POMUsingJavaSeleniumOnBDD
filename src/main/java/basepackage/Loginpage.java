package basepackage;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utility.LoggerHelper;

public class Loginpage extends BaseClass {

    WebDriver driver = BaseClass.getDriver();
    Logger log = LoggerHelper.getLogger(Loginpage.class);

    @FindBy(id = "user-name")
    WebElement username;

    @FindBy(id = "password")
    WebElement password;

    @FindBy(id = "login-button")
    WebElement loginbutton;

    public Loginpage(WebDriver driver)
    {
        this.driver=driver;
        PageFactory.initElements(driver,this);
        log.info("Loginpage initialized");
    }

    public void enterUsername(String uname)
    {
        log.info("Entering username: " + uname);
        username.sendKeys(uname);
    }

    public void enterPassword(String pwd)
    {
        log.info("Entering password");
        password.sendKeys(pwd);
    }

    public void clickLogin()
    {
        log.info("Clicking on login button");
        loginbutton.click();
    }
}

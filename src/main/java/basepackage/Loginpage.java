package basepackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class Loginpage extends BaseClass {

    WebDriver driver = BaseClass.getDriver();

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
    }

    public void enterUsername(String uname)
    {
        username.sendKeys(uname);
    }

    public void enterPassword(String pwd)
    {
        password.sendKeys(pwd);
    }

    public void clickLogin()
    {
        loginbutton.click();
    }

}

package stepdefinitions;

import basepackage.BaseClass;
import basepackage.Homepage;
import basepackage.Loginpage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import utility.ConfigPropertiesReader;
import utility.WaitClass;

import java.time.Duration;

import static org.junit.Assert.assertTrue;

public class Login {

    public static WebDriver driver = new FirefoxDriver();
    Loginpage loginpage = new Loginpage(driver);
    Homepage homepage = new Homepage(driver);
    WaitClass wait = new WaitClass(driver);

    String url = ConfigPropertiesReader.getProperty("envurl");
    String username = ConfigPropertiesReader.getProperty("username");
    String password = ConfigPropertiesReader.getProperty("password");

    @Given("User navigate to login page")
    public void User_navigate_to_login_page() {

        BaseClass.setDriver(driver);
        driver.manage().window().maximize();
        driver.get(url);
    }

    @When("^User enter username and password$")
    public void User_enter_user_name_and_password() {

        loginpage.enterUsername(username);
        loginpage.enterPassword(password);
    }

    @And("^User click on login button$")
    public void user_click_on_login_button()
    {
        loginpage.clickLogin();
    }
    @Then("^User should navigate to Home page$")
    public void user_should_navigate_to_home_page()
    {
        wait.implicitWait();
        assertTrue(homepage.verifyShoppingCartLink());
    }

}

package utility;

import basepackage.BaseClass;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class WaitClass {

    WebDriver driver = BaseClass.getDriver();

    public WaitClass(WebDriver driver)
    {
        this.driver=driver;
    }

    public void implicitWait()
    {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
}

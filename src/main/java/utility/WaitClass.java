package utility;

import basepackage.BaseClass;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class WaitClass {

    WebDriver driver = BaseClass.getDriver();
    Logger log = LoggerHelper.getLogger(WaitClass.class);

    public WaitClass(WebDriver driver)
    {
        this.driver=driver;
        log.info("WaitClass initialized for driver: " + driver);
    }

    public void implicitWait()
    {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        log.info("Implicit wait applied: 10 seconds");
    }
}

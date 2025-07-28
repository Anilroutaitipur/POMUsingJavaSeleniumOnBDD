package basepackage;


import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import utility.LoggerHelper;

public class BaseClass {

    private static final Logger log = LoggerHelper.getLogger(BaseClass.class);
    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public static WebDriver getDriver()
    {
        log.debug("Getting WebDriver instance");
        return driver.get();
    }

    public static void setDriver(WebDriver driverInstance)
    {
        driver.set(driverInstance);
        log.info("WebDriver instance set for thread: " + Thread.currentThread().getId());
    }

    public static void quitDriver()
    {
        if(driver.get()!=null)
        {
            log.info("Quitting WebDriver for thread: " + Thread.currentThread().getId());
            driver.get().quit();
            driver.remove();
            log.debug("WebDriver removed from ThreadLocal");
        }
        else {
            log.warn("Tried to quit WebDriver, but it was null for thread: " + Thread.currentThread().getId());
        }
    }
}

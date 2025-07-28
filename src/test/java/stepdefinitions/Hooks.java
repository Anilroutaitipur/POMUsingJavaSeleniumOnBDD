package stepdefinitions;

import basepackage.BaseClass;
import basepackage.Loginpage;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import utility.ConfigPropertiesReader;
import utility.ExtentReportManager;
import utility.LoggerHelper;
import utility.ScreenshotUtil;

public class Hooks {

    WebDriver driver;
    private static ExtentReports extent = ExtentReportManager.getInstance();

    // Declare ThreadLocal for parallel test execution
    public static ThreadLocal<ExtentTest> scenarioTest = new ThreadLocal<>();

    Logger log = LoggerHelper.getLogger(Loginpage.class);

    @Before
    public void setup(Scenario scenario) {
        log.info("***** Starting Scenario: " + scenario.getName() + " *****");
        // Set browser
        String browser = ConfigPropertiesReader.getProperty("browser");
        log.info("Launching browser: " + browser);

        if (browser.equalsIgnoreCase("chrome")) {
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("firefox")) {
            driver = new FirefoxDriver();
        } else if (browser.equalsIgnoreCase("edge")) {
            driver = new EdgeDriver();
        } else {
            throw new RuntimeException("Browser not supported: " + browser);
        }

        BaseClass.setDriver(driver);

        // Create a new ExtentTest for this scenario
        ExtentTest test = extent.createTest(scenario.getName());
        scenarioTest.set(test);
    }

    @After
    public void afterScenario(Scenario scenario) {
        if (scenario.isFailed()) {
            log.warn("Scenario Failed: " + scenario.getName());
            scenarioTest.get().log(Status.FAIL, "Scenario failed");
            ScreenshotUtil.takeScreenshot(BaseClass.getDriver(), scenario.getName());
        } else {
            log.info("Scenario Passed: " + scenario.getName());
            scenarioTest.get().log(Status.PASS, "Scenario passed");
        }

        log.info("Closing browser and quitting WebDriver");
        extent.flush();
        BaseClass.quitDriver();
    }
}

package stepdefinitions;

import basepackage.BaseClass;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utility.ExtentReportManager;
import utility.ScreenshotUtil;

public class Hooks {
    public static ExtentReports extent;
    public static ExtentTest scenarioTest;

    @Before
    public void beforeScenario(Scenario scenario) {
        extent = ExtentReportManager.getInstance();
        scenarioTest = extent.createTest(scenario.getName());
    }

    @After
    public void afterScenario(Scenario scenario) throws InterruptedException {

        if (scenario.isFailed()) {
            scenarioTest.log(Status.FAIL, "Scenario failed");
            ScreenshotUtil.takeScreenshot(BaseClass.getDriver(),scenario.getName());
        } else {
            scenarioTest.log(Status.PASS, "Scenario passed");
        }
        extent.flush();
        Thread.sleep(10000);
        BaseClass.quitDriver();
    }
}

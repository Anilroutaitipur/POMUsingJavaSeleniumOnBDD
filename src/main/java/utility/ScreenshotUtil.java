package utility;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ScreenshotUtil
{
    private static final Logger log = LoggerHelper.getLogger(ScreenshotUtil.class);

    public static void takeScreenshot(WebDriver driver, String scenarioName) {
        TakesScreenshot ts = (TakesScreenshot)driver;
        File srcFile = ts.getScreenshotAs(OutputType.FILE);

        String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String screenshotName = "screenshots/" + scenarioName.replaceAll(" ","_")+"_"+timestamp+".png";

        try
        {
            FileUtils.copyFile(srcFile,new File(screenshotName));
            System.out.println("Screenshot saved to: "+screenshotName);
            log.info("Screenshot saved to: " + screenshotName);
        }
        catch (IOException e)
        {
            log.error("Failed to save screenshot: " + e.getMessage(), e);
        }
    }
}


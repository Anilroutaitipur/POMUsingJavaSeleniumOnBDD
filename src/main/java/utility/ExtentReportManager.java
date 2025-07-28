package utility;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.apache.logging.log4j.Logger;

public class ExtentReportManager
{
    private static ExtentReports extent;
    private static final Logger log = LoggerHelper.getLogger(ExtentReportManager.class);

    public static ExtentReports getInstance()
    {
        if (extent == null)
        {
            String path = System.getProperty("user.dir") + "/test-output/ExtentReport.html";
            log.info("Creating Extent Report at: " + path);
            ExtentSparkReporter spark = new ExtentSparkReporter(path);
            extent = new ExtentReports();
            extent.attachReporter(spark);
            log.info("Extent Report initialized successfully.");
        }
        return extent;
    }
}

package extent_report;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.io.File;

public class ExtentReport {
    public static ExtentReports extent;
    public static ExtentReports extentReportGenerator()
    {
        String path= System.getProperty("user.dir") + File.separator + "target" + File.separator + "ExtentReport" + File.separator + "report-" + System.currentTimeMillis() + ".html";
        ExtentSparkReporter reporter = new ExtentSparkReporter(path);
        reporter.config().setReportName("MOBILE TEST");
        extent= new ExtentReports();
        extent.attachReporter(reporter);
        extent.setSystemInfo("","");
        return extent;
    }
}

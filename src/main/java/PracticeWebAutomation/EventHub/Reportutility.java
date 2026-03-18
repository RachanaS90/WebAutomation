package PracticeWebAutomation.EventHub;

import java.io.File;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Reportutility {

	public static ExtentReports extentReports()
	{
		File file = new File(System.getProperty("user.dir")+"\\ExtentReports\\Index.html");
		ExtentSparkReporter extentsparkreporter = new ExtentSparkReporter(file);
		
		extentsparkreporter.config().setDocumentTitle("Event Booking Workflow Report");
		extentsparkreporter.config().setTheme(Theme.STANDARD);
		extentsparkreporter.config().setReportName("EndtoEnd flow");
		
		ExtentReports extentreports = new ExtentReports();
		extentreports.attachReporter(extentsparkreporter);
		
		return extentreports;
	}
}

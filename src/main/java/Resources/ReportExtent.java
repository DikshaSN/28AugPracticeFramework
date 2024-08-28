package Resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ReportExtent {
	
	public static ExtentReports getReportObject() {
		String file = "D:\\Selenium\\Scripts\\16AugFramework\\Reports\\index.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(file);
		 reporter.config().setReportName("Diksha kamdi Test Report");
		 ExtentReports extent = new ExtentReports();
		 extent.attachReporter(reporter);
		 extent.setSystemInfo("Testing Report", "Diksha Kamdi");
		 return extent;
		 
	}

}

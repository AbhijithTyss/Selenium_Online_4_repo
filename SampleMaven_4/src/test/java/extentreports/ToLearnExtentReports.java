package extentreports;

import java.time.LocalDateTime;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ToLearnExtentReports {
	@Test
	public void createReport() {
		String timestamp = LocalDateTime.now().toString().replace(":", "-");
		// step 1: create an instance of ExtentSparkReporter
		ExtentSparkReporter spark=new ExtentSparkReporter("./HTML_reports/"+timestamp+"extentReport.html");
		
		// step 2: create an instance of ExtentReports
		ExtentReports extReport=new ExtentReports();
		
		// step 3: attach ExtentSparkReporter to ExtentReports
		extReport.attachReporter(spark);
		
		// step 4: create an instance of ExtentTest 
		ExtentTest test = extReport.createTest("createReport");
		
		// step 5: call log() to provide status and message
		test.log(Status.INFO, "log message added into report");
		
		// step 6: call flush()
		extReport.flush();
	}
}

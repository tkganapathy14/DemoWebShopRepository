package genericUtilities;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import freemarker.log.Logger;

public class ItestListener extends BaseClass implements ITestListener {

	ExtentReports reports;
	
	public void onStart(ITestContext context) {
		ExtentSparkReporter reporter=new ExtentSparkReporter("./Report/demo1.html");
		reporter.config().setTheme(Theme.STANDARD);
		reporter.config().setDocumentTitle("sample report");
		reporter.config().setReportName("Ganapathy");
		reports=new ExtentReports();
		reports.attachReporter(reporter);

	}

	public void onTestStart(ITestResult result) {
		logger = reports.createTest(result.getName());
	}

	public void onTestSuccess(ITestResult result) {
		logger.log(Status.PASS,"the Test"+result.getName()+" is passed");
	}

	public void onTestFailure(ITestResult result) {
		logger.log(Status.FAIL,"the Test"+result.getName()+" is failed");
		logger.addScreenCaptureFromPath(screenshot.capturescreenshot(result.getName()));
	}
	public void onFinish(ITestContext context) {
		reports.flush();

	}
}

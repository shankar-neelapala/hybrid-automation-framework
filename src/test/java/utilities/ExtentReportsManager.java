package utilities;

import java.awt.Desktop;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import testbase.BaseClass;

public class ExtentReportsManager implements ITestListener{

	public ExtentSparkReporter spark;
	public ExtentReports report;
	public ExtentTest test;
	public String reportName;
	
	@Override
	public void onStart(ITestContext context) {
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		reportName = System.getProperty("user.dir")+"\\reports\\"+"Test-Report-" + timeStamp + ".html";

		spark = new ExtentSparkReporter(reportName);
		
		spark.config().setDocumentTitle("Opencart Automation Testing");
		spark.config().setReportName("Opencart Functional Testing");
		spark.config().setTheme(Theme.STANDARD);
		
		report = new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("Application", "Opencart");
		report.setSystemInfo("Module", "Customers");
		report.setSystemInfo("Environment", "QA");
		report.setSystemInfo("User Name", System.getProperty("user.name"));
		report.setSystemInfo("OS", context.getCurrentXmlTest().getParameter("os"));
		report.setSystemInfo("Browser", context.getCurrentXmlTest().getParameter("browser"));
		
		List<String> includedGroups = context.getCurrentXmlTest().getIncludedGroups();
		if(!includedGroups.isEmpty()) {
			report.setSystemInfo("Groups", includedGroups.toString());
		}
	}
	
	@Override
	public void onTestSuccess(ITestResult result) {
		test = report.createTest(result.getTestClass().getName());
		test.assignCategory(result.getMethod().getGroups());
		test.log(Status.PASS, result.getName()+" got successfully passed");
	}
	
	@Override
	public void onTestFailure(ITestResult result) {
		test = report.createTest(result.getTestClass().getName());
		test.assignCategory(result.getMethod().getGroups());
		test.log(Status.FAIL, result.getName()+" got failed");
		test.info(result.getThrowable().getMessage());
		
		try {
			String imagePath = BaseClass.captureScreenshot(result.getName());
			test.addScreenCaptureFromPath(imagePath);
		} 
		catch (Exception e) {
			e.printStackTrace();
		}		
	}
	
	@Override
	public void onTestSkipped(ITestResult result) {
		test = report.createTest(result.getTestClass().getName());
		test.assignCategory(result.getMethod().getGroups());
		test.log(Status.SKIP, result.getName()+" got skipped");
		test.info(result.getThrowable().getMessage());
	}
	
	@Override
	public void onFinish(ITestContext context) {
		report.flush();
		
		//String extentReportPath = System.getProperty("user.dir")+"\\reports\\"+reportName;
		File file = new File(reportName);
		try {
			Desktop.getDesktop().browse(file.toURI());
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}

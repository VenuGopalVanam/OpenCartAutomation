package utilities;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
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

public class ExtentReportUtility implements ITestListener {
public ExtentSparkReporter extentSparkReporter;
public ExtentReports extentReports;
public ExtentTest extentTest;

String reportName;

public void onStart(ITestContext testcontent) {
    String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
    reportName = "Test-Report-"+timeStamp+".html";
    extentSparkReporter = new ExtentSparkReporter(".\\reports\\"+reportName);
    extentSparkReporter.config().setDocumentTitle("OPENCART AUTOMATION REPORT");
    extentSparkReporter.config().setReportName("OPENCART FUNCTIONAL TESTING");
    extentSparkReporter.config().setTheme(Theme.DARK);
    
    extentReports = new ExtentReports();
    extentReports.attachReporter(extentSparkReporter);
    extentReports.setSystemInfo("Application", "Opencart");
    extentReports.setSystemInfo("Module", "Admin");
	extentReports.setSystemInfo("Sub Module", "Customers");
	extentReports.setSystemInfo("User Name", System.getProperty("user.name"));
	extentReports.setSystemInfo("Environemnt", "QA");
	
	String os = testcontent.getCurrentXmlTest().getParameter("os");
	extentReports.setSystemInfo("Operating system", os);
	String browser = testcontent.getCurrentXmlTest().getParameter("browser");
	extentReports.setSystemInfo("BrowserName ", browser);
	
	List<String> includedGroups = testcontent.getCurrentXmlTest().getIncludedGroups();
	if(!includedGroups.isEmpty()) {
		extentReports.setSystemInfo("Groups", includedGroups.toString());
	}
  }


public void onTestSuccess(ITestResult result) {
	extentTest = extentReports.createTest(result.getTestClass().getName());
	extentTest.assignCategory(result.getMethod().getGroups());
	extentTest.log(Status.PASS, result.getName()+"got sucessfullyExcuted");
   
  }

public void onTestFailure(ITestResult result) {
    extentTest = extentReports.createTest(result.getTestClass().getName());
    extentTest.assignCategory(result.getMethod().getGroups());
    extentTest.log(Status.FAIL, result.getName()+"got failed");
    extentTest.log(Status.INFO, result.getThrowable().getMessage());
    
    try {
    	String imgpath = new BaseClass().captureScreen(result.getName());
    	extentTest.addScreenCaptureFromPath(imgpath);
    }catch(IOException e) {
    	e.printStackTrace();
    }
  }

 
 public void onTestSkipped(ITestResult result) {
	    extentTest = extentReports.createTest(result.getTestClass().getName());
		extentTest.assignCategory(result.getMethod().getGroups());
		extentTest.log(Status.SKIP, result.getName()+" got skipped");
		extentTest.log(Status.INFO, result.getThrowable().getMessage());
  }



	public void onFinish(ITestContext testContext) {
		
		extentReports.flush();
		
		String pathOfExtentReport = System.getProperty("user.dir")+"\\reports\\"+reportName;
		File extentReport = new File(pathOfExtentReport);
		
		try {
			Desktop.getDesktop().browse(extentReport.toURI());
		} catch (IOException e) {
			e.printStackTrace();
		}


}
}
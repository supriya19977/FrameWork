package api.utilities;


import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import org.testng.ITestListener;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.google.common.io.Files;

public class ExtentreportManager  //implements ITestListener
{

//	public ExtentSparkReporter sparkReporter;
//	public ExtentReports extent;
//	public ExtentTest test;
//	
//	String repName;
//	
//	public void onstart(ITestContext testContext) {
//		
//		String timestamp=new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());//time stamp
//		
//		repName="Test-Reports-"+timestamp+".html";
//		sparkReporter=new ExtentSparkReporter(".\\reports\\"+repName);//Specify the location of reports
//		//ExtentTest test = sparkReporter.start("TestName");
//		
//		sparkReporter.config().setDocumentTitle("RestAssuredAutomationProject");//Title of report
//		sparkReporter.config().setReportName("pet store user api");// name of the report
//		sparkReporter.config().setTheme(Theme.DARK);
//		
//		/*
//		 * extent=new ExtentReports();
//		 * 
//		 * sparkReporter = new ExtentSparkReporter(
//		 * "C:\\Users\\sp21036\\eclipse-workspace\\restassured\\FrameWork\\target\\report.html"
//		 * );
//		 */
//		extent.setSystemInfo("Application", "pet store user api");
//		extent.setSystemInfo("Operating System",System.getProperty("Os.name"));
//		extent.setSystemInfo("User Name", System.getProperty("user.name"));
//		extent.setSystemInfo("Environment", "QA");
//		extent.setSystemInfo("user", "supriya");
//	}
//	@BeforeClass
//	public void Reports() {
//         extent=new ExtentReports();
//		
//		sparkReporter = new ExtentSparkReporter("C:\\Users\\sp21036\\eclipse-workspace\\restassured\\FrameWork\\Reportsssssssss\\report.html");
//		
//	}
//
//	
//	public void OnTestSuccess(ITestResult result) {
//		test=extent.createTest(result.getName());
//		test.assignCategory(result.getMethod().getGroups());
//		test.createNode(result.getName());
//		test.log(Status.PASS, "Test Passed");
//	}
//	
//	public void OnTestFailure(ITestResult result) {
//		test=extent.createTest(result.getName());
//		test.createNode(result.getName());
//		test.assignCategory(result.getMethod().getGroups());
//		test.log(Status.FAIL, "Test Failed");
//		test.log(Status.FAIL, result.getThrowable().getMessage());
//		
//	}
//	public void OnTestSkipped(ITestResult result) {
//		test=extent.createTest(result.getName());
//		test.createNode(result.getName());
//		test.assignCategory(result.getMethod().getGroups());
//		test.log(Status.SKIP, "test Skipped");
//		test.log(Status.SKIP, result.getThrowable().getMessage());
//	}
//	
//	@AfterClass
//	public void onFinish_(ITestContext testContext) {
//		extent.attachReporter(sparkReporter);
//		
//		extent.flush();
//		
//	}
//	
	
	public ExtentReports ext;
	public ExtentSparkReporter spark;
	public ExtentTest test;
	
	@Test
	public void Arun() {
		ext = new ExtentReports();
		spark = new ExtentSparkReporter("Report.html");
		ext.attachReporter(spark);
		ext.createTest("wishlist").log(Status.PASS, "Wishlist").info("Added to wishlist");
		ext.flush();
	}

//	public String Screenshotmethod(String Path, String filename,WebDriver driver) throws IOException {
//		TakesScreenshot ts = (TakesScreenshot) driver;
//		File loc = ts.getScreenshotAs(OutputType.FILE);
//		File file = new File(Path + "//" + filename + System.currentTimeMillis()+".png");
//		Files.copy(loc, file);
//		return file.getAbsolutePath();
//	}
	
	

}


	
	


package Practice;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ExtentReport
{
	static   WebDriver driver;
   public static void main(String[] args) throws Throwable 
   {
	   ExtentReports extentReport=new ExtentReports();
		ExtentSparkReporter sparkReporter=new ExtentSparkReporter("report.html");
		extentReport.attachReporter(sparkReporter);
	
		sparkReporter.config().setDocumentTitle("Shivani ahirwar");
		sparkReporter.config().setTheme(Theme.DARK);
		
		 String path= screnShot("screenShot1.png");
		  String path2=base64();
		 
		Throwable t= new RuntimeException("This is failed test");
		ExtentTest extentTest = extentReport.createTest("VtigerLaunchTest");
		extentTest.pass(t).addScreenCaptureFromBase64String(path2, "Vtiger Login Page");
		
		extentReport.createTest("CampaginTest").info("This is info msg")
		.addScreenCaptureFromPath(path);
		
		extentReport.createTest("ProductTest").info("This is info msg")
		.addScreenCaptureFromPath(path)
		.fail(MediaEntityBuilder.createScreenCaptureFromBase64String(path2).build());
		
		extentReport.flush();
		Desktop.getDesktop().browse(new File("report.html").toURI());	
   }
   public static String screnShot(String fileName)
   {   
	   TakesScreenshot ts=(TakesScreenshot) driver;
		File Ram = ts.getScreenshotAs(OutputType.FILE);
		 File dest = new File("./photo/"+fileName);
		 try
		 {
		 FileUtils.copyFile(Ram, dest);
		 }
		 catch(IOException e)
		 {
			e.printStackTrace(); 
		 }
     return dest.getAbsolutePath();
   }
   public static String base64()
   {   
	   TakesScreenshot ts=(TakesScreenshot) driver;
		String Ram = ts.getScreenshotAs(OutputType.BASE64);
		System.out.println();
		 
     return Ram;
   }
   
}

package comcast.vtiger.genericUtility;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenerImplimentationClass implements ITestListener
{

	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub

	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub

	}

	public void onTestFailure(ITestResult result)
	{
	    String testname = result.getMethod().getMethodName();

	    EventFiringWebDriver edriver=new EventFiringWebDriver(BaseClass.sDriver);
	    File srcFile = edriver.getScreenshotAs(OutputType.FILE);

	    	File destFile = new File("./SDET/Screenshots"+testname+".png");
	    	try
	    	{
				FileUtils.copyFile(srcFile, destFile);
			}
	    	catch (IOException e)
	    	{
				e.printStackTrace();
			}
	    	
	}

	public void onTestSkipped(ITestResult result) {

	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub

	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub

	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub

	}

}

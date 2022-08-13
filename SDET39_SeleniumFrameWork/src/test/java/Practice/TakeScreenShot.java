package Practice;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import comcast.vtiger.genericUtility.File_Utility;
import comcast.vtiger.genericUtility.WebDriver_Utility;
import comcast.vtiger.objectRepository.LoginPage;

public class TakeScreenShot
{
    public static void main(String[] args) throws Throwable
    {
    	WebDriver_Utility webLib=new WebDriver_Utility();
	 File_Utility fileLib=new File_Utility();

	 String url = fileLib.getPropertyKeysAndValue("url");
	  String username = fileLib.getPropertyKeysAndValue("un");
      String password = fileLib.getPropertyKeysAndValue("pwd");
      WebDriver driver=new ChromeDriver();
      driver.get("url");
      webLib.waitForPageLoad(driver);
      LoginPage login=new LoginPage(driver);
      login.login(username, password);

      TakesScreenshot ts=(TakesScreenshot) driver;
  	File Ram = ts.getScreenshotAs(OutputType.FILE);
  	 File dest = new File("./photo/vtiger.png");
  	 FileUtils.copyFile(Ram, dest);

    }
}

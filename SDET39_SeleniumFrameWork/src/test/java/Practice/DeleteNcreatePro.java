package Practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import comcast.vtiger.genericUtility.Excel_utility;
import comcast.vtiger.genericUtility.File_Utility;
import comcast.vtiger.genericUtility.Java_Utility;
import comcast.vtiger.genericUtility.WebDriver_Utility;
import comcast.vtiger.objectRepository.HomePage;
import comcast.vtiger.objectRepository.LoginPage;

public class DeleteNcreatePro
{
	public static void main(String[] args) throws Throwable
	   {
		   WebDriver driver=new ChromeDriver();

		   WebDriver_Utility webLib=new WebDriver_Utility();
		   webLib.waitForPageLoad(driver);

		   File_Utility fileLib=new File_Utility();
		   String browser = fileLib.getPropertyKeysAndValue("url");
		   String username = fileLib.getPropertyKeysAndValue("un");
		   String password = fileLib.getPropertyKeysAndValue("pwd");

		   driver.get(browser);
		   LoginPage login=new LoginPage(driver);
		   login.login(username, password);
		   HomePage home=new HomePage(driver);
		   home.productModule();
		   // driver.findElement(By.name("user_name")).sendKeys(username);
		  // driver.findElement(By.name("user_password")).sendKeys(password);
		  // driver.findElement(By.id("submitButton")).click();
		   Java_Utility javaLib=new Java_Utility();
		   int random = javaLib.getRandomNum();

		   Excel_utility excelLib=new Excel_utility();
		   String excelData = excelLib.getExcelValue("Sheet1",1, 0)+random;

		  //driver.findElement(By.linkText("Products")).click();
		  // driver.findElement(By.xpath("//img[@src=\"themes/softed/images/btnL3Add.gif\"]")).click();
		  // driver.findElement(By.name("productname")).sendKeys(excelData);
		   //driver.findElement(By.name("button")).click();


	      driver.findElement(By.name("Delete")).click();
	     webLib.switchToalertAndAccept(driver);

	     WebElement ele = driver.findElement(By.xpath("//img[@src=\"themes/softed/images/user.PNG\"]"));
	 	   webLib.performingMoveToElement(driver, ele);
	 	   driver.findElement(By.linkText("Sign Out")).click();
	     driver.close();
	   }
}

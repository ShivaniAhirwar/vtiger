package comcast.vtiger.genericUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import comcast.vtiger.objectRepository.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass
{
	public WebDriver driver;
	public static WebDriver sDriver;
	File_Utility flib=new File_Utility();

   @BeforeSuite(groups= {"Smoke Testing","Regression Testing"})
   public void BS()
   {
	   System.out.println("database connectivity");
   }
   @BeforeTest(groups= {"Smoke Testing","Regression Testing"})
   public void BT()
   {
	   System.out.println("Execute the Script in parallel mode");
   }
   @Parameters("BROWSER")
   @BeforeClass(groups= {"Smoke Testing","Regression Testing"})
   public void BC() throws Throwable
   {
		String Browser = flib.getPropertyKeysAndValue("Browser");
		   if(Browser.equalsIgnoreCase("chrome"))
		   {

		   WebDriverManager.chromedriver().setup();
		   driver = new ChromeDriver();

		   }
		    else if(Browser.equalsIgnoreCase("firefox"))
		   {
		    WebDriverManager.firefoxdriver().setup();
		     driver = new FirefoxDriver();
		   }
		   else if(Browser.equalsIgnoreCase("edge"))
		    {
		    WebDriverManager.edgedriver().setup();
		     driver = new EdgeDriver();
		    }
		    else
		    {
		      driver = new ChromeDriver();

		    }
		   sDriver=driver;
	   System.out.println("Launching the browser");
   }
   @BeforeMethod(groups= {"Smoke Testing","Regression Testing"})
   public void BM() throws Throwable
   {
	   System.out.println("Login tothe application");
	   String Url=flib.getPropertyKeysAndValue("url");
	   String username=flib.getPropertyKeysAndValue("un");
	   String password=flib.getPropertyKeysAndValue("pwd");
	   driver.get(Url);
	   LoginPage login=new LoginPage(driver);
	   login.login(username, password);
   }
   @AfterMethod(groups= {"Smoke Testing","Regression Testing"})
   public void AM()
   {
	   System.out.println("Logout from the application");
   }
   @AfterClass(groups= {"Smoke Testing","Regression Testing"})
   public void AC()
   {
	   System.out.println("close the browser");
   }
   @AfterTest(groups= {"Smoke Testing","Regression Testing"})
   public void AT()
   {
	   System.out.println("stop execute parallel execution");
   }
   @AfterSuite(groups= {"Smoke Testing","Regression Testing"})
   public void AS()
   {
	   System.out.println("close the database connectivity");
   }
}

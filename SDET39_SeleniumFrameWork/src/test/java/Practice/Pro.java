package Practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Pro
{
   public static void main(String[] args) 
   {
	   WebDriverManager.chromedriver().setup();
	  ChromeDriver driver=new ChromeDriver();
	  driver.get("https://www.amazon.in/");
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  driver.findElement(By.xpath("//input[@id=\"twotabsearchtextbox\"]")).sendKeys("shorts for women");
	  
	  driver.getScreenshotAs(OutputType.FILE);
	  
   }
}

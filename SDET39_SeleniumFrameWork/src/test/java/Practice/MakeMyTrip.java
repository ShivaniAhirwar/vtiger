package Practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import comcast.vtiger.genericUtility.WebDriver_Utility;

public class MakeMyTrip
{
   public static void main(String[] args)
   {
	   WebDriver driver=new ChromeDriver();
	   driver.manage().window().maximize();
	   WebDriver_Utility webLib=new WebDriver_Utility();
	   webLib.waitForPageLoad(driver);

	   driver.get("https://www.makemytrip.com/");
	   driver.findElement(By.xpath("//span[text()='From']")).click();
	   driver.findElement(By.id("fromCity")).sendKeys("pune,india");
	   driver.findElement(By.xpath("//p[text()='Pune, India']")).click();
	   driver.findElement(By.xpath("//span[text()='To']")).click();
	  driver.findElement(By.xpath("(//input[@type=\"text\"])[3]")).sendKeys("Gwalior,india");
	  driver.findElement(By.xpath("//p[text()='Gwalior, India']")).click();
	 driver.findElement(By.xpath("//span[text()='DEPARTURE']")).click();

	String departureDate="9";
	  driver.findElement(By.xpath("(//p[text()="+departureDate+"])[1]")).click();
	  driver.findElement(By.xpath("//span[text()='RETURN']")).click();

	  WebElement ele = driver.findElement(By.xpath("//span[@aria-label=\"Next Month\"]"));
	 webLib.performingDoubleClick(driver, ele);

     String returnDate="17";
	  driver.findElement(By.xpath("(//p[text()="+returnDate+"])[2]")).click();

   }
}

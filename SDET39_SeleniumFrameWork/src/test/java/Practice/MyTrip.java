package Practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import comcast.vtiger.genericUtility.WebDriver_Utility;
import io.github.bonigarcia.wdm.WebDriverManager;

public class MyTrip
{
  public static void main(String[] args)
  {
	  WebDriverManager.chromedriver().setup();
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
			   
			   String requiredMonth="november";
			   String requiredYear="2022";
			   String requiredDate="17";
			   String currentMonthYear=driver.findElement(By.xpath("(//div[@class='DayPicker-Caption'])[1]")).getText();
			   String currentMonth=currentMonthYear.split(" ")[0];
			   String currentYear=currentMonthYear.split(" ")[1];
			   while(!(currentMonth.equalsIgnoreCase(requiredMonth) && currentYear.equalsIgnoreCase(requiredYear) ))
			   {
				   driver.findElement(By.xpath("//span[@class='DayPicker-NavButton DayPicker-NavButton--next']")).click();
				   currentMonthYear=driver.findElement(By.xpath("(//div[@class='DayPicker-Caption']/div)[1]")).getText();
				   currentMonth=currentMonthYear.split(" ")[0];
				   currentYear =currentMonthYear.split(" ")[1];
			   }
			   driver.findElement(By.xpath("(//p[.='"+requiredDate+"'])[1]"));
  
  }
}

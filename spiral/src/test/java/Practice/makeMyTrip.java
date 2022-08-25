package Practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class makeMyTrip
{
	  public static void main(String[] args) 
	   {
		   WebDriverManager.edgedriver().setup();
		   WebDriver driver=new EdgeDriver();
		   driver.get("https://www.makemytrip.com");
		   driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		   driver.findElement(By.xpath("//a[text()='Search']")).click();
		   driver.findElement(By.xpath("//button[text()='OKAY, GOT IT!']")).click();
		   
		   String check="Refundable Fares";
		   driver.findElement(By.xpath("//span[@title='"+check+"']")).click();
	   }
}

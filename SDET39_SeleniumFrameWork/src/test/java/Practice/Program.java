package Practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Program 
{
   public static void main(String[] args) 
   {
	   WebDriverManager.chromedriver().setup();
	   WebDriver driver =new ChromeDriver();
	   driver.get("https://www.youtube.com/");
	   driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	WebElement song = driver.findElement(By.xpath("//input[@id=\"search\"]"));
   song.sendKeys("pehla pehla pyaar hai mera");
   driver.findElement(By.xpath("//button[@id=\"search-icon-legacy\"]")).click();
   driver.findElement(By.xpath("//img[@src=\"https://i.ytimg.com/vi/B7SkAq_94J8/hq720.jpg?sqp=-oaymwEcCNAFEJQDSFXyq4qpAw4IARUAAIhCGAFwAcABBg==&rs=AOn4CLBrA2JkZUK7fR3UGTwybfAZHyB5OA\"]")).click();
   }
}

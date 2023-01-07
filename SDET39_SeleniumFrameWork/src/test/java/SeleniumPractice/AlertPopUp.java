package SeleniumPractice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AlertPopUp
{
   public static void main(String[] args) 
   {
	 WebDriverManager.chromedriver().setup();
	 WebDriver driver=new ChromeDriver();
	 driver.get("https://demoapp.skillrary.com/product.php?product=selenium-training");
	 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	 
	 driver.findElement(By.xpath("//button[text()=' Add to Cart']")).click();
	 Alert a = driver.switchTo().alert();
	 a.accept();
   }
}
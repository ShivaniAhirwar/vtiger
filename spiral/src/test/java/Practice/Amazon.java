package Practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Amazon 
{
   public static void main(String[] args) 
   {
	   WebDriverManager.edgedriver().setup();
	   WebDriver driver=new EdgeDriver();
	   driver.get("https://www.amazon.in/");
	   driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	   String option="Mobiles";
	   driver.findElement(By.xpath("(//a[text()='"+option+"'])[1]")).click();
   }
}

package SeleniumPractice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class IccRanking
{
  public static void main(String[] args) 
  {
	  WebDriverManager.chromedriver().setup();
		 WebDriver driver=new ChromeDriver();
			driver.manage().window().maximize();
			driver.get("https://www.icc-cricket.com/");
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	 WebElement ele = driver.findElement(By.xpath("//nav[@class=\"sub-menu\"]/a[@href=\"https://www.icc-cricket.com/rankings/mens/overview\"]"));
 Actions a=new Actions(driver);
 a.moveToElement(ele).perform();

 Select s=new Select(ele);
 s.selectByVisibleText("PLAYER RANKINGS");
  }
}

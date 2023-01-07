package SeleniumPractice;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;


import io.github.bonigarcia.wdm.WebDriverManager;

public class ChildBrowser 
{
   public static void main(String[] args) 
   {
	   WebDriverManager.chromedriver().setup();
		 WebDriver driver=new ChromeDriver();
			driver.manage().window().maximize();
			driver.get("https://skillrary.com/");
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.findElement(By.xpath("//a[text()=' GEARS ']")).click();
	driver.findElement(By.xpath("(//a[text()=' SkillRary Demo APP'])[2]")).click();



	String parent = driver.getWindowHandle();
	System.out.println(parent);

	Set<String> child = driver.getWindowHandles();
	System.out.println(child);

	for(String b:child) {
		driver.switchTo().window(b);
	}
	driver.findElement(By.xpath("(//a[text()='Selenium Training'])[2]")).click();
	}
}

package Practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class VtigerLaunchTest
{
   public static void main(String[] args) throws IOException
   {
	    FileInputStream fis=new FileInputStream("./data/commonData.properties");
	    Properties p=new Properties();
	    p.load(fis);

	    String browser=p.getProperty("url");
	    String username=p.getProperty("un");
	    String password=p.getProperty("pwd");

	    WebDriver driver=new ChromeDriver();
	    driver.get(browser);

	    driver.findElement(By.name("user_name")).sendKeys(username);
	    driver.findElement(By.name("user_password")).sendKeys(password);
	    driver.findElement(By.id("submitButton")).click();
   }
}

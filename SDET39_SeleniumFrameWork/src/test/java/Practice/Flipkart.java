package Practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Flipkart
{

	public static void main(String[] args) throws IOException {

	FileInputStream fis=new FileInputStream("./data/flipkart.properties");
    Properties p=new Properties();
    p.load(fis);

    String browser=p.getProperty("url");
    String username=p.getProperty("un");
    String password=p.getProperty("pwd");
    
    WebDriver driver=new ChromeDriver();
    driver.get(browser);


    driver.findElement(By.xpath("(//input[@type=\"text\"])[2]")).sendKeys(username);
    driver.findElement(By.xpath("//input[@type=\"password\"]")).sendKeys(password);
    driver.findElement(By.xpath("(//span[text()='Login'])[2]")).click();
	}
}

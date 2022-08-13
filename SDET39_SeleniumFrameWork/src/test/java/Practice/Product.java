package Practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Product
{
   public static void main(String[] args) throws IOException
   {
	  FileInputStream fis=new FileInputStream("./data/vtiger.properties");
	  Properties p=new Properties();
	  p.load(fis);

	  String browser = p.getProperty("url");
	   String username = p.getProperty("un");
	   String password = p.getProperty("pwd");

	   WebDriver driver=new ChromeDriver();
	   driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	   driver.manage().window().maximize();
	   driver.get(browser);
	   driver.findElement(By.name("user_name")).sendKeys(username);
	   driver.findElement(By.name("user_password")).sendKeys(password);
	   driver.findElement(By.id("submitButton")).click();

	   FileInputStream fs=new FileInputStream("./data/name.xlsx");
	   Workbook wb = WorkbookFactory.create(fs);
	   Sheet sh = wb.getSheet("Sheet1");
	   Row row = sh.getRow(1);
	   Cell cell = row.getCell(1);
	  String value = cell.getStringCellValue();
	  System.out.println(value);
	  driver.findElement(By.linkText("Products")).click();
	   driver.findElement(By.xpath("//img[@title=\"Create Product...\"]")).click();

	  driver.findElement(By.name("productname")).sendKeys(value);
	   driver.findElement(By.name("button")).click();
	   String actTitle = driver.findElement(By.xpath("//span[@class=\"lvtHeaderText\"]")).getText();
	   if(value.contains(actTitle))
	   {
		   System.out.println("pass");
	   }
	   else
	   {
		   System.out.println("fails");
	   }

	   WebElement element = driver.findElement(By.xpath("//img[@src=\"themes/softed/images/user.PNG\"]"));
	   Actions a=new Actions(driver);
	   a.moveToElement(element).perform();
	   driver.findElement(By.linkText("Sign Out")).click();
   }
}

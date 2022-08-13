package Practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.Properties;
import java.util.Random;
import java.util.Set;
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

public class CreateCampaigntAndProduct
{
   public static void main(String[] args) throws IOException, InterruptedException

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

		   driver.findElement(By.linkText("Products")).click();
		   driver.findElement(By.xpath("//img[@title='Create Product...']")).click();

		   Random r=new Random();
		   int random=r.nextInt();
		   FileInputStream fs=new FileInputStream("./data/name.xlsx");
		   Workbook wb = WorkbookFactory.create(fs);
	        Sheet sh = wb.getSheet("Sheet1");
	        Row row = sh.getRow(1);
	        Cell cell = row.getCell(1);
	        String productName = cell.getStringCellValue()+random;
	        System.out.println(productName);
	        driver.findElement(By.xpath("//input[@name='productname']")).sendKeys(productName);
	        driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();

	        WebElement ele = driver.findElement(By.xpath("//img[@src='themes/softed/images/menuDnArrow.gif']"));
	  	   Actions a=new Actions(driver);
	  	   a.moveToElement(ele).perform();
	  	   driver.findElement(By.name("Campaigns")).click();
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	 	  driver.findElement(By.xpath("//img[@title=\"Create Campaign...\"]")).click();

	   	 Random rn=new Random();
		   int ran=rn.nextInt(1000);

		   FileInputStream fis1=new FileInputStream("./data/name.xlsx");
	  	   Workbook w = WorkbookFactory.create(fis1);
	  	   Sheet sheet = w.getSheet("Sheet1");
	  	 Row rw = sheet.getRow(1);
		   Cell cll = rw.getCell(2);
		  String value = cll.getStringCellValue()+ran;
		  System.out.println(value);

		  driver.findElement(By.name("campaignname")).sendKeys(value);

		  driver.findElement(By.xpath("//img[@src='themes/softed/images/select.gif']")).click();
		  Thread.sleep(3000);
		  Set<String> alt = driver.getWindowHandles();
		 Iterator<String> ite = alt.iterator();
		 while(ite.hasNext())
		 {
			 String win = ite.next();
			 driver.switchTo().window(win);
			 if(driver.getTitle().contains("Products&action"))
			 {
				 break;
			 }
		 }
		 driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		 String actData=driver.findElement(By.xpath("//span[@class=\"lvtHeaderText\"]")).getText();
		 if(actData.contains(value))
		 {
			 System.out.println("pass");
		 }
		 else
		 {
			 System.out.println("fail");
		 }
		 WebElement element = driver.findElement(By.xpath("//img[@src=\"themes/softed/images/user.PNG\"]"));
		   Actions ac=new Actions(driver);
		   ac.moveToElement(element).perform();
		   driver.findElement(By.linkText("Sign Out")).click();

   }
}

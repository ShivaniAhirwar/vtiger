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

public class CreatecampaignNproduct
{


		public static void main(String[] args) throws IOException, InterruptedException
		{
			FileInputStream fis = new FileInputStream("./Data/vtiger.properties");
			Properties pobj = new Properties();
			pobj.load(fis);


			 String Url=pobj.getProperty("url");
			 String UN=pobj.getProperty("un");
			 String PW=pobj.getProperty("pwd");

			 WebDriver driver =new ChromeDriver();
			 driver.manage().window().maximize();
			 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			 driver.get(Url);
			 driver.findElement(By.name("user_name")).sendKeys(UN);
			 driver.findElement(By.name("user_password")).sendKeys(PW);
			 driver.findElement(By.id("submitButton")).click();
			 driver.findElement(By.xpath("(//a[text()='Products'])[1]")).click();
			 driver.findElement(By.xpath("//img[@title='Create Product...']")).click();

			 Random ran =new Random();
			 int ranNum = ran.nextInt(1000);
			 FileInputStream fis1=new FileInputStream("./Data/name.xlsx");
				Workbook wb = WorkbookFactory.create(fis1);
				Sheet sh = wb.getSheet("Sheet1");

				Row r= sh.getRow(1);
				Cell cel = r.getCell(0);
				String prodName = cel.getStringCellValue()+ranNum;
				System.out.println(prodName);

				driver.findElement(By.name("productname")).sendKeys(prodName);
				driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
				 WebElement element = driver.findElement(By.xpath("//a[text()='More']"));

					Actions a=new Actions(driver);
					a.moveToElement(element).perform();

					driver.findElement(By.name("Campaigns")).click();

					driver.findElement(By.xpath("//img[@title='Create Campaign...']")).click();
					driver.findElement(By.xpath("//img[@title='Select']")).click();

					Random ran1=new Random();
					int ranNum1= ran1.nextInt(1000);

					FileInputStream fis2 = new FileInputStream("./Data/name.xlsx");
					Workbook wb2 = WorkbookFactory.create(fis2);
					Sheet sh1 = wb2.getSheet("Sheet1");

					Row r1= sh1.getRow(1);
					Cell cell = r.getCell(0);
					String campaignName = cell.getStringCellValue()+ranNum1;
					System.out.println(campaignName);

					driver.findElement(By.name("campaignname")).sendKeys(campaignName);
					driver.findElement(By.xpath("//img[@title='Select']")).click();
					Thread.sleep(3000);
					Set<String> allId = driver.getWindowHandles();
					Iterator<String> it=allId.iterator();
					while(it.hasNext())
					{
						String wid =it.next();
						driver.switchTo().window(wid);
						if(driver.getTitle().contains("Products&action"))
						{
							break;
						}
					}
						driver.findElement(By.xpath("//input[@id='search_txt']")).sendKeys(prodName);

						driver.findElement(By.name("search")).click();
						driver.findElement(By.xpath("//a[text()='"+prodName+"']")).click();

						Set<String> st1 = driver.getWindowHandles();
						Iterator<String> a1=st1.iterator();
						while(a1.hasNext())
						{
							String wid1 =a1.next();
							driver.switchTo().window(wid1);
							if(driver.getTitle().contains("Campaigns&action"))
							{
								break;
							}

						}

						driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
						String actData = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();

						if(actData.contains(campaignName))
						{
							System.out.println("pass");
						}
						else
						{
							System.out.println("Fail");
						}

						WebElement ele = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));


						a.moveToElement(ele).perform();

						driver.findElement(By.linkText("Sign Out")).click();


						 driver.close();

					}


}


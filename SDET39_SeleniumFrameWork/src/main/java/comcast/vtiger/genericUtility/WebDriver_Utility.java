package comcast.vtiger.genericUtility;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriver_Utility
{
	/**
	 * wait for page to load the identifing the specific element
	 * @author shivani
	 */
   public void waitForPageLoad(WebDriver driver)
   {
	   driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
   }
   /**
    * used for element to be ready for execution
    * @author Shivani
    * @param driver
    */
   public void scriptTimeOut(WebDriver driver)
   {
	   driver.manage().timeouts().setScriptTimeout(20,TimeUnit.SECONDS);
   }
   /**
    * used to wait for element to be clickable in GUI and check for a specific element for every 500miliSeconds.
    * @author Shivani
    * @param driver
    * @param element
    */
   public void waitForElementToBeClikable(WebDriver driver,WebElement element)
   {
	WebDriverWait wait=new WebDriverWait(driver,10);
	wait.until(ExpectedConditions.elementToBeClickable(element));
   }
   /**
    * used to wait for particular condition to be satisfy.
    * @param driver
    * @param element
    * @param polling
    */
   public void waitForElementWithCustomTimeOut(WebDriver driver,WebElement element,int pollingperiod)
   {
	   FluentWait wait=new FluentWait(driver);
	   wait.pollingEvery(Duration.ofSeconds(10));
	   wait.until(ExpectedConditions.elementToBeClickable(element));
   }
   /**
    * used to switch the window from parent to child
    * @param driver
    * @param partialWindowTitle
    * @author shivani
    */
   public void switchToWindow(WebDriver driver,String partialWindowTitle)
   {
	   Set<String> allId = driver.getWindowHandles();
		Iterator<String> it=allId.iterator();
		while(it.hasNext())
		{
			String wid =it.next();
			driver.switchTo().window(wid);
			if(driver.getTitle().contains(partialWindowTitle))
			{
				break;
			}
		}
   }
   /**
    * user to handle alert popup and click on ok button
    * @param driver
    * @author Shivani
    */
   public void switchToalertAndAccept(WebDriver driver)
   {
	  driver.switchTo().alert().accept();
   }
   /**
    * used to handle the alert popup and click on cancel button
    * @param driver
    * @author Shivani
    */
   public void switchToalertAndDissmiss(WebDriver driver)
   {

	   driver.switchTo().alert().dismiss();
   }
   /**
    * used to switch the the control from outer frame to inner frame
    * @param driver
    * @param frameNum
    * @author shivani
    */
   public void switchToFrame(WebDriver driver,int index)
   {
	   driver.switchTo().frame(index);
   }
   /**
    * used to switch the control from outer frame to inner frame by using id_name_attribute
    *
    */
   public void switchToFrame(WebDriver driver,String id_name_Attribute )
   {
	   driver.switchTo().frame(id_name_Attribute);
   }
   /**
    * used to perform move to element action.
    * @param driver
    * @param element
    * @author Shivani
    */
   public void performingMoveToElement(WebDriver driver,WebElement element)
   {
	   Actions a=new Actions(driver);
	   a.moveToElement(element).perform();
   }
   /**
    * used to perform right click the element action.
    * @param driver
    * @param element
    * @author Shivani
    */
   public void performingRightClick(WebDriver driver,WebElement element)
   {
	   Actions a=new Actions(driver);
	   a.contextClick(element).perform();
   }
   /**
    * used to perform double click to the element action.
    * @param driver
    * @param element
    * @author Shivani
    */
   public void performingDoubleClick(WebDriver driver,WebElement element)
   {
	   Actions a=new Actions(driver);
	   a.doubleClick(element).perform();
   }
   /**
    * used to perform drag and drop on elements action.
    * @param driver
    * @param element
    * @author Shivani
    */
   public void performingDragNdrop(WebDriver driver,WebElement ele1,WebElement ele2)
   {
	   Actions a=new Actions(driver);
	   a.dragAndDrop(ele1, ele2).perform();
   }
   /**
    * used to perform drop and down by selecting index of the element.
    * @param element
    * @param index
    * @author Shivani
    */
   public void select(WebElement element,int index)
   {
	   Select s=new Select(element);
	   s.selectByIndex(index);
   }
   /**
    * used to perform drop and down by selecting text of the element .
    * @param element
    * @param text
    * @author Shivani
    */
   public void select(WebElement element,String text )
   {
	   Select s=new Select(element);
	   s.selectByVisibleText(text);
   }
}

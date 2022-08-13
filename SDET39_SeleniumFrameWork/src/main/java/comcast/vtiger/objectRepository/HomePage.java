package comcast.vtiger.objectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import comcast.vtiger.genericUtility.WebDriver_Utility;

public class HomePage
{
   public HomePage(WebDriver driver)
   {
	   PageFactory.initElements(driver,this);
   }

   @FindBy(linkText="Organizations")
   private WebElement organizationModuleBtn;

   @FindBy(linkText="Products")
   private WebElement productModuleBtn;

   @FindBy(name="Campaigns")
   private WebElement campaignModuleBtn;

   @FindBy(xpath="//img[@src=\"themes/softed/images/user.PNG\"]")
   private WebElement imgForGetSingoutOption;

   @FindBy(linkText="Sign Out")
   private WebElement signOutButton;

   @FindBy(xpath="//img[@src=\"themes/softed/images/menuDnArrow.gif\"]")
   private WebElement moreLink;

   public WebElement getOrganizationModuleBtn()
  {
	return organizationModuleBtn;
  }

  public WebElement getProductModuleBtn()
  {
	return productModuleBtn;
  }

  public WebElement getCampaignModuleBtn()
  {
	return campaignModuleBtn;
  }

  public WebElement getImgForGetSingoutOption()
  {
	return imgForGetSingoutOption;
  }

  public WebElement getSignOutButton()
  {
	return signOutButton;
  }

  //business logic
  /**
   * use to perform task in particular module
   * @author Shivani
   */
   public void organizationModule()
   {
	   organizationModuleBtn.click();
   }
   public void productModule()
   {
	   productModuleBtn.click();
   }
   public void imgForSignOut()
   {
	   imgForGetSingoutOption.click();
   }
   public void signOutLink()
   {
	   signOutButton.click();
   }
   public void campaignModule()
   {
	   campaignModuleBtn.click();
   }
   public void moreLink(WebDriver driver)
   {
	   WebElement element = driver.findElement(By.xpath("//a[text()='More']"));
	   WebDriver_Utility webLib=new WebDriver_Utility();
	   webLib.performingMoveToElement(driver, element);
   }

}

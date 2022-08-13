package comcast.vtiger.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CampaignValidation
{
   public CampaignValidation(WebDriver driver)
   {
	   PageFactory.initElements(driver,this);
   }
   @FindBy(xpath="//span[@class='dvHeaderText']")
   private WebElement orgActualTitle;

  public WebElement getOrgActualTitle()
 {
	return orgActualTitle;
 }
  public String actualOrgData()
  {
	  return orgActualTitle.getText();
  }

}

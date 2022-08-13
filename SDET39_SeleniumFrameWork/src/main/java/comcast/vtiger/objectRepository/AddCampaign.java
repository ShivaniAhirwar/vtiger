package comcast.vtiger.objectRepository;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddCampaign
{
   public AddCampaign(WebDriver driver)
   {
	   PageFactory.initElements(driver,this);
   }
   //declaration
   @FindBy(name="campaignname")
   private WebElement campaginTextField;

   @FindBy(xpath="//img[@src=\"themes/softed/images/select.gif\"]")
   private WebElement productPlusBtn;

   @FindBy(name="button")
   private WebElement saveButton;

   public WebElement getCampaginTextField()
   {
	return campaginTextField;
   }

   public WebElement getProductPlusBtn()
   {
	return productPlusBtn;
   }

   public WebElement getSaveButton()
   {
	return saveButton;
   }
   //business logics
   /**
    * use to create new campaign.
    * @param campaignName
    * @author Shivani
    */
    public void campaignTextField(String campaignName)
    {
    	campaginTextField.sendKeys(campaignName);
    }
   public void proPlusButton()
   {
	   productPlusBtn.click();
   }
   public void saveButton()
   {
	   saveButton.click();
   }
}

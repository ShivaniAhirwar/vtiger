package comcast.vtiger.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateProduct
{
	//initialization
   public CreateProduct(WebDriver driver)
   {
	   PageFactory.initElements(driver,this);
   }
   //declaration

   @FindBy(name="productname")
   private WebElement productNameTextField;

   @FindBy(name="button")
   private WebElement saveButton;

    public WebElement getProductNameTextField()
   {
	return productNameTextField;
   }

    public WebElement getSaveButton()
    {
	  return saveButton;
    }
    //business Logic
    /**
     * use to create product.
     * @param proName
     * @author shivani
     */
    public void createProduct(String proName)
    {
    	productNameTextField.sendKeys(proName);
    	saveButton.click();
    }
}


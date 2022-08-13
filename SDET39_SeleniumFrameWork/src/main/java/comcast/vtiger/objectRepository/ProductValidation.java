package comcast.vtiger.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductValidation
{
    public ProductValidation(WebDriver driver)
    {
    	PageFactory.initElements(driver,this);
    }
    @FindBy(xpath="//span[@class=\"lvtHeaderText\"]")
    private WebElement productTitle;

	public WebElement getProductTitle()
	{
		return productTitle;
	}
	public String actualProductData()
	{
		return productTitle.getText();
	}
	//business logic
	/**
	 *
	 */
	public void actualProductTitle()
	{
		productTitle.getText();
	}

}

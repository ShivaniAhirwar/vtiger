package comcast.vtiger.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage
{
   //initialization
	public ProductPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	//declaration

	@FindBy(xpath="//img[@src=\"themes/softed/images/btnL3Add.gif\"]")
	private WebElement plusButton;

	public WebElement getPlusButton()
	{
		return plusButton;
	}
	//business logics
	/**
	 * use to get create product page.
	 * @author shivani
	 */
	public void newProduct()
	{
		plusButton.click();
	}
}

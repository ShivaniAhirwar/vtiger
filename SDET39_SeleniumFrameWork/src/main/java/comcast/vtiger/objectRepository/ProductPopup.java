package comcast.vtiger.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPopup
{
   //initialization
	public ProductPopup(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	//declaration
	@FindBy(id="search_txt")
	private WebElement searchTextField;

	@FindBy(name="search")
	private WebElement searchButton;

	@FindBy(xpath="//a[@href=\"javascript:window.close();\"]")
     private WebElement proName;

	public WebElement getSearchTextField()
	{
		return searchTextField;
	}

	public WebElement getSearchButton()
	{
		return searchButton;
	}
	public WebElement getproductNameInsearch()
	{
		return proName;
	}

	//business logic
	/**
	 * use to add the product in create campaign page
	 * @param productName
	 * @author Shivani
	 */
	public void addProduct(String proName)
	{
		searchTextField.sendKeys(proName);
		searchButton.click();
	}
	public void selectProductName()
	{
		proName.click();
	}
}

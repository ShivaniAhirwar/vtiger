package comcast.vtiger.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DeleteCreatedProduct
{
   //initialization
	public DeleteCreatedProduct(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	//declation
	@FindBy(name="Delete")
	private WebElement deleteButton;
	public WebElement getDeleteButton()
	{
		return deleteButton;
	}
	//business logic
	/**
	 *use to delete the created product
	 *@author Shivani
	 */
	public void deleteCreatePro()
	{
		deleteButton.click();
	}
}

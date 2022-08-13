package comcast.vtiger.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationPage
{
   //initialization
	public OrganizationPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}

	//Declaration
	@FindBy(xpath="//img[@src=\"themes/softed/images/btnL3Add.gif\"]")
	private WebElement plusButton;



	public WebElement getPlusButton()
	{
		return plusButton;
	}

   //business logics
	/**
	 * use to get create organization page.
	 * @author Shivani
	 */
	public void organizationPageObjects()
	{
		plusButton.click();
	}
}

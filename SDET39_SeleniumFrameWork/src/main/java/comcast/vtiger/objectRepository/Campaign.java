package comcast.vtiger.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Campaign
{
   //initialization
	public Campaign(WebDriver driver)
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
	//business logic
	/**
	 * use to get create campaign page.
	 * @author shivani
	 */
	public void newCampaign()
	{
		plusButton.click();
	}

}

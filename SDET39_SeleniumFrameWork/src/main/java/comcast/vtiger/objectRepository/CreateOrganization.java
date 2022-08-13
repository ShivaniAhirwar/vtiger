package comcast.vtiger.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateOrganization
{
	//initialization
    public CreateOrganization(WebDriver driver)
    {
    	PageFactory.initElements(driver,this);
    }
    //declaration
    @FindBy(name="accountname")
	private WebElement orgNameTextField;

	@FindBy(name="button")
	private WebElement saveButton;

	public WebElement getOrgNameTextField()
	{
		return orgNameTextField;
	}

	public WebElement getSaveButton()
	{
		return saveButton;
	}


	/**
	 * use to create organization
	 * @param orgName
	 * @author Shivani
	 */
	public void createOrg(String orgName)
	{
		orgNameTextField.sendKeys(orgName);
		saveButton.click();

	}


}

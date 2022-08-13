package comcast.vtiger.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage
{
    public LoginPage(WebDriver driver)
    {
    	PageFactory.initElements(driver,this);
    }
    @FindBy(name="user_name")
    private WebElement usenameTextField;

    @FindBy(name="user_password")
    private WebElement userPasswordTextField;

    @FindBy(id="submitButton")
    private WebElement loginButton;

	public WebElement getUsenameTextField()
	{
		return usenameTextField;
	}

	public WebElement getUserPasswordTextField()
	{
		return userPasswordTextField;
	}

	public WebElement getLoginButton()
	{
		return loginButton;
	}
    //business logics
	/**
	 * used for login application
	 * @param username
	 * @param password
	 * @author Shivani
	 */
	public void login(String username,String password)
	{
		usenameTextField.sendKeys(username);
		userPasswordTextField.sendKeys(password);
		loginButton.click();
	}
}

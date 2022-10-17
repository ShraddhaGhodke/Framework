package crm.com.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class loginpage {
  
	public loginpage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(name="user_name")
	private WebElement usernameTF;
	
	@FindBy(name="user_password")
	private WebElement passwordTF;
	
	@FindBy(id="submitButton")
	private WebElement submitbutton;

	public WebElement getUsername() {
		return usernameTF;
	}

	public WebElement getPassword() {
		return passwordTF;
	}

	public WebElement getSubmit() {
		return submitbutton;
	}
	
	public void login(String username,String password)
	{
		usernameTF.sendKeys(username);
		passwordTF.sendKeys(password);
		submitbutton.click();
	}
	
}

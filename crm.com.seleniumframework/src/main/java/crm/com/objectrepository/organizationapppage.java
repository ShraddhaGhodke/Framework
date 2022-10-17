package crm.com.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class organizationapppage {

	@FindBy(xpath="//img[@src='themes/softed/images/btnL3Add.gif']")
	private WebElement plusorg;

	@FindBy(name="accountname")
	private WebElement orgname;

	@FindBy(xpath="//input[@name='button']")
	private WebElement saveorg;
	
	

	public organizationapppage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}

	public WebElement getPlusorg() {
		return plusorg;
	}

	public WebElement getOrgname() {
		return orgname;
	}

	public WebElement getSaveorg() {
		return saveorg;
	}

	public void clickonplusorg()
	{
plusorg.click();
	}
	public void setaccountname(String data2)
	{
orgname.sendKeys(data2);		
	}
	public void clickonsave()
	{
		saveorg.click();
	}
}


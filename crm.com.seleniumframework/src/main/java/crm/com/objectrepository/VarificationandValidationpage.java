package crm.com.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VarificationandValidationpage {

	public  VarificationandValidationpage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css="span.dvHeaderText")
	private WebElement actualOrganizationData;

	public WebElement getActualOrganizationData() {
		return actualOrganizationData;
	}
	
	public void clickvalidate(WebDriver driver,String data2)
	{
	String actData=	actualOrganizationData.getText();
	
	if(actData.contains(data2))
	{
		System.out.println("pass");
	}
	else
	{
		System.out.println("fail");
	}
	
}
}

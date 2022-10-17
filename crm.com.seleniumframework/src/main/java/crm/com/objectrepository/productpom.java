package crm.com.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class productpom {
	public productpom(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//img[@alt='Create Product...']")
	private WebElement plusproduct;
	
	@FindBy(name="productname")
	private WebElement setproductname;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveproductname;
	
	@FindBy(name="Delete")
	private WebElement deleteproduct;

	public WebElement getDeleteproduct() {
		return deleteproduct;
	}

	public WebElement getPlusproduct() {
		return plusproduct;
	}

	public WebElement getSetproductname() {
		return setproductname;
	}

	public WebElement getSaveproductname() {
		return saveproductname;
	}
	
	public void clickplusproduct()
	{
		plusproduct.click();
	}
	public void clickproductname(String data2)
	{
		setproductname.sendKeys(data2);
	}
	public void clickproductsave()
	{
		saveproductname.click();
	}
	public void clickondeleteproduct()
	{
		deleteproduct.click();
		
	}
}

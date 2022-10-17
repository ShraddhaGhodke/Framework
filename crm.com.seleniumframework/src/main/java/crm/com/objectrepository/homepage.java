package crm.com.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class homepage {
public  homepage(WebDriver driver)
{
	PageFactory.initElements(driver,this);
}
	
@FindBy(xpath="//a[.='Organizations']")
private WebElement orglink;

@FindBy(xpath="//a[.='Products']")
private WebElement productlink; 

public WebElement getProductlink() {
	return productlink;
}

@FindBy(linkText="More")
private WebElement morelink;


@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
private WebElement addministrator ;

@FindBy(xpath="//a[.='Sign Out']")
private WebElement signout;

public WebElement getOrglink() {
	return orglink;
}
public WebElement getMorelink() {
	return morelink;
}

public WebElement getAddministrator() {
	return addministrator;
}

public WebElement getSignout() {
	return signout;
}

public void clickorganizationlink()
{
	orglink.click();
}
public void clickonmorelink()
{
	morelink.click();
	
}
public void clickonaddministrator(WebDriver driver)
{
	addministrator.click();
}
public void clickonsignout()
{
signout.click();
}
public void clickonproductlink()
{
	productlink.click();
}

}

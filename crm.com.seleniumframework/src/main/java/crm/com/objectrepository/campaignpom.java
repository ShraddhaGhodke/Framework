package crm.com.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class campaignpom {
  
	private static final String productdata = null;

	public campaignpom(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	
	
	@FindBy(name="Campaigns")
	private WebElement campaignslink;
	
	@FindBy(xpath="//img[@src='themes/softed/images/btnL3Add.gif']")
	private WebElement pluscampaign;
	
	@FindBy(xpath="//img[@title='Select']")
	private WebElement productincampaign;
	
	@FindBy(id="search_txt")
	private WebElement setproductincampaign;
	
	@FindBy(name="search")
	private WebElement searchproduct;
	
	/*@FindBy(cssSelector="span.dvHeaderText")
	private WebElement campaignheader;*/
	
	/*@FindBy(xpath="//a[text()='"+productdata+"']")
	private WebElement productincamplink;*/
	
	public WebElement getPluscampaign() {
		return pluscampaign;
	}

	/*public WebElement getCampaignheader() {
		return campaignheader;
	}*/

	public static String getProductdata() {
		return productdata;
	}

	public WebElement getSetproductincampaign() {
		return setproductincampaign;
	}

	public WebElement getSearchproduct() {
		return searchproduct;
	}



	@FindBy(name="campaignname")
	private WebElement campaignsname;
	
	@FindBy(xpath="//input[@name='button']")
	private WebElement savecampaign;

	public WebElement getCampaignslink() {
		return campaignslink;
	}

	public WebElement getProductincampaign() {
		return productincampaign;
	}

	public WebElement getCampaignsname() {
		return campaignsname;
	}

	public WebElement getSavecampaign() {
		return savecampaign;
	}
	
	public void clickoncampaignlink()
	{
		campaignslink.click();
		
	}
	public void clickonpluscamp()
	{
		pluscampaign.click();
	}
	public void setcampaignsname(String data2)
	
	{
		campaignsname.sendKeys(data2);
	}
	public void clickonsavecampaign()
	{
		savecampaign.click();
	}
	public void clickonProductincampaign()
	{
		productincampaign.click();
	}
	public void clicksetproductincampaign(String data2)
	{
		setproductincampaign.sendKeys(data2);
	}
	public void clicksearchproduct()
	{
		searchproduct.click();
	}
/*	public void clickoncampaignheader()
	{
		campaignheader.click();
	}*/
}

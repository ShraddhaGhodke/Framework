package crm.com.campaign;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import crm.com.grnrric_utilities.BaseClass;
import crm.com.grnrric_utilities.Excel_utilities;
import crm.com.grnrric_utilities.File_utility;
import crm.com.grnrric_utilities.java_utility;
import crm.com.grnrric_utilities.webdriverutility;
import crm.com.objectrepository.campaignpom;
import crm.com.objectrepository.homepage;
import crm.com.objectrepository.loginpage;
import crm.com.objectrepository.productpom;
import io.github.bonigarcia.wdm.WebDriverManager;

public class pomproductcampaign extends BaseClass{
@Test
	//public static void main(String[] args) throws IOException {
public void pomproductcampaigntest() throws IOException
{
	
		
		File_utility flib=new File_utility();
		Excel_utilities eutil=new Excel_utilities();
		java_utility jutil=new java_utility();
		webdriverutility web=new webdriverutility();
			
		/*String BROWSER = flib.getPropertyKeyValue("browser");
		String URL = flib.getPropertyKeyValue("url");
		String username = flib.getPropertyKeyValue("un");
		String password = flib.getPropertyKeyValue("pw");*/
		
		/*WebDriver driver = null;
		if(BROWSER.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}
		else if(BROWSER.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
		}
		else
		{
			driver=new ChromeDriver();
		}*/
		
	//	web.implywait(driver);
		int rannum = jutil.getRanDomNum();
		String data2 = eutil.getdatafromexcel("Sheet1", 0, 0)+rannum;
		//driver.get(URL);
		
		//loginpage login=new loginpage(driver);
		homepage home=new homepage(driver);
		productpom product=new productpom(driver);
		campaignpom campaign=new campaignpom(driver);
		
		//login.login(username,password);
		home.clickonproductlink();
		product.clickplusproduct();
		product.clickproductname(data2);
		product.clickproductsave();
		home.clickonmorelink();
		campaign.clickoncampaignlink();
		campaign.clickonpluscamp();
		campaign.setcampaignsname(data2);
		campaign.clickonProductincampaign();
		
		//window switching
		web.switchtowindow(driver);
		campaign.clicksetproductincampaign(data2);
		campaign.clicksearchproduct();
		
		//Dynamic Xpath
		driver.findElement(By.xpath("//a[text()='"+data2+"']")).click();
		//Switch back Window
		web.switchtowindow(driver);
		campaign.clickonsavecampaign();
		
	
		String actData = driver.findElement(By.cssSelector("span.dvHeaderText")).getText();
		if(actData.contains(data2))
		{
		System.out.println("pass");
		}
		else
		{
		System.out.println("fail");
		}
		home.clickonaddministrator(driver);
		home.clickonsignout();
	
		
	}

}

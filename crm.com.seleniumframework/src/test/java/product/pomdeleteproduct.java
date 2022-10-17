package product;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import crm.com.grnrric_utilities.BaseClass;
import crm.com.grnrric_utilities.Excel_utilities;
import crm.com.grnrric_utilities.File_utility;
import crm.com.grnrric_utilities.java_utility;
import crm.com.grnrric_utilities.webdriverutility;
import crm.com.objectrepository.homepage;
import crm.com.objectrepository.loginpage;
import crm.com.objectrepository.productpom;
import io.github.bonigarcia.wdm.WebDriverManager;

public class pomdeleteproduct extends BaseClass {
@Test
public void pomdeleteproducttest() throws IOException
{
	//public static void main(String[] args) throws IOException {

		File_utility flib=new File_utility();
		webdriverutility web=new webdriverutility();
		java_utility ran=new java_utility();
		Excel_utilities elib = new Excel_utilities();
		
		
	/*String BROWSER = flib.getPropertyKeyValue("browser");
	
		WebDriver driver;
		if(BROWSER.equalsIgnoreCase("chrome"))
				{
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
				}
		else if(BROWSER.equalsIgnoreCase("fire"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}
		else
		{
			driver=new ChromeDriver();
		}*/
		
		web.implywait(driver);
		
		/*String URL = flib.getPropertyKeyValue("url");
		String username = flib.getPropertyKeyValue("un");
		String password = flib.getPropertyKeyValue("pw");
		String browser=flib.getPropertyKeyValue("browser");*/
		int rannum = ran.getRanDomNum();
		String data2 = elib.getdatafromexcel("Sheet1", 0, 0)+rannum;
		
		//driver.get(URL);
		
		//pomloginpage
		//loginpage login=new loginpage(driver);
		homepage home=new homepage(driver);
		productpom product=new productpom(driver);
		
		
		//login.login(username, password);
		home.clickonproductlink();
		product.clickplusproduct();
		product.clickproductname(data2);
		product.clickproductsave();
		
	//web.mousehoveraction(driver);
		
		//web.switchtoalert(driver);
		String actdata = driver.findElement(By.cssSelector("span.lvtHeaderText")).getText();
		if(actdata.contains(data2))
		{
			System.out.println("pass");
			
		}
		else
		{
			System.out.println("fail");
			
		}
		product.clickondeleteproduct();
		web.switchtoalert(driver);
		home.clickonaddministrator(driver);
		home.clickonsignout();
	}

}

package crm.com.grnrric_utilities;


import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import crm.com.objectrepository.loginpage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
	File_utility flib=new File_utility();
	webdriverutility web=new webdriverutility();
	public WebDriver driver;	
	
@BeforeSuite
public void BS()
{
	System.out.println("database connection");
}
@BeforeTest
public void BT()
{
	System.out.println("excecute in paeallel mode");
}

//@Parameters("BROWSER")
@BeforeClass
public void BC() throws Throwable
{
String BROWSER= flib.getPropertyKeyValue("browser");
	if(BROWSER.equalsIgnoreCase("chrome"))
			{
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
			}
	else if(BROWSER.equalsIgnoreCase("firefox"))
	{
		WebDriverManager.firefoxdriver().setup();
		driver=new FirefoxDriver();
	}
	else
	{
		driver=new ChromeDriver();
	}
	System.out.println("launching the browser");
}
@BeforeMethod
public void BM() throws IOException
{
	web.implywait(driver);
	String URL = flib.getPropertyKeyValue("url");
	String username = flib.getPropertyKeyValue("un");
	String password = flib.getPropertyKeyValue("pw");
//	String browser=flib.getPropertyKeyValue("browser");
	driver.get(URL);
	loginpage login=new loginpage(driver);
	login.login(username, password);
	System.out.println("login to application");
}
@AfterMethod
public void AM()
{
	System.out.println("logout the application");
}
@AfterClass
public void AC()
{
	System.out.println("close the browser");
}
@AfterTest
public void AT()
{
	System.out.println("excecuted succesfully");
}
@AfterSuite
public void AS()
{
	System.out.println("database close");
}

}

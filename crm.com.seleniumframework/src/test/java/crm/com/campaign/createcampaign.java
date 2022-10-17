package crm.com.campaign;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import crm.com.grnrric_utilities.BaseClass;
import crm.com.grnrric_utilities.Excel_utilities;
import crm.com.grnrric_utilities.File_utility;
import crm.com.grnrric_utilities.java_utility;
import crm.com.grnrric_utilities.webdriverutility;
import crm.com.objectrepository.campaignpom;
import crm.com.objectrepository.homepage;
import crm.com.objectrepository.loginpage;
import crm.com.objectrepository.organizationapppage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class createcampaign extends BaseClass {


	//public static void main(String[] args) throws IOException {
	@Test
	public void createcampaigntest() throws IOException
	{
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
	//	loginpage login=new loginpage(driver);
		homepage home=new homepage(driver);
		campaignpom campaign=new campaignpom(driver);
		
	//	login.login(username, password);
		home.clickonmorelink();
		campaign.clickoncampaignlink();
		campaign.clickonpluscamp();
		campaign.setcampaignsname(data2);
		campaign.clickonsavecampaign();
		home.clickonaddministrator(driver);
		home.clickonsignout();
		
		driver.close();
		
		/*FileInputStream fis4=new FileInputStream("./common_data.property.txt");
		Properties pro=new Properties();
		pro.load(fis4);
		String URL = pro.getProperty("url");
		String username = pro.getProperty("un");
		String password = pro.getProperty("pw");
	
		driver.get(URL);
		driver.findElement(By.name("user_name")).sendKeys(username);
		driver.findElement(By.name("user_password")).sendKeys(password);
		driver.findElement(By.id("submitButton")).click();
		 WebElement ele1 = driver.findElement(By.xpath("//img[@src='themes/softed/images/menuDnArrow.gif']"));
		Actions act1=new Actions(driver);
		act1.moveToElement(ele1).perform();
		
		 driver.findElement(By.name("Campaigns")).click();
		//Actions act2=new Actions(driver);
		//act2.moveToElement(ele2).perform();;
		
		driver.findElement(By.)).click();
		
		Random ran=new Random();
		int rannum = ran.nextInt(1000);
		
		FileInputStream fis5=new FileInputStream("./orgbook1.xlsx");
		Workbook book=WorkbookFactory.create(fis5);
		Sheet sheet = book.getSheet("Sheet1");
		Row row = sheet.getRow(0);xpath("//img[@src='themes/softed/images/btnL3Add.gif']"
		Cell cell = row.getCell(0);
		 String data4=cell.getStringCellValue()+rannum;
		
		
		driver.findElement(By.name("campaignname")).sendKeys(data4);
		driver.findElement(By.xpath("//input[@name='button']")).click();
		
		
		
		String actdata = driver.findElement(By.cssSelector("span.dvHeaderText")).getText();
		if(actdata.contains(data4))
		{
			System.out.println("pass");
			
		}
		else
		{
			System.out.println("fail");
			
		}
		WebElement ele = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
				Actions act = new Actions(driver);
				act.moveToElement(ele).perform();
				driver.findElement(By.xpath("//a[.='Sign Out']")).click();
				System.out.println("github successfull");
	}
*/
}
}

package crm.com.campaign;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.Properties;
import java.util.Random;
import java.util.Set;
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
import org.openqa.selenium.interactions.Actions;

public class productcampaign {

		public static void main(String[] args) throws Throwable {
			System.setProperty("webdriver.chrome.driver","./chromedriver.exe");
			WebDriver driver=new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);

			FileInputStream fis=new FileInputStream("./common_data.property.txt");
			Properties pro=new Properties();
			pro.load(fis);
			String URL = pro.getProperty("url");
			String UserName = pro.getProperty("un");
			String PassWord = pro.getProperty("pw");
			driver.get(URL);
			driver.findElement(By.name("user_name")).sendKeys(UserName);
			driver.findElement(By.name("user_password")).sendKeys(PassWord);
			driver.findElement(By.id("submitButton")).click();

			//product data
			driver.findElement(By.linkText("Products")).click();
			driver.findElement(By.xpath("//img[@alt='Create Product...']")).click();

			Random ran =new Random();
			int RanNum = ran.nextInt(1000);
			FileInputStream fis2=new FileInputStream("./Book1.xlsx");

			Workbook book1=WorkbookFactory.create(fis2);

			Sheet sh1 = book1.getSheet("Sheet1");

			Row row1 = sh1.getRow(0);

			Cell cell = row1.getCell(0);

			String productdata = cell.getStringCellValue()+RanNum;
			driver.findElement(By.name("productname")).sendKeys(productdata);
			driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();

			//Navigate to Campaign
			driver.findElement(By.linkText("More")).click();

			driver.findElement(By.linkText("Campaigns")).click();
			driver.findElement(By.xpath("//img[@alt='Create Campaign...']")).click();


			FileInputStream fis1=new FileInputStream("./Book1.xlsx");

			Workbook book=WorkbookFactory.create(fis1);
			Sheet sh = book.getSheet("Sheet1");
			Row row = sh.getRow(0);
			Cell cel = row.getCell(0);
			String data = cel.getStringCellValue()+RanNum;
			driver.findElement(By.name("campaignname")).sendKeys(data);

			driver.findElement(By.xpath("//img[@title='Select']")).click();
			//Window Switching

			Set<String> allId = driver.getWindowHandles();
			Iterator<String> it=allId.iterator();
			while(it.hasNext())
			{
			String wid = it.next();
			driver.switchTo().window(wid);
			if(driver.getTitle().contains("Products&action"))
			{
			break;
			}}


			driver.findElement(By.id("search_txt")).sendKeys(productdata);
			driver.findElement(By.name("search")).click();

			//Dynamic Xpath
			driver.findElement(By.xpath("//a[text()='"+productdata+"']")).click();
			//Switch back Window
			Set<String> allId1 = driver.getWindowHandles();
			Iterator<String> it1=allId1.iterator();
			while(it1.hasNext())
			{
			String wid = it1.next();
			driver.switchTo().window(wid);
			if(driver.getTitle().contains("Campaigns&action"))
			{
			break;
			}}

			driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();

			Thread.sleep(1000);

			String actData = driver.findElement(By.cssSelector("span.dvHeaderText")).getText();

			if(actData.contains(data))
			{
			System.out.println("pass");
			}
			else
			{
			System.out.println("fail");
			}
			driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
			driver.findElement(By.xpath("//a[text()='Sign Out']")).click();


			}
}
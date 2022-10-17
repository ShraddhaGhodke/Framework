package product;

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
import org.openqa.selenium.interactions.Actions;

public class deleteproduct {

	public static void main(String[] args) 	throws IOException {
			System.setProperty("webdriver.chrome.driver","./chromedriver.exe");
			WebDriver driver=new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			
			FileInputStream fis4=new FileInputStream("./common_data.property.txt");
			Properties pro=new Properties();
			pro.load(fis4);
			String URL = pro.getProperty("url");
			String username = pro.getProperty("un");
			String password = pro.getProperty("pw");
		
			driver.get(URL);
			driver.findElement(By.name("user_name")).sendKeys(username);
			driver.findElement(By.name("user_password")).sendKeys(password);
			driver.findElement(By.id("submitButton")).click();
			driver.findElement(By.xpath("//a[.='Products']")).click();
			
			driver.findElement(By.name("selected_id")).click();
			
		driver.findElement(By.xpath("//input[@type='button']")).click();
			
			
			WebElement ele = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
					Actions act = new Actions(driver);
					act.moveToElement(ele).perform();
					driver.findElement(By.xpath("//a[.='Sign Out']")).click();
		
	}

}

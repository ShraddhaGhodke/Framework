package practise;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class makemytrip {

	public static void main(String[] args) throws IOException {
		System.setProperty("webdriver.chrome.driver","./chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);

		FileInputStream fis=new FileInputStream("./makemytripproperty.txt");
		Properties pro=new Properties();
		pro.load(fis);
		String URL = pro.getProperty("url");
		driver.get(URL);
	
       
	//	driver.findElement(By.xpath("//span[@class='langCardClose']")).click();;
     //from
		String srccity = "Pune, India";
		WebElement src = driver.findElement(By.xpath("//input[@id='fromCity']"));
		src.sendKeys("'"+srccity+"'");
	//	driver.findElement(By.xpath("//p[.='"+srccity+"']"))
		
		//driver.findElement(By.xpath("//span[.='DEPARTURE']")).click();
		
		
		
	}

}

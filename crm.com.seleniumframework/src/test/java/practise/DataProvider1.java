package practise;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProvider1 {
	@Test(dataProvider="dataprovider_test")
	public void vender(String name, String emailid,String Phoneno) throws Throwable  {
		System.setProperty("Webdriver.chrome.driver", "C:\\Users\\makmc\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		driver.get("http://localhost:8888/");
		driver.findElement(By.name("user_name")).sendKeys("admin");
				driver.findElement(By.name("user_password")).sendKeys("admin");
				driver.findElement(By.id("submitButton")).click();
			Actions action=new Actions(driver);
			  WebElement more = driver.findElement(By.xpath("//a[@href='javascript:;']"));

				  action.moveToElement(more).perform();
				  
				  driver.findElement(By.xpath(" //a[@name='Vendors']")).click();
				  
			      driver.findElement(By.xpath("//img[@title='Create Vendor...']")).click();

		driver.findElement(By.name("vendorname")).sendKeys(name);
		driver.findElement(By.name("email")).sendKeys(emailid);
		driver.findElement(By.xpath("//input[@id='phone']")).sendKeys(Phoneno);
		driver.quit();
		Thread.sleep(3000);

			}
	@DataProvider
	public Object[][] dataprovider_test(){
		Object[][] objarr= new Object[3][3];
		objarr[0][0]="ruby";
		objarr[0][1]="ryby2234";
		objarr[0][2]="16756757";
		
		objarr[1][0]="rani";
		objarr[1][1]="123@lore";
		objarr[1][2]="565675766";
		
		objarr[2][0]="puja";
		objarr[2][1]="fhgfh@5465";
		objarr[2][2]="567576";
		return objarr;
}
}

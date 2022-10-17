package practise;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Flipkart {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("WebDriver.chrome.driver", "./chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.get("https://www.flipkart.com/");
	
		driver.findElement(By.xpath("//html[@lang='en']/descendant::div[@class='_2QfC02']//button[.='✕']")).click();
		driver.findElement(By.xpath("//input[@placeholder='Search for products, brands and more']")).sendKeys("tshirt for men");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		String name="Color Block Men Round Neck Black T-Shirt";
		String amount="₹159";
		driver.findElement(By.xpath("//a[text()='"+name+"']/../descendant::div[text()='"+amount+"']")).click();
		
	}

}

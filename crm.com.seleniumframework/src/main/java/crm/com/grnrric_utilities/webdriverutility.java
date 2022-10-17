package crm.com.grnrric_utilities;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class webdriverutility {

	public void implywait(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		
	}
	
	/**/
	public void scripttimeout(WebDriver driver)
	{
		driver.manage().timeouts().setScriptTimeout(20,TimeUnit.SECONDS);
		
	}
	
	public void mousehoveraction(WebDriver driver,WebElement ele)
	{
		Actions act=new Actions(driver);
		act.moveToElement(ele).perform();
	}
	
	public void rightclick(WebDriver driver,WebElement ele)
	{
		Actions act=new Actions(driver);
		act.moveToElement(ele).perform();
	}
	
	public void switchtowindow(WebDriver driver)
	{
		Set<String> allId = driver.getWindowHandles();
		Iterator<String> it=allId.iterator();
		while(it.hasNext())
		{
		String wid = it.next();
		driver.switchTo().window(wid);
		if(driver.getTitle().contains("Products&action"))
		{
		break;
		}}}
	public void switchtoalert(WebDriver driver)
	{
		driver.switchTo().alert().accept();
	}
}
	
	

package crm.com.organization;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import crm.com.grnrric_utilities.BaseClass;
import crm.com.grnrric_utilities.Excel_utilities;
import crm.com.grnrric_utilities.java_utility;
import crm.com.grnrric_utilities.webdriverutility;
import crm.com.objectrepository.VarificationandValidationpage;
import crm.com.objectrepository.homepage;
import crm.com.objectrepository.organizationapppage;

public class CreateorganizationTest extends BaseClass {

	//public static void main(String[] args) throws  IOException {
	@Test
	//@Test(groups={"smoketest","regressiontest"})
		public void createorganizationTest() throws IOException
		{
		
	//File_utility flib=new File_utility();
		webdriverutility web=new webdriverutility();
		java_utility ran=new java_utility();
		Excel_utilities elib = new Excel_utilities();
			
		web.implywait(driver);
		
		/*String URL = flib.getPropertyKeyValue("url");
		String username = flib.getPropertyKeyValue("un");
		String password = flib.getPropertyKeyValue("pw");
		String browser=flib.getPropertyKeyValue("browser");*/
		int rannum = ran.getRanDomNum();
		String data2 = elib.getdatafromexcel("Sheet1", 0, 0)+rannum;
		
		//driver.get(URL);
		
		//pomloginpage
	//	loginpage login=new loginpage(driver);
		homepage home=new homepage(driver);
		organizationapppage org=new organizationapppage(driver);
		
	//	login.login(username, password);
		/*driver.findElement(By.name("user_name")).sendKeys(username);
		driver.findElement(By.name("user_password")).sendKeys(password);
		driver.findElement(By.id("submitButton")).click();*/
		
		//pomhomepage
		home.clickorganizationlink();
		/*driver.findElement(By.xpath("//a[.='Organizations']")).click();
		driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();*/
		
		
		//pomorgnipage 
		org.clickonplusorg();
		org.setaccountname(data2);
		org.clickonsave();
		/*driver.findElement(By.name("accountname")).sendKeys(data2);
		driver.findElement(By.xpath("//input[@name='button']")).click();*/
		
		VarificationandValidationpage validate=new VarificationandValidationpage(driver);
		validate.clickvalidate(driver, data2);
		
		/*String actdata = driver.findElement(By.cssSelector("span.dvHeaderText")).getText();
		if(actdata.contains(data2))
		{
			System.out.println("pass");
			
		}
		else
		{
			System.out.println("fail");
			
		}*/
		/*WebElement ele = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
				Actions act = new Actions(driver);
				act.moveToElement(ele).perform();
				driver.findElement(By.xpath("//a[.='Sign Out']")).click();*/
		home.clickonaddministrator(driver);
		home.clickonsignout();
	
		/*@Test
		public void modifyorg()
		{
			System.out.println("modified");
		}*/
		driver.close();
	
		
	}

}

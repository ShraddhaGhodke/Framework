package practise;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
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
import org.openqa.selenium.chrome.ChromeDriver;

public class practisecampaigninprodut {

	public static void main(String[] args) throws IOException {
System.setProperty("webdriver.chrome.driver","./chromedriver.exe");
WebDriver driver=new ChromeDriver();
driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);

FileInputStream fis=new FileInputStream("./common_data.property.txt");
Properties pro=new Properties();
pro.load(fis);
String URL = pro.getProperty("url");
String username = pro.getProperty("un");
String password = pro.getProperty("pwd");

driver.get(URL);
driver.findElement(By.name("user_name")).sendKeys(username);
driver.findElement(By.name("user_password")).sendKeys(password);
driver.findElement(By.id("submitButton")).click();

driver.findElement(By.xpath("//a[.='Products']")).click();
driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();

Random ran = new Random();
int RanNum = ran.nextInt(1000);
FileInputStream fis1=new FileInputStream("./orgbook1.xlsx");
Workbook book=WorkbookFactory.create(fis1);
Sheet sheet = book.getSheet("Sheet1");
Row row = sheet.getRow(0);
Cell cell = row.getCell(0);
String data1 = cell.getStringCellValue();
driver.findElement(By.name("productname")).sendKeys(data1);
driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();

//naigate to campaigbn
driver.findElement(By.linkText("More")).click();

driver.findElement(By.linkText("Campaigns")).click();
driver.findElement(By.xpath("//img[@alt='Create Campaign...']")).click();


FileInputStream fis2=new FileInputStream("./Book1.xlsx");

Workbook book1=WorkbookFactory.create(fis2);
Sheet sh = book1.getSheet("Sheet1");
Row row1 = sh.getRow(0);
Cell cel = row1.getCell(0);
String data = cel.getStringCellValue()+RanNum;
driver.findElement(By.name("campaignname")).sendKeys(data);

driver.findElement(By.xpath("//img[@title='Select']")).click();



	}

}

package HRM_Project_Website;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class FacebookSearch {
	
	public void test() throws Throwable
	{
		File F1 = new File("Facebook Search list.xlsx");
		FileInputStream fis = new FileInputStream(F1);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet ws = wb.getSheet("Sheet1");
		
		int rowcount  = ws.getLastRowNum();
		//int cellcount = ws.getRow(0).getLastCellNum();
		
		//String Sno   = ws.getRow(0).getCell(0).getStringCellValue();
		
		WebDriver driver = new FirefoxDriver ();
		driver.get("http://facebook.com");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElement(By.xpath(".//*[@id='email']")).sendKeys("vignesh.chary08@gmail.com");
		driver.findElement(By.xpath(".//*[@id='pass']")).sendKeys("urmyeverythinG");
		driver.findElement(By.xpath("//input[@value='Log In']")).click();
		
		for(int i=1;i<=rowcount-1;i++)
		{
			String Names = ws.getRow(i).getCell(1).getStringCellValue();
			driver.findElement(By.xpath(".//*[@class='innerWrap']//div[1]/input[2]")).sendKeys(Names);
			
			Actions act = new Actions(driver);
//			WebElement ele = driver.findElement(By.xpath(".//*[@id='js_2m']/form/button"));
			act.sendKeys(Keys.ENTER).build().perform();
			Thread.sleep(5000);
			System.out.println(driver.getTitle());
			driver.navigate().back();		
		}
		
		System.out.println("all done");
}
	public static void main(String[] args) throws Throwable {
		
		FacebookSearch FS = new FacebookSearch();
		FS.test();
	}
}















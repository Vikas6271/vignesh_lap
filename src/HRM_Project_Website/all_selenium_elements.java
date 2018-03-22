package HRM_Project_Website;

import java.awt.List;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.sun.jna.platform.FileUtils;

public class all_selenium_elements {
	
	public void Rightclick(By by, WebDriver driver)
	{
		Actions act = new Actions(driver);
		WebElement ele = driver.findElement(by);
		act.contextClick(ele).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.RETURN).build().perform();
	}
	
	public void MouseHover(By by, WebDriver driver)
	{
		Actions act = new Actions(driver);
		WebElement ele = driver.findElement(by);
		act.moveToElement(ele).build().perform();
	}

	public void WindowHandle(By by, WebDriver driver)
	{
		String mainwindow = driver.getWindowHandle();
		Set<String> Strmainwindow = driver.getWindowHandles();
		Iterator<String> IT = Strmainwindow.iterator();
			if(IT.hasNext())
			{
				String childwindow = IT.next();
				while(!mainwindow.equalsIgnoreCase(childwindow))
				{
					driver.switchTo().window(childwindow);
				}
			}
		}
	
	
	public void AlertAccept (By by, WebDriver driver)
	{
		Alert ale = driver.switchTo().alert();
		ale.accept();
	}
	
	public void AlertMessage(By by, WebDriver driver)
	{
		Alert ale = driver.switchTo().alert();
		String message = ale.getText();
		System.out.println(message);
	}
	
	public void AlertDismiss(By by, WebDriver driver)
	{
		Alert ale = driver.switchTo().alert();
		ale.dismiss();
	}
	
	public void Frames(By by, WebDriver driver)
	{
		int sizze = driver.findElements(By.tagName("iframe")).size();
		for(int i=0; i<sizze-1;i++)
		{
			driver.switchTo().frame(i);
		}
		
		driver.switchTo().defaultContent();
	}
	
	public void excelread(By by, WebDriver driver) throws Throwable
	{
		File f1 = new File("C:\\Users\\Vignesh\\Desktop\\excelone.xlsx");
		FileInputStream fis = new FileInputStream(f1);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet ws = wb.getSheet("Sheet1");
		
			int rowcount = ws.getLastRowNum();
			int cellcount = ws.getRow(0).getLastCellNum();
			for(int i=0;i<rowcount;i++)
			{
				String str = ws.getRow(i+1).getCell(0).getStringCellValue();
				System.out.println(str);
			}
	}
	
	public void Screenshot (By by, WebDriver driver, String shotname) throws Throwable
	{
		TakesScreenshot ts = (TakesScreenshot)driver;
		File F1 = ts.getScreenshotAs(OutputType.FILE);
		org.apache.commons.io.FileUtils.copyFile(F1, new File("Screenshot\\"+shotname+"png"));
		System.out.println("its done ");
 	}
}















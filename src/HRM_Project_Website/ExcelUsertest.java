package HRM_Project_Website;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ExcelUsertest {
	
	public static void main(String[] args) throws Throwable {
		
//		WebDriver driver = new FirefoxDriver ();
//		driver.get("https://www.facebook.com/");
//		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		File f1 = new File("C:\\Users\\Vignesh\\Desktop\\excelone.xlsx");
		FileInputStream fis = new FileInputStream(f1);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet ws = wb.getSheet("Sheet2");
		
		int rowcount = ws.getLastRowNum();
		int cellcount = ws.getRow(0).getLastCellNum();
		
		System.out.println(rowcount);
		System.out.println(cellcount);
//		
//		String Username = ws.getRow(1).getCell(0).getRawValue();		
//		driver.findElement(By.xpath(".//*[@id='email']")).sendKeys(Username);
//		System.out.println("its done");
		
		for(int i=5;i<=rowcount;i++)
		{
			String names = ws.getRow(i).getCell(0).getStringCellValue();
			System.out.println(names);
		}
		
	}

}

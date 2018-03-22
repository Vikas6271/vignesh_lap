package HRM_Project_Website;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Working_On_Chrome {
	WebDriver driver;
	
	public static void main(String[] args) throws Throwable
	{
		System.out.println("*==============================*");
		System.out.println("Statring of Chrome driver");
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Vignesh\\Downloads\\Chrome setup\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://www.sambav.com/");
		driver.manage().window().maximize();
		String title = driver.getTitle();
		System.out.println(title);
		driver.findElement(By.xpath("//*[@id='menu']/nav/ul/li[9]/a")).click();
		driver.findElement(By.xpath("//*[@id='clieventsignDet2']")).click();
	
		File fi = new File("C:\\Users\\Vignesh\\Desktop\\excelone.xlsx");
		FileInputStream fis = new FileInputStream(fi);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet ws = wb.getSheet("Sheet2");
			
			int rowcount = ws.getLastRowNum();
			int cellcount = ws.getRow(0).getLastCellNum();
			for(int i=1;i<rowcount;i++)
			{
			
			String Name = ws.getRow(i).getCell(0).getStringCellValue();
			String EmailID = ws.getRow(i).getCell(1).getStringCellValue();
			String Phone = ws.getRow(i).getCell(2).getRawValue();
			String Pwd = ws.getRow(i).getCell(3).getStringCellValue();
			String CPwd = ws.getRow(i).getCell(4).getStringCellValue();
			
		
		driver.findElement(By.xpath("//*[@id='txtFullname']")).sendKeys(Name);
		driver.findElement(By.xpath("//*[@id='email']")).sendKeys(EmailID);
		driver.findElement(By.xpath("//*[@id='mobile']")).sendKeys(Phone);
		driver.findElement(By.xpath("//*[@id='pwd']")).sendKeys(Pwd);
		driver.findElement(By.xpath("//*[@id='confirmPassord']")).sendKeys(CPwd);
		driver.findElement(By.xpath("//*[@id='robotCheckBoxR']")).click();
			}
		
		System.out.println("*=============================*");
		//driver.close();
	}
}

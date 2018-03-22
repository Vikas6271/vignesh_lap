package HRM_Project_Website;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class HDFC {

	public static void main(String[] args) throws Throwable {
		
		WebDriver driver = new FirefoxDriver();
		driver.get("https://netbanking.hdfcbank.com/netbanking/");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		int frames = driver.findElements(By.tagName("iframe")).size();
		System.out.println(frames);
		
		driver.switchTo().frame("login_page");
		driver.findElement(By.xpath("//input[@class='input_password']")).sendKeys("40080858");
		driver.findElement(By.xpath("//a[@ondblclick='return fLogon()']/img")).click();
		
		driver.findElement(By.xpath("//p[@class='fPinPwd']/a")).click();
		
								//Window Handle
	
		String MainWindow = driver.getWindowHandle();
		Set<String> SMainWindow = driver.getWindowHandles();
		Iterator<String> IT = SMainWindow.iterator();
		while(IT.hasNext())
		{
			String ChildWindow = IT.next();
			if(!MainWindow.equalsIgnoreCase(ChildWindow))
			{
				driver.switchTo().window(ChildWindow);
				driver.findElement(By.xpath("//input[@name='fldLoginUserId']")).sendKeys("40080858");
				driver.findElement(By.xpath("//a[@ondblclick='return fLogon()']/img")).click();
				
				JavascriptExecutor js = (JavascriptExecutor)driver;
				js.executeScript("scroll(0,500);");
				
				driver.findElement(By.xpath("html/body/p[2]/a[1]")).click();
			}
		}
		String MainWindow1 = driver.getWindowHandle();
		Set<String> SMainWindow1 = driver.getWindowHandles();
		Iterator<String> IT1 = SMainWindow1.iterator();
		int count=0;
		while(IT1.hasNext())
		{
			count++;
			String SubChild = IT1.next();
			if(count==3)
			{
				driver.switchTo().window(SubChild);
				Thread.sleep(5000);
				driver.close();
			}
		}
		driver.switchTo().window(MainWindow1).close();
		driver.switchTo().window(MainWindow);
		
		Thread.sleep(5000);

		driver.switchTo().defaultContent();
		
		driver.switchTo().frame("login_page");
		
		driver.findElement(By.xpath("//p[@class='fPinPwd']/a")).click();
		
		String thirdwindow = driver.getWindowHandle();
		Set<String>Sthirdwindow = driver.getWindowHandles();
		Iterator<String> IIT = Sthirdwindow.iterator();
		while(IIT.hasNext())
		{
			String ChildWindd = IIT.next();
			if(!thirdwindow.equalsIgnoreCase(ChildWindd))
			{
				driver.switchTo().window(ChildWindd);
				driver.findElement(By.xpath("//a[@ondblclick='return fLogon()']/img")).click();
				
				Alert alee = driver.switchTo().alert();
				String salee = driver.switchTo().alert().getText();
				System.out.println(salee);
				alee.accept();
				Thread.sleep(5000);
				driver.close();
			}
		}
		driver.quit();

		System.out.println("Done So far");
	}

}















package HRM_Project_Website;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Kwik_Treat_Website {
	
	public static void main (String[] args) throws Throwable
	{
		WebDriver driver = new FirefoxDriver();
		driver.get("https://www.kwiktreat.com/#/home");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("scroll(0,250);");
		
		Thread.sleep(3000);
		driver.findElement(By.xpath(".//*[@id='browse']/div/div/div/ul/li[1]/div/a/div[1]/img")).click();
		
		Thread.sleep(5000);
		driver.findElement(By.xpath("html/body/div[1]/div/div/section/div[2]/div[4]/button")).click();
		driver.findElement(By.xpath("//div[@class='modal-body']/div[16]/button")).click();
		driver.findElement(By.xpath(".//*[@id='body']/div[1]/div/div/section/div[3]/button[1]")).click();
		System.out.println("Booking done on 9th this FRIDAY");
		
		js.executeScript("scroll(0,100);");
		
		String bakery = driver.findElement(By.xpath(".//*[@id='body']/div[2]/div[1]/div/div/div/div[2]/section/div/div/div[2]/ul/li[1]/div/div[2]/div/div/div/div/h3/span")).getText();
		System.out.println("Bakery Name:" +bakery);
		
		String Flavour = driver.findElement(By.xpath(".//*[@id='body']/div[2]/div[1]/div/div/div/div[2]/section/div/div/div[2]/ul/li[1]/div/div[2]/div/div/div/div/p[1]/span")).getText();
		System.out.println("Cake Flavour:" +Flavour);
		
	//	driver.findElement(By.xpath(".//*[@id='body']/div[2]/div[1]/div/div/div/div[2]/section/div/div/div[2]/ul/li[1]/div/div[2]/div/div/div/div/div[2]/div[2]/button")).click();
		
		
		
		
		
	}

}

package HRM_Project_Website;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Java_Tpoint {
	
	public void Jpoint() throws Throwable
	{
		WebDriver driver = new FirefoxDriver();
		driver.get("https://www.javatpoint.com/");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		List<WebElement> ele = driver.findElements(By.xpath(".//*[@id='link']/div/ul/li/a"));
		for(int i=1;i<ele.size()-1;i++)
		{
			ele.get(i).click();
			Thread.sleep(5000);
			System.out.println(driver.getTitle());
			driver.navigate().back();
			ele = driver.findElements(By.xpath(".//*[@id='link']/div/ul/li/a"));
		}
	}
	public static void main (String[] args) throws Throwable
	{
		Java_Tpoint JTP = new Java_Tpoint();
		JTP.Jpoint();
	}

}

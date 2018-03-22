package HRM_Project_Website;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Login_Page {
	
	public void Login_Page()
	{
		WebDriver driver = new FirefoxDriver();
		driver.get("http://testingmasters.com/hrm/symfony/web/index.php/auth/login");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElement(By.xpath(".//*[@id='txtUsername']")).sendKeys("ankit3");
		driver.findElement(By.xpath(".//*[@id='txtPassword']")).sendKeys("abcd1234");
		driver.findElement(By.xpath(".//*[@id='btnLogin']")).click();
		System.out.println(driver.getTitle());
		
		driver.quit();
	}
	
	
	public static void main (String [] args)
	{
		Login_Page LP = new Login_Page();
		LP.Login_Page();
	}

}

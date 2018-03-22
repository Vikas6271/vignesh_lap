package HRM_Project_Website;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class FreeCRM {

	WebDriver driver;

	public void test1() {
		driver = new FirefoxDriver();
		driver.get("https://www.freecrm.com/index.html");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElement(By.xpath(".//*[@id='loginForm']/div/input[1]")).sendKeys("bashakhan");
		driver.findElement(By.xpath(".//*[@id='loginForm']/div/input[2]")).sendKeys("Zaibunnisa_Khan1");
		driver.findElement(By.xpath(".//*[@id='loginForm']/div/div/input")).click();
		System.out.println("Login successfull");

		List<WebElement> frame = driver.findElements(By.tagName("frame"));
		int framesize=frame.size();
		
		System.out.println(framesize);
		int count = 0;
		for (int i = 0; i < framesize; i++) {
			count++;
			if (count == 2) {
				driver.switchTo().frame(i);
				driver.findElement(By.xpath(".//*[@id='navmenu']/ul/li[4]/a")).click();
				System.out.println("Task done");
			}
		}
		
		String name=driver.findElement(By.xpath("//a[text()='Contacts']")).getText();
		System.out.println(name);
		
		driver.findElement(By.xpath(".//*[@id='vContactsForm']/table/tbody/tr[1]/td/table/tbody/tr/td[2]/input[3]")).click();
		WebElement ele = driver.findElement(By.xpath(".//*[@id='contactForm']/table/tbody/tr[2]/td[1]/table/tbody/tr[1]/td[2]/select"));
		Select sle = new Select(ele);
		sle.selectByValue("Mr.");
		
		driver.findElement(By.xpath(".//*[@id='first_name']")).sendKeys("virat");
		driver.findElement(By.xpath(".//*[@id='surname']")).sendKeys("kohli");
		
		WebElement ele2 = driver.findElement(By.xpath(".//*[@id='contactForm']/table/tbody/tr[2]/td[2]/table/tbody/tr[1]/td[2]/select"));
		Select slee = new Select(ele2);
		slee.selectByValue("Friend");
		
		driver.findElement(By.xpath(".//*[@id='phone']")).sendKeys("9016595676");
		driver.findElement(By.xpath(".//*[@id='email']")).sendKeys("vignsignsi@gmail.com");
		}
	public static void main(String[] args)
	{
		FreeCRM Free = new FreeCRM(); 
		Free.test1();
	}
}















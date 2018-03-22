package HRM_Project_Website;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Sample_Task_Alert {
	
	public static void main (String[] args) throws Throwable
	{
		WebDriver driver = new FirefoxDriver ();
		driver.get("https://netbanking.hdfcbank.com/netbanking/");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		List<WebElement> Frames = driver.findElements(By.tagName("frame"));
		int framesize = Frames.size();
		System.out.println(framesize);
//		
//		int count=0;
//		for(int i=0;i<framesize;i++)
//		{
//			count++;
//			if(count==2)
//			{
				driver.switchTo().frame("login_page");
				driver.findElement(By.xpath("//input[@class='input_password']")).sendKeys("40080858");	
				driver.findElement(By.xpath("//table[@class='label']/tbody/tr[3]/td[2]/table/tbody/tr[6]/td[2]/a")).click();
				driver.findElement(By.xpath("//a[text()='Forgot IPIN (Password)?']")).click();
				
				Thread.sleep(5000);
				
				String pw=driver.getWindowHandle();
				Set<String> str=driver.getWindowHandles();
				Iterator<String> itr=str.iterator();
				while(itr.hasNext())
				{
					String cw=itr.next();
					if(!pw.equalsIgnoreCase(cw))
					{
						driver.switchTo().window(cw);
					//	driver.findElement(By.xpath("//input[@name='fldLoginUserId']")).sendKeys("40080858");
						
						Thread.sleep(3000);
						driver.findElement(By.xpath("html/body/p[2]/a[1]")).click();
						
						String aw=driver.getWindowHandle();
						Set<String> str1=driver.getWindowHandles();
						Iterator<String> itr1=str1.iterator();
						int count=0;
						while(itr1.hasNext())
						{
							count++;
							String cw1=itr1.next();
							if(count==3)
							{
								driver.switchTo().window(cw1);
								driver.close();
							}
						}
						driver.switchTo().window(cw);
						driver.findElement(By.xpath("//img[@alt='Go']")).click();
						Alert ale = driver.switchTo().alert();
						String strale = driver.switchTo().alert().getText();
						System.out.println(strale);
						ale.accept();
						
				}
				}
				
//			}
//		}			
	}
}

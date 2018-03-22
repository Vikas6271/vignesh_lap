package HRM_Project_Website;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebTableSample {
	
	public static void main (String[] args)
	{
		WebDriver driver = new FirefoxDriver();
		driver.get("http://testingmasters.weebly.com/webtables.html");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		// Print the employee ID's of the candiates whose designation is Analyst.
		List<WebElement> IDs = driver.findElements(By.xpath("//*[text()='Analyst']//preceding-sibling::td[3]"));
		for(int i=0;i<IDs.size();i++)
		{
			System.out.println(IDs.get(i).getText());
		}
	
		//Print the Mail Id's of the candidates who have applied for less than or equal to 5 days.
		
		
		
		//Click on the check boxes of the records whose Designation is Manager.
		
//		List<WebElement> checkbox = driver.findElements(By.xpath("//*[text()='Manager']//preceding-sibling::td[4]/input"));
//		for(int i=0;i<checkbox.size();i++)
//		{
//			checkbox.get(i).click();
//		}
//		
//		List<WebElement> mailids = driver.findElements(By.xpath("//*[text()<'5']//preceding-sibling::td[3]"));
//		for(int i=0;i<mailids.size();i++)
//		{
//			System.out.println(mailids.get(i).getText());
//		}
		
		List<WebElement> demo = driver.findElements(By.xpath("//*[contains(text(),'demo')]//preceding-sibling::td[3]/input"));
		for(int i=0;i<demo.size();i++)
		{
			demo.get(i).click();
		}
	}

}














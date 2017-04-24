package trainpack;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
public class iframecode {

	public static void main(String[] args) throws Exception {
		WebDriver driver=new FirefoxDriver();
		driver.get("file:///C:/Users/348027/Documents/TCS%20Confidential/Webex%20Selenium%20Training/Day3/iframe.html");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		//By Index
		driver.switchTo().frame(0);
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//h2[contains(text(),'What is Selenium?')]")).isDisplayed();
		driver.switchTo().defaultContent();
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		System.out.println("Useby Index passed");
		Thread.sleep(3000);
		
		//By Name or ID
		driver.switchTo().frame("selenium_download");
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		driver.findElement(By.partialLinkText("Previous Releases")).click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.switchTo().defaultContent();
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		System.out.println("Useby Name or ID passed");
		Thread.sleep(3000);
		
		//By WebElement
		WebElement element=driver.findElement(By.xpath("//iframe[@title='w3school']"));
		driver.switchTo().frame(element);
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//a[@title='Search W3Schools']")).click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.switchTo().defaultContent();
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		System.out.println("Useby WebElement passed");
		Thread.sleep(3000);
		
		driver.close();

	}

}

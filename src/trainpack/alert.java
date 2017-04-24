package trainpack;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class alert {

	public static void main(String[] args) throws Exception {
	
		WebDriver driver=new FirefoxDriver();
		driver.get("http://www.seleniumframework.com/Practiceform/");
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.findElement(By.id("alert")).click();
		Thread.sleep(4000);
		
		String alerttext="Please share this website with your friends and in your organization.";
		
		if(alerttext.equalsIgnoreCase(driver.switchTo().alert().getText().trim()))
		{
		driver.switchTo().alert().accept();
		
		}
		else{System.out.println("It's not right popup please check");}
		Thread.sleep(2000);
		driver.close();

	}

}

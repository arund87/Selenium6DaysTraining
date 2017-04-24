package trainpack;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class alert1 {

	public static void main(String[] args) throws Exception {
	
		WebDriver driver=new FirefoxDriver();
		driver.get("https://www.w3schools.com/js/tryit.asp?filename=tryjs_alert");
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.switchTo().frame("iframeResult");
		driver.findElement(By.xpath("//button[text()='Try it']")).click();
		Thread.sleep(4000);
		
		String alerttext="I am an alert box!";
		
		if(alerttext.equalsIgnoreCase(driver.switchTo().alert().getText().trim()))
		{
		driver.switchTo().alert().accept();
		System.out.println("Test passed");
		
		}
		else{System.out.println("It's not right popup please check");}
		Thread.sleep(2000);
		driver.close();

	}

}

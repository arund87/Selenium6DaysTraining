package trainpack;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;

public class day1 {

	public static void main(String[] args) {
		
		//WebDriver driver=new FirefoxDriver();
		System.setProperty("webdriver.ie.driver", "C:\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://www.ultimatix.net/");
		driver.findElement(By.id("USER")).sendKeys("348027");
		driver.findElement(By.id("PASSWORD")).sendKeys("********");
		
		driver.findElement(By.xpath("//input[@id='user_login']")).sendKeys("ertr");
		
		driver.findElement(By.xpath("//label[text()='Username or Email Address']")).isDisplayed();
		
		driver.findElement(By.linkText("Forgot Username/Password? ")).click();
		driver.findElement(By.partialLinkText("Forgot")).click();
		
		
		driver.close();

	}

}

package trainpack;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
public class Sample {

	public static void main(String[] args) throws Exception {
		
		WebDriver driver=new FirefoxDriver();
		driver.get("http://demoqa.com/");
		  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		  driver.findElement(By.linkText("Registration")).click();
		  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		  driver.findElement(By.id("name_3_firstname")).sendKeys("Arun Kumar");
		  driver.findElement(By.id("name_3_lastname")).sendKeys("Deivakumar");
		  driver.findElement(By.xpath("//input[@name='radio_4[]' and @value='married']")).click();
		  driver.findElement(By.xpath("//input[@value='reading']")).click();
		  Select country=new Select(driver.findElement(By.name("dropdown_7")));
		  country.selectByValue("Algeria");
		  Select month=new Select(driver.findElement(By.id("mm_date_8")));
		  month.selectByValue("2");
		  Select day=new Select(driver.findElement(By.id("dd_date_8")));
		  day.selectByValue("6");
		  Select year=new Select(driver.findElement(By.id("yy_date_8")));
		  year.selectByValue("2008");
		  driver.findElement(By.id("phone_9")).sendKeys("9884570793");
		  driver.findElement(By.id("username")).sendKeys("Arunkumar");
		  driver.findElement(By.id("email_1")).sendKeys("arund87@gmail.com");
		  driver.findElement(By.id("description")).sendKeys("No Comments");
		  driver.findElement(By.id("password_2")).sendKeys("Password@123");
		  driver.findElement(By.id("confirm_password_password_2")).sendKeys("Password@123");
		  driver.findElement(By.name("pie_submit")).click();
		  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		  
		 // driver.findElement(By.xpath("//p[text()='Thank you for your registration']")).isDisplayed();
		  Thread.sleep(2000);

	}

}

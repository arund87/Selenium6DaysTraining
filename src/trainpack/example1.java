package trainpack;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class example1 {

	public static void main(String[] args) {
		
		WebDriver driver=new FirefoxDriver();
		driver.get("http://demoqa.com/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.linkText("Registration")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//h1[text()='Registration']")).isDisplayed();
		driver.findElement(By.id("name_3_firstname")).sendKeys("Arunkumar");
		driver.findElement(By.id("name_3_lastname")).sendKeys("Deivekumar");
		driver.findElement(By.xpath("//input[@value='single']")).click();
		driver.findElement(By.xpath("//input[@value='cricket ']")).click();
		Select dd1=new Select(driver.findElement(By.id("dropdown_7")));
		dd1.selectByVisibleText("Algeria");
		Select dd2=new Select(driver.findElement(By.id("mm_date_8")));
		dd2.selectByVisibleText("7");
		Select dd3=new Select(driver.findElement(By.id("dd_date_8")));
		dd3.selectByVisibleText("5");
		Select dd4=new Select(driver.findElement(By.id("yy_date_8")));
		dd4.selectByVisibleText("2013");
		driver.findElement(By.id("phone_9")).sendKeys("9665412358");
		driver.findElement(By.id("username")).sendKeys("arunkumards");
		driver.findElement(By.id("email_1")).sendKeys("arunkumards@gmail.com");
		driver.findElement(By.id("password_2")).sendKeys("Arun@7890");
		driver.findElement(By.id("confirm_password_password_2")).sendKeys("Arun@7890");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//input[@value='Submit']")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		String expected="Thank you for your registration";
		WebElement actual=driver.findElement(By.xpath(".//*[@id='post-49']/div/p"));
		Assert.assertEquals(actual.getText(), expected);
		driver.close();

	}

}

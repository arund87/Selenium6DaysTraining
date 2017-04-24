package trainpack;
import java.io.File;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;


public class failurescrreshottestng {
	
WebDriver driver;
	
	public void capturescreen(WebDriver driver, String name)
	{
		try {
			  TakesScreenshot clk=(TakesScreenshot)driver;
			  File source=clk.getScreenshotAs(OutputType.FILE);
			  FileUtils.copyFile(source,new File("./screenshot/"+name+".jpg"));
			} catch (Exception e) {
				e.printStackTrace();
			}
	}
	
	@Test
	public void test1() throws InterruptedException
	{
		driver =new FirefoxDriver();
		driver.get("http://newtours.demoaut.com/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		capturescreen(driver,"Registerpage");
		Thread.sleep(3000);
		driver.findElement(By.linkText("REGISTER")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.name("firstName")).sendKeys("arunkumar");
		//driver.findElement(By.name("lastName")).sendKeys("Deivakumar");
		
		//fail
		driver.findElement(By.name("lastNameesggh")).isDisplayed();
		Thread.sleep(3000);
		driver.close();
	}
	
	@Test
	public void test2() throws InterruptedException
	{
		driver.findElement(By.name("phone")).sendKeys("Deivakumar");
		//driver.findElement(By.name("userName")).sendKeys("arun@test.com");
		//fail
		driver.findElement(By.name("userNameecd")).sendKeys("arun@test.com");
	}
	
	@Test
	public void test3() throws InterruptedException
	{
		driver.findElement(By.name("address1")).sendKeys("Tidel");
		//driver.findElement(By.name("city")).sendKeys("Chennai");
		//fail
		driver.findElement(By.name("cityesr")).sendKeys("Chennai");
	}
	

	  @AfterMethod
	  public void tearDown(ITestResult result)
	  {
		  if(ITestResult.FAILURE==result.getStatus())
		  {
			  String filename=result.getName();
			  capturescreen(driver,filename);
		  }
	  }
	  
	@AfterTest
	public void bclose()
	{
		driver.close();
	}
	

	

	
}

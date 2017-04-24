package trainpack;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class testngdataprovider {
WebDriver driver;
	
	@Test(dataProvider="logindetails")
	public void login(String username, String Password) throws InterruptedException
	{
		driver=new FirefoxDriver();
		driver.get("http://newtours.demoaut.com/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.name("userName")).sendKeys(username);
		driver.findElement(By.name("password")).sendKeys(Password);
		//driver.findElement(By.name("login")).click();
		Thread.sleep(3000);
		driver.close();
	}
	
	@DataProvider(name="logindetails")
	public Object[][] logindata()
	{
		Object[][] data=new Object[2][2];
		
		data[0][0]="arund87@gmail.com";
		data[0][1]="pass123";
		
		data[1][0]="venugopal@gmail.com";
		data[1][1]="pass456";
		
		return data;
	}

}

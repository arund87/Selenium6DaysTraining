package trainpack;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class datadrivenexample {
	WebDriver driver;
	Flightlib config = new Flightlib();
	public int rescolumn=13;public int resrow=0;
	public String xlpath="C:\\Users\\348027\\webexselenium\\Training\\lib\\Injectfile.xls";
	
	@Test(dataProvider = "Registration")
	public void regtest(String name1, String name2, String pnone, String username, String address1, String address2,
			String city, String state, String pincode, String country, String email, String passwd1, String passwd2)
			throws InterruptedException {
		resrow=resrow+1;
		driver = new FirefoxDriver();
		driver.get("http://newtours.demoaut.com/");
		driver.manage().window().maximize();
		driver.findElement(By.linkText("REGISTER")).click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElement(By.name("firstName")).sendKeys(name1);
		driver.findElement(By.name("lastName")).sendKeys(name2);
		driver.findElement(By.name("phone")).sendKeys(pnone);
		driver.findElement(By.id("userName")).sendKeys(username);
		driver.findElement(By.name("address1")).sendKeys(address1);
		driver.findElement(By.name("address2")).sendKeys(address2);
		driver.findElement(By.name("city")).sendKeys(city);
		driver.findElement(By.name("state")).sendKeys(state);
		driver.findElement(By.name("postalCode")).sendKeys(pincode);
		Select countryname = new Select(driver.findElement(By.name("country")));
		countryname.selectByVisibleText(country);
		driver.findElement(By.id("email")).sendKeys(email);
		driver.findElement(By.name("password")).sendKeys(passwd1);
		driver.findElement(By.name("confirmPassword")).sendKeys(passwd2);
		driver.findElement(By.name("register")).click();
		Thread.sleep(2000);
		driver.findElement(By.linkText("SIGN-OFF")).click();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		driver.close();

	}

	// Data provider for Registration.
	@DataProvider(name = "Registration")
	public Object[][] passData() {
		config.Excelpath(xlpath, 0);
		int rows = config.Excelcount();
		int roww = rows - 1;
		Object[][] data = new Object[roww][13];
		for (int i = 1; i < rows; i++) {
			for (int j = 0; j < 13; j++) {
				int k = i - 1;
				data[k][j] = config.Exceldata(i, j);						
			}
		}

		return data;
	}

	@AfterMethod
	public void tearDown(ITestResult result) {
		
		if (ITestResult.FAILURE == result.getStatus()) {
			config.captureScreenshot(driver, result.getName());
			config.writeresult(xlpath, resrow, rescolumn, "FAIL");
			driver.close();
		}else{
			config.writeresult(xlpath, resrow, rescolumn, "PASS");
		}
	}

}

package trainpack;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class mouseover {

	public static void main(String[] args) throws Exception {
TrainingLibrary library=new TrainingLibrary();
		
		WebDriver driver=new FirefoxDriver();
		WebDriverWait wait = new WebDriverWait(driver, 60);
		driver.get("https://www.ultimatix.net");
		driver.manage().window().maximize();
		driver.findElement(By.id("USER")).sendKeys(library.username);
		driver.findElement(By.id("PASSWORD")).sendKeys(library.password);
		driver.findElement(By.id("ALIAS_CHECK")).click();
		driver.findElement(By.id("login_button")).click(); 
								
			
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String mouseOverScript =
                "if(document.createEvent){var evObj = document.createEvent('MouseEvents');evObj.initEvent('mouseover', true, false); arguments[0].dispatchEvent(evObj);} else if(document.createEventObject) { arguments[0].fireEvent('onmouseover');}";
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.partialLinkText("Employee Services")));
		js.executeScript(mouseOverScript, element);

		
		Thread.sleep(4000);
		driver.findElement(By.partialLinkText("My Allocation & Utilization")).isDisplayed();
		driver.close();

	}

}

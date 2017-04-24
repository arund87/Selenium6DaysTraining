package trainpack;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class scroll {

	public static void main(String[] args) throws Exception {
		WebDriver driver=new FirefoxDriver();
		driver.get("http://demoqa.com/registration/");
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);
		JavascriptExecutor javascript = (JavascriptExecutor) driver;  
		javascript.executeScript("window.scrollBy(0,900)", "");
        Thread.sleep(3000);
        
        WebElement element=driver.findElement(By.partialLinkText("Home"));
        javascript.executeScript("arguments[0].scrollIntoView(true);",element);
        Thread.sleep(3000);
        driver.close();

	}

}

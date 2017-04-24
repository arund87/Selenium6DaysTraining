package trainpack;
import java.io.File;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class screenshot {

	public static void main(String[] args) throws Exception {
		WebDriver driver=new FirefoxDriver();
		driver.get("http://newtours.demoaut.com/");
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);
		try {
			  TakesScreenshot clk=(TakesScreenshot)driver;
			  File source=clk.getScreenshotAs(OutputType.FILE);
			  FileUtils.copyFile(source,new File("./screenshot/capture.jpg"));
			} catch (Exception e) {
				e.printStackTrace();
			}
		Thread.sleep(3000);
		driver.close();

	}
		

	}



package trainpack;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class webtable {
	
	public static void traveldate(WebDriver driver, String path, String selectdate)
	{
		List<WebElement> dates=driver.findElements(By.xpath(path));
		int datessize=dates.size();
		for(int i=0; i<datessize; i++)
		{
		    String date=dates.get(i).getText();
		    System.out.println(date);
		    if(date.equalsIgnoreCase(selectdate))
		    {
		    	dates.get(i).click();
		    	break;
		    }
			
		}
		return;
	}

	public static void main(String[] args) throws Exception {
		WebDriver driver=new FirefoxDriver();
		driver.get("https://www.redbus.in/");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElement(By.xpath(".//*[@class='fl icon-calendar_icon-new icon-onward-calendar icon']")).click();
		Thread.sleep(5000);
		
		traveldate(driver,".//*[@id='rb-calendar_onward_cal']/table[1]//td","15");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		Thread.sleep(5000); 
		
		driver.findElement(By.xpath(".//*[@class='fl icon-calendar_icon-new icon-return-calendar icon']")).click();
		Thread.sleep(5000);
		
		traveldate(driver,".//*[@id='rb-calendar_return_cal']/table[1]//td","17");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		
		Thread.sleep(2000);
		driver.close();

	}

}

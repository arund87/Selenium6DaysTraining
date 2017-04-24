package trainpack;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class DDDC {

	public static void main(String[] args) throws Exception {
		WebDriver driver=new FirefoxDriver();
		
		//Drag and Drop
		driver.get("http://demoqa.com/droppable/");
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);
		Actions action = new Actions(driver);
		
		WebElement src=driver.findElement(By.id("draggableview"));
		WebElement dest=driver.findElement(By.id("droppableview"));
		action.dragAndDrop(src, dest).perform();
		Thread.sleep(3000);
		
		//Double Click
		driver.get("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_ondblclick");
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);
		driver.switchTo().frame("iframeResult");
		Thread.sleep(2000);
		WebElement element=driver.findElement(By.xpath("//p[@ondblclick='myFunction()']"));
		action.doubleClick(element).build().perform();
		Thread.sleep(3000);
		driver.close();

	}

}

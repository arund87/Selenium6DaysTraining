package trainpack;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;


public class windowhandle {

	public static void main(String[] args) throws Exception {
		
		TrainingLibrary library=new TrainingLibrary();
		
		WebDriver driver=new FirefoxDriver();
		driver.get("https://www.ultimatix.net");
		driver.manage().window().maximize();
		driver.findElement(By.id("USER")).sendKeys(library.username);
		driver.findElement(By.id("PASSWORD")).sendKeys(library.password);
		driver.findElement(By.id("ALIAS_CHECK")).click();
		driver.findElement(By.id("login_button")).click(); 
		String parentw=driver.getWindowHandle();
						
		WebElement lnkES=driver.findElement(By.partialLinkText("Employee Services"));
		Actions builder=new Actions(driver);
		Action mouseOverHome = builder.moveToElement(lnkES).build();
		mouseOverHome.perform();
		Thread.sleep(7000);
		driver.findElement(By.partialLinkText("My Allocation & Utilization")).click();
						
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		Set<String> s1=driver.getWindowHandles();
		
		Iterator<String> i1=s1.iterator();
		
		while(i1.hasNext()){
		String childw=i1.next();
		if(!parentw.equalsIgnoreCase(childw))
		{
		driver.switchTo().window(childw);
		Thread.sleep(7000);

		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElement(By.id("frmPortal:_idJsp40")).click();
		String projectno=driver.findElement(By.id("frmPortal:allocationTable2:0:_idJsp107")).getText();
		System.out.println("Project number: "+projectno);		
		driver.findElement(By.id("frmPortal:allocationTable2:0:_idJsp107")).click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		driver.findElement(By.xpath("//label[text()='D, MR. Arun Kumar (Arun Kumar)']")).isDisplayed();
		driver.findElement(By.xpath("//label[text()='348027']")).isDisplayed();

		System.out.println("You are allocated in this project");
		driver.close();
		}
		}
		driver.switchTo().window(parentw);
		driver.findElement(By.partialLinkText("Logout")).click();
		driver.findElement(By.id("logoutbutton")).click();
		driver.close();
	}

}

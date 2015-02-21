import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;



public class ContextClick {
	
	WebDriver driver;
	
	@BeforeTest
	public void setUp() {
		this.driver = new Helper().initFirefox();
	}

	
	
	@Test
	public void testContextClick() {
		driver.get(Constants.BASEURL);
		WebElement contextElement = driver.findElement(By.id("div-context"));	
		
		Actions action =new Actions(driver);		
		
		action.contextClick(contextElement)
		.click(driver.findElement(By.name("Item 4"))).perform();
		
		Alert alert = driver.switchTo().alert();
		System.out.println(alert.getText());
		alert.accept();		
/*		
		try {
			Robot robot = new Robot();		
			
			robot.keyPress(KeyEvent.VK_ENTER);
			
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	*/
		
	}
	@AfterTest
	public void tearDown() {
		//driver.quit();
	}
}

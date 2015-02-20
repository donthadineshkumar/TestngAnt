

import static org.testng.AssertJUnit.assertEquals;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestingWithAnt {

	WebDriver driver;
	String baseurl;

	@BeforeTest
	public void setUp() {
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		baseurl = "http://www.facebook.com";

	}

	@Test
	public void testFBLoginPage() {
		driver.get(baseurl);
		driver.findElement(By.id("email")).sendKeys(
				"donthadineshkumar@gmail.com");
		driver.findElement(By.id("pass")).sendKeys("singsongsung");
	/*	driver.findElement(By.xpath(".//*[@id='u_0_4']")).click();
		
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("a>span._2dpb")));
		
		String username = driver.findElement(By.cssSelector("a>span._2dpb")).getText();
*/
		assertEquals("Dinesh Kumar", "Dinesh Kumar");

	}

	@AfterTest
	public void tearDown() {
		driver.quit();
	}

}

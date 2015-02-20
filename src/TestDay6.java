

import static org.testng.AssertJUnit.assertEquals;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestDay6 {
	
	WebDriver  driver;
	String baseurl;
	String userEmail ="dinesh2@gmail.com";
	String userPwd = "Password";
	
	@BeforeTest
	public void setUp() {
		
		File file = new File("/home/dinesh/Downloads/JavaDownloads/chromedriver/2.12/chromedriver");
		System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
		driver = new ChromeDriver();
		baseurl = "http://live.guru99.com";
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}
	
	
	@Test
	public void testDay6() throws InterruptedException {
		
		driver.get(baseurl);
		
		//driver.findElement(By.xpath("//header[@id='header']/div/div[2]/div/a/span[2]")).click();
		driver.findElement(By.xpath("//a/span[contains(text(),'Account')]")).click();
		driver.findElement(By.xpath("//a[@title='My Account']")).click();
		
		driver.findElement(By.id("email")).clear();
		driver.findElement(By.id("email")).sendKeys(userEmail);
		
		driver.findElement(By.id("pass")).clear();
		driver.findElement(By.id("pass")).sendKeys(userPwd);
		
		driver.findElement(By.id("send2")).click();
		
		
		
		WebElement element =driver.findElement(By.linkText("MY WISHLIST"));
		
		element.click();
		
	//	driver.wait(2000);
		
		driver.findElement(By.xpath("//button[@title='Add to Cart']")).click();
		driver.findElement(By.xpath("//button[@title='Proceed to Checkout']")).click();
		
		//entering billing info
		driver.findElement(By.id("billing:street1")).sendKeys("ABC");
		driver.findElement(By.id("billing:city")).sendKeys("New York");
		
		new Select(driver.findElement(By.id("billing:region_id"))).selectByVisibleText("New York");
		
		driver.findElement(By.id("billing:postcode")).sendKeys("542896");
		
		new Select(driver.findElement(By.id("billing:country_id"))).selectByVisibleText("United States");
		
		driver.findElement(By.id("billing:telephone")).sendKeys("12345678");
		
		driver.findElement(By.cssSelector("#billing-buttons-container > button.button")).click();
		
		
		
		String flatrate = driver.findElement(By.cssSelector("label>span.price")).getText();
		System.out.println(flatrate);
		
		try {
			assertEquals(flatrate,"$5.00");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		driver.findElement(By.cssSelector("#shipping-method-buttons-container > button.button")).click();
		
		driver.findElement(By.id("p_method_checkmo")).click();
		
		driver.findElement(By.cssSelector("#payment-buttons-container > button.button")).click();
		
		
		
		
		
		
		String subTotalString = driver.findElement(By.xpath(".//*[@id='checkout-review-table']/tfoot/tr[1]/td[2]/span")).getText().substring(1);
		float subTotal  = Float.parseFloat(subTotalString);
		
		
		String grandTotalString = driver.findElement(By.xpath(".//*[@id='checkout-review-table']/tfoot/tr[3]/td[2]/strong/span")).getText().substring(1);
		float grandTotal  = Float.parseFloat(grandTotalString);
		
		float shippingRate  = Float.parseFloat(flatrate.substring(1));
		
		System.out.println("shipping rate: "+flatrate +" grandTotal: $"+grandTotalString+
				" subTotal: $"+subTotal);
		
		try {
			//this verify shipping total is added to grand total
			assertEquals(shippingRate,grandTotal-subTotal);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		driver.findElement(By.cssSelector("#review-buttons-container > button.button")).click();
	/*	
		String orderConfirmMsg =driver.findElement(By.cssSelector("div.page-title>h1")).getText();
		
		try {
			
			assertEquals(orderConfirmMsg,"Your order has been received.");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		String orderNumber = driver.findElement(By.cssSelector("div.col-main>p>a")).getText();
		System.out.println("Order number is generated :"+ orderNumber);
		
	}
	
	
	@AfterTest
	public void tearDown() {
		
	}

}

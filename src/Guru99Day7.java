import static org.testng.AssertJUnit.assertTrue;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
/*import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.event.AWTEventListener;*/




public class Guru99Day7{

	WebDriver driver;
	FetchElements fetch;
	
	@BeforeTest
	public void setUp(){
		driver = new Helper().initFirefox();
		fetch =new FetchElements(driver);
	}
	
	@Test
	public void testPDFGeneration() throws InterruptedException{
		driver.get(Constants.GURU99_URL);
		fetch.getElement("XPATH", "//a/span[contains(text(),'Account')]").click();
		driver.findElement(By.xpath("//a[@title='My Account']")).click();
		fetch.getElement("ID", "email").clear();
		fetch.getElement("ID", "email").sendKeys("dinesh@gmail.com");
		fetch.getElement("ID", "pass").clear();
		fetch.getElement("ID", "pass").sendKeys("Password");
		fetch.getElement("ID", "send2").click();
		fetch.getElement("LINK", "MY ORDERS").click();
		fetch.getElement("LINK", "VIEW ORDER").click();
		String orderStatus =fetch.getElement("XPATH", "//h1").getText();
		System.out.println("Order Status: "+ orderStatus);
		assertTrue(orderStatus.contains("PENDING"));
		fetch.getElement("LINK", "Print Order").click();
		
		
		//Commented - Pushing to git to make jenkins build
/*		Thread.sleep(5000);
		Robot rb;
		try {
			rb = new Robot();
			rb.keyPress(KeyEvent.VK_TAB);
			rb.keyRelease(KeyEvent.VK_TAB);
			rb.keyPress(KeyEvent.VK_TAB);
			rb.keyRelease(KeyEvent.VK_TAB);
			rb.keyPress(KeyEvent.VK_COPY);
			rb.keyRelease(KeyEvent.VK_COPY);
			//rb.keyPress(KeyEvent.VK_ALT);
			rb.keyPress(KeyEvent.VK_PASTE);
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
			
	}
	
	
	
/*	public void onPaste(){
	    Clipboard c = Toolkit.getDefaultToolkit().getSystemClipboard();
	    Transferable t = c.getContents(this);
	    String pdfStatus;
		try {
			pdfStatus = (String) t.getTransferData(DataFlavor.stringFlavor);
			  System.out.println(pdfStatus);
		} catch (UnsupportedFlavorException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	  
	}*/
	
	@AfterTest
	public void tearDown(){
		
	}


	
}

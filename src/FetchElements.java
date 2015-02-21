import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FetchElements {
	


	WebDriver driver;
	WebElement element;
	
	

	public FetchElements(WebDriver driver) {
		
		this.driver =driver;
	}

	public WebElement getElement(String way,
			String findMe) {	
		

		switch (way) {
		case "CSS":
			element = driver.findElement(By.cssSelector(findMe));
			break;
			
		case "XPATH":
			element = driver.findElement(By.xpath(findMe));
			break;

		case "ID":
			element = driver.findElement(By.id(findMe));
			break;
			
		case "NAME":
			element = driver.findElement(By.name(findMe));
			break;
			
		case "LINK":
			element = driver.findElement(By.linkText(findMe));
			break;
			
		case "PLINK":
			element = driver.findElement(By.partialLinkText(findMe));
			break;
			
		default:
			break;
		}

		return element;
	}

}

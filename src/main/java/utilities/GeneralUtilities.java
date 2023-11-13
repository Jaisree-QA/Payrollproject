package utilities;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Random;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.FluentWait;

public class GeneralUtilities {

	public String getElementtext(WebElement element) {
		return element.getText();
	}
	
	public boolean getviewDisplay(WebElement element) {
		return element.isDisplayed();
	}
	public boolean getviewEnabled(WebElement element) {
		return element.isEnabled();
	}

	public boolean getViewSelect(WebElement element) {
		return element.isSelected();
	}
	
	public String getTitle(WebElement element) {
		return element.getTagName();
	}
	public void alertAccept(WebDriver driver) {
		driver.switchTo().alert().accept();
	}
	public void alertDismiss(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}

	public String alertText(WebDriver driver) {
	return	driver.switchTo().alert().getText();
	}
	 public void selectField(String value, WebElement element) {
	        
	        element.sendKeys(value);
	    }
	public void browseActions(WebDriver driver, WebElement element) {

		Actions obj = new Actions(driver);
		obj.moveToElement(element).click().perform();
	}
	public void scrolLing(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,4500)");		//scroll code

	}

	public void saveButton(WebDriver driver, WebElement element) {

		// Create a JavaScriptExecutor instance
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;

		// Use JavaScriptExecutor to click the element
		jsExecutor.executeScript("arguments[0].click();", element);
	}
	public void explicitWait(WebDriver driver) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));// Explicit wait
		wait.until(ExpectedConditions.alertIsPresent());
		
		}
	public void explicitWaittwo(WebDriver driver, WebElement element) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));// Explicit wait
	wait.until(ExpectedConditions.elementToBeClickable(element));		
		}	
	
	public void FluentWait(WebDriver driver, WebElement element) {
		
		FluentWait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver)			  
				 .withTimeout(Duration.ofSeconds(30)) .pollingEvery(Duration.ofSeconds(3))
				 .ignoring(NoSuchElementException.class);
				 fluentWait.until(ExpectedConditions.elementToBeClickable(element));			
	}
	 public void clickElement(WebElement element) {
	        element.click();
	    }
	public int randon() {
		Random random = new Random();
		int limit = 1000;
		int randomNumber = random.nextInt(limit);// Random no limit
		return randomNumber;
	}

// generate current data and time inorder to diffentiate
	public String generateCurrentDateAndTime() {
		Date date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("ddMMyyhhmmss");
		return formatter.format(date);
	}
	public boolean asssertEquals(boolean actual, boolean expected, String message) {
		return expected;
        
    }
}

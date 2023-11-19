package elementRepository;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Excelworkbook;
import org.openqa.selenium.WebElement;

public class LoginPage {
	WebDriver driver;
	static Excelworkbook ew = new Excelworkbook();
	Homepage hp = new Homepage(driver);

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);// with page factory
	}

	@FindBy(xpath = "//input[@id='loginform-username']")
	WebElement usernameField;
	@FindBy(id = "loginform-password")
	WebElement passwordField;
	@FindBy(xpath = "//button[@name='login-button']")
	WebElement logclickField;

	public void sendUsername() {
		try {
			String username = Excelworkbook.stringDataReader(1, 0);
			usernameField.sendKeys(username);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void sendPassword() {
		try {
			String password = Excelworkbook.stringDataReader(1, 1);
			passwordField.sendKeys(password);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void sendUsername(String username, String Password) {

		usernameField.sendKeys(username);
		passwordField.sendKeys(Password);
	}

	public void logClick() {
		logclickField.click();
	}
	public String expectedAssert(int row, int col) {
	
			return Excelworkbook.dataReaderforAssert(row, col);
}
	}
	

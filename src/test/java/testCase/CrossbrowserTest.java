package testCase;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class CrossbrowserTest {

	WebDriver driver;
	
	@BeforeMethod(alwaysRun = true)
	@Parameters("browser")
	public void CrossTest(String browserName) {
		if (browserName.equals("chrome")) {

			System.setProperty("webdriver.chrome.driver",			
					System.getProperty("user.dir") + "\\src\\main\\resources\\Driver\\chromedriver.exe");
			driver = new ChromeDriver();
				
			
		} else if (browserName.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver",			
							System.getProperty("user.dir") + "\\src\\main\\resources\\Driver\\chromedriver.exe");
					
			driver = new FirefoxDriver();
		} else {
			throw new IllegalArgumentException("Invalid browser name: ");
/*
			
			  else if (browserName.equals("edge")) {
			  
			  WebDriverManager.firefoxdriver().setup();
			  
			  WebDriver driver=new FirefoxDriver();	*/   
			 
		}

		driver.get("https://www.qabible.in/payrollapp/"); // it will wait till loading
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(10000));
	}

	@AfterMethod(alwaysRun = true) // to run always
	public void afterMethod() {
		driver.close();
	}
}

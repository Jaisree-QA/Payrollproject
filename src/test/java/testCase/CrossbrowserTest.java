package testCase;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;
import utilities.ConfigFileReader;

public class CrossbrowserTest {
	WebDriver driver;
	ConfigFileReader cf;

	@BeforeMethod(alwaysRun = true)
	@Parameters("browser")
	@Test
	public void CrossTest(String browserName) {
		cf = new ConfigFileReader();
		cf.testBasicHandling();
		if (browserName.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (browserName.equals("firefox")) {
			WebDriverManager.chromedriver().setup();
			driver = new FirefoxDriver();
		}
		driver.get(ConfigFileReader.pro.getProperty("baseURL"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(10000));
	}

	@AfterMethod(alwaysRun = true) // to run always
	public void afterMethod() {
		driver.quit();
	}
}
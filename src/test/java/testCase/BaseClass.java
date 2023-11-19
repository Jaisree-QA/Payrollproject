package testCase;

import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;
import utilities.ConfigFileReader;
import utilities.ScreenShotCapture;
import java.io.IOException;
import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;

public class BaseClass {
	WebDriver driver;
	ScreenShotCapture sc;
	ConfigFileReader cf;

	@BeforeMethod(alwaysRun = true)

	public void beforeMethod() {
		cf = new ConfigFileReader();
		cf.testBasicHandling();
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get(ConfigFileReader.pro.getProperty("baseURL"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(10000));
	}

	@AfterMethod(alwaysRun = true)
	public void afterMethod(ITestResult iTestResult) throws IOException {
		
		try {
			if (iTestResult.getStatus() == ITestResult.FAILURE) { 
				sc = new ScreenShotCapture();
				sc.captureFailureScreenShot(driver, iTestResult.getName());
			}
		} 
	
	finally {
        
        if (driver != null) {
            driver.quit();
        }
    }
}
}
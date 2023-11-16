package testCase;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import utilities.ScreenShotCapture;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;

public class BaseClass {
	WebDriver driver;
	ScreenShotCapture sc;
	public static Properties pro;
@Test
	public static void testBasic() throws IOException {

		pro = new Properties(); // for url pulling
		FileInputStream fp = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\main\\resources\\Properties\\config.properties");
		pro.load(fp);
	}
	
	@BeforeMethod(alwaysRun = true)

	
	public void beforeMethod() {		
		try {
			testBasic(); // for loading method
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.setProperty(pro.getProperty("ChromeDriver"),			
				System.getProperty("user.dir") + "\\src\\main\\resources\\Driver\\config.properties");
		
		driver = new ChromeDriver();

		driver.get(pro.getProperty("baseURL"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(10000));
	}

	 @AfterMethod(alwaysRun = true) 
	 	public void afterMethode(ITestResult iTestResult) throws IOException { 
	 		if (iTestResult.getStatus() == ITestResult.FAILURE) { //itest listener
	 			sc = new ScreenShotCapture(); 
	 			sc.captureFailureScreenShot(driver, iTestResult.getName()); 
	 		}		 
	 		driver.close(); 
	 	}
}
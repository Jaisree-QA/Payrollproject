package testCase;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import constant.Constant;
import elementRepository.Homepage;
import elementRepository.LoginPage;
import utilities.Retry;

public class LoginPageTest extends BaseClass {
	LoginPage lp;
	Homepage hp;
	Retry Retry;
	@Test(enabled=true)
	public void loginPage() {
		lp = new LoginPage(driver);
		hp = new Homepage(driver);
		lp.sendUsername();
		lp.sendPassword();
		lp.logClick();
		String actual = hp.getHomepagetext();
		String expected = lp.expectedAssert(0, 0);
		Assert.assertEquals(actual, expected, Constant.ms_verifyValid);
	}

	@Test(dataProvider = "data-provider") 

	public void verifyValid(String username, String password) {
		hp = new Homepage(driver);
		lp = new LoginPage(driver);
		lp.sendUsername(username, password);
		lp.logClick();
		String actual = hp.getHomepagetexts();
		String expected = lp.expectedAssert(1, 0);
		Assert.assertEquals(actual, expected, Constant.ms_verifyValid);

	}

	@DataProvider(name = "data-provider")
	public Object[][] dpMethod() {
		return new Object[][] { { "carol", "5q2w3e4r" }, { "marol", "1q2w3e4r" }, { "marol", "8q2w3e4r" } };
	}
}

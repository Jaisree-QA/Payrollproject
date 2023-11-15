package testCase;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constant;
import elementRepository.Createclient;
import elementRepository.Homepage;
import elementRepository.LoginPage;
import utilities.Excelworkbook;
import utilities.GeneralUtilities;

public class CreateclientTest extends BaseClass {
	LoginPage lp;
	Homepage hp;
	Createclient cc;
	GeneralUtilities gu;
	Excelworkbook eu;

	@Test (priority=7,enabled = true)
	public void clientpageAssert() {

		lp = new LoginPage(driver);
		hp = new Homepage(driver);
		lp.sendUsername();
		lp.sendPassword();
		lp.logClick();
		hp.clientTag();
		String actual = hp.getClientpagetext();
		String expected = "CLIENTS";
		Assert.assertEquals(actual, expected, Constant.ms_clientpageAssert);
	}

	@Test (enabled = true)
	public void createClientpageAssert() {

		lp = new LoginPage(driver);
		hp = new Homepage(driver);
		lp.sendUsername();
		lp.sendPassword();
		lp.logClick();
		hp.clientTag();
		hp.createClientTag();
		String actual = hp.getCreateclientpagetexts();
		String expected = "CREATE CLIENT";
		Assert.assertEquals(actual, expected, Constant.ms_createClientpageAssert);
	}

	@Test(priority=8,enabled = true)

	public void clientDetails() {

		lp = new LoginPage(driver);
		hp = new Homepage(driver);
		cc = new Createclient(driver);

		lp.sendUsername();
		lp.sendPassword();
		lp.logClick();
		hp.clientTag();
		hp.createClientTag();
		hp.selectDrop();
		cc.refField();
		cc.selectSettlementDays();
		cc.selectingAllCheckBox();
		cc.selectSave();
		String actual = hp.getdavidtext();
		String expected = "DAVID";
		Assert.assertEquals(actual, expected, Constant.ms_createClientpageAssert);

	}
	
	@Test(priority=9,enabled = true)

	public void updateClient() {
		lp = new LoginPage(driver);
		hp = new Homepage(driver);
		cc = new Createclient(driver);

		lp.sendUsername();
		lp.sendPassword();
		lp.logClick();
		hp.clientTag();
		cc.clientNameSearch();
		cc.searchButton();
		cc.validatingClient();
		cc.pencilButton();	
	boolean actual = cc.pencilButton();
	boolean expected = true;
		Assert.assertEquals(actual, expected, Constant.ms_createClientpageAssert);
	}	
	
	@Test(priority=10,enabled = true)

	public void updatingFeatures() {
		lp = new LoginPage(driver);
		hp = new Homepage(driver);
		cc = new Createclient(driver);
		
		lp.sendUsername();
		lp.sendPassword();
		lp.logClick();
		hp.clientTag();
		cc.clientNameSearch();
		cc.searchButton();
		cc.validatingClient();
		cc.clickElementWithRetry();		
		hp.selectDrop();
		cc.selectSave();
		String actual = hp.eyeHeadText();
		String expected = "AKSHAY".toUpperCase();
		Assert.assertEquals(actual, expected, Constant.ms_createClientpageAssert);		
	}	
	
	@Test(priority=11,enabled = true)

	public void viewClient() {
		lp = new LoginPage(driver);
		hp = new Homepage(driver);
		cc = new Createclient(driver);

		lp.sendUsername();
		lp.sendPassword();
		lp.logClick();
		hp.clientTag();
		cc.clientNameSearch();
		cc.searchButton();
		cc.validatingClient();
		cc.eyeButton();	
		boolean actual = cc.eyeButton();
		boolean expected = true;
			Assert.assertEquals(actual, expected, Constant.ms_createClientpageAssert);
		}
	@Test(priority=12,enabled = true)

	public void withoutSearch() {
		lp = new LoginPage(driver);
		hp = new Homepage(driver);
		cc = new Createclient(driver);

		lp.sendUsername();
		lp.sendPassword();
		lp.logClick();
		hp.clientTag();
		cc.directEye();	
		String actual = hp.clienteyeText();
		String expected = "~amal_xaviourupd".toUpperCase();
		Assert.assertEquals(actual, expected, Constant.ms_createClientpageAssert);
	}
	@Test(priority=13,enabled = true)

	public void deductionPage() {
		lp = new LoginPage(driver);
		hp = new Homepage(driver);
		cc = new Createclient(driver);

		lp.sendUsername();
		lp.sendPassword();
		lp.logClick();
		hp.deductionTag();
		cc.allAmountDed();
		int actual = cc.allAmountDed();
		int expected = 12893725;
		Assert.assertEquals(actual, expected, Constant.ms_createClientpageAssert);
	}
		
		
}


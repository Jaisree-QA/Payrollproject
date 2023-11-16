package testCase;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constant;
import elementRepository.Createclient;
import elementRepository.Homepage;
import elementRepository.LoginPage;

public class CreateclientTest extends BaseClass {
	
	LoginPage login;
	Homepage home;
	Createclient createclient;


	@Test (priority=7,enabled = true)
	public void clientpageAssert() {

		login = new LoginPage(driver);
		home = new Homepage(driver);
		login.sendUsername();
		login.sendPassword();
		login.logClick();
		home.clientTag();
		String actual = home.getClientpagetext();
		String expected = "CLIENTS";
		Assert.assertEquals(actual, expected, Constant.ms_clientpageAssert);
		
	}

	@Test (enabled = true)
	public void createClientpageAssert() {

		login = new LoginPage(driver);
		home = new Homepage(driver);
		login.sendUsername();
		login.sendPassword();
		login.logClick();
		home.clientTag();
		home.createClientTag();
		String actual = home.getCreateclientpagetexts();
		String expected = "CREATE CLIENT";
		Assert.assertEquals(actual, expected, Constant.ms_createClientpageAssert);
	}

	@Test(priority=8,enabled = true)

	public void saveclientDetails() {

		login = new LoginPage(driver);
		home = new Homepage(driver);
		createclient = new Createclient(driver);

		login.sendUsername();
		login.sendPassword();
		login.logClick();
		home.clientTag();
		home.createClientTag();
		home.selectDrop();
		createclient.refField();
		createclient.selectSettlementDays();
		createclient.selectingAllCheckBox();
		createclient.selectSave();
		String actual = home.getdavidtext();
		String expected = "DAVID";
		Assert.assertEquals(actual, expected, Constant.ms_createClientpageAssert);

	}
	
	@Test(priority=9,enabled = true)

	public void updateClient() {
		login = new LoginPage(driver);
		home = new Homepage(driver);
		createclient = new Createclient(driver);

		login.sendUsername();
		login.sendPassword();
		login.logClick();
		home.clientTag();
		createclient.clientNameSearch();
		createclient.searchButton();
		createclient.validatingClient();
		createclient.pencilButton();	
	boolean actual = createclient.pencilButton();
	boolean expected = true;
		Assert.assertEquals(actual, expected, Constant.ms_createClientpageAssert);
	}	
		
	@Test(priority=11,enabled = true)

	public void viewClient() {
		login = new LoginPage(driver);
		home = new Homepage(driver);
		createclient = new Createclient(driver);

		login.sendUsername();
		login.sendPassword();
		login.logClick();
		home.clientTag();
		createclient.clientNameSearch();
		createclient.searchButton();
		createclient.validatingClient();
		createclient.eyeButton();	
		boolean actual = createclient.eyeButton();
		boolean expected = true;
			Assert.assertEquals(actual, expected, Constant.ms_createClientpageAssert);
		}
	@Test(priority=13,enabled = true)

	public void deductionPage() {
		login = new LoginPage(driver);
		home = new Homepage(driver);
		createclient = new Createclient(driver);

		login.sendUsername();
		login.sendPassword();
		login.logClick();
		home.deductionTag();
		createclient.allAmountDed();
		int actual = createclient.allAmountDed();
		int expected = 12893725;
		Assert.assertEquals(actual, expected, Constant.ms_createClientpageAssert);
	}

	@Test(dataProvider = "data-provider",dataProviderClass=TimesheetTest.class)
	
		public void clientandIdsearchButtonVerify(String clientName, String clientId) {			
			login = new LoginPage(driver);
			home = new Homepage(driver);
			createclient = new Createclient(driver);
			login.sendUsername();
			login.sendPassword();
			login.logClick();
			home.clientTag();
			createclient.senduserDetails(clientName, clientId);
			createclient.searchButton();			
		}
}


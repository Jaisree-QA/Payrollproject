package testCase;

import java.util.Arrays;
import java.util.Collection;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import constant.Constant;
import elementRepository.Homepage;
import elementRepository.LoginPage;
import elementRepository.Timesheet;
import utilities.ConfigFileReader;
import utilities.GeneralUtilities;

public class TimesheetTest extends BaseClass {
	LoginPage login;
	Homepage home;
	Timesheet timesheet;
	GeneralUtilities utilities;
	ConfigFileReader cf;

	@Test(priority = 6, enabled = true)
	public void timesheetPageTitleCheck() {
		login = new LoginPage(driver);
		home = new Homepage(driver);
		login.sendUsername();
		login.sendPassword();
		login.logClick();
		home.timesheetTag();
		String actual = home.getTimesheetHeading();
		String expected = login.expectedAssert(1, 1);
		Assert.assertEquals(actual, expected, Constant.ms_acceptGeneratePayslip);
	}

	@Test(priority = 2, enabled = true)
	public void acceptgenerateInvoiceAlert() {// alert handling
		login = new LoginPage(driver);
		home = new Homepage(driver);
		timesheet = new Timesheet(driver);
		utilities = new GeneralUtilities();
		login.sendUsername();
		login.sendPassword();
		login.logClick();
		home.timesheetTag();
		timesheet.generateInvoice();
		utilities.alertAccept(driver);
		utilities.explicitWait(driver);
		utilities.alertText(driver);
		String actual = utilities.alertText(driver);
		String expected = login.expectedAssert(0, 1);
		Assert.assertEquals(actual, expected, Constant.ms_acceptGeneratePayslip);
		utilities.alertAccept(driver);
	}

	@Test(enabled = true)
	public void cancelgenerateInvoiceAlert() {
		login = new LoginPage(driver);
		home = new Homepage(driver);
		timesheet = new Timesheet(driver);
		utilities = new GeneralUtilities();
		login.sendUsername();
		login.sendPassword();
		login.logClick();
		home.timesheetTag();
		timesheet.generateInvoice();
		String actual = utilities.alertText(driver);
	 String expected = login.expectedAssert(2, 0);
	 Assert.assertEquals(actual, expected, Constant.ms_acceptGeneratePayslip);
		utilities.alertDismiss(driver);

	}

	@Test(enabled = true)
	public void uploadFileTimesheet() {
		login = new LoginPage(driver);
		home = new Homepage(driver);
		timesheet = new Timesheet(driver);
		utilities = new GeneralUtilities();
		cf = new ConfigFileReader();
		cf.testBasicHandling();
		login.sendUsername();
		login.sendPassword();
		login.logClick();
		home.timesheetTag();
		timesheet.createTimesheet();
		timesheet.browseFilepath();
		timesheet.uploadButton();
		 String actual = home.getCreateTimesheetHeading();
		 String expected = login.expectedAssert(2, 1);
		 Assert.assertEquals(actual, expected, Constant.ms_acceptGeneratePayslip);
	}

	@Test(enabled = true) // dynamic table
	public void pendingTimesheetTableverifying() {
		login = new LoginPage(driver);
		home = new Homepage(driver);
		timesheet = new Timesheet(driver);
		utilities = new GeneralUtilities();
		login.sendUsername();
		login.sendPassword();
		login.logClick();
		home.timesheetTag();
		timesheet.wholeTable();
		boolean actual = timesheet.wholeTable();
		boolean expected = true;
		Assert.assertEquals(actual, expected, Constant.ms_acceptGeneratePayslip);
	}

	@Test
	public void pdfAttachinDeduction() {
		login = new LoginPage(driver);
		home = new Homepage(driver);
		timesheet = new Timesheet(driver);
		utilities = new GeneralUtilities();
		login.sendUsername();
		login.sendPassword();
		login.logClick();
		home.windowHandling();
	}

	@Test(enabled = true)
	public void validatingHighestpaidDeduction() {
		login = new LoginPage(driver);
		home = new Homepage(driver);
		timesheet = new Timesheet(driver);
		utilities = new GeneralUtilities();
		login.sendUsername();
		login.sendPassword();
		login.logClick();
		home.timesheetTag();
		timesheet.crossCheckElement();
		Collection<String> actual = timesheet.crossCheckElement();
		java.util.List<String> expected = Arrays.asList("Sam");
		Assert.assertEquals(actual, expected, Constant.ms_acceptGeneratePayslip);
	}

	@DataProvider(name = "data-provider")
	public Object[][] dpMethod() {
		return new Object[][] { { "Sam", "115" }, { "~amal_xaviourupd", "112" } };
	}
}
package testCase;

import java.util.Arrays;
import java.util.Collection;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constant;
import elementRepository.Homepage;
import elementRepository.LoginPage;
import elementRepository.Timesheet;
import utilities.GeneralUtilities;

public class TimesheetTest extends BaseClass {
	LoginPage lp;
	Homepage hp;
	Timesheet tm;
	GeneralUtilities gu;

	@Test(priority = 6, enabled = false)
	public void timesheetPage() {
		lp = new LoginPage(driver);
		hp = new Homepage(driver);
		lp.sendUsername();
		lp.sendPassword();
		lp.logClick();
		hp.timesheetTag();
		String actual = hp.getTimesheetHeading();
		String expected = "TIMESHEETS";
		Assert.assertEquals(actual, expected, Constant.ms_acceptGeneratePayslip);
	}

	@Test(priority = 2, enabled = true)
	public void acceptgenerateInvoice() {// alert handling
		lp = new LoginPage(driver);
		hp = new Homepage(driver);
		tm = new Timesheet(driver);
		gu = new GeneralUtilities();
		lp.sendUsername();
		lp.sendPassword();
		lp.logClick();
		hp.timesheetTag();
		tm.generateInvoice();
		gu.alertAccept(driver);
		gu.explicitWait(driver);
		gu.alertText(driver);
		String actual = gu.alertText(driver);
		String expected = "Invoice generated!!!";
		Assert.assertEquals(actual, expected, Constant.ms_acceptGeneratePayslip);
		gu.alertAccept(driver);
	}

	@Test(priority = 3, enabled = true)
	public void cancelgenerateInvoice() {// alert handling
		lp = new LoginPage(driver);
		hp = new Homepage(driver);
		tm = new Timesheet(driver);
		gu = new GeneralUtilities();
		lp.sendUsername();
		lp.sendPassword();
		lp.logClick();
		hp.timesheetTag();
		tm.generateInvoice();
		String actual = gu.alertText(driver);
		String expected = "Are you sure you want to generate invoice?";
		Assert.assertEquals(actual, expected, Constant.ms_acceptGeneratePayslip);
		gu.alertDismiss(driver);

	}

	@Test(priority = 4, enabled = true)
	public void uploadFile() {
		lp = new LoginPage(driver);
		hp = new Homepage(driver);
		tm = new Timesheet(driver);
		gu = new GeneralUtilities();
		lp.sendUsername();
		lp.sendPassword();
		lp.logClick();
		hp.timesheetTag();
		tm.createTimesheet();
		tm.browseFilepath();
		tm.uploadButton();
		String actual = hp.getCreateTimesheetHeading();
		String expected = "CREATE TIMESHEET";
		Assert.assertEquals(actual, expected, Constant.ms_acceptGeneratePayslip);
	}

	@Test(priority = 1, enabled = true) // dynamic table
	public void pendingTimesheet() {
		lp = new LoginPage(driver);
		hp = new Homepage(driver);
		tm = new Timesheet(driver);
		gu = new GeneralUtilities();
		lp.sendUsername();
		lp.sendPassword();
		lp.logClick();
		hp.timesheetTag();
		tm.wholeTable();
		boolean actual = tm.wholeTable();
		boolean expected = true;
		Assert.assertEquals(actual, expected, Constant.ms_acceptGeneratePayslip);

	}

	@Test(priority = 5, enabled = true)
	public void crossCheckElement() {
		lp = new LoginPage(driver);
		hp = new Homepage(driver);
		tm = new Timesheet(driver);
		gu = new GeneralUtilities();
		lp.sendUsername();
		lp.sendPassword();
		lp.logClick();
		hp.timesheetTag();
		tm.crossCheckElement();
		Collection<String> actual = tm.crossCheckElement();
		java.util.List<String> expected = Arrays.asList("Sam");
		Assert.assertEquals(actual, expected, Constant.ms_acceptGeneratePayslip);
	}
}
package elementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utilities.GeneralUtilities;

public class Homepage {
	WebDriver driver;
	GeneralUtilities gu = new GeneralUtilities();

	public Homepage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);// with page factory
	}

	@FindBy(xpath = "//h1[text()='Payroll Application']")
	WebElement heading;
	@FindBy(xpath = "//p[text()='Incorrect username or password.']")
	WebElement Incorrectheading;
	@FindBy(xpath = "//h1[text()='Create Timesheet']")
	WebElement createtimesheetheading;
	@FindBy(xpath = "//h1[text()='Clients']")
	WebElement clientheading;
	@FindBy(xpath = "//h1[text()='Create Client']")
	WebElement createclientheading;
	@FindBy(xpath = "//h1[text()='Timesheets']")
	WebElement timesheetheading;
	@FindBy(xpath = "//h1[text()='david']")
	WebElement davidheading;
	@FindBy(xpath = "//h1[text()='Update Client: akshay']")
	WebElement pencilheading;
	@FindBy(xpath = "//h1[text()='akshay']")
	WebElement eyeheading;
	@FindBy(xpath = "//h1[text()='~amal_xaviourupd']")
	WebElement clienteye;
	@FindBy(xpath = "//select[@id='client-branch_id']")
	WebElement branchDrop;
	@FindBy(id = "client-invoice_order")
	WebElement invoiceOrder;
	@FindBy(id = "client-invoice_delivery_method")
	WebElement invoiceMethod;
	@FindBy(id = "client-division_id")
	WebElement division;
	@FindBy(id = "client-master_document")
	WebElement masterdoc;
	@FindBy(id = "client-vat_rate")
	WebElement vatrate;

	public String clienteyeText() {
		return gu.getElementtext(clienteye);
	}

	public String pencilHeadText() {

		return gu.getElementtext(pencilheading);
	}

	public String eyeHeadText() {
		return gu.getElementtext(eyeheading);
	}

	public void selectDrop() {
		Select object = new Select(branchDrop);
		object.selectByValue("1");
		Select object1 = new Select(invoiceOrder);
		object1.selectByValue("Invoice per worker");
		Select object2 = new Select(invoiceMethod);
		object2.selectByValue("Paper");
		Select object3 = new Select(division);
		object3.selectByIndex(1);
		Select object4 = new Select(masterdoc);
		object4.selectByValue("PDF");
		Select object5 = new Select(vatrate);
		object5.selectByValue("VAT 20.00%");
	}

	@FindBy(xpath = "//a[@href='/payrollapp/client/index']")
	WebElement clientTab;
	@FindBy(xpath = "//a[@href='/payrollapp/client/create']")
	WebElement createClient;
	@FindBy(xpath = "//a[@href='/payrollapp/worker/index']")
	WebElement workersTab;
	@FindBy(xpath = "//a[@href='/payrollapp/worker/create']")
	WebElement createWorkers;
	@FindBy(xpath = "//a[@href='/payrollapp/deduction/index']")
	WebElement deductionTab;
	@FindBy(xpath = "//a[@href='/payrollapp/timesheet/index']")
	WebElement timesheetTab;
	@FindBy(xpath = "//a[@href='/payrollapp/payslip/index']")
	WebElement payslipTab;
	@FindBy(xpath = "//a[@href='/payrollapp/invoice/index']")
	WebElement invoiceTab;
	@FindBy(xpath = "//a[@href='/payrollapp/timesheet/approvedlist']")
	WebElement approvedtimesheet;

	public void approvedTimesheetTag() {
		approvedtimesheet.click();
	}

	public void clientTag() {
		clientTab.click();
	}

	public void createClientTag() {
		createClient.click();
	}

	public void workersTag() {
		workersTab.click();
	}

	public void deductionTag() {
		deductionTab.click();
	}

	public void timesheetTag() {
		timesheetTab.click();
	}

	public void payslipTag() {
		payslipTab.click();
	}

	public void invoiceTag() {
		invoiceTab.click();
	}

	public void createWorkerTag() {
		createWorkers.click();
	}

	public String getdavidtext() {
		return gu.getElementtext(davidheading);
	}

	public String getHomepagetext() {
		return gu.getElementtext(heading);
	}

	public String getHomepagetexts() {
		return gu.getElementtext(Incorrectheading);
	}

	public String getClientpagetext() {
		return gu.getElementtext(clientheading);
	}

	public String getCreateclientpagetexts() {
		return gu.getElementtext(createclientheading);
	}

	public String getTimesheetHeading() {
		return gu.getElementtext(timesheetheading);
	}

	public String getCreateTimesheetHeading() {
		return gu.getElementtext(createtimesheetheading);
	}
}

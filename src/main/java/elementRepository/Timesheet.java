package elementRepository;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.GeneralUtilities;

public class Timesheet {

	WebDriver driver;
	GeneralUtilities gu = new GeneralUtilities();

	public Timesheet(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);// with page factory
	}

	@FindBy(xpath = "//button[@class='btn btn-warning btn-responsive playslip']")
	WebElement generatepayslip;
	@FindBy(xpath = "//button[@class='btn btn-warning btn-responsive invoice']")
	WebElement generateinvoice;

	@FindBy(xpath = "//button[@class='btn btn-warning btn-responsive invoice']")
	WebElement generatetable;

	@FindBy(xpath = "//a[@href='/payrollapp/timesheet/create']")
	WebElement createtimesheet;

	@FindBy(xpath = "//input[(@id='file-logo')]")
	WebElement browseclick;

	@FindBy(xpath = "//input[@class='file-caption-name']")
	WebElement filepath;

	@FindBy(xpath = "//span[text()='Upload']")
	WebElement upload;
	@FindBy(xpath = "//table[@class='table table-striped table-bordered']//thead//tr[1]")
	List<WebElement> tableheader;

	@FindBy(xpath = "//table[@class='table table-striped table-bordered']//tbody//tr[1]")
	List<WebElement> tablerow;

	@FindBy(xpath = "//table[@class='table table-striped table-bordered']//tbody//tr//td[1]")
	List<WebElement> tablecol;

	public boolean wholeTable() {
		
		for (int i = 0; i < tablecol.size(); i++) {			
			for (int j = 0; j < tablerow.size(); j++) {				
String tableXpath = "//table[@class='table table-striped table-bordered']//tbody//tr[" + (i + 1)
						+ "]//td[" + (j + 1) + "]";
WebElement fullTable = driver.findElement(By.xpath(tableXpath));
fullTable.getText();
			}
		}
		return true;
	}
	public  List<String>crossCheckElement() {
		 List<String> valuesList = new ArrayList<>();
		for (int i = 0; i < tablecol.size(); i++) {
			if (tablecol.get(i).getText().equals("343445")) {
String locator = "//table[@class='table table-striped table-bordered']//tbody//tr[" + (i + 1)+ "]//td[2]";
		WebElement values = driver.findElement(By.xpath(locator));
valuesList.add(values.getText());
	        }
	    }
	    return valuesList;
	}
	public void browseTimesheet() {
		browseclick.click();
	}

	public void browseFilepath() {
		gu.selectField("C:\\Users\\user\\Pictures\\newyear2023.jpg", browseclick);
	}

	public void uploadButton() {
		upload.click();
	}

	public void createTimesheet() {
		createtimesheet.click();
	}

	public void generatePayslip() {
		generatepayslip.click();
	}

	public void generateInvoice() {
		generateinvoice.click();
	}

	public void generateTable() {
		generatetable.click();
	}
		    }

	
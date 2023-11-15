package elementRepository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.GeneralUtilities;

public class Createclient {
	WebDriver driver;
	GeneralUtilities gu = new GeneralUtilities();

	public Createclient(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);// with page factory
	}

	@FindBy(xpath = "//input[@type='checkbox']")
	List<WebElement> checkBox;
	@FindBy(id = "client-your_ref")
	WebElement refTab;
	@FindBy(id = "client-invoice_contact")
	WebElement invoiceContact;
	@FindBy(xpath = "//button[@class='btn btn-success']")
	WebElement save;
	@FindBy(id = "client-client_name")
	WebElement name;
	@FindBy(id = "client-client_address")
	WebElement clientaddress;
	@FindBy(id = "client-postcode")
	WebElement postalcode;
	@FindBy(id = "client-phone")
	WebElement phone;
	@FindBy(id = "client-email")
	WebElement email;
	@FindBy(id = "client-company_reg")
	WebElement reg;
	@FindBy(id = "client-settilement_days")
	WebElement days;
	@FindBy(xpath = "//input[@id='clientsearch-client_name']")
	WebElement clientnamesearch;
	@FindBy(id = "clientsearch-id")
	WebElement clientidsearch;
	@FindBy(xpath = "//button[@class='btn btn-primary']")
	WebElement searchbutton;
	@FindBy(xpath = "//table[@class='table table-striped table-bordered']//tbody//tr[@data-key='19']//td[2]")
	List<WebElement> validating;
	@FindBy(xpath = "//a[@href='/payrollapp/client/view?id=19']")
	WebElement eyes;
	@FindBy(xpath = "//a[@href='/payrollapp/client/update?id=19']")
	WebElement pencilnineteen;

	public void selectingAllCheckBox() {
		for (int i = 0; i < checkBox.size(); i++) {
			checkBox.get(i).click();
			System.out.println(checkBox.get(i).getText());
		}
	}

	public void validatingClient() {
		for (int i = 0; i < validating.size(); i++) {
			String s = validating.get(i).getText();
		}
	}

	public void clickElementWithRetry() {
		int attempts = 0;
		int maxAttempts = 2; // Adjust the number of attempts as needed

		while (attempts < maxAttempts) {
			try {
				gu.FluentWait(driver, pencilnineteen);
				pencilnineteen.click();
				
			} catch (StaleElementReferenceException e) {
				e.printStackTrace();
				
			}
			attempts++;
		}
	}

	public boolean pencilButton() {
		try {
			gu.FluentWait(driver, pencilnineteen);
			return pencilnineteen.isEnabled();
		} catch (StaleElementReferenceException e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean nine() {
		return gu.getviewEnabled(pencilnineteen);
	}

	public boolean eyeButton() {

		try {
			gu.FluentWait(driver, eyes);
			return eyes.isEnabled();
		} catch (StaleElementReferenceException e) {
			e.printStackTrace();
			return false;
		}

	}

	public void clientNameSearch() {
		gu.selectField("akshay", clientnamesearch);
		gu.selectField("19", clientidsearch);
	}

	public void searchButton() {
		searchbutton.click();
	}

	public void refField() {
		gu.selectField("695", refTab);
		gu.selectField("333", invoiceContact);
		gu.selectField("33-333-1212", phone);
		gu.selectField("david", name);
		gu.selectField("W91p5nk", postalcode);
		gu.selectField("92 Arconagh new bridgeRoad Naas", clientaddress);
		gu.selectField("knkcka@yopmail.com", email);
		gu.selectField("company3", reg);
	}

	public void selectSettlementDays() {
		gu.selectField("171", days);
		gu.scrolLing(driver);
	}

	public void selectSave() {
		save.isEnabled();
		save.isDisplayed();
		boolean flag = save.isEnabled();
		System.out.println(flag);
		boolean flag1 = save.isDisplayed();
		System.out.println(flag1);

		gu.saveButton(driver, save);
	}

	public void directEye() {
		WebElement getclient = driver.findElement(By.xpath(
				"//td[normalize-space()='~amal_xaviourupd']//following::td[4]//a[@href='/payrollapp/client/view?id=4']"));
		gu.browseActions(driver, getclient);
	}

	@FindBy(xpath = "//td[4]")
	List<WebElement> dedamount;

	public Integer allAmountDed() {
		ArrayList<Integer> amountList = new ArrayList<Integer>();
		for (WebElement element : dedamount) {
			String individualamount = element.getText().replace(".00", "").replace("£", "").replace(",", "");
			amountList.add(Integer.parseInt(individualamount));
		}
		int largevalue = Collections.max(amountList);
		return largevalue;

	}
}

package elementRepository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.GeneralUtilities;

public class Createclient {
	WebDriver driver;
	GeneralUtilities utilities = new GeneralUtilities();

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

	public void senduserDetails(String clientName, String clientId) {

		clientnamesearch.sendKeys(clientName);
		clientidsearch.sendKeys(clientId);
	}

	
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
				utilities.FluentWait(driver, pencilnineteen);
				pencilnineteen.click();
				
			} catch (StaleElementReferenceException e) {
				e.printStackTrace();
				
			}
			attempts++;
		}
	}

	public boolean pencilButton() {
		try {
			utilities.FluentWait(driver, pencilnineteen);
			return pencilnineteen.isEnabled();
		} catch (StaleElementReferenceException e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean nine() {
		return utilities.getviewEnabled(pencilnineteen);
	}

	public boolean eyeButton() {

		try {
			utilities.FluentWait(driver, eyes);
			return eyes.isEnabled();
		} catch (StaleElementReferenceException e) {
			e.printStackTrace();
			return false;
		}

	}

	public void clientNameSearch() {
		utilities.selectField("akshay", clientnamesearch);
		utilities.selectField("19", clientidsearch);
	}

	public void searchButton() {
		searchbutton.click();
	}
	public boolean searchButtonClickable() {
		return searchbutton.isEnabled();
	}
	

	public void refField() {
		utilities.selectField("695", refTab);
		utilities.selectField("333", invoiceContact);
		utilities.selectField("33-333-1212", phone);
		utilities.selectField("david", name);
		utilities.selectField("W91p5nk", postalcode);
		utilities.selectField("92 Arconagh new bridgeRoad Naas", clientaddress);
		utilities.selectField("knkcka@yopmail.com", email);
		utilities.selectField("company3", reg);
	}

	public void selectSettlementDays() {
		utilities.selectField("171", days);
		utilities.scrolLing(driver);
	}

	public void selectSave() {
		save.isEnabled();
		save.isDisplayed();
		utilities.saveButton(driver, save);
	}

	public void directEye() {
		WebElement getclient = driver.findElement(By.xpath(
				"//td[normalize-space()='~amal_xaviourupd']//following::td[4]//a[@href='/payrollapp/client/view?id=4']"));
		utilities.browseActions(driver, getclient);
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

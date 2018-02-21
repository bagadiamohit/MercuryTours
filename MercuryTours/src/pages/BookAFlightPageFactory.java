package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import tests.FlightFinder;

public class BookAFlightPageFactory {
	
	WebDriver driver;
	FlightFinder flightFinder = new FlightFinder();
	int passCount=flightFinder.passCount;
	
	@FindBy(name="passFirst0") WebElement firstName0Box;
	@FindBy(name="passLast0") WebElement lastName0Box;
	@FindBy(name="pass.0.meal") WebElement pass0MealSelect;
	@FindBy(name="creditCard") WebElement creditCardSelect;
	@FindBy(name="creditnumber") WebElement creditnumberBox;
	@FindBy(name="cc_exp_dt_mn") WebElement creditExpMonthSelect;
	@FindBy(name="cc_exp_dt_yr") WebElement creditExpYearSelect;
	@FindBy (name="cc_frst_name") WebElement creditFirstNameBox;
	@FindBy (name="cc_mid_name") WebElement creditMiddleNameBox;
	@FindBy (name="cc_last_name") WebElement creditLastNameBox;
	@FindBy (css="input[name='buyFlights'][src='/images/forms/purchase.gif']") WebElement securePurchaseButton;
	@FindBy (xpath="/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr[1]/td[2]/table/tbody/tr[3]/td/p/font/b/font[2]") WebElement conf_message;
	
	public void setPassengerDetails(String passFirstName0, String passLastName0, String mealType) {
		for(int i=0; i<=passCount; i++) {
			firstName0Box.sendKeys(passFirstName0);
			lastName0Box.sendKeys(passLastName0);
			new Select(pass0MealSelect).selectByValue(mealType);
		}
	}
	
	public void creditCardDetails(String cardType, String creditCardNum, int expMonth, int expYear, String passFirstName0,
			String passLastName0) {
		new Select(creditCardSelect).selectByValue(cardType);
		creditnumberBox.sendKeys(String.valueOf(creditCardNum));
		new Select(creditExpMonthSelect).selectByIndex(expMonth);
		new Select(creditExpYearSelect).selectByValue(String.valueOf(expYear));
		creditFirstNameBox.sendKeys(passFirstName0);
		creditLastNameBox.sendKeys(passLastName0);
	}
	
	public void submit() {
		securePurchaseButton.click();
	}
	
	public String confirmationMessage() {
		return conf_message.getText();
	}
	
	public void bookAFlight(String passFirstName0, String passLastName0, String mealType,String cardType, String creditCardNum, int expMonth, int expYear) {
		setPassengerDetails(passFirstName0, passLastName0, mealType);
		creditCardDetails(cardType, creditCardNum, expMonth, expYear, passFirstName0, passLastName0);
		submit();
	}
	
	public BookAFlightPageFactory(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

}

package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
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
	
	public void setPassengerDetails(String passFirstName0, String passLastName0, String mealType) {
		for(int i=0; i<=passCount; i++) {
			firstName0Box.sendKeys(passFirstName0);
			lastName0Box.sendKeys(passLastName0);
			new Select(pass0MealSelect).selectByValue(mealType);
		}
	}
	
	public void bookAFlight() {
		
	}
	
	public BookAFlightPageFactory(WebDriver driver) {
		this.driver=driver;
	}

}

package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import test.FlightFinder;

public class BookAFlightPageFactory {
	
	WebDriver driver;
//	FlightFinder flightFinder = new FlightFinder();
//	int passCount=flightFinder.passCount;
	
	@FindBy(name="passFirst0") WebElement firstName0Box;
	@FindBy(name="passLast0") WebElement lastName0Box;
	@FindBy(name="pass.0.meal") WebElement pass0MealSelect;
	@FindBy(name="passFirst1") WebElement firstName1Box;
	@FindBy(name="passLast1") WebElement lastName1Box;
	@FindBy(name="pass.1.meal") WebElement pass1MealSelect;
	@FindBy(name="passFirst2") WebElement firstName2Box;
	@FindBy(name="passLast2") WebElement lastName2Box;
	@FindBy(name="pass.2.meal") WebElement pass2MealSelect;
	@FindBy(name="passFirst3") WebElement firstName3Box;
	@FindBy(name="passLast3") WebElement lastName3Box;
	@FindBy(name="pass.3.meal") WebElement pass3MealSelect;
	@FindBy(name="creditCard") WebElement creditCardSelect;
	@FindBy(name="creditnumber") WebElement creditnumberBox;
	@FindBy(name="cc_exp_dt_mn") WebElement creditExpMonthSelect;
	@FindBy(name="cc_exp_dt_yr") WebElement creditExpYearSelect;
	@FindBy (name="cc_frst_name") WebElement creditFirstNameBox;
	@FindBy (name="cc_mid_name") WebElement creditMiddleNameBox;
	@FindBy (name="cc_last_name") WebElement creditLastNameBox;
	@FindBy (css="input[name='buyFlights'][src='/images/forms/purchase.gif']") WebElement securePurchaseButton;
	@FindBy (xpath="/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr[1]/td[2]/table/tbody/tr[3]/td/p/font/b/font[2]") WebElement conf_message;
	
	public void setPassengerDetails(int passCount, String[] passFirstName, String[] passLastName, String[] mealType) {
		if (passCount==0) {
			firstName0Box.sendKeys(passFirstName[0]);
			lastName0Box.sendKeys(passLastName[0]);
			new Select(pass0MealSelect).selectByValue(mealType[0]);
		}
		else if (passCount==1) {
			firstName0Box.sendKeys(passFirstName[0]);
			lastName0Box.sendKeys(passLastName[0]);
			new Select(pass0MealSelect).selectByValue(mealType[0]);
			firstName1Box.sendKeys(passFirstName[1]);
			lastName1Box.sendKeys(passLastName[1]);
			new Select(pass1MealSelect).selectByValue(mealType[1]);
		}
		else if (passCount==2) {
			firstName0Box.sendKeys(passFirstName[0]);
			lastName0Box.sendKeys(passLastName[0]);
			new Select(pass0MealSelect).selectByValue(mealType[0]);
			firstName1Box.sendKeys(passFirstName[1]);
			lastName1Box.sendKeys(passLastName[1]);
			new Select(pass1MealSelect).selectByValue(mealType[1]);
			firstName2Box.sendKeys(passFirstName[2]);
			lastName2Box.sendKeys(passLastName[2]);
			new Select(pass2MealSelect).selectByValue(mealType[2]);
		}
		else if (passCount==3) {
			firstName0Box.sendKeys(passFirstName[0]);
			lastName0Box.sendKeys(passLastName[0]);
			new Select(pass0MealSelect).selectByValue(mealType[0]);
			firstName1Box.sendKeys(passFirstName[1]);
			lastName1Box.sendKeys(passLastName[1]);
			new Select(pass1MealSelect).selectByValue(mealType[1]);
			firstName2Box.sendKeys(passFirstName[2]);
			lastName2Box.sendKeys(passLastName[2]);
			new Select(pass2MealSelect).selectByValue(mealType[2]);
			firstName3Box.sendKeys(passFirstName[3]);
			lastName3Box.sendKeys(passLastName[3]);
			new Select(pass3MealSelect).selectByValue(mealType[3]);
		}
	}
	
	public void creditCardDetails(String cardType, String creditCardNum, int expMonth, int expYear, String[] passFirstName,
			String[] passLastName) {
		new Select(creditCardSelect).selectByValue(cardType);
		creditnumberBox.sendKeys(String.valueOf(creditCardNum));
		new Select(creditExpMonthSelect).selectByIndex(expMonth);
		new Select(creditExpYearSelect).selectByValue(String.valueOf(expYear));
		creditFirstNameBox.sendKeys(passFirstName[0]);
		creditLastNameBox.sendKeys(passLastName[0]);
	}
	
	public void submit() {
		securePurchaseButton.click();
	}
	
	public String confirmationMessage() {
		return conf_message.getText();
	}
	
	public void bookAFlight(int passCount, String[] passFirstName, String[] passLastName, String[] mealType,String cardType, String creditCardNum, int expMonth, int expYear) {
		setPassengerDetails(passCount, passFirstName, passLastName, mealType);
		creditCardDetails(cardType, creditCardNum, expMonth, expYear, passFirstName, passLastName);
		submit();
	}
	
	public BookAFlightPageFactory(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

}

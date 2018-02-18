package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class FlightFinderPageFactory {
	
	WebDriver driver;
	
	@FindBy(css="input[name='tripType'][value='roundtrip']")
	WebElement roundTripRadio;
	
	@FindBy(css="input[name='tripType'][value='oneway']")
	WebElement oneWayRadio;
	
	@FindBy(css="select[name='passCount']")
	WebElement passCountSelect;
	
	@FindBy(css="select[name='fromPort']")
	WebElement departFromSelect;
	
	@FindBy(css="select[name='fromMonth']")
	WebElement fromMonthSelect;
	
	@FindBy(css="select[name='fromDay']")
	WebElement fromDaySelect;
	
	@FindBy(css="select[name='toPort']")
	WebElement departToSelect;
	
	@FindBy(css="select[name='toMonth']")
	WebElement toMonthSelect;
	
	@FindBy(css="select[name='toDay']")
	WebElement toDaySelect;
	
	@FindBy(css="input[name='servClass'][value='Economy class ']")
	WebElement economyRadio;
	
	@FindBy(css="input[name='servClass'][value='Business']")
	WebElement businessRadio;
	
	@FindBy(css="input[name='servClass'][value='First']")
	WebElement firstRadio;
	
	@FindBy(css="input[type='image'][src='/images/forms/continue.gif']")
	WebElement continueButton;
	
	public void setTripType(String tripType) {
		if (tripType.equalsIgnoreCase("roundtrip")){
			roundTripRadio.click();
		}
		else if(tripType.equalsIgnoreCase("oneway")) {
			oneWayRadio.click();
		}
		else {
			System.out.println("Please enter a valid trip type");
		}
	}
	
	public void setPassCount(String passCount) {
		new Select(passCountSelect).selectByValue(passCount);
	}
	
	public void departFromCity(String departFrom) {
		new Select(departFromSelect).selectByValue(departFrom);
	}
	
	public void departFromMonth(String fromMonth) {
		new Select(fromMonthSelect).selectByValue(fromMonth);
	}
	
	public void departFromDate(String fromDay) {
		new Select(fromDaySelect).selectByValue(fromDay);
	}
	
	public void departToCity(String departTo) {
		new Select (departToSelect).selectByValue(departTo);
	}
	
	public void departToMonth(String toMonth) {
		new Select(toMonthSelect).selectByValue(toMonth);
	}
	
	public void departToDate(String toDay) {
		new Select(toDaySelect).selectByValue(toDay);
	}
	
	public void serviceClassSelect(String serviceClass) {
		if (serviceClass.equalsIgnoreCase("Economy class ")) {
			economyRadio.click();
		}
		else if(serviceClass.equalsIgnoreCase("Business")) {
			businessRadio.click();
		}
		else if (serviceClass.equalsIgnoreCase("first")) {
			firstRadio.click();
		}
	}
	
	public void continueFurther() {
		continueButton.click();
		System.out.println("Proceeding further . . . .");
	}
	
	public String pageTitle() {
		return driver.getTitle();
	}
	
	public void flighFinder(String tripType, String passCount, String departFrom, String fromMonth,
			String fromDay, String departTo, String toMonth, String toDay, String serviceClass) {
		setTripType(tripType);
		setPassCount(passCount);
		departFromCity(departFrom);
		departFromMonth(fromMonth);
		departFromDate(fromDay);
		departToCity(departTo);
		departToMonth(toMonth);
		departToDate(toDay);
		serviceClassSelect(serviceClass);
		continueFurther();
		pageTitle();
	}
	
	public FlightFinderPageFactory(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

}

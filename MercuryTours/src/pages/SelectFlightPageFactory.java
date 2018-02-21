package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SelectFlightPageFactory {
	
	WebDriver driver;
	
	@FindBy(xpath="/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table[1]/tbody/tr[5]/td[1]/input")
	WebElement departFlightRadio;
	
	@FindBy(xpath="/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table[2]/tbody/tr[7]/td[1]/input")
	WebElement returnFlightRadio;
	
	@FindBy(css="input[name='reserveFlights'][src='/images/forms/continue.gif']")
	WebElement continueButton;
	
	public void setDepartFlight() {
		departFlightRadio.click();
	}
	
	public void setReturnFlight() {
		returnFlightRadio.click();
	}
	
	public void continueFurther() {
		continueButton.click();
		System.out.println("Proceeding further . . . . ");
	}
	
	public String confirmation() {
		return driver.getTitle();
	}
	
	public void selectFlight() {
		setDepartFlight();
		setReturnFlight();
		continueFurther();
	}
	
	public SelectFlightPageFactory(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

}

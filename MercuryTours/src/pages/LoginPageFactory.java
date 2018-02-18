package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class LoginPageFactory {
	
	// 1. Initialize the driver
	WebDriver driver;
	
	@FindBy(name="userName")
	WebElement userNameBox;
	
	@FindBy(name="password")
	WebElement passwordBox;
	
	@FindBy(name="login")
	WebElement loginButton;
	
	@FindBy(xpath="/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[1]/td/font/font/b/font/font")
	WebElement conf_message;
	
	public void setUsername (String userName) {
		userNameBox.sendKeys(userName);
	}
	
	public void setPassword (String password) {
		passwordBox.sendKeys(password);
	}
	
	public void submit() {
		loginButton.click();
	}
	
	public String confirmation() {
		String confirmation = conf_message.getText();
		return confirmation;
	}

	// 2. Enter the login details and click on submit
	public void login(String userName, String password) {
		setUsername(userName);
		setPassword(password);
		submit();
	}
	
	public LoginPageFactory(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	// 3. Confirmation 

}

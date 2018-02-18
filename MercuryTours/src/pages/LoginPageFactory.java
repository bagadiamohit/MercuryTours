package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageFactory {
	
	// 1. Initialize the driver
	WebDriver driver;
	
	@FindBy(name="userName")
	WebElement userNameBox;
	
	@FindBy(name="password")
	WebElement passwordBox;
	
	@FindBy(name="login")
	WebElement loginButton;
	
	public void setUsername (String userName) {
		userNameBox.sendKeys(userName);
	}
	
	public void setPassword (String password) {
		passwordBox.sendKeys(password);
	}
	
	public void submit() {
		loginButton.click();
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

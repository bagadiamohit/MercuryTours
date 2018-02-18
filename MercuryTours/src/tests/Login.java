package tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.LoginPageFactory;

public class Login {
	WebDriver driver;
	String webURL = "http://newtours.demoaut.com/";
	String userName="mohit";
	String password="mohit";
	String browserType = "chrome";
	
	@Test
	public void loginTest() {
		System.out.println("Executing the test");
		LoginPageFactory loginPage = new LoginPageFactory(driver);
		loginPage.login(userName, password);
	}
	
	@BeforeMethod
	public void setUp() {
		System.out.println("Initializing the Test");
		driver = utilities.DriverFactory.open(browserType);
		driver.get(webURL);
	}
	
	@AfterMethod
	public void tearDown() {
		System.out.println("Closing the test");
		driver.quit();
	}

}

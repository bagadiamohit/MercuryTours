package test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.LoginPageFactory;

public class Login {
	WebDriver driver;
	String webURL = "http://newtours.demoaut.com/";
	String userName = "mohit";
	String password = "mohit";
	String browserType = "firefox";

	@Test
	public void loginTest() {
		System.out.println("Executing the test");
		LoginPageFactory loginPage = new LoginPageFactory(driver);
		loginPage.login(userName, password);
		Assert.assertTrue(loginPage.confirmation().contains("Flight"));
		System.out.println("The confirmation message is: " + loginPage.confirmation());
	}

	@BeforeMethod
	public void setUp() {
		System.out.println("Initializing the Test");
		driver = utilities.DriverFactory.open(browserType);
		driver.get(webURL);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	}

	@AfterMethod
	public void tearDown() {
		System.out.println("Closing the test");
		driver.quit();
	}

}

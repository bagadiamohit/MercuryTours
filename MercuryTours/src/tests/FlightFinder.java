package tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.FlightFinderPageFactory;
import pages.LoginPageFactory;

public class FlightFinder {
	
	WebDriver driver;
	String webURL = "http://newtours.demoaut.com/";
	String userName="mohit", password="mohit",browserType = "chrome", tripType="round trip", 
			departFrom="New York",fromMonth="3",fromDay="19",departTo="Paris",toMonth="3",toDay="25",
			serviceClass="business";
	public int passCount=0;
	int airline=2;
	
	@Test
	public void flightFinderTest() {
		System.out.println("Executing the test");
		FlightFinderPageFactory flightFinder = new FlightFinderPageFactory(driver);
		flightFinder.flighFinder(tripType, passCount, departFrom, fromMonth, fromDay, departTo, toMonth, toDay, serviceClass, airline);
		Assert.assertTrue(flightFinder.pageTitle().contains("Select a Flight"));
		System.out.println("The title of the page is: "+flightFinder.pageTitle());
	}
	
	@BeforeMethod
	public void setUp() {
		System.out.println("Initializing the Test");
		driver = utilities.DriverFactory.open(browserType);
		driver.get(webURL);
		LoginPageFactory loginPage = new LoginPageFactory(driver);
		loginPage.login(userName, password);
		Assert.assertTrue(loginPage.confirmation().contains("Flight"));
		System.out.println("The confirmation message is: "+loginPage.confirmation());
	}
	
	@AfterMethod
	public void tearDown() {
		System.out.println("Closing the test");
		driver.quit();
	}

}

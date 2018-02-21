package tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.BookAFlightPageFactory;
import pages.FlightFinderPageFactory;
import pages.LoginPageFactory;
import pages.SelectFlightPageFactory;

public class MercuryBookAFlight {
	
	WebDriver driver;
	String webURL = "http://newtours.demoaut.com/";
	String userName="mohit", password="mohit",browserType = "chrome", tripType="round trip",  
		departFrom="New York",fromMonth="3",fromDay="19",departTo="Paris",toMonth="3",toDay="25",serviceClass="business",
		passFirstName0 = "Mohit", passLastName0="Kumar",mealType="HNML",cardType="BA",creditCardNum="4444555566667777";
	int passCount=0, airline=2,expMonth=4,expYear=2000;
	
	@Test(priority=0)
	public void login() {
		System.out.println("Logging into the application");
		LoginPageFactory loginPage = new LoginPageFactory(driver);
		loginPage.login(userName, password);
		Assert.assertTrue(loginPage.confirmation().contains("Flight"));
		System.out.println("The confirmation message is: "+loginPage.confirmation());
	}
	
	@Test(priority=1)
	public void flightFinder() {
		Reporter.log("Browser is opened and website is launched");
		System.out.println("Finding the flight");
		FlightFinderPageFactory flightFinder = new FlightFinderPageFactory(driver);
		flightFinder.flighFinder(tripType, passCount, departFrom, fromMonth, fromDay, departTo, toMonth, toDay, serviceClass, airline);
		Assert.assertTrue(flightFinder.pageTitle().contains("Select a Flight"));
		System.out.println("The title of the page is: "+flightFinder.pageTitle());
	}
	
	@Test(priority=2)
	public void selectFlight() {
		System.out.println("Selecting the flight");
		SelectFlightPageFactory selectFlight = new SelectFlightPageFactory(driver);
		selectFlight.selectFlight();
		Assert.assertTrue(selectFlight.confirmation().contains("Book a Flight"));
	}
	
	@Test(priority=3)
	public void bookFlight() {
		System.out.println("Booking the flight");
		BookAFlightPageFactory bookFlight = new BookAFlightPageFactory(driver);
		bookFlight.bookAFlight(passFirstName0, passLastName0, mealType, cardType, creditCardNum, expMonth, expYear);
		Assert.assertTrue(bookFlight.confirmationMessage().contains("Your"));
		System.out.println("Flight is successfully booked. "+bookFlight.confirmationMessage());
	}
	
	@BeforeClass
	public void setUp() {
		System.out.println("Initializing the Test");
		driver = utilities.DriverFactory.open(browserType);
		driver.get(webURL);
		Reporter.log("Browser is opened and website is launched");
	}
	
	@AfterClass
	public void tearDown() {
		System.out.println("Closing the test");
		driver.quit();
	}


}

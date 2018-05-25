package tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.BookAFlightPageFactory;
import pages.FlightFinderPageFactory;
import pages.LoginPageFactory;
import pages.SelectFlightPageFactory;

public class MercuryBookAFlightDDT {
	
	WebDriver driver;
	String webURL = "http://newtours.demoaut.com/", browserType = "chrome";
	String[] passFirstName1 = null;
	String[] passLastName1 = null;
	String[] mealType1 = null;
	/*String userName="mohit", password="mohit", tripType="round trip",  
		departFrom="New York",fromMonth="3",fromDay="19",departTo="Paris",toMonth="3",toDay="25",serviceClass="business",
		cardType="BA",creditCardNum="4444555566667777";
	String[] passFirstName = {"Mohit", "Ravi"}; 
	String[] passLastName = {"Kumar", "John"};
	String[] mealType= {"HNML","LCML"};
	int passCount=0, airline=2,expMonth=4,expYear=2000;*/
	
	@Test(dataProvider = "getData")
	public void bookAFlightDDT(String userName, String password, String tripType, String departFrom, String fromMonth,
			String fromDay, String departTo, String toMonth, String toDay, String serviceClass, String cardType, String creditCardNum,
			String passFirstName, String passLastName, String mealType, String passCount, String airline, String expMonth,
			String expYear) {
		
		int passCount1 = Integer.parseInt(passCount);
		int airline1 = Integer.parseInt(airline);
		int expMonth1 = Integer.parseInt(expMonth);
		int expYear1 = Integer.parseInt(expYear);
		passFirstName1 = passFirstName.split(",");
		passLastName1 = passLastName.split(",");
		mealType1 = mealType.split(",");
		
		//Login Functionality
		System.out.println("Logging into the application");
		LoginPageFactory loginPage = new LoginPageFactory(driver);
		loginPage.login(userName, password);
		Assert.assertTrue(loginPage.confirmation().contains("Flight"));
		System.out.println("The confirmation message is: "+loginPage.confirmation());
		Reporter.log("Browser is opened and website is launched");
		
		//Flight Finder
		System.out.println("Finding the flight");
		FlightFinderPageFactory flightFinder = new FlightFinderPageFactory(driver);
		flightFinder.flighFinder(tripType, passCount1, departFrom, fromMonth, fromDay, departTo, toMonth, toDay, serviceClass, airline1);
		Assert.assertTrue(flightFinder.pageTitle().contains("Select a Flight"));
		System.out.println("The title of the page is: "+flightFinder.pageTitle());
		
		//Flight Selection
		System.out.println("Selecting the flight");
		SelectFlightPageFactory selectFlight = new SelectFlightPageFactory(driver);
		selectFlight.selectFlight();
		Assert.assertTrue(selectFlight.confirmation().contains("Book a Flight"));
		
		//Booking a flight
		System.out.println("Booking the flight");
		BookAFlightPageFactory bookFlight = new BookAFlightPageFactory(driver);
		bookFlight.bookAFlight(passCount1, passFirstName1, passLastName1, mealType1, cardType, creditCardNum, expMonth1, expYear1);
		Assert.assertTrue(bookFlight.confirmationMessage().contains("Your"));
		System.out.println("Flight is successfully booked. "+bookFlight.confirmationMessage());
	}
	
	@DataProvider
	public String[][] getData(){
		String filename = "C:\\Soft\\Test Data\\flightBooking.xls";
		return utilities.Excel.get(filename);
	}
	
	@BeforeMethod
	public void setUp() {
		System.out.println("Initializing the Test");
		//Initializing the web driver
		driver = utilities.DriverFactory.open(browserType);
		driver.get(webURL);
		Reporter.log("Browser is opened and website is launched");
	}
	
	@AfterMethod
	public void tearDown() {
		System.out.println("Closing the test");
		driver.quit();
	}


}

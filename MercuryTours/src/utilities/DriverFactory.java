package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class DriverFactory {
	
	public static WebDriver open(String browserType) {
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.addArguments("--start-maximized");
		
		if (browserType.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\Soft\\chromedriver.exe");
			return new ChromeDriver(chromeOptions);
		}
		
		else if (browserType.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.firefox.driver", "C:\\Soft\\geckodriver.exe");
			return new FirefoxDriver();
		}
		
		else if (browserType.equalsIgnoreCase("IE")) {
			System.setProperty("webdriver.ie.driver", "C:\\Soft\\IEDriverServer.exe");
			return new InternetExplorerDriver();
		}
		
		else {
			System.setProperty("webdriver.chrome.driver", "C:\\Soft\\chromedriver.exe");
			return new ChromeDriver(chromeOptions);
		}
		
	}

}

package cheers.cognizant.testobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import cheers.cognizant.utilities.LibraryFunctions;

public class LoginPage extends LibraryFunctions {
	// Constructor of the LoginPage taking driver and Extent Test
	// instance as parameter
	public LoginPage(WebDriver driver, ExtentTest logger) {
		this.driver = driver;
		this.logger = logger;
	}

	public LandingPage openWebsite(String Url) throws Exception {
		logger.log(Status.INFO, "Opening the WebSite");
		// opening the URL
		driver.get(Url);
		// Waiting for the page to load
		waitForPageLoad();
		// Logging the report status to the ExtentTest instance
		logger.log(Status.PASS, "Navigating To The Home Page");
		wait.until(ExpectedConditions.titleIs("Welcome"));
		logger.log(Status.INFO, "Verifying the title of the Home Page");
		checkTitle("Welcome");
		// Creating instance of landing Page class and passing the driver and ExtentTest
		// instance as arguments
		LandingPage landingPage = new LandingPage(driver, logger);
		// initializing Web Elements defined in the Landing Page Class
		PageFactory.initElements(driver, landingPage);
		return landingPage;
	}

}

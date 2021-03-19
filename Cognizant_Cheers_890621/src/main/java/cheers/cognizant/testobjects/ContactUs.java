package cheers.cognizant.testobjects;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import cheers.cognizant.utilities.ScreenShots;

public class ContactUs extends LoginPage {

	// Constructor of the CorporateWellnessPage taking driver and Extent Test
	// instance as parameter
	public ContactUs(WebDriver driver, ExtentTest logger) throws IOException {
		super(driver, logger);
	}

	@FindBy(xpath = "//*[contains(text(),'International')]/following-sibling::td[2]")
	public WebElement InternationalNumber;

	// Fetching International Number
	public void fetchInternationalNumber() {
		logger.log(Status.INFO, "Fetching the International Number");
		ScreenShots.takeScreenshot(driver);
		String number = getTheText(InternationalNumber);
		System.out.println("International Number - " + number);
		RandomList.add("International Number - " + number);
	}

}

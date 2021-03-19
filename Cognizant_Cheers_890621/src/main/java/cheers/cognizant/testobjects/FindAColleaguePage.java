package cheers.cognizant.testobjects;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import cheers.cognizant.utilities.PropertiesFile;
import cheers.cognizant.utilities.ScreenShots;

public class FindAColleaguePage extends LoginPage {

	// Constructor of the CorporateWellnessPage taking driver and Extent Test
	// instance as parameter
	public FindAColleaguePage(WebDriver driver, ExtentTest logger) throws IOException {
		super(driver, logger);
	}

	@FindBy(xpath = "//*[@class='sideSection pull-left']/h2")
	public WebElement colleagueUserName;

	// Method to get Colleague Name
	public void getColleagueName() throws Exception {
		logger.log(Status.INFO, "Fetching the colleague Name");
		ScreenShots.takeScreenshot(driver);
		String name = getTheText(colleagueUserName);
		Assert.assertEquals((PropertiesFile.readProperties()).getProperty("name"), name);
	}

}

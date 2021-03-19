package cheers.cognizant.testobjects;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import cheers.cognizant.utilities.ScreenShots;

public class MyDashboardMyMobile extends LoginPage {

	public MyDashboardMyMobile(WebDriver driver, ExtentTest logger) throws IOException {
		super(driver, logger);
	}

	@FindBy(xpath = "//div[@class='row noMargin mobile']/p/b[1]")
	public List<WebElement> featureList;

	@FindBy(xpath = "//*[contains(text(),' Manage Mobile account > ')]")
	public WebElement manageMob;
	public By manageMobLocator = By.xpath("//*[contains(text(),' Manage Mobile account > ')]");
	@FindBy(xpath = "//*[@id='sendEmailMobile-button']")
	public WebElement sendEmail;
	public By sendEmailLocator = By.xpath("//*[@id='sendEmailMobile-button']");
	@FindBy(xpath = "//img[@alt='iPhone']")
	public WebElement appleStore;
	public By appleStoreLocator = By.xpath("//img[@alt='iPhone']");
	@FindBy(xpath = "//img[@alt='Android']")
	public WebElement googlePlay;
	public By googlePlayLocator = By.xpath("//img[@alt='Android']");

	// checking if Manage Mobile Button is Clickable
	public void isManageMobButtonClickable() {
		logger.log(Status.INFO, "checking if Manage mobile Button clickable or not");
		isElementClickable(manageMobLocator);
	}

	// checking if send Email Button is Clickable
	public void isSendEmailButtonClickable() {
		logger.log(Status.INFO, "checking if send Email  Button clickable or not");
		isElementClickable(sendEmailLocator);
	}

	// checking if Apple Button is Clickable
	public void isAppleButtonClickable() {
		logger.log(Status.INFO, "checking if apple Button clickable or not");
		isElementClickable(appleStoreLocator);
	}

	// checking if Google Play Button is Clickable
	public void isGooglePlayButtonClickable() {
		logger.log(Status.INFO, "checking if Google Play Button clickable or not");
		isElementClickable(googlePlayLocator);
	}

	// Fetching features list
	public void fetchFeaturesOfMobile() {
		ScreenShots.takeScreenshot(driver);
		logger.log(Status.INFO, "Fetching the Features of the WorkHuman Mobile");
		mobileFeaturesList.add("Fetching the Features of the WorkHuman Mobile");
		System.out.println("Fetching the Features of the WorkHuman Mobile");
		printTheList(featureList, mobileFeaturesList);

	}

}

package cheers.cognizant.testobjects;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class MyDashboardMyActivity extends LoginPage {
	public MyDashboardMyActivity(WebDriver driver, ExtentTest logger) throws IOException {
		super(driver, logger);
	}

	@FindBy(xpath = "//div[@class='mainSection']//h2")
	public WebElement userName;

	@FindBy(xpath = "//*[@id='subNavBar']/li[2]/a")
	public WebElement myAwardsButton;
	public By myAwardsButtonLocator = By.xpath("//*[@id='subNavBar']/li[2]/a");

	@FindBy(xpath = "//*[@id='subNavBar']/li[3]/a")
	public WebElement myNominationsButton;
	public By myNominationsButtonLocator = By.xpath("//*[@id='subNavBar']/li[3]/a");

	@FindBy(xpath = "//*[@id='subNavBar']/li[4]/a")
	public WebElement myOrdersButton;
	public By myOrdersButtonLocator = By.xpath("//*[@id='subNavBar']/li[4]/a");

	@FindBy(xpath = "//*[@id='subNavBar']/li[5]/a")
	public WebElement myMobileButton;
	public By myMobileButtonLocator = By.xpath("//*[@id='subNavBar']/li[5]/a");

	@FindBy(xpath = "//*[@id='subNavBar']/li[6]/a")
	public WebElement mySettingsButton;
	public By mySettingsButtonLocator = By.xpath("//*[@id='subNavBar']/li[6]/a");

	// checking if My Awards Button is Clickable
	public void isMyAwardsButtonClickable() {
		logger.log(Status.INFO, "checking if My Awards Button clickable or not");
		isElementClickable(myAwardsButtonLocator);
	}

	// checking if My Nominations Button is Clickable
	public void isMyNominationsButtonClickable() {
		logger.log(Status.INFO, "checking if My Nominations Button clickable or not");
		isElementClickable(myNominationsButtonLocator);
	}

	// checking if My Orders Button is Clickable
	public void isMyOrdersButtonClickable() {
		logger.log(Status.INFO, "checking if My Orders Button clickable or not");
		isElementClickable(myOrdersButtonLocator);
	}

	// checking if My Settings Button is Clickable
	public void isMySettingsButtonClickable() {
		logger.log(Status.INFO, "checking if My Settings Button clickable or not");
		isElementClickable(mySettingsButtonLocator);
	}

	// checking if My Mobile Button is Clickable
	public void isMyMobileClickable() {
		logger.log(Status.INFO, "checking if My Mobile Button clickable or not");
		isElementClickable(myMobileButtonLocator);
	}

	// Navigating to My Awards Page
	public MyDashboardMyAwards goToMyAwardsPage() throws InterruptedException, IOException {
		logger.log(Status.INFO, "Clicking the My Awards button");
		jsClickTheElement(myAwardsButton);
		Thread.sleep(3000);
		logger.log(Status.INFO, "Verifying the title of the My Awards Page");
		// Checking the title of the page
		checkTitle(
				"Awards Available for Redemption<p> Please note that all awards need to be redeemed within 24 months from the date of receipt. If awards have already expired, please contact our customer service team</p>");
		MyDashboardMyAwards myDashboardMyAwards = new MyDashboardMyAwards(driver, logger);
		// initializing Web Elements defined in the Landing Page Class
		PageFactory.initElements(driver, myDashboardMyAwards);
		return myDashboardMyAwards;
	}

	// Navigating to My Mobile Page
	public MyDashboardMyMobile goToMyMobilePage() throws InterruptedException, IOException {
		logger.log(Status.INFO, "Clicking the My Mobile button");
		jsClickTheElement(myMobileButton);
		Thread.sleep(3000);
		logger.log(Status.INFO, "Verifying the title of the My Mobile Page");
		// Checking the title of the page
		checkTitle("Workhuman Mobile");
		MyDashboardMyMobile myDashboardMyMobile = new MyDashboardMyMobile(driver, logger);
		// initializing Web Elements defined in the Landing Page Class
		PageFactory.initElements(driver, myDashboardMyMobile);
		return myDashboardMyMobile;
	}

	// Navigating to My Nominations Page
	public MyDashboardMyNominations goToMyNominationsPage() throws InterruptedException, IOException {
		logger.log(Status.INFO, "Clicking the My Nominations button");
		jsClickTheElement(myNominationsButton);
		Thread.sleep(3000);
		logger.log(Status.INFO, "Verifying the title of the My Nominations Page");
		// Checking the title of the page
		checkTitle("People You Have Recognized");
		MyDashboardMyNominations myDashboardMyNominations = new MyDashboardMyNominations(driver, logger);
		// initializing Web Elements defined in the Landing Page Class
		PageFactory.initElements(driver, myDashboardMyNominations);
		return myDashboardMyNominations;
	}

	// Navigating to My Orders Page
	public MyDashboardMyOrders goToMyOrdersPage() throws InterruptedException, IOException {
		logger.log(Status.INFO, "Clicking the My Orders button");
		jsClickTheElement(myOrdersButton);
		Thread.sleep(3000);
		logger.log(Status.INFO, "Verifying the title of the My Orders Page");
		// Checking the title of the page
		checkTitle("Store");
		MyDashboardMyOrders myDashboardMyOrders = new MyDashboardMyOrders(driver, logger);
		// initializing Web Elements defined in the Landing Page Class
		PageFactory.initElements(driver, myDashboardMyOrders);
		return myDashboardMyOrders;
	}

	// Navigating to My Settings Page
	public MyDashboardMySettings goToMYSettingsPage() throws InterruptedException, IOException {
		logger.log(Status.INFO, "Clicking the My Settings button");
		jsClickTheElement(mySettingsButton);
		Thread.sleep(3000);
		waitForPageLoad();
		logger.log(Status.INFO, "Verifying the title of the My Settings Page");
		// Checking the title of the page
		checkTitle("My Settings");
		MyDashboardMySettings myDashboardMySettings = new MyDashboardMySettings(driver, logger);
		// initializing Web Elements defined in the Landing Page Class
		PageFactory.initElements(driver, myDashboardMySettings);
		return myDashboardMySettings;
	}

	// Method to print the username
	public void printUserName() {
		logger.log(Status.INFO, "Printing the UserName of My Dashboard");
		String name = getTheText(userName);
		System.out.println("UserName: " + name);
		RandomList.add("UserName: " + name);
		logger.log(Status.PASS, "UserName Printed Successful");
	}

}

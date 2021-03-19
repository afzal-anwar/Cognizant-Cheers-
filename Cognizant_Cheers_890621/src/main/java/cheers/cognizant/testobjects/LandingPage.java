package cheers.cognizant.testobjects;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import cheers.cognizant.utilities.PropertiesFile;
import cheers.cognizant.utilities.ScreenShots;

public class LandingPage extends LoginPage {

	// Constructor of the CorporateWellnessPage taking driver and Extent Test
	// instance as parameter
	public LandingPage(WebDriver driver, ExtentTest logger) throws IOException {
		super(driver, logger);
	}

	@FindBy(xpath = "//*[@id='navBar']/div/ul/li[1]/span[2]/a")
	public WebElement homeButton;
	public By homeButtonLocator = By.xpath("//*[@id='navBar']/div/ul/li[1]/span[2]/a");

	@FindBy(xpath = "//div[@id='userProfileSearchResultsContainer']/div[1]")
	public WebElement firstColleagueSuggestion;

	@FindBy(xpath = "//*[@id='programLogo']//img")
	public WebElement cognizantLogo;
	public By cognizantLogoLocator = By.xpath("//*[@id='programLogo']//img");

	@FindBy(xpath = "//div[@id='np-select-recipient-content']/div[3]/ul[1]//div[3]/h4")
	public List<WebElement> nameList;

	@FindBy(xpath = "//a[contains(text(),'My Dashboard')]")
	public WebElement myDashboardButton;
	public By myDashBoardButtonLocator = By.xpath("//a[contains(text(),'My Dashboard')]");

	@FindBy(xpath = "//*[@class='listStyle2 right']//a[contains(text(),'Contact Us')]")
	public WebElement contactUsButton;
	public By contactUsButtonLocator = By.xpath("//*[@class='listStyle2 right']//a[contains(text(),'Contact Us')]");

	@FindBy(xpath = "//*[@id='navBar']//li[3]//a")
	public WebElement recognizeButton;
	public By recognizeButtonLocator = By.xpath("//*[@id='navBar']//li[3]//a");

	@FindBy(xpath = "//*[@id='navBar']//li[4]//a")
	public WebElement redeemButton;
	public By redeemButtonLocator = By.xpath("//*[@id='navBar']//li[4]//a");

	@FindBy(xpath = "//*[@class='recognize-link']")
	public WebElement recognizeGridButton;
	public By recognizeGridButtonLocator = By.xpath("//*[@class='recognize-link'] ");

	@FindBy(xpath = "//*[@id='spendAward-button'] ")
	public WebElement redeemGridButton;
	public By redeemGridButtonLocator = By.xpath("//*[@id='spendAward-button'] ");

	@FindBy(xpath = "//*[@id='footer']//p/a[1]")
	public WebElement footerTermsOfUseButton;
	public By footerTermsOfUseButtonLocator = By.xpath("//*[@id='footer']//p/a[1]");

	@FindBy(xpath = "//*[@id='footer']//p/a[2]")
	public WebElement footerPrivacyPolicyButton;
	public By footerPrivacyPolicyLocator = By.xpath("//*[@id='footer']//p/a[2]");

	@FindBy(xpath = "//*[@id='footer']//p/a[3]")
	public WebElement footerCookiePolicyButton;
	public By footerCookiePolicyButtonLocator = By.xpath("//*[@id='footer']//p/a[3]");

	@FindBy(xpath = "//*[@id='footer']//p/a[4]")
	public WebElement footerContactUsButton;
	public By footerContactUsButtonLocator = By.xpath("//*[@id='footer']//p/a[4]");

	@FindBy(xpath = "//nav//*[@title='#Cheers']")
	public WebElement controlBarCheersButton;
	public By controlBarCheersButtonLocator = By.xpath("//nav//*[@title='#Cheers']");

	@FindBy(xpath = "//*[@id='globalNavHolder']/global-nav/gn-app-links/nav/div[1]/a[2]")
	public WebElement controlBarStoreButton;
	public By controlBarStoreButtonLocator = By
			.xpath("//*[@id='globalNavHolder']/global-nav/gn-app-links/nav/div[1]/a[2]");

	@FindBy(xpath = "//*[@class='gn-cart gn-text']")
	public WebElement controlBarCartButton;
	public By controlBarCartButtonLocator = By.xpath("//*[@class='gn-cart gn-text']");

	@FindBy(xpath = "//*[@id='gn-balanceLink']")
	public WebElement controlBar0PointsButton;
	public By controlBar0PointsButtonLocator = By.xpath("//*[@id='gn-balanceLink']");

	@FindBy(xpath = "//*[@id='gn-user-dropdown-toggler']")
	public WebElement controlBarDropdownButton;
	public By controlBarDropdownButtonLocator = By.xpath("//*[@id='gn-user-dropdown-toggler']");

	@FindBy(xpath = "//*[@id='gn-dropdown-myAwardsLink']")
	public WebElement controlBarMyAwrardsButton;
	public By controlBarMyAwrardsButtonLocator = By.xpath("//*[@id='gn-dropdown-myAwardsLink']");

	@FindBy(xpath = "//*[@id='gn-dropdown-myOrdersLink']")
	public WebElement controlBarMyOrdersButton;
	public By controlBarMyOrdersButtonLocator = By.xpath("//*[@id='gn-dropdown-myOrdersLink']");

	@FindBy(xpath = "//*[@id='gn-dropdown']//a[3]")
	public WebElement controlBarLogOutButton;
	public By controlBarLogOutButtonLocator = By.xpath("//*[@id='gn-dropdown']//a[3]");

	@FindBy(xpath = "//*[@class='listStyle2 right']//span")
	public WebElement programInformationButton;
	public By programInformationButtonLocator = By.xpath("//*[@class='listStyle2 right']//span");

	@FindBy(xpath = "//*[@id='userProfileSearchInput']")
	public WebElement findingAColleagueTextbox;
	public By findingAColleagueTextboxLocator = By.xpath("//*[@id='userProfileSearchInput']");

	@FindBy(xpath = "//div[@class='gf-drawer np-app-drawer']/div/button")
	public WebElement closeButton;

	// checking if Home Button is Clickable
	public void isHomeButtonClickable() {
		logger.log(Status.INFO, "checking if Home Button is clickable or not");
		isElementClickable(homeButtonLocator);
	}

	// checking if Cognizant Logo is Clickable
	public void isCognizantLogoClickable() {
		logger.log(Status.INFO, "checking if Cognizant Logo is clickable or not");
		isElementClickable(cognizantLogoLocator);
	}

	// checking if My Dashboard Button is Clickable
	public void isMyDashboardButtonClickable() {
		logger.log(Status.INFO, "checking if My Dashboard Button is clickable or not");
		isElementClickable(myDashBoardButtonLocator);
	}

	// checking if Contact us Button is Clickable
	public void isContactUsButtonClickable() {
		logger.log(Status.INFO, "checking if contact Us Button is clickable or not");
		isElementClickable(contactUsButtonLocator);

	}

	// checking if Nav Bar recognize Button is Clickable
	public void isRecognizeNavButtonClickable() {
		logger.log(Status.INFO, "checking if Recognize Button at navbar is clickable or not");
		isElementClickable(recognizeButtonLocator);

	}

	// checking if nav bar redeem Button is Clickable
	public void isRedeemNavButtonClickable() {
		logger.log(Status.INFO, "checking if Redeem Button at navbar is clickable or not");
		isElementClickable(redeemButtonLocator);
	}

	// checking if Grid Redeem Button is Clickable
	public void isRedeemGridButtonClickable() {
		logger.log(Status.INFO, "checking if Redeem Button at grid is clickable or not");
		isElementClickable(redeemGridButtonLocator);

	}

	// checking if grid recognize Button is Clickable
	public void isRecognizeGridButtonClickable() {
		logger.log(Status.INFO, "checking if Recognize Button at grid is clickable or not");
		isElementClickable(recognizeGridButtonLocator);
	}

	// checking if Footer Contact us Button is Clickable
	public void isFooterContactUsButtonClickable() {
		logger.log(Status.INFO, "checking if contact us Button at footer is clickable or not");
		isElementClickable(footerContactUsButtonLocator);

	}

	// checking if Footer Terms Of use Button is Clickable
	public void isFooterTermsOfButtonClickable() {
		logger.log(Status.INFO, "checking if Terms Of Use Button at footer is clickable or not");
		isElementClickable(footerTermsOfUseButtonLocator);
	}

	// checking if Footer Privacy Policy Button is Clickable
	public void isFooterPrivacyPolicyClickable() {
		logger.log(Status.INFO, "checking if Privacy Policy Button at footer is clickable or not");
		isElementClickable(footerPrivacyPolicyLocator);

	}

	// checking if Footer Cookie policy Button is Clickable
	public void isFooterCookiePolicyClickable() {
		logger.log(Status.INFO, "checking if Cookie Policy Button at footer is clickable or not");
		isElementClickable(footerCookiePolicyButtonLocator);

	}

	// checking if Control Bar Cheers Button is Clickable
	public void isControlBarCheersButtonClickable() {
		logger.log(Status.INFO, "checking if Cheers Button at control Bar is clickable or not");
		isElementClickable(controlBarCheersButtonLocator);

	}

	// checking if Control Bar Store Button is Clickable
	public void isControlBarStoreButtonClickable() {
		logger.log(Status.INFO, "checking if Store Button at control Bar is clickable or not");
		isElementClickable(controlBarStoreButtonLocator);

	}

	// checking if Control Bar Cart Button is Clickable
	public void iscontrolBarCartButtonClickable() {
		logger.log(Status.INFO, "checking if Cart Button at control Bar is clickable or not");
		isElementClickable(controlBarCartButtonLocator);
	}

	// checking if Control Bar 0 Points Button is Clickable
	public void iscontrolBar0PointsButtonClickable() {
		logger.log(Status.INFO, "checking if 0 Points Button at control Bar is clickable or not");
		isElementClickable(controlBar0PointsButtonLocator);
	}

	// checking if Control Bar Drop Down Button is Clickable
	public void iscontrolBarDropdownButtonClickable() {
		logger.log(Status.INFO, "checking if DropDown Button at control Bar is clickable or not");
		isElementClickable(controlBarDropdownButtonLocator);

	}

	// checking if Control Bar My Awards Button is Clickable
	public void iscontrolBarMyAwardsButtonClickable() {
		logger.log(Status.INFO, "checking if My Awards Button at control Bar is clickable or not");
		isElementClickable(controlBarMyAwrardsButtonLocator);
	}

	// checking if Control Bar My Orders Button is Clickable
	public void iscontrolBarMyOrdersButtonClickable() {
		logger.log(Status.INFO, "checking if My Orders Button at control Bar is clickable or not");
		isElementClickable(controlBarMyOrdersButtonLocator);
	}

	// checking if Control Bar Log Out Button is Clickable
	public void iscontrolBarLogOutButtonClickable() {
		logger.log(Status.INFO, "checking if Log Out Button at control Bar is clickable or not");
		isElementClickable(controlBarLogOutButtonLocator);
	}

	// checking if Program Information Button is Clickable
	public void isProgramInformationButtonClickable() {
		logger.log(Status.INFO, "checking if Program Information Button at is clickable or not");
		isElementClickable(programInformationButtonLocator);

	}

	// checking if finding a colleague is Enabled
	public void isFindingAColleagueTextboxEnabled() {
		logger.log(Status.INFO, "checking if Finding a Colleague Textbox is enabled or not");
		isElementEnabled(findingAColleagueTextbox);
	}

	// click on control bar dropdown button
	public void clickControlBarDropdownButton() {
		logger.log(Status.INFO, "Clicking on dropdown button");
		clickTheElement(controlBarDropdownButton);
	}

	// Navigating to my activity page
	public MyDashboardMyActivity clickingMyDashboardButton() throws IOException {
		logger.log(Status.INFO, "clicking on My Dashboard Button");
		clickTheElement(myDashboardButton);
		waitForPageLoad();
		logger.log(Status.INFO, "Verifying the title of My Dashboard page");
		checkTitle("My Activity");
		// Creating instance of landing Page class and passing the driver and ExtentTest
		// instance as arguments
		MyDashboardMyActivity myActivity = new MyDashboardMyActivity(driver, logger);
		// initializing Web Elements defined in the Landing Page Class
		PageFactory.initElements(driver, myActivity);
		return myActivity;
	}

	// Fetching Recognized Names
	public void fetchRecognizedNames() {
		logger.log(Status.INFO, "clicking on recognize Grid Button");
		clickTheElement(recognizeGridButton);
		waitForPageLoad();
		logger.log(Status.INFO, "Fetching the list of Names");
		printTheList(nameList, nameOfColleagueslist);
	}

	// Clicking on Grid Redeem Button
	public ShoppingPage clickGridRedeem() throws IOException {
		logger.log(Status.INFO, "clicking on Redeem button on Grid");
		clickTheElement(redeemGridButton);
		waitForPageLoad();
		logger.log(Status.INFO, "Verifying the title of Shopping Page");
		checkTitle("Store");
		// Creating instance of landing Page class and passing the driver and ExtentTest
		// instance as arguments
		ShoppingPage shoppingPage = new ShoppingPage(driver, logger);
		// initializing Web Elements defined in the Landing Page Class
		PageFactory.initElements(driver, shoppingPage);
		return shoppingPage;
	}

	// Finding a colleague through emp Id
	public FindAColleaguePage searchForAColleague() throws IOException {
		logger.log(Status.INFO, "Searching for a colleague");
		sendTheKeys(findingAColleagueTextbox, PropertiesFile.readProperties().getProperty("empId"));
		clickTheElement(firstColleagueSuggestion);
		waitForPageLoad();
		// findingAColleagueTextbox.sendKeys(Keys.ENTER);
		logger.log(Status.INFO, "Verifying the title of View Profile Page");
		checkTitle("View Profile");
		FindAColleaguePage findAColleaguePage = new FindAColleaguePage(driver, logger);
		// initializing Web Elements defined in the Landing Page Class
		PageFactory.initElements(driver, findAColleaguePage);
		return findAColleaguePage;
	}

	// Clicking on 0 points Button
	public ShoppingPage click0PointsButton() throws IOException {
		logger.log(Status.INFO, "clicking on 0 Points button on control Bar");
		clickTheElement(redeemGridButton);
		waitForPageLoad();
		logger.log(Status.INFO, "Verifying the title of Shopping Page");
		checkTitle("Store");
		// Creating instance of landing Page class and passing the driver and ExtentTest
		// instance as arguments
		ShoppingPage shoppingPage = new ShoppingPage(driver, logger);
		// initializing Web Elements defined in the Landing Page Class
		PageFactory.initElements(driver, shoppingPage);
		return shoppingPage;
	}

	// Navigating to My Awards Page by clicking on My Awards
	public MyDashboardMyAwards clickOnControlBarMyAwardsButton() throws IOException {
		logger.log(Status.INFO, "clicking on control Bar My Awards button on control Bar");
		clickTheElement(redeemGridButton);
		waitForPageLoad();
		logger.log(Status.INFO, "Verifying the title of My Awards Page");
		checkTitle("Store");
		// Creating instance of landing Page class and passing the driver and ExtentTest
		// instance as arguments
		MyDashboardMyAwards myDashboardMyAwards = new MyDashboardMyAwards(driver, logger);
		// initializing Web Elements defined in the Landing Page Class
		PageFactory.initElements(driver, myDashboardMyAwards);
		return myDashboardMyAwards;
	}

	// Navigating to My Orders Page by clicking on My orders
	public MyDashboardMyOrders clickOnControlBarMyOrdersButton() throws IOException {
		logger.log(Status.INFO, "clicking on control Bar My Orders button on control Bar");
		clickTheElement(redeemGridButton);
		waitForPageLoad();
		logger.log(Status.INFO, "Verifying the title of My Orders Page");
		checkTitle("Store");
		// Creating instance of landing Page class and passing the driver and ExtentTest
		// instance as arguments
		MyDashboardMyOrders myDashboardMyOrders = new MyDashboardMyOrders(driver, logger);
		// initializing Web Elements defined in the Landing Page Class
		PageFactory.initElements(driver, myDashboardMyOrders);
		return myDashboardMyOrders;
	}

	// Navigating to Shopping Cart Page by clicking on cart button
	public ShoppingPage clickOnCartButton() throws IOException {
		logger.log(Status.INFO, "clicking on cart button on control Bar");
		clickTheElement(redeemGridButton);
		waitForPageLoad();
		logger.log(Status.INFO, "Verifying the title of Cart Page");
		checkTitle("Store");
		// Creating instance of landing Page class and passing the driver and ExtentTest
		// instance as arguments
		ShoppingPage shoppingPage = new ShoppingPage(driver, logger);
		// initializing Web Elements defined in the Landing Page Class
		PageFactory.initElements(driver, shoppingPage);
		return shoppingPage;
	}

	// Navigating to Shopping Page by clicking on store button
	public ShoppingPage clickOnControlBarStoreButton() throws IOException, InterruptedException {
		ScreenShots.takeScreenshot(driver);
		logger.log(Status.INFO, "clicking on store button on control Bar");
		clickTheElement(redeemGridButton);
		waitForPageLoad();
		Thread.sleep(3000);
		logger.log(Status.INFO, "Verifying the title of Cart Page");
		checkTitle("Store");
		// Creating instance of landing Page class and passing the driver and ExtentTest
		// instance as arguments
		ShoppingPage shoppingPage = new ShoppingPage(driver, logger);
		// initializing Web Elements defined in the Landing Page Class
		PageFactory.initElements(driver, shoppingPage);
		return shoppingPage;
	}

	// Navigating to Home Page by clicking on Home Button
	public LandingPage clickOnHomeButton() throws IOException {
		logger.log(Status.INFO, "clicking on Home button on nav Bar");
		clickTheElement(homeButton);
		waitForPageLoad();
		logger.log(Status.INFO, "Verifying the title of Home Page");
		checkTitle("Welcome");
		// Creating instance of landing Page class and passing the driver and ExtentTest
		// instance as arguments
		LandingPage landingPage = new LandingPage(driver, logger);
		// initializing Web Elements defined in the Landing Page Class
		PageFactory.initElements(driver, landingPage);
		return landingPage;
	}

	// Clicking on Cognizant Logo and navigating to Home Page
	public LandingPage clickOnCognizantLogo() throws IOException {
		logger.log(Status.INFO, "clicking on Cognizant Logo on above nav bar");
		clickTheElement(cognizantLogo);
		waitForPageLoad();
		logger.log(Status.INFO, "Verifying the title of Home Page");
		checkTitle("Welcome");
		// Creating instance of landing Page class and passing the driver and ExtentTest
		// instance as arguments
		LandingPage landingPage = new LandingPage(driver, logger);
		// initializing Web Elements defined in the Landing Page Class
		PageFactory.initElements(driver, landingPage);
		return landingPage;
	}

	// Navigating to Home Page by clicking on cheers button
	public LandingPage clickOnCheersButton() throws IOException {
		logger.log(Status.INFO, "clicking on Cheers Button on Control Bar");
		clickTheElement(controlBarCheersButton);
		waitForPageLoad();
		logger.log(Status.INFO, "Verifying the title of Home Page");
		checkTitle("Welcome");
		// Creating instance of landing Page class and passing the driver and ExtentTest
		// instance as arguments
		LandingPage landingPage = new LandingPage(driver, logger);
		// initializing Web Elements defined in the Landing Page Class
		PageFactory.initElements(driver, landingPage);
		return landingPage;
	}

	// Navigating to Shopping Page by clicking on Nav Bar Redeem button
	public ShoppingPage clickNavRedeemButton() throws IOException {
		logger.log(Status.INFO, "clicking on Redeem Button on Nav Bar");
		clickTheElement(redeemButton);
		waitForPageLoad();
		logger.log(Status.INFO, "Verifying the title of Shopping Page");
		checkTitle("Store");
		// Creating instance of landing Page class and passing the driver and ExtentTest
		// instance as arguments
		ShoppingPage shoppingPage = new ShoppingPage(driver, logger);
		// initializing Web Elements defined in the Landing Page Class
		PageFactory.initElements(driver, shoppingPage);
		return shoppingPage;
	}

	// Navigating to Contact Us Page by clicking on contact us button
	public ContactUs clickContactUsButton() throws IOException {
		logger.log(Status.INFO, "clicking on Contact Us Button");
		clickTheElement(contactUsButton);
		waitForPageLoad();
		logger.log(Status.INFO, "Verifying the title of Contact Us Page");
		checkTitle("Contacts");
		// Creating instance of landing Page class and passing the driver and ExtentTest
		// instance as arguments
		ContactUs contactUs = new ContactUs(driver, logger);
		// initializing Web Elements defined in the Landing Page Class
		PageFactory.initElements(driver, contactUs);
		return contactUs;
	}

	// Clicking on Grid Recognize Button
	public void clickGridRecognize() throws IOException {
		logger.log(Status.INFO, "clicking on Recognize button on Grid");
		clickTheElement(recognizeGridButton);
		logger.log(Status.INFO, "Verifying If List of colleagues is Shown");
		logger.log(Status.PASS, "List of colleagues is Shown Successfully");
		logger.log(Status.PASS, "Closing the List Window");
		jsClickTheElement(closeButton);
	}

	// Clicking on Nav Bar Recognize Button
	public void clickNavRecognize() throws IOException {
		logger.log(Status.INFO, "clicking on Recognize button on Nav Bar");
		clickTheElement(recognizeButton);
		logger.log(Status.INFO, "Verifying If List of colleagues is Shown");
		logger.log(Status.PASS, "List of colleagues is Shown Successfully");
		logger.log(Status.PASS, "Closing the List Window");
		jsClickTheElement(closeButton);
	}

}

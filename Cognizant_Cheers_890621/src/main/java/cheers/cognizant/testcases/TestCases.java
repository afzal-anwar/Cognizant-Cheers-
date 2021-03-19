package cheers.cognizant.testcases;

import java.io.IOException;
import java.util.ArrayList;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import cheers.cognizant.testobjects.ContactUs;
import cheers.cognizant.testobjects.FindAColleaguePage;
import cheers.cognizant.testobjects.LandingPage;
import cheers.cognizant.testobjects.LoginPage;
import cheers.cognizant.testobjects.MyDashboardMyActivity;
import cheers.cognizant.testobjects.MyDashboardMyAwards;
import cheers.cognizant.testobjects.MyDashboardMyMobile;
import cheers.cognizant.testobjects.MyDashboardMyNominations;
import cheers.cognizant.testobjects.MyDashboardMyOrders;
import cheers.cognizant.testobjects.MyDashboardMySettings;
import cheers.cognizant.testobjects.ShoppingPage;
import cheers.cognizant.testobjects.ShoppingSearchResults;
import cheers.cognizant.utilities.ExcelUtils;
import cheers.cognizant.utilities.LibraryFunctions;
import cheers.cognizant.utilities.PropertiesFile;

public class TestCases extends LibraryFunctions {
	public LandingPage landingPage;
	public LoginPage loginPage;
	public FindAColleaguePage findAColleaguePage;
	public ShoppingPage shoppingPage;
	public ShoppingSearchResults shoppingSearchResults;
	public ContactUs contactUsPage;
	public MyDashboardMyAwards myDashboardMyAwards;
	public MyDashboardMyOrders myDashboardMyOrders;
	public MyDashboardMyActivity myDashboardMyActivity;
	public MyDashboardMyMobile myDashboardMyMobile;
	public MyDashboardMyNominations myDashboardMyNominations;
	public MyDashboardMySettings myDashboardMySettings;

	// Method get the browser name from properties file and opening the browser
	@BeforeSuite(alwaysRun = true)
	@Parameters({ "browserCodes" })
	public void openTheBrowser(String browserCodes) throws Exception {
		openBrowser(PropertiesFile.readProperties().getProperty(browserCodes));
	}

	// Method to smoke test the home page
	@Test(groups = { "Smoke" }, priority = 0)
	public void homePageSmoke() throws IOException, Exception {
		// Creating the ExtentTest instance for the Test
		logger = report.createTest("Smoke Home Page");
		// Creating instance of login Page class and passing the driver and ExtentTest
		// instance as arguments
		LoginPage loginPage = new LoginPage(driver, logger);
		// initializing Web Elements defined in the LoginPage Class
		PageFactory.initElements(driver, loginPage);
		// Opening the Website by calling the method of Login Page class and passing the
		// url through the properties file
		landingPage = loginPage.openWebsite((PropertiesFile.readProperties()).getProperty("url"));
		landingPage.isHomeButtonClickable();
		landingPage.isCognizantLogoClickable();
		landingPage.isFooterContactUsButtonClickable();
		landingPage.isFooterCookiePolicyClickable();
		landingPage.isFooterPrivacyPolicyClickable();
		landingPage.isFooterTermsOfButtonClickable();
		landingPage.isControlBarStoreButtonClickable();
		landingPage.isMyDashboardButtonClickable();
	}

	// Method to smoke test the shopping page
	@Test(groups = { "Smoke" }, priority = 1)
	public void shoppingPageSmoke() throws IOException, Exception {
		logger = report.createTest("Smoke Shopping Page");
		LoginPage loginPage = new LoginPage(driver, logger);
		PageFactory.initElements(driver, loginPage);
		landingPage = loginPage.openWebsite((PropertiesFile.readProperties()).getProperty("url"));
		shoppingPage = landingPage.clickOnControlBarStoreButton();
		shoppingPage.isEditorPicksButtonClickable();
		shoppingPage.isShopAllButtonClickable();
		shoppingPage.isSearchBoxEnabled();
		shoppingPage.isTopBrandsButtonClickable();
	}

	// Method for Regression 1
	@Test(groups = { "Regression" }, priority = 2)
	public void regression_1() throws IOException, Exception {
		logger = report.createTest("Regression 1");
		LoginPage loginPage = new LoginPage(driver, logger);
		PageFactory.initElements(driver, loginPage);
		landingPage = loginPage.openWebsite((PropertiesFile.readProperties()).getProperty("url"));
		findAColleaguePage = landingPage.searchForAColleague();
		findAColleaguePage.getColleagueName();
	}

	// Method for Regression 2
	@Test(groups = { "Regression" }, priority = 3)
	public void regression_2() throws IOException, Exception {
		logger = report.createTest("Regression 2");
		LoginPage loginPage = new LoginPage(driver, logger);
		PageFactory.initElements(driver, loginPage);
		landingPage = loginPage.openWebsite((PropertiesFile.readProperties()).getProperty("url"));
		landingPage.isContactUsButtonClickable();
		contactUsPage = landingPage.clickContactUsButton();
		contactUsPage.fetchInternationalNumber();
	}

	// Method to check Home Button
	@Test(groups = { "Functional" }, priority = 4)
	public void checkHomeButton() throws IOException, Exception {
		logger = report.createTest("Home Button Check");
		LoginPage loginPage = new LoginPage(driver, logger);
		PageFactory.initElements(driver, loginPage);
		landingPage = loginPage.openWebsite((PropertiesFile.readProperties()).getProperty("url"));
		landingPage.isHomeButtonClickable();
		landingPage = landingPage.clickOnHomeButton();
	}

	// Method to check Cognizant Logo
	@Test(groups = { "Functional" }, priority = 5)
	public void checkCognizantLogo() throws IOException, Exception {
		logger = report.createTest("Cognizant Logo Button Check");
		LoginPage loginPage = new LoginPage(driver, logger);
		PageFactory.initElements(driver, loginPage);
		landingPage = loginPage.openWebsite((PropertiesFile.readProperties()).getProperty("url"));
		landingPage.isCognizantLogoClickable();
		landingPage = landingPage.clickOnCognizantLogo();
	}

	// Method to check Cheers Button
	@Test(groups = { "Functional" }, priority = 6)
	public void checkCheersButton() throws IOException, Exception {
		logger = report.createTest("Cheers Button Check");
		LoginPage loginPage = new LoginPage(driver, logger);
		PageFactory.initElements(driver, loginPage);
		landingPage = loginPage.openWebsite((PropertiesFile.readProperties()).getProperty("url"));
		landingPage.isControlBarCheersButtonClickable();
		landingPage = landingPage.clickOnCheersButton();
	}

	// Method to check Store Button
	@Test(groups = { "Functional" }, priority = 7)
	public void checkStoreButton() throws IOException, Exception {
		logger = report.createTest("Store Button Check");
		LoginPage loginPage = new LoginPage(driver, logger);
		PageFactory.initElements(driver, loginPage);
		landingPage = loginPage.openWebsite((PropertiesFile.readProperties()).getProperty("url"));
		landingPage.isControlBarStoreButtonClickable();
		shoppingPage = landingPage.clickOnControlBarStoreButton();
	}

	// Method to check cart button
	@Test(groups = { "Functional" }, priority = 8)
	public void checkCartButton() throws IOException, Exception {
		logger = report.createTest("Cart Button Check");
		LoginPage loginPage = new LoginPage(driver, logger);
		PageFactory.initElements(driver, loginPage);
		landingPage = loginPage.openWebsite((PropertiesFile.readProperties()).getProperty("url"));
		landingPage.iscontrolBarCartButtonClickable();
		shoppingPage = landingPage.clickOnCartButton();

	}

	// Method to check points button
	@Test(groups = { "Functional" }, priority = 9)
	public void checkPointsButton() throws IOException, Exception {
		logger = report.createTest("Points Button Check");
		LoginPage loginPage = new LoginPage(driver, logger);
		PageFactory.initElements(driver, loginPage);
		landingPage = loginPage.openWebsite((PropertiesFile.readProperties()).getProperty("url"));
		landingPage.iscontrolBar0PointsButtonClickable();
		shoppingPage = landingPage.click0PointsButton();
	}

	// Method to check dropdown button of home page
	@Test(groups = { "Functional" }, priority = 10)
	public void checkDropdownButton() throws IOException, Exception {
		logger = report.createTest("DropDown Button Check");
		LoginPage loginPage = new LoginPage(driver, logger);
		PageFactory.initElements(driver, loginPage);
		landingPage = loginPage.openWebsite((PropertiesFile.readProperties()).getProperty("url"));
		landingPage.iscontrolBarDropdownButtonClickable();
	}

	// Method to check Control bar My Awrads button of home page
	@Test(groups = { "Functional" }, priority = 11)
	public void checkControlBarMyAwardsButton() throws IOException, Exception {
		logger = report.createTest("Control Bar My Awards Button Check");
		LoginPage loginPage = new LoginPage(driver, logger);
		PageFactory.initElements(driver, loginPage);
		landingPage = loginPage.openWebsite((PropertiesFile.readProperties()).getProperty("url"));
		landingPage.clickControlBarDropdownButton();
		landingPage.iscontrolBarMyAwardsButtonClickable();
		myDashboardMyAwards = landingPage.clickOnControlBarMyAwardsButton();
	}

	// Method to check Control bar My Awrads button of home page
	@Test(groups = { "Functional" }, priority = 12)
	public void checkControlBarMyOrdersButton() throws IOException, Exception {
		logger = report.createTest("Control Bar My Orders Button Check");
		LoginPage loginPage = new LoginPage(driver, logger);
		PageFactory.initElements(driver, loginPage);
		landingPage = loginPage.openWebsite((PropertiesFile.readProperties()).getProperty("url"));
		landingPage.clickControlBarDropdownButton();
		landingPage.iscontrolBarMyOrdersButtonClickable();
		myDashboardMyOrders = landingPage.clickOnControlBarMyOrdersButton();
	}

	// Method to check Control bar My Log Out button of home page
	@Test(groups = { "Functional" }, priority = 13)
	public void checkControlBarLogoutButton() throws IOException, Exception {
		logger = report.createTest("Control Bar Logout Button Check");
		LoginPage loginPage = new LoginPage(driver, logger);
		PageFactory.initElements(driver, loginPage);
		landingPage = loginPage.openWebsite((PropertiesFile.readProperties()).getProperty("url"));
		landingPage.clickControlBarDropdownButton();
		landingPage.iscontrolBarLogOutButtonClickable();
	}

	// Method to check Control bar My Log Out button of home page
	@Test(groups = { "Functional" }, priority = 14)
	public void checkGridRedeem() throws IOException, Exception {
		logger = report.createTest("Grid Redeem Button Check");
		LoginPage loginPage = new LoginPage(driver, logger);
		PageFactory.initElements(driver, loginPage);
		landingPage = loginPage.openWebsite((PropertiesFile.readProperties()).getProperty("url"));
		landingPage.isRedeemGridButtonClickable();
		shoppingPage = landingPage.clickGridRedeem();
	}

	// Method to check Grid Recognize button of home page
	@Test(groups = { "Functional" }, priority = 15)
	public void checkGridRecognize() throws IOException, Exception {
		logger = report.createTest("Grid Recognize Button Check");
		LoginPage loginPage = new LoginPage(driver, logger);
		PageFactory.initElements(driver, loginPage);
		landingPage = loginPage.openWebsite((PropertiesFile.readProperties()).getProperty("url"));
		landingPage.isRecognizeGridButtonClickable();
		landingPage.clickGridRecognize();
	}

	// Method to check Grid Redeem button of home page
	@Test(groups = { "Functional" }, priority = 16)
	public void checkNavRedeem() throws IOException, Exception {
		logger = report.createTest("Nav Redeem Button Check");
		LoginPage loginPage = new LoginPage(driver, logger);
		PageFactory.initElements(driver, loginPage);
		landingPage = loginPage.openWebsite((PropertiesFile.readProperties()).getProperty("url"));
		landingPage.isRedeemNavButtonClickable();
		landingPage.clickNavRedeemButton();
	}

	// Method to check Nav Recognize button of home page
	@Test(groups = { "Functional" }, priority = 17)
	public void checkNavRecognizeButton() throws IOException, Exception {
		logger = report.createTest("Nav Recognize Button Check");
		LoginPage loginPage = new LoginPage(driver, logger);
		PageFactory.initElements(driver, loginPage);
		landingPage = loginPage.openWebsite((PropertiesFile.readProperties()).getProperty("url"));
		landingPage.isRecognizeNavButtonClickable();
		landingPage.clickNavRecognize();
	}

	// Method to check Footer Terms Of Use button of home page
	@Test(groups = { "Functional" }, priority = 18)
	public void checkFooterTermsOfUseButton() throws IOException, Exception {
		logger = report.createTest("Footer Terms Of use Button Check");
		LoginPage loginPage = new LoginPage(driver, logger);
		PageFactory.initElements(driver, loginPage);
		landingPage = loginPage.openWebsite((PropertiesFile.readProperties()).getProperty("url"));
		landingPage.isFooterTermsOfButtonClickable();
	}

	// Method to check Footer Policy button of home page
	@Test(groups = { "Functional" }, priority = 19)
	public void checkFooterPrivacyPolicyButton() throws IOException, Exception {
		logger = report.createTest("Footer Privacy Policy Button Check");
		LoginPage loginPage = new LoginPage(driver, logger);
		PageFactory.initElements(driver, loginPage);
		landingPage = loginPage.openWebsite((PropertiesFile.readProperties()).getProperty("url"));
		landingPage.isFooterPrivacyPolicyClickable();
	}

	// Method to check Footer Cookie Policy button of home page
	@Test(groups = { "Functional" }, priority = 20)
	public void checkFooterCookiePolicyButton() throws IOException, Exception {
		logger = report.createTest("Footer Cookie Policy Button Check");
		LoginPage loginPage = new LoginPage(driver, logger);
		PageFactory.initElements(driver, loginPage);
		landingPage = loginPage.openWebsite((PropertiesFile.readProperties()).getProperty("url"));
		landingPage.isFooterCookiePolicyClickable();
	}

	// Method to check Footer Contact Us Policy button of home page
	@Test(groups = { "Functional" }, priority = 21)
	public void checkFooterContactUsButton() throws IOException, Exception {
		logger = report.createTest("Footer Contact Us Button Check");
		LoginPage loginPage = new LoginPage(driver, logger);
		PageFactory.initElements(driver, loginPage);
		landingPage = loginPage.openWebsite((PropertiesFile.readProperties()).getProperty("url"));
		landingPage.isFooterContactUsButtonClickable();
	}

	// Method to check Program Information Button of home page
	@Test(groups = { "Functional" }, priority = 22)
	public void checkProgramInformationButton() throws IOException, Exception {
		logger = report.createTest("Program Information Button Check");
		LoginPage loginPage = new LoginPage(driver, logger);
		PageFactory.initElements(driver, loginPage);
		landingPage = loginPage.openWebsite((PropertiesFile.readProperties()).getProperty("url"));
		landingPage.isProgramInformationButtonClickable();
	}

	// Method to check Contact Us Button of home page
	@Test(groups = { "Functional" }, priority = 23)
	public void checkContactUsButton() throws IOException, Exception {
		logger = report.createTest("ContactUs Button Check");
		LoginPage loginPage = new LoginPage(driver, logger);
		PageFactory.initElements(driver, loginPage);
		landingPage = loginPage.openWebsite((PropertiesFile.readProperties()).getProperty("url"));
		landingPage.isContactUsButtonClickable();
	}

	// Method to fetch International Number
	@Test(groups = { "Functional" }, priority = 24)
	public void fetchInternationalNumber() throws IOException, Exception {
		logger = report.createTest("Fetching International Number From Contact Us Page");
		LoginPage loginPage = new LoginPage(driver, logger);
		PageFactory.initElements(driver, loginPage);
		landingPage = loginPage.openWebsite((PropertiesFile.readProperties()).getProperty("url"));
		landingPage.isContactUsButtonClickable();
		contactUsPage = landingPage.clickContactUsButton();
		contactUsPage.fetchInternationalNumber();
	}

	// Method to check Finding A colleague Textbox of home page
	@Test(groups = { "Functional" }, priority = 25)
	public void checkingFindingAColleaguetextbox() throws IOException, Exception {
		logger = report.createTest("Checking Finding a Colleague textbox");
		LoginPage loginPage = new LoginPage(driver, logger);
		PageFactory.initElements(driver, loginPage);
		landingPage = loginPage.openWebsite((PropertiesFile.readProperties()).getProperty("url"));
		landingPage.isFindingAColleagueTextboxEnabled();
	}

	// Method to Fetch the Name of the Colleague
	@Test(groups = { "Functional" }, priority = 26)
	public void fetchingTheNameAfterFindingColleague() throws IOException, Exception {
		logger = report.createTest("Fetching the Name After finding the colleague");
		LoginPage loginPage = new LoginPage(driver, logger);
		PageFactory.initElements(driver, loginPage);
		landingPage = loginPage.openWebsite((PropertiesFile.readProperties()).getProperty("url"));
		findAColleaguePage = landingPage.searchForAColleague();
		findAColleaguePage.getColleagueName();
	}

	// Method to check My Dashboard Us Button of home page
	@Test(groups = { "Functional" }, priority = 27)
	public void checkingMyDashboardButton() throws IOException, Exception {
		logger = report.createTest("Dashboard Button Check ");
		LoginPage loginPage = new LoginPage(driver, logger);
		PageFactory.initElements(driver, loginPage);
		landingPage = loginPage.openWebsite((PropertiesFile.readProperties()).getProperty("url"));
		landingPage.isMyDashboardButtonClickable();
		myDashboardMyActivity = landingPage.clickingMyDashboardButton();
	}

	// Method to check My Awards Button of MyDashboard page
	@Test(groups = { "Functional" }, priority = 28)
	public void checkingMyAwardsButton() throws IOException, Exception {
		logger = report.createTest("My Awards Button Check ");
		LoginPage loginPage = new LoginPage(driver, logger);
		PageFactory.initElements(driver, loginPage);
		landingPage = loginPage.openWebsite((PropertiesFile.readProperties()).getProperty("url"));
		myDashboardMyActivity = landingPage.clickingMyDashboardButton();
		myDashboardMyActivity.isMyAwardsButtonClickable();
		myDashboardMyAwards = myDashboardMyActivity.goToMyAwardsPage();
	}

	// Method to check My Nominations Page Elements
	@Test(groups = { "Functional" }, priority = 29)
	public void checkingMyNominationsPageElements() throws IOException, Exception {
		logger = report.createTest("My Nominations Page Elements Check ");
		LoginPage loginPage = new LoginPage(driver, logger);
		PageFactory.initElements(driver, loginPage);
		landingPage = loginPage.openWebsite((PropertiesFile.readProperties()).getProperty("url"));
		myDashboardMyActivity = landingPage.clickingMyDashboardButton();
		myDashboardMyActivity.isMyNominationsButtonClickable();
		myDashboardMyNominations = myDashboardMyActivity.goToMyNominationsPage();
		myDashboardMyNominations.isNominateButtonClickable();
	}

	// Method to check My Mobile Page Elements
	@Test(groups = { "Functional" }, priority = 30)
	public void checkingMyMobilePageElements() throws IOException, Exception {
		logger = report.createTest("My Mobile Page Elements Check ");
		LoginPage loginPage = new LoginPage(driver, logger);
		PageFactory.initElements(driver, loginPage);
		landingPage = loginPage.openWebsite((PropertiesFile.readProperties()).getProperty("url"));
		myDashboardMyActivity = landingPage.clickingMyDashboardButton();
		myDashboardMyActivity.isMyMobileClickable();
		myDashboardMyMobile = myDashboardMyActivity.goToMyMobilePage();
		myDashboardMyMobile.isManageMobButtonClickable();
		myDashboardMyMobile.isSendEmailButtonClickable();
		myDashboardMyMobile.isAppleButtonClickable();
		myDashboardMyMobile.isGooglePlayButtonClickable();
	}

	// Method to check My Elements Page Elements
	@Test(groups = { "Functional" }, priority = 31)
	public void checkingMySettingsPageElements() throws IOException, Exception {
		logger = report.createTest("My Settings Page Elements Check ");
		LoginPage loginPage = new LoginPage(driver, logger);
		PageFactory.initElements(driver, loginPage);
		landingPage = loginPage.openWebsite((PropertiesFile.readProperties()).getProperty("url"));
		myDashboardMyActivity = landingPage.clickingMyDashboardButton();
		myDashboardMyActivity.isMySettingsButtonClickable();
		myDashboardMySettings = myDashboardMyActivity.goToMYSettingsPage();
		myDashboardMySettings.isUploadButtonClickable();
		myDashboardMySettings.selectABackgroundPicture();
		myDashboardMySettings.isCancelButtonClickable();
		myDashboardMySettings.isSaveButtonClickable();
	}

	// Method to check My Orders Page Elements
	@Test(groups = { "Functional" }, priority = 32)
	public void checkingMyOrdersPageElements() throws IOException, Exception {
		logger = report.createTest("My Orders Page Elements Check ");
		LoginPage loginPage = new LoginPage(driver, logger);
		PageFactory.initElements(driver, loginPage);
		landingPage = loginPage.openWebsite((PropertiesFile.readProperties()).getProperty("url"));
		myDashboardMyActivity = landingPage.clickingMyDashboardButton();
		myDashboardMyActivity.isMyOrdersButtonClickable();
		myDashboardMyOrders = myDashboardMyActivity.goToMyOrdersPage();
		myDashboardMyOrders.isselectButtonClickable();
		myDashboardMyOrders.selectSecondOption();
		myDashboardMyOrders.isContinueShoppingButtonClickable();
		shoppingPage = myDashboardMyOrders.clickOnContinueShopping();
	}

	// Printing the user name
	@Test(groups = { "Functional" }, priority = 33)
	public void printingUserNameOfMyDashboard() throws IOException, Exception {
		logger = report.createTest("Printing UserName of My Dashboard Page");
		LoginPage loginPage = new LoginPage(driver, logger);
		PageFactory.initElements(driver, loginPage);
		landingPage = loginPage.openWebsite((PropertiesFile.readProperties()).getProperty("url"));
		myDashboardMyActivity = landingPage.clickingMyDashboardButton();
		myDashboardMyActivity.printUserName();
	}

	// Fetching MyAwards Page text
	@Test(groups = { "Functional" }, priority = 34)
	public void fetchingMyAwardsPagetext() throws IOException, Exception {
		logger = report.createTest("Fetching Text of My Awards Page");
		LoginPage loginPage = new LoginPage(driver, logger);
		PageFactory.initElements(driver, loginPage);
		landingPage = loginPage.openWebsite((PropertiesFile.readProperties()).getProperty("url"));
		myDashboardMyActivity = landingPage.clickingMyDashboardButton();
		myDashboardMyAwards = myDashboardMyActivity.goToMyAwardsPage();
		myDashboardMyAwards.printMyAwardsContent();
	}

	// Fetching List Of Colleagues In Nominations Page
	@Test(groups = { "Functional" }, priority = 35)
	public void fetchingListOfColleaguesInNominationsPage() throws IOException, Exception {
		logger = report.createTest("Fetching List of Colleagues of My Nominations Page");
		LoginPage loginPage = new LoginPage(driver, logger);
		PageFactory.initElements(driver, loginPage);
		landingPage = loginPage.openWebsite((PropertiesFile.readProperties()).getProperty("url"));
		myDashboardMyActivity = landingPage.clickingMyDashboardButton();
		myDashboardMyNominations = myDashboardMyActivity.goToMyNominationsPage();
		myDashboardMyNominations.printColleagueList();
	}

	// Fetching List Of Mobile Features
	@Test(groups = { "Functional" }, priority = 36)
	public void fetchingListOfMobileFeatures() throws IOException, Exception {
		logger = report.createTest("Fetching List of Mobile Features From My Mobile Page");
		LoginPage loginPage = new LoginPage(driver, logger);
		PageFactory.initElements(driver, loginPage);
		landingPage = loginPage.openWebsite((PropertiesFile.readProperties()).getProperty("url"));
		myDashboardMyActivity = landingPage.clickingMyDashboardButton();
		myDashboardMyMobile = myDashboardMyActivity.goToMyMobilePage();
		myDashboardMyMobile.fetchFeaturesOfMobile();
	}

	// Changing The Profile Picture
	@Test(groups = { "Functional" }, priority = 37)
	public void changingTheProfilePicture() throws IOException, Exception {
		logger = report.createTest("Changing the profile picture in My Settings Page");
		LoginPage loginPage = new LoginPage(driver, logger);
		PageFactory.initElements(driver, loginPage);
		landingPage = loginPage.openWebsite((PropertiesFile.readProperties()).getProperty("url"));
		myDashboardMyActivity = landingPage.clickingMyDashboardButton();
		myDashboardMySettings = myDashboardMyActivity.goToMYSettingsPage();
		myDashboardMySettings.changeProfilePicture();
	}

	// Changing The Background Picture
	@Test(groups = { "Functional" }, priority = 38)
	public void changingTheBackgroundPicture() throws IOException, Exception {
		logger = report.createTest("Changing the Background picture in My Settings Page");
		LoginPage loginPage = new LoginPage(driver, logger);
		PageFactory.initElements(driver, loginPage);
		landingPage = loginPage.openWebsite((PropertiesFile.readProperties()).getProperty("url"));
		myDashboardMyActivity = landingPage.clickingMyDashboardButton();
		myDashboardMySettings = myDashboardMyActivity.goToMYSettingsPage();
		myDashboardMySettings.changeBackgroundPicture();
	}

	// Checking The Search Box Shopping Page
	@Test(groups = { "Functional" }, priority = 39)
	public void checkingTheSearchBoxShoppingPage() throws IOException, Exception {
		logger = report.createTest("checking the Search Box of Shopping page");
		LoginPage loginPage = new LoginPage(driver, logger);
		PageFactory.initElements(driver, loginPage);
		landingPage = loginPage.openWebsite((PropertiesFile.readProperties()).getProperty("url"));
		shoppingPage = landingPage.clickOnControlBarStoreButton();
		shoppingPage.isSearchBoxEnabled();
	}

	// Checking The Shop All Button Shopping Page
	@Test(groups = { "Functional" }, priority = 40)
	public void checkingTheShopAllButtonShoppingPage() throws IOException, Exception {
		logger = report.createTest("checking the Shop All Button of Shopping page");
		LoginPage loginPage = new LoginPage(driver, logger);
		PageFactory.initElements(driver, loginPage);
		landingPage = loginPage.openWebsite((PropertiesFile.readProperties()).getProperty("url"));
		shoppingPage = landingPage.clickOnControlBarStoreButton();
		shoppingPage.isShopAllButtonClickable();
	}

	// Checking The Editor Picks Button Shopping Page
	@Test(groups = { "Functional" }, priority = 41)
	public void checkingTheEditorPicksButtonShoppingPage() throws IOException, Exception {
		logger = report.createTest("checking the Editor Picks Button of Shopping page");
		LoginPage loginPage = new LoginPage(driver, logger);
		PageFactory.initElements(driver, loginPage);
		landingPage = loginPage.openWebsite((PropertiesFile.readProperties()).getProperty("url"));
		shoppingPage = landingPage.clickOnControlBarStoreButton();
		shoppingPage.isEditorPicksButtonClickable();
	}

	// Checking The Top Brands Button Shopping Page
	@Test(groups = { "Functional" }, priority = 42)
	public void checkingTheTopBrandsButtonShoppingPage() throws IOException, Exception {
		logger = report.createTest("checking the Top Brands Button of Shopping page");
		LoginPage loginPage = new LoginPage(driver, logger);
		PageFactory.initElements(driver, loginPage);
		landingPage = loginPage.openWebsite((PropertiesFile.readProperties()).getProperty("url"));
		shoppingPage = landingPage.clickOnControlBarStoreButton();
		shoppingPage.isTopBrandsButtonClickable();
	}

	// Fetching Shopall Sublist Shopping Page
	@Test(groups = { "Functional" }, priority = 43)
	public void fetchingShopallSublistShoppingPage() throws IOException, Exception {
		logger = report.createTest("Fetching Shop All Sub List Shopping Page");
		LoginPage loginPage = new LoginPage(driver, logger);
		PageFactory.initElements(driver, loginPage);
		landingPage = loginPage.openWebsite((PropertiesFile.readProperties()).getProperty("url"));
		shoppingPage = landingPage.clickOnControlBarStoreButton();
		shoppingPage.clickShopAllButton();
		shoppingPage.printShopAllSubList();
	}

	// Fetching Editor Picks1 Sublist Shopping Page
	@Test(groups = { "Functional" }, priority = 44)
	public void fetchingEditorPicks1SublistShoppingPage() throws IOException, Exception {
		logger = report.createTest("Fetching Editor Picks 1 Sub List Shopping Page");
		LoginPage loginPage = new LoginPage(driver, logger);
		PageFactory.initElements(driver, loginPage);
		landingPage = loginPage.openWebsite((PropertiesFile.readProperties()).getProperty("url"));
		shoppingPage = landingPage.clickOnControlBarStoreButton();
		shoppingPage.clickEditorPicksButton();
		shoppingPage.printEditorPickSubList1();
	}

	// Fetching Top Brands List Shopping Page
	@Test(groups = { "Functional" }, priority = 45)
	public void fetchingTopBrandsListShoppingPage() throws IOException, Exception {
		logger = report.createTest("Fetching Top Brands List Shopping Page");
		LoginPage loginPage = new LoginPage(driver, logger);
		PageFactory.initElements(driver, loginPage);
		landingPage = loginPage.openWebsite((PropertiesFile.readProperties()).getProperty("url"));
		shoppingPage = landingPage.clickOnControlBarStoreButton();
		shoppingPage.clickTopBrandsButton();
		shoppingPage.printTopBrandsSubList();
	}

	// Fetching Featured Finds List Shopping Page
	@Test(groups = { "Functional" }, priority = 46)
	public void fetchingFeaturedFindsListShoppingPage() throws IOException, Exception {
		logger = report.createTest("Fetching Featured Find List Shopping Page");
		LoginPage loginPage = new LoginPage(driver, logger);
		PageFactory.initElements(driver, loginPage);
		landingPage = loginPage.openWebsite((PropertiesFile.readProperties()).getProperty("url"));
		shoppingPage = landingPage.clickOnControlBarStoreButton();
		shoppingPage.printFeaturedFindsSubList();
	}

	// Fetching Trending List Shopping Page
	@Test(groups = { "Functional" }, priority = 47)
	public void fetchingTrendingListShoppingPage() throws IOException, Exception {
		logger = report.createTest("Fetching Trending List Shopping Page");
		LoginPage loginPage = new LoginPage(driver, logger);
		PageFactory.initElements(driver, loginPage);
		landingPage = loginPage.openWebsite((PropertiesFile.readProperties()).getProperty("url"));
		shoppingPage = landingPage.clickOnControlBarStoreButton();
		shoppingPage.printTrendingCategoriesSubList();
	}

	// Fetching Editor Picks 2 List Shopping Page
	@Test(groups = { "Functional" }, priority = 48)
	public void fetchingEditorPicks2ListShoppingPage() throws IOException, Exception {
		logger = report.createTest("Fetching Editor Picks 2 Sub List Shopping Page");
		LoginPage loginPage = new LoginPage(driver, logger);
		PageFactory.initElements(driver, loginPage);
		landingPage = loginPage.openWebsite((PropertiesFile.readProperties()).getProperty("url"));
		shoppingPage = landingPage.clickOnControlBarStoreButton();
		shoppingPage.printEditorPickSubList2();
	}

	// Searching Results In Shopping Page
	@Test(groups = { "Functional" }, priority = 49)
	public void searchingResultsInshoppingPage() throws IOException, Exception {
		logger = report.createTest("Fetching List Of searched Results");
		LoginPage loginPage = new LoginPage(driver, logger);
		PageFactory.initElements(driver, loginPage);
		landingPage = loginPage.openWebsite((PropertiesFile.readProperties()).getProperty("url"));
		shoppingPage = landingPage.clickOnControlBarStoreButton();
		shoppingSearchResults = shoppingPage.serachMyItem();
		shoppingSearchResults.printSearchResults();
	}

	// Method to call the method of Excel class for writing the output in the Excel
	@AfterSuite(alwaysRun = true)
	public void flushExcelReport() {
		ExcelUtils.writeToExcel(RandomList, nameOfColleagueslist, mobileFeaturesList, shopAllList, editorPickList1,
				topBrandsList, featureFindList, editorPickList2, trendingList, searchResultsList);
		// Clearing the reportsList after each suite
		RandomList.clear();
		nameOfColleagueslist.clear();
		mobileFeaturesList.clear();
		shopAllList.clear();
		editorPickList1.clear();
		topBrandsList.clear();
		featureFindList.clear();
		editorPickList2.clear();
		trendingList.clear();
		searchResultsList.clear();

	}

	// Method to flush the ExtentTest to the Extent Report
	@AfterMethod(alwaysRun = true)
	public void flushReport() throws Exception {
		report.flush();
	}

	// Method to quit the driver
	@AfterSuite(alwaysRun = true)
	public void quitDriver() throws Exception {
		driver.quit();
	}

}

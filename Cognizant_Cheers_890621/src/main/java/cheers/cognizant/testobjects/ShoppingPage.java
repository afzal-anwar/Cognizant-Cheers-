package cheers.cognizant.testobjects;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import cheers.cognizant.utilities.PropertiesFile;
import cheers.cognizant.utilities.ScreenShots;

public class ShoppingPage extends LoginPage {

	public ShoppingPage(WebDriver driver, ExtentTest logger) throws IOException {
		super(driver, logger);
	}

	@FindBy(xpath = "//*[@id='categoriesLink']/div/span")
	public WebElement shopAllButton;
	public By shopAllButtonLocator = By.xpath("//*[@id='categoriesLink']/div/span");
	@FindBy(xpath = "//*[@id='collectionsLink']/div/span")
	public WebElement editorPicksButton;
	public By editorPicksButtonLocator = By.xpath("//*[@id='collectionsLink']/div/span");
	@FindBy(xpath = "//*[@id='brandCollectionsLink']/div/span")
	public WebElement topBrandsButton;
	public By topBrandsButtonLocator = By.xpath("//*[@id='brandCollectionsLink']/div/span");
	@FindBy(xpath = "//*[@type='submit']")
	public WebElement submitButton;
	public By submitButtonLocator = By.xpath("//*[@type='submit']");
	@FindBy(xpath = "//*[@id='ecomSearchInput']")
	public WebElement searchBox;

	@FindBy(xpath = "//ul[@class='menuTree-categoryColumn nonClickable']/li//span")
	public List<WebElement> shopAllSubList;
	@FindBy(xpath = "//*[@id='collectionsDropdown']/div/ul/li/a/span[@class='menuList-label'] ")
	public List<WebElement> editorPickSubList1;
	@FindBy(xpath = "//*[@id='brandCollectionsDropdown']/div/ul/li/a/span[@class='menuList-label']")
	public List<WebElement> topBrandsSubList;
	@FindBy(xpath = "//div[@class='productMixed-info']/span | //div[@class='productMixed-info']/div[@class='productMixed-price']")
	public List<WebElement> featuredFindsSubList;
	@FindBy(xpath = "//ul[@class='circularPanel-list circularPanel-list--scrollable']/li//div[@class='circularPanel-cardName--circle']")
	public List<WebElement> trendingCategoriesSubList;
	@FindBy(xpath = "//ul[@class='collectionsPromozone-list']//div[@class='collectionsPromozone-cardName']")
	public List<WebElement> editorPickSubList2subList;

	// Checking if Shop All button is Clickable
	public void isShopAllButtonClickable() {
		logger.log(Status.INFO, "checking if Shop All Button is clickable or not");
		isElementClickable(shopAllButtonLocator);
	}

	// Checking if Editor Picks button is Clickable
	public void isEditorPicksButtonClickable() {
		logger.log(Status.INFO, "checking if editor picks Button is clickable or not");
		isElementClickable(editorPicksButtonLocator);
	}

	// Checking if Top Brands button is Clickable
	public void isTopBrandsButtonClickable() {
		logger.log(Status.INFO, "checking if Top Brands Button is clickable or not");
		isElementClickable(topBrandsButtonLocator);
	}

	// Checking if Search Box is Enabled
	public void isSearchBoxEnabled() {
		logger.log(Status.INFO, "checking if Search Box Enabled or Not");
		isElementEnabled(searchBox);
	}

	// Clicking on ShopAll button
	public void clickShopAllButton() {
		logger.log(Status.INFO, "Clicking the Shop All Button");
		clickTheElement(shopAllButton);
	}

	// Clicking on Top brands button
	public void clickTopBrandsButton() {
		logger.log(Status.INFO, "Clicking the Top Brands Button");
		clickTheElement(topBrandsButton);
	}

	// Clicking on Editor Picks button
	public void clickEditorPicksButton() {
		logger.log(Status.INFO, "Clicking the Editor Picks Button");
		clickTheElement(editorPicksButton);
	}

	// Printing shop all sub list
	public void printShopAllSubList() {
		waitForPageLoad();
		ScreenShots.takeScreenshot(driver);
		logger.log(Status.INFO, "Fetching the list of shop all categories");
		shopAllList.add("Printing the list under Shop All Categories");
		System.out.println("Printing the list under Shop All Categories");
		printTheList(shopAllSubList, shopAllList);
	}

	// Printing Top Brands sub list
	public void printTopBrandsSubList() {
		waitForPageLoad();
		ScreenShots.takeScreenshot(driver);
		logger.log(Status.INFO, "Fetching the list of Top Brands");
		topBrandsList.add("Printing the list under Top Brands Categories");
		System.out.println("Printing the list under Top Brands Categories");
		printTheList(topBrandsSubList, topBrandsList);
	}

	// Printing Featured Finds sub list
	public void printFeaturedFindsSubList() throws InterruptedException {
		waitForPageLoad();
		Thread.sleep(3000);
		logger.log(Status.INFO, "Fetching the list of featured Finds");
		featureFindList.add("Printing the list under Featured Categories");
		System.out.println("Printing the list under Featured Categories");
		for (int i = 0; i < 5; i++) {
			featureFindList.add(featuredFindsSubList.get(i).getText());
			System.out.println(featuredFindsSubList.get(i).getText());
		}
		logger.log(Status.PASS, "Fetching the list of featured Finds successful");
	}

	// Printing Trending Categories sub list
	public void printTrendingCategoriesSubList() {
		waitForPageLoad();
		logger.log(Status.INFO, "Fetching the list of Trending Categories");
		trendingList.add("Printing the list under trending Categories");
		System.out.println("Printing the list under trending Categories");
		printTheList(trendingCategoriesSubList, trendingList);
	}

	// Printing editor picks2 sub list
	public void printEditorPickSubList2() {
		waitForPageLoad();
		ScreenShots.takeScreenshot(driver);
		logger.log(Status.INFO, "Fetching the list of editor picks categories 2");
		editorPickList2.add("Printing the list under Editor picks 2 Categories");
		System.out.println("Printing the list under Editor Picks 2 Categories");
		printTheList(editorPickSubList2subList, editorPickList2);
	}

	// Printing editor picks1 sub list
	public void printEditorPickSubList1() {
		waitForPageLoad();
		ScreenShots.takeScreenshot(driver);
		logger.log(Status.INFO, "Fetching the list of editor picks categories 1");
		editorPickList1.add("Printing the list under Editor picks 1 Categories");
		System.out.println("Printing the list under Editor Picks 1 Categories");
		printTheList(editorPickSubList1, editorPickList1);
	}

	// Searching the product
	public ShoppingSearchResults serachMyItem() throws IOException, InterruptedException {
		logger.log(Status.INFO, "Entering the item to be searched");
		sendTheKeys(searchBox, PropertiesFile.readProperties().getProperty("searchItem"));
		clickTheElement(submitButton);
		waitForPageLoad();
		Thread.sleep(3000);
		logger.log(Status.INFO, "Verifying the title of the Shopping Search Results Page");
		// Checking the title of the page
		checkTitle("Store");
		ShoppingSearchResults shoppingSearchResults = new ShoppingSearchResults(driver, logger);
		// initializing Web Elements defined in the Landing Page Class
		PageFactory.initElements(driver, shoppingSearchResults);
		return shoppingSearchResults;
	}

}

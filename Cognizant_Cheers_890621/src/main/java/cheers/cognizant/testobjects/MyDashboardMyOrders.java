package cheers.cognizant.testobjects;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import cheers.cognizant.utilities.ScreenShots;

public class MyDashboardMyOrders extends LoginPage {

	public MyDashboardMyOrders(WebDriver driver, ExtentTest logger) throws IOException {
		super(driver, logger);
	}

	@FindBy(xpath = "//select[@class='customSelect__2Ppgz']")
	public WebElement selectDropBox;
	public By selectButtonLocator = By.xpath("//select[@class='customSelect__2Ppgz']");
	@FindBy(xpath = "//*[@class='a-button-text__xBrmf']")
	public WebElement continueShoppingButton;
	public By continueShoppingButtonLocator = By.xpath("//*[@class='a-button-text__xBrmf']");

	// Checking if select button is clickable
	public void isselectButtonClickable() {
		logger.log(Status.INFO, "checking if select Button is clickable or not");
		isElementClickable(selectButtonLocator);
	}

	// Checking if continue shopping button is clickable
	public void isContinueShoppingButtonClickable() {
		logger.log(Status.INFO, "checking if continue Shopping Button is clickable or not");
		isElementClickable(continueShoppingButtonLocator);
	}

	// Selecting second option from dropdown
	public void selectSecondOption() {
		logger.log(Status.INFO, "Selecting the second button");
		Select select = new Select(selectDropBox);
		select.selectByIndex(2);
		ScreenShots.takeScreenshot(driver);
		logger.log(Status.PASS, "second option selected successfully");
	}

	// Clicking on continue shopping button
	public ShoppingPage clickOnContinueShopping() throws IOException {
		logger.log(Status.INFO, "Clicking the continue shopping button");
		clickTheElement(continueShoppingButton);
		logger.log(Status.INFO, "Verifying the title of the Shopping page");
		// Checking the title of the page
		checkTitle("Store");
		ShoppingPage shoppingPage = new ShoppingPage(driver, logger);
		// initializing Web Elements defined in the Landing Page Class
		PageFactory.initElements(driver, shoppingPage);
		return shoppingPage;
	}

}

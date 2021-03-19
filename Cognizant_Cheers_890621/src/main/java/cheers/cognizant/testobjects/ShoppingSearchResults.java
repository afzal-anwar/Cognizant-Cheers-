package cheers.cognizant.testobjects;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import cheers.cognizant.utilities.ScreenShots;

public class ShoppingSearchResults extends LoginPage {

	public ShoppingSearchResults(WebDriver driver, ExtentTest logger) throws IOException {
		super(driver, logger);
	}

	@FindBy(xpath = "//select[@class='customSelect']")
	public WebElement selectSortBy;
	@FindBy(xpath = "//div[@class='productMixed-info']//p | //div[@class='productMixed-info']/div[@class='productMixed-price']")
	public List<WebElement> searchResults;

	//Printing the searched Results
	public void printSearchResults() {
		logger.log(Status.INFO, "Selecting sort by relevance");
		Select select = new Select(selectSortBy);
		select.selectByIndex(1);
		waitForPageLoad();
		//Taking screenshot
		ScreenShots.takeScreenshot(driver);
		logger.log(Status.INFO, "Fetching the list of searched results");
		searchResultsList.add("Printing the list of searched Results");
		System.out.println("Printing the list of searched Results");
		printTheList(searchResults, searchResultsList);
	}

}

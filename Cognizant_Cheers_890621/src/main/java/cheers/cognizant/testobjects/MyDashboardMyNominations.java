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

public class MyDashboardMyNominations extends LoginPage {

	public MyDashboardMyNominations(WebDriver driver, ExtentTest logger) throws IOException {
		super(driver, logger);
	}

	@FindBy(xpath = "//*[@id='nominateButton']")
	public WebElement nominateButton;
	public By nominateButtonLocator = By.xpath("//*[@id='nominateButton']");
	@FindBy(xpath = "//div[@id='np-select-recipient-content']/div[3]/ul[1]//div[3]/h4") // attribute:data-title
	public List<WebElement> nameList;
	@FindBy(xpath = "//div[@class='gf-drawer np-app-drawer']/div/button")
	public WebElement closeButton;

	// checking if Nominations Button is Clickable
	public void isNominateButtonClickable() {
		logger.log(Status.INFO, "checking if Nominate Button is clickable or not");
		isElementClickable(nominateButtonLocator);
	}

	// Printing the Colleague List
	public void printColleagueList() {
		logger.log(Status.INFO, "Clicking the Nominee button");
		clickTheElement(nominateButton);
		waitForPageLoad();
		ScreenShots.takeScreenshot(driver);
		logger.log(Status.INFO, "Printing the Colleagues list from My Nominations Page");
		System.out.println("Printing the Colleagues list from My Nominations Page");
		nameOfColleagueslist.add("Colleagues list from My Nominations Page");
		for (WebElement e : nameList) {
			System.out.println(e.getAttribute("data-title"));
			nameOfColleagueslist.add(e.getAttribute("data-title"));
		}
		logger.log(Status.PASS, "Printing the Colleagues list from My Nominations Successful");
		logger.log(Status.INFO, "Clicking the Close button");
		clickTheElement(closeButton);
	}

}

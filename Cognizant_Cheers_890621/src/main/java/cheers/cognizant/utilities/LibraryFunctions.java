package cheers.cognizant.utilities;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class LibraryFunctions extends DriverClass {

	public ExtentReports report = Reporter.getReport();
	public ExtentTest logger;
	public WebDriver driver;
	public static ArrayList<String> shopAllList = new ArrayList<String>();
	public static ArrayList<String> editorPickList1 = new ArrayList<String>();
	public static ArrayList<String> topBrandsList = new ArrayList<String>();
	public static ArrayList<String> featureFindList = new ArrayList<String>();
	public static ArrayList<String> editorPickList2 = new ArrayList<String>();
	public static ArrayList<String> trendingList = new ArrayList<String>();
	public static ArrayList<String> mobileFeaturesList = new ArrayList<String>();
	public static ArrayList<String> nameOfColleagueslist = new ArrayList<String>();
	public static ArrayList<String> RandomList = new ArrayList<String>();
	public static ArrayList<String> searchResultsList = new ArrayList<String>();

	// Opening the browser
	public void openBrowser(String browserName) throws Exception {
		driver = DriverClass.setupDriver(browserName);
	}

	// Method to generate random number from 1 to 12
	public int generateRnadomNumber() {
		Random random = new Random();
		int rand = 0;
		while (true) {
			rand = random.nextInt(13);
			if (rand != 0)
				break;
		}
		return rand;

	}

	// checking if element is clickable or not
	public void isElementClickable(By locator) {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(locator));
			reportPass("Element is clickable");
		} catch (TimeoutException e) {
			reportFail("Element is not clickable");
		}
	}

	// Checking the title of the page
	public void checkTitle(String title) {
		try {
			wait.until(ExpectedConditions.titleIs(title));
			String verify = driver.getTitle();
			if (verify.equals(title))
				// Reporting pass if the page title is correct
				reportPass("Title verified successfully");
			else
				// Reporting fail if the page title is incorrect
				reportFail("Title not matching");
		} catch (Exception e) {
			reportFail(e.getMessage());
		}
	}

	// Clicking the element through JavascriptExecutor
	public void jsClickTheElement(WebElement element) {
		try {
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].click();", element);
			// Reporting pass if element is clicked successfully
			reportPass("Element clicked successfully");
		} catch (Exception e) {
			reportFail(e.getMessage());
		}
	}

	// Checking if an element is enabled
	public void isElementEnabled(WebElement element) {
		try {
			Thread.sleep(2000);
			if (element.isEnabled())
				// Reporting pass if element is enabled
				reportPass("Element is Enabled");
			else
				// Reporting fail if element is not enabled
				reportFail("Element not Enabled");

		} catch (Exception e) {
			reportFail(e.getMessage());
		}
	}

	// Clearing the textbox with backspace
	public void clearWithBackspace(WebElement element) {
		wait.until(ExpectedConditions.visibilityOf(element));
		try {
			int elementTextSize = (element.getAttribute("value")).length();
			// Clicking backspace after counting the length of the string
			while (elementTextSize != 0) {
				element.sendKeys(Keys.BACK_SPACE);
				elementTextSize--;
			}

		} catch (Exception e) {
			reportFail(e.getMessage());
		}

	}

	// Clearing the textbox
	public void clearTheTextbox(WebElement element) {
		try {
			// Applying Explicit wait
			wait.until(ExpectedConditions.elementToBeClickable(element));
			element.clear();
			// Reporting pass if the textbox is cleared successfully
			reportPass("Textbox cleared successfully");
		} catch (Exception e) {
			reportFail(e.getMessage());
		}
	}

	// Method to check if alert is present
	public boolean isAlertPresent() {
		try {
			// switching to alert window
			driver.switchTo().alert();
			return true;
		} catch (Exception ex) {
			return false;
		}
	}

	// Clicking on an element
	public void clickTheElement(WebElement element) {
		try {
			// Applying Explicit wait
			wait.until(ExpectedConditions.elementToBeClickable(element));
			element.click();
			// Reporting pass if the element is clicked successfully
			reportPass("Element clicked successfully");
		} catch (Exception e) {
			reportFail(e.getMessage());
		}
	}

//	 Sending Keys to an element
	public void sendTheKeys(WebElement element, String keys) {
		try {
			wait.until(ExpectedConditions.visibilityOf(element));
			element.sendKeys(keys); // sending keys to the element
			// Reporting pass if the textbox is filled successfully
			reportPass("TextBox filled successfully");
		} catch (Exception e) {
			reportFail(e.getMessage());
		}
	}

	// Printing the list
	public void printTheList(List<WebElement> elementsList, ArrayList<String> list) {

		try {
			for (WebElement element : elementsList) {
				list.add(element.getText());
				System.out.println(element.getText());
			}
			reportPass("List printed Successfully");
		} catch (Exception e) {
			reportFail(e.getMessage());
		}

	}

	// Checking the visibility of an element
	public void checkVisibilityOfTheElement(WebElement element) {
		try {
			wait.until(ExpectedConditions.visibilityOf(element));
			if (element.isDisplayed())
				// Reporting pass if element is visible
				reportPass("Element is visible");
			else
				// Reporting fail if element is not visible
				reportFail("Element is not visible");
		} catch (Exception e) {
			reportFail(e.getMessage());
		}

	}

	// Getting text of an WebElement
	public String getTheText(WebElement element) {
		try {

			wait.until(ExpectedConditions.visibilityOf(element));
			// Reporting pass if text is retrieved successfully
			reportPass("Text retrieved successfully");
			// Getting text from the element and returning it
			return element.getText();
		} catch (Exception e) {
			reportFail(e.getMessage());
			return null;
		}
	}

	// Scrolling to End Of Page using JavascriptExecutor
	public void ScrollToEndOfPage() {
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver; // Parsing the driver to JavaScriptExceutor
			js.executeScript("window.scrollTo(0, document.body.scrollHeight)"); // Scrolling tom end of the page
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	// Highlighting the Element before Taking the Screenshot
	public void highlightTheElement(WebElement element) throws Exception {
		JavascriptExecutor jse = (JavascriptExecutor) driver; // Parsing the driver to JavaScriptExceutor
		jse.executeScript("arguments[0].style.border='5px solid red'", element); // Highlighting an
																					// element using its // locator
	}

	// Function to wait for the page to load completely
	public void waitForPageLoad() {
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver; // Parsing the driver to JavaScriptExceutor
			int i = 0;
			while (i != 180) {
				String pageState = (String) js.executeScript("return document.readyState;"); // Storing the state of
																								// page in a string
				if (pageState.equalsIgnoreCase("Complete")) { // Checking if the state of page is complete
					break;
				} else {
					try {
						Thread.sleep(1000);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}

			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	// Method to report a test as Fail
	public void reportFail(String message) {
		// Logging the status as Fail in the ExtentTest instance
		logger.log(Status.FAIL, message);
		ScreenShots.takeScreenshotOnFailure(driver);
		// Asserting fail to fail a testcase
		Assert.fail(message);
	}

	// Method to report a test as Pass
	public void reportPass(String message) {
		// Logging the status as Pass in the ExtentTest instance
		logger.log(Status.PASS, message);
	}

	// Method to accept an alert
	public void acceptAlert() throws Exception {
		try {
			Alert alert = driver.switchTo().alert();
			alert.accept();
			// Logging the status as Pass in the ExtentTest instance
			logger.log(Status.PASS, "Alert Accepted");
		} catch (Exception e) {
			reportFail(e.getMessage());
		}

	}

	// Method to retrieve text from the alertbox
	public String getAlertText() throws Exception {
		try {
			Alert alert = driver.switchTo().alert();
			// Logging the status as Pass in the ExtentTest instance
			logger.log(Status.PASS, "Alert Text Retrieved");
			return alert.getText();
		} catch (Exception e) {
			reportFail(e.getMessage());
			return null;
		}

	}

}

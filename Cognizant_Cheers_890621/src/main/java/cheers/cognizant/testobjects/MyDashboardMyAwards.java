package cheers.cognizant.testobjects;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import cheers.cognizant.utilities.LibraryFunctions;

public class MyDashboardMyAwards extends LoginPage {
	public MyDashboardMyAwards(WebDriver driver, ExtentTest logger) throws IOException {
		super(driver, logger);
	}

	@FindBy(xpath = " //*[@id='awardsHolder']/div[1]/h1")
	public WebElement myAwardsContent;

	// Printing My Awards Page Content
	public void printMyAwardsContent() {
		logger.log(Status.INFO, "Printing the My Awards page content");
		String content = myAwardsContent.getText();
		System.out.println("My Awards Page Content \n" + content);
		RandomList.add("My Awards Page Content: ");
		RandomList.add(content);
		logger.log(Status.PASS, "Printing of My Awards Page Content Successful");
	}

}

package cheers.cognizant.testobjects;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import cheers.cognizant.utilities.ScreenShots;

public class MyDashboardMySettings extends LoginPage {

	public MyDashboardMySettings(WebDriver driver, ExtentTest logger) throws IOException {
		super(driver, logger);
	}

	@FindBy(id = "personPictureUploadButton")
	public WebElement uploadButton;
	public By uploadButtonLocator = By.xpath("//*[@id='subNavBar']/li[6]/a");
	@FindBy(id = "saveButton")
	public WebElement saveButton;
	public By saveButtonLocator = By.id("saveButton");
	@FindBy(id = "cancelButton")
	public WebElement cancelButton;
	public By cancelButtonLocator = By.id("cancelButton");

	// Checking if upload button is clickable
	public void isUploadButtonClickable() {
		logger.log(Status.INFO, "checking if upload Button clickable or not");
		isElementEnabled(uploadButton);
	}

	// Checking if save button is clickable
	public void isSaveButtonClickable() throws InterruptedException {
		selectABackgroundPicture();
		logger.log(Status.INFO, "checking if save Button clickable or not");
		isElementEnabled(saveButton);
	}

	// Checking if cancel button is clickable
	public void isCancelButtonClickable() throws InterruptedException {
		selectABackgroundPicture();
		logger.log(Status.INFO, "checking if cancel Button clickable or not");
		isElementEnabled(cancelButton);
	}

	// Selecting a background picture
	public void selectABackgroundPicture() throws InterruptedException {
		logger.log(Status.INFO, "Selecting a Background Picture");
		WebElement backgroundPic = driver.findElement(By.xpath("//*[@image-id='" + generateRnadomNumber() + "']/img"));
		jsClickTheElement(backgroundPic);
		Thread.sleep(3000);
		WebElement backgroundPic1 = driver.findElement(By.xpath("//*[@image-id='" + generateRnadomNumber() + "']/img"));
		jsClickTheElement(backgroundPic1);
		logger.log(Status.PASS, "Background Picture Selected successfully");
	}

	// Changing a background picture
	public void changeBackgroundPicture() throws InterruptedException {
		logger.log(Status.INFO, "Changing the Background Picture");
		selectABackgroundPicture();
		ScreenShots.takeScreenshot(driver);
		Thread.sleep(2000);
		logger.log(Status.INFO, "Saving the Background Picture");
		jsClickTheElement(saveButton);
		logger.log(Status.PASS, "Background Picture changed successfully");
	}

	// Changing the Profile Picture
	public void changeProfilePicture() throws InterruptedException {
		logger.log(Status.INFO, "Changing the Profile Picture");
		uploadButton.sendKeys(System.getProperty("user.dir") + "\\Resources\\ProfPic.png");
		Thread.sleep(3000);
		logger.log(Status.INFO, "Profile Picture changed successfully");
	}

}

package cheers.cognizant.utilities;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class Retry implements IRetryAnalyzer {

	int counter = 0, retryCount = 2;

	// Method to retry the test
	@Override
	public boolean retry(ITestResult result) {
		// Checking if the counter has exceeded the retryCount
		if (counter < retryCount) {
			counter++;
			return true;
		}
		return false;
	}

}

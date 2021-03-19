package cheers.cognizant.utilities;

import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Reporter {

	public static ExtentReports report;

	public static ExtentReports getReport() {

		// Creating instance of Date class
		Date date = new Date();
		String currentDate = date.toString().replaceAll(":", "_").replaceAll(" ", "_");
		if (report == null) {

			String reportName = currentDate + ".html";

			// Creating instance of the ExtentHtmlReporter
			ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(
					System.getProperty("user.dir") + "\\ExtentReports\\" + reportName);
			// creating an Extent Report instance
			report = new ExtentReports();
			// Attaching the Extent Reports instance to the html Reporter
			report.attachReporter(htmlReporter);

			// Setting system info in the report
			report.setSystemInfo("OS", "Windows 10");
			report.setSystemInfo("Environment", "UAT");
			report.setSystemInfo("Build Number", "1.0");

			// configuring the html Reporter
			htmlReporter.config().setDocumentTitle("Cognizant Cheers Automation Results");
			htmlReporter.config().setReportName("Functional Testing");
			htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
			htmlReporter.config().setTheme(Theme.STANDARD);
		}
		return report;

	}

}

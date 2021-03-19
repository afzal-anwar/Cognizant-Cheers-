package cheers.cognizant.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesFile {

	// Using the properties file to store the key value pairs
	public static Properties readProperties() throws IOException {
		Properties prop = null; // Creating new properties file
		try {
			prop = new Properties();
			// Reading the configuration properties file
			InputStream ReadFile = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\cheers\\cognizant\\testobjects\\config.properties");
					
					
					
//					(System.getProperty("user.dir")
//					+ "src\\main\\java\\cheers\\cognizant\\testobjects\\config.properties");

			// Loading the file to the properties
			prop.load(ReadFile);
		} catch (Exception e) {

			System.out.println("Error reading properties file: " + e.getMessage());
		}

		return prop; // Returning the properties object

	}

}

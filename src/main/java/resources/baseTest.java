/**
 * 
 */
package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;

/**
 * @author kshubham
 *
 */
public class baseTest {

	public WebDriver driver;
	public Properties prop;

	public WebDriver initializeBrowser() throws IOException {

		// Getting browser and urls data from data.properties file
		prop = new Properties();
		FileInputStream fis = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\main\\java\\resources\\data.properties");
		prop.load(fis);

		String browserName = prop.getProperty("browser");

		// for initializing Chrome Browser in normal/headless mode
		if (browserName.contains("chrome")) {

			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir") + "\\drivers\\chromeDriver\\chromedriver.exe");

			ChromeOptions options = new ChromeOptions();

			if (browserName.contains("headless")) {

				options.addArguments("headless");
			}

			driver = new ChromeDriver(options);
		}

		// for initializing Firefox Browser
		if (browserName.contains("firefox")) {

			System.setProperty("webdriver.gecko.driver",
					System.getProperty("user.dir") + "\\drivers\\firefoxDriver\\geckodriver.exe");

			FirefoxOptions options = new FirefoxOptions();

			if (browserName.contains("headless")) {
				options.addArguments("headless");
			}

			driver = new FirefoxDriver(options);

		}

		// for initializing Internet Explorer Browser
		if (browserName.equalsIgnoreCase("IE")) {

			System.setProperty("webdriver.ie.driver",
					System.getProperty("user.dir") + "\\drivers\\internetExplorerDriver\\IEDriverServer3_4.exe");
			driver = new InternetExplorerDriver();
		}

		// Clearing cookies and maximising window screen
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();

		// defining an implicit timeout
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		// returning driver object to use it in test cases
		return driver;

	}
	
	public String getScreenshotPath(String testCaseName, WebDriver driver) throws IOException {

		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String destinationFile = System.getProperty("user.dir") + "\\reports\\" + testCaseName + ".png";
		FileUtils.copyFile(source, new File(destinationFile));
		return destinationFile;

	}

}

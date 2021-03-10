package testcases;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import resources.baseTest;

public class Test_Shaadi extends baseTest {

	public WebDriver driver;
	
	// adding Log4j logger
	private static Logger log = LogManager.getLogger(baseTest.class.getName());

	@BeforeMethod
	public void initialize() throws IOException {

		driver = initializeBrowser();

	}

	@Test(dataProvider = "details")
	public void createMarathiProfile(String email, String password, String profile) throws InterruptedException {
		log.debug("Hitting the url:" + prop.getProperty("urlMarathi"));
		driver.get(prop.getProperty("urlMarathi"));
		log.info("Landed into the website");

		HomePage objHome = new HomePage(driver);

		log.debug("Clicking on Lets Begin Button");
		objHome.LetsBeginButton().click();
		log.info("Clicked on Lets Begin button");

		Thread.sleep(2000);
		log.debug("Sending keys on EmailId field");
		objHome.EmailId().sendKeys(email);
		log.info("EmailID provided");
		
		log.debug("Sending keys on Password field");
		objHome.Password().sendKeys(password);
		log.info("Password provided");
		
		log.debug("Clicking on Create Profile dropdown");
		objHome.CreateProfileFor().click();
		log.info("Clicked on Create Profile dropdown");

		log.debug("Selecting Profile: "+ profile);
		for (WebElement option : objHome.SelectProfile()) {

			if (option.getText().equalsIgnoreCase(profile)) {
				option.click();
				break;
			}
		}
		log.info("Profile Selected as: "+ profile);
		
		log.debug("Clicking on Gender Male Radio button");
		objHome.GenderMale().click();
		log.info("Clicked on Gender Male Radio button");
		
		Thread.sleep(1000);
		
		log.debug("Clicking on Next button");
		objHome.NextButton().click();
		log.info("Clicked on Next button");
		
		Thread.sleep(2000);
		
		log.debug("Verifing Community as: "+  prop.getProperty("communityM"));
		Assert.assertEquals(objHome.Community().getText(), prop.getProperty("communityM"));
		log.info(prop.getProperty("communityM")+ " : community verified");
		

	}
	
	@Test(dataProvider = "details")
	public void createGujratiProfile(String email, String password, String profile) throws InterruptedException {
		log.debug("Hitting the url:" + prop.getProperty("urlMarathi"));
		driver.get(prop.getProperty("urlGujrati"));
		log.info("Landed into the website");

		HomePage objHome = new HomePage(driver);

		log.debug("Clicking on Lets Begin Button");
		objHome.LetsBeginButton().click();
		log.info("Clicked on Lets Begin button");

		Thread.sleep(2000);

		log.debug("Sending keys on EmailId field");
		objHome.EmailId().sendKeys(email);
		log.info("EmailID provided");
		
		log.debug("Sending keys on Password field");
		objHome.Password().sendKeys(password);
		log.info("Password provided");
		
		log.debug("Clicking on Create Profile dropdown");
		objHome.CreateProfileFor().click();
		log.info("Clicked on Create Profile dropdown");
	

		log.debug("Selecting Profile: "+ profile);
		for (WebElement option : objHome.SelectProfile()) {

			if (option.getText().equalsIgnoreCase(profile)) {
				option.click();
				break;
			}
		}
		log.info("Profile Selected as: "+ profile);
		
		log.debug("Clicking on Gender Male Radio button");
		objHome.GenderMale().click();
		log.info("Clicked on Gender Male Radio button");
		
		Thread.sleep(1000);
		
		log.debug("Clicking on Next button");
		objHome.NextButton().click();
		log.info("Clicked on Next button");
		
		Thread.sleep(2000);
		
		log.debug("Verifing Community as: "+  prop.getProperty("communityG"));
		Assert.assertEquals(objHome.Community().getText(), prop.getProperty("communityG"));
		log.info(prop.getProperty("communityG")+ " : community verified");
		
	}


	@AfterMethod
	public void terminate() {

		driver.close();
	}

	// Creating a Data Provider method
	@DataProvider(name = "details")
	public Object[][] getData() {
		return new Object[][] { { "abcxyz489@gmail.com", "qvsuvw@134123", "Self" },
				{ "lmnxyz489@gmail.com", "ecbnfwjk@413w3", "Friend" } };

	}

}

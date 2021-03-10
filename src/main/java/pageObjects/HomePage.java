/**
 * 
 */
package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * @author kshubham
 *
 */
public class HomePage {

	public WebDriver driver;

	// constructor for class HomePage
	public HomePage(WebDriver driver) {

		this.driver = driver;
	}

	// locators definition
	private By letsBeginButton = By.xpath("//div[@class='buttonWrap']/button");
	private By emailID = By
			.xpath("//div[@class='form-group col-md-12 form-module--formEleWrap--28QHv']//input[@name='email']");
	private By password = By
			.xpath("//div[@class='form-group col-md-12 form-module--formEleWrap--28QHv']//input[@name='password1']");
	private By createProfileFor = By.xpath("//div[@class='Dropdown-placeholder']");
	private By selectProfile = By.xpath("//div[@class='Dropdown-option']");
	private By genderMale = By.xpath("//input[@id='gender_male']");
	private By nextButton = By.xpath("//button[@type='submit']");
	private By community = By.xpath("//div[contains(@class,'mother_tongue')]");
	

	
	// locator method

	public WebElement LetsBeginButton() {

		return driver.findElement(letsBeginButton);
	}

	public WebElement EmailId() {

		return driver.findElement(emailID);
	}

	public WebElement Password() {

		return driver.findElement(password);
	}

	public WebElement CreateProfileFor() {

		return driver.findElement(createProfileFor);
	}

	public List<WebElement> SelectProfile() {

		return driver.findElements(selectProfile);
	}
	
	public WebElement GenderMale() {

		return driver.findElement(genderMale);
	}
	
	public WebElement NextButton() {

		return driver.findElement(nextButton);
	}
	
	public WebElement Community() {

		return driver.findElement(community);
	}

}

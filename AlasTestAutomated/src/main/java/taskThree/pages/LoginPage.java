package taskThree.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import pac.helpers.Utils;

public class LoginPage {
private WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}
	// In class Utilis I have helpers methods that are used in multiple places in page classes. 
	// In this way, the repeating parts are pulled in one place.  
	// All methods are static, so they can be invoked without instantiating the class itself.
	
	// Find the element  and get text for assertion Dashboard
	public String getTitle() {
		return Utils.waitForElementPresence(driver, By.xpath("//*[@id=\"midPaneContentWrapper\"]/h1/b"), 15).getText();
	}
	//Find the button login
	public WebElement getLoginBtn() {
		return Utils.waitForElementPresence(driver, By.id("btnLogin"), 15);
	}	
	// Find the element  and get text for assertion Logout
	public String getTitleLogout() {
		return Utils.waitForElementPresence(driver, By.xpath("//*[@id='midPaneContentWrapper']/h1/b"), 10).getText();
	}

}

package taskOne.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import pac.helpers.Utils;

public class TooltipPage {
	private WebDriver driver;

	public TooltipPage(WebDriver driver) {
		this.driver = driver;
	}
	
	// In class Utilis I have helpers methods that are used in multiple places in page classes.
	// In this way, the repeating parts are pulled in one place.  
	// All methods are static, so they can be invoked without instantiating the class itself.

	// Find the element and and call the method waitForElementPresence described in the class Utils
	public WebElement getTooltip() {
		return Utils.waitForElementPresence(driver, By.linkText("Tooltip"), 10);
	}
	// Find the element  and get text for assertion
	public String getTitle() {
		return Utils.waitForElementPresence(driver, By.xpath("//*[@id=\"content\"]/h1"), 10).getText();
	}
	// Find the alert message element and get text for print
	public String getMsgAlert() {
		return Utils.waitForElementPresence(driver, By.xpath("//*[@id=\"ui-id-1\"]/div"), 10).getText();
	}
	// Find the Your age field
	public WebElement getYourAge() {
		return Utils.waitForElementPresence(driver, By.id("age"), 10);
	}
	//Set the Your age field
	public void setAgeFild(String age) {
		WebElement yourAge = getYourAge();
		yourAge.clear();
		yourAge.sendKeys(age);
	}

}

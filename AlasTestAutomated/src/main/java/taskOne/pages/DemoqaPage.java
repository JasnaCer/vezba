package taskOne.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import pac.helpers.*;

public class DemoqaPage {
	private WebDriver driver;

	public DemoqaPage(WebDriver driver) {
		this.driver = driver;
	}
	// In class Utilis I have helpers methods that are used in multiple places in page classes.
	// In this way, the repeating parts are pulled in one place.  
	// All methods are static, so they can be invoked without instantiating the class itself.

	// Find the element and and call the method waitForElementPresence described in the class Utils
	public WebElement getDroppable() {
		return Utils.waitForElementPresence(driver, By.linkText("Droppable"), 10);
	}
	// Find the element  and get text for assertion
	public String getTitle() {
		return Utils.waitForElementPresence(driver, By.xpath("//*[@id=\"content\"]/h1"), 10).getText();
	}
	
	
}

package taskThree.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import pac.helpers.Utils;

public class VacanciesPage {
private WebDriver driver;
	
	public VacanciesPage(WebDriver driver) {
		this.driver = driver;
	}
	// In class Utilis I have helpers methods that are used in multiple places in page classes. 
	// In this way, the repeating parts are pulled in one place.  
	// All methods are static, so they can be invoked without instantiating the class itself.
	
	//find element menu
	public WebElement getMenu() {
		return Utils.waitForElementPresence(driver, By.xpath("//div[@id='content']/div[5]/nav/div/a/i"), 10);
	}
	//Find the Candidates link
	public WebElement getCandidates() {
		return Utils.waitForElementPresence(driver, By.linkText("Candidates"), 10);
	}

}

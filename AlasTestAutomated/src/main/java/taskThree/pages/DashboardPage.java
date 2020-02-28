package taskThree.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import pac.helpers.Utils;

public class DashboardPage {
	private WebDriver driver;
	
	public DashboardPage(WebDriver driver) {
		this.driver = driver;
	}
	// In class Utilis I have helpers methods that are used in multiple places in page classes. 
	// In this way, the repeating parts are pulled in one place.  
	// All methods are static, so they can be invoked without instantiating the class itself.
	
	// Find the element  and get text for assertion 
	// and call the method waitForElementPresence described in the class Utils
	public String getTitle() {
		return Utils.waitForElementPresence(driver, By.xpath("//*[@id=\"dashboard-navbar\"]/nav/div/ul[1]/li"), 15).getText();
	}
	// Find the element Recruitment
	public WebElement getRecruitment() {
		return Utils.waitForElementPresence(driver, By.xpath("//*[@id=\"menu_recruitment_viewRecruitmentModule\"]/span[2]"), 25);
	}
	
}

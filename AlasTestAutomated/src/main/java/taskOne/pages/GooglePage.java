package taskOne.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import pac.helpers.*;


public class GooglePage {
	
	private WebDriver driver;

	public GooglePage(WebDriver driver) {
		this.driver = driver;
	}
	// In class Utilis I have helpers methods that are used in multiple places in page classes. 
	// In this way, the repeating parts are pulled in one place.  
	// All methods are static, so they can be invoked without instantiating the class itself.
	
	// Find the element and and call the method waitForElementPresence described in the class Utils
	public WebElement getSearch() {
		return Utils.waitForElementPresence(driver, By.name("q"), 10);
	}
	//Set element search
	public void setSearch(String term) {
		WebElement searchFild = getSearch();
		searchFild.clear();
		searchFild.sendKeys(term);
	}
	//Find the button google search
	public WebElement getSearchBtn() {
		return Utils.waitForElementPresence(driver, By.name("btnK"), 10);
	}
	//In this method I pass the search term into the Google Search field and click on button search
	public void searching(String term) {
		setSearch(term);
		getSearchBtn().click();
	}
	//Search for demoqa.com link
	public WebElement getLink(){
		return Utils.waitForElementPresence(driver, By.xpath("//*[@id=\"rso\"]/div[1]/div/div/div/div/div[1]/a/h3"), 10);
	}
	
	//task 2
	// Find the element  and get text for assertion
	public String getResult() {
		return Utils.waitForElementPresence(driver, By.id("mBMHK"), 10).getText();
	}
	

}

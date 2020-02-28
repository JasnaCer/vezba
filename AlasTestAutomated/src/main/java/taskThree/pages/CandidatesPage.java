package taskThree.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import pac.helpers.Utils;

public class CandidatesPage {
	private WebDriver driver;
	
	public CandidatesPage(WebDriver driver) {
		this.driver = driver;
	}
	// In class Utilis I have helpers methods that are used in multiple places in page classes. 
	// In this way, the repeating parts are pulled in one place.  
	// All methods are static, so they can be invoked without instantiating the class itself.
	
	//Find the Candidates table
	public WebElement getCandidatesTable() {
		return Utils.waitForElementPresence(driver, By.xpath("//*[@id='content']/div[8]/div/div[2]/table"), 10);
	}
	// the row where the candidate is located, found by name
	public WebElement rowCandidate(String candidatName) {
		return Utils.waitForElementPresence(driver, By.xpath("//*[contains(text(),\"" + candidatName + "\")]/../.."), 10);
	}
	//Find element three dots
	public WebElement getThreeDots() {
		return Utils.waitForElementPresence(driver, By.xpath("//*[@id='ohrmList_Menu']"), 10);
	}
	//Find delete
	public  WebElement getDelete() {
		return Utils.waitForElementPresence(driver, By.xpath("//*[@id='deleteItemBtn']"),10);
	}
	
	//Find alert delete and click on button yes
	public  WebElement getAlert() {
		return Utils.waitForElementPresence(driver, By.id("modal-delete-candidate"),10);
	}
	//Find delete and click on button yes  
	public  WebElement getAlertBtnDelete() {
		return Utils.waitForElementPresence(driver, By.id("candidate-delete-button"),10);
	}
	//find element alert message Successfully Deleted
	public  WebElement getElementAlert() {
		return Utils.waitForElementPresence(driver, By.cssSelector(".toast-message"),10);
	}
	//method of deleting candidates from the table
	public void deleteCandidateByName(String name){
		//find candidates row and click on checkbox,click on  three dots and click on  delete
		rowCandidate(name).findElement(By.xpath("//td/label")).click();
		getThreeDots().click();
		getDelete().click();
		getAlert().isDisplayed();
		getAlertBtnDelete().isDisplayed();
		getAlertBtnDelete().click();
	}		
				
	// method to count number of rows in table
	public Integer noRow(){
	List<WebElement> getRowFromTable = 
		driver.findElements(By.xpath("//*[@id='content']/div[8]/div/div[2]/table/tbody/tr"));
	Integer a = getRowFromTable.size();
	return a;	
	}
	//Find the Add button 
	public WebElement getAddBtn() {
		return Utils.waitForElementPresence(driver, By.cssSelector(".large"), 10);
	}	
	//Find the Admin  window
	public WebElement getAdmin() {
		return Utils.waitForElementPresence(driver, By.xpath("//*[@id='welcome']/span[3]"), 10);
	}
	//Find the logout link
	public WebElement getLogout() {
		return Utils.waitForElementPresence(driver, By.xpath("//*[@id='novaLogoutPanel']/div[3]/a"), 10);
	}			
	public void logout(){
		//click on element admin and link login
		getAdmin().click();
		getLogout().click();
	}
}

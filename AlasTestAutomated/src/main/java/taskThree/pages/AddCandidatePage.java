package taskThree.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import pac.helpers.Utils;

public class AddCandidatePage {
	private WebDriver driver;
	
	public AddCandidatePage(WebDriver driver) {
		this.driver = driver;
	}
	// In class Utilis I have helpers methods that are used in multiple places in page classes. 
	// In this way, the repeating parts are pulled in one place.  
	// All methods are static, so they can be invoked without instantiating the class itself.
	
	//Find the modal add candidate
	public WebElement getCandidateModal() {
		return Utils.waitForElementPresence(driver, By.id("modalAddCandidate"), 15);
	}
	//Find elements and get text for assertion
	public String getTitle(){
		return Utils.waitForElementPresence(driver,By.xpath("//*[@id='modalAddCandidate']/div[1]"),10).getText();
	}
	//Find elements Add resume
	public WebElement getAddResume(){
		return Utils.waitForElementPresence(driver, By.id("addCandidate_resume"),10);
	} 
	//Set element Add resume: String resume = path to the required document
	public void setAddResume(String resume){
		WebElement Resume = getAddResume();
		Resume.clear();
		Resume.sendKeys(resume);
	}	
	//Find elements First Name
	public WebElement getName(){
		return Utils.waitForElementPresence(driver, By.id("addCandidate_firstName"),10);
	} 
	//Set element First Name
	public void setName(String name){
		WebElement Name = getName();
		Name.clear();
		Name.sendKeys(name);
	}	
	//Find elements Last Name
	public WebElement getLastName(){
		return Utils.waitForElementPresence(driver, By.id("addCandidate_lastName"),10);
	} 
	//Set element Last Name
	public void setLastName(String lastname){
		WebElement LastName = getLastName();
		LastName.clear();
		LastName.sendKeys(lastname);
	}	
	//Find elements Email
	public WebElement getEmail(){
		return Utils.waitForElementPresence(driver, By.id("addCandidate_email"),10);
	} 
	//Set element Email
	public void setEmail(String email){
		WebElement Email = getEmail();
		Email.clear();
		Email.sendKeys(email);
	}	
	//Find elements Vacancy
	public WebElement getVacancy(){
		return Utils.waitForElementPresence(driver, By.id("textarea_addCandidate_vacancy"),10);
	} 
	//Find elements select vacancy
	public  WebElement getSelectVacancy() {
		return Utils.waitForElementPresence(driver, By.xpath("//p[contains(.,'Software QA Engineer')]"),10);
	}
	//find element alert message Successfully Saved
	public  WebElement getElementAlert() {
		return Utils.waitForElementPresence(driver, By.cssSelector(".toast-message"),10);
	}
	//Find button save
	public WebElement getBtnSave(){
		return Utils.waitForElementPresence(driver, By.id("saveCandidateButton"),10);	
	}
	//method for adding candidate
	public void addCandidate(String resume, String name, String lastname, String email){
		setAddResume(resume);
		setName(name);
		setLastName(lastname);
		setEmail(email);
		getVacancy().click();
		getSelectVacancy().isDisplayed();
		getSelectVacancy().click();
		getBtnSave().isDisplayed();
		getBtnSave().click();
	}
	
}

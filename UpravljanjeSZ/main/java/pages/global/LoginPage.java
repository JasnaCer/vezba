package pages.global;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import pages.helpers.Utility;

public class LoginPage {
	private WebDriver driver;
	//konstruktor stranice
	public LoginPage(WebDriver driver){
		this.driver = driver;
	}
	//dobavljanje i setovanje email polja
	public WebElement getEmail(){
		return Utility.waitForElementPresence(driver, By.id("email"),10);
	}
	public void setEmail(String em){
		WebElement email = getEmail();
		email.clear();
		email.sendKeys(em);
	}
	//dobavljanje i setovanje password polja
	public WebElement getLozinka(){
		return Utility.waitForElementPresence(driver, By.id("lozinka"),10);
	}
	public void setLozinka(String loz){
		WebElement lozinka = getLozinka();
		lozinka.clear();
		lozinka.sendKeys(loz);
	}
	//dobavljanje uloguj se dugmeta
	public WebElement getbtnUlogujteSe(){
		return Utility.waitForElementPresence(driver, By.xpath("//button[@class='btn btn-primary']"),10);
	}
	// poruka koja se ispise kada se ne unese validan email 
	public String getMsgEmail(){
		return Utility.waitForElementPresence
		(driver, By.xpath("/html/body/app-root/app-logovanje/div/form/fieldset/div[1]/strong"),10).getText();
	}
	// poruka koja se ispise kada se ne unese valina lozinka  
		public String getMsgLozinka(){
			return Utility.waitForElementPresence
			(driver, By.xpath("/html/body/app-root/app-logovanje/div/form/fieldset/div[1]/strong"),10).getText();
		}
	//metoda za login(prosledjuje parametre i klikce)
	public void logIn(String email, String lozinka){
		setEmail(email);
		setLozinka(lozinka);
		getbtnUlogujteSe().click();
	}

}

package zadatakPOM1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class NastavnikPage {
	
private WebDriver driver;
	
	public NastavnikPage (WebDriver driver){
		this.driver = driver;
	}
	
	//kada na stranici nastavnik kliknem na dugme create ovoje forma koja se otvara
		//KREIRANJ NOVOG NASTAVNIKA
	public WebElement getFormaNastavnik(){
		return Utility.waitForElementPresence(driver, By.xpath("//div[@class='modal-content']"),10);
	}
	public WebElement getIme(){
		return Utility.waitForElementPresence(driver, By.id("field_ime"),10);
	} 
	public void setIme(String imee){
		WebElement ime = getIme();
		ime.clear();
		ime.sendKeys(imee);
	}
	public WebElement getPrezime(){
		return Utility.waitForElementPresence(driver, By.id("field_prezime"),10);
	} 
	public void setPrezime(String prez){
		WebElement prezime = getPrezime();
		prezime.clear();
		prezime.sendKeys(prez);
	}
	public WebElement getZvanje(){
		return Utility.waitForElementPresence(driver, By.id("field_zvanje"),10);
	} 
	public void setZvanje(String zvanje){
		WebElement zvanjeN = getZvanje();
		zvanjeN.clear();
		zvanjeN.sendKeys(zvanje);
	}
	public WebElement getBtnSave(){
		return Utility.waitForElementPresence
				(driver, By.xpath("//div[@class='modal-footer']/button[@type='submit']"),10);
		
	}
	public void createNastavnik(String ime, String prez, String zvanje){
		setIme(ime);
		setPrezime(prez);
		setZvanje(zvanje);
		getBtnSave().click();
	}

}

package zadatakPOM1;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class StudentPage {
	
	private WebDriver driver;
	
	public StudentPage (WebDriver driver){
		this.driver = driver;
	}
	
	//kada na stranici studenti kliknem na dugme create ovoje forma koja se otvara
	//KREIRANJ NOVOG STUDENTA

	public WebElement getFormaStudent(){
		return Utility.waitForElementPresence(driver, By.xpath("//div[@class='modal-body']"),10);
	}
	
	public WebElement getIndeks(){
		return Utility.waitForElementPresence(driver, By.id("field_indeks"),10);
	} 
	public void setIndeks(String ind){
		WebElement indeks = getIndeks();
		indeks.clear();
		indeks.sendKeys(ind);
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
	public WebElement getGrad(){
		return Utility.waitForElementPresence(driver, By.id("field_grad"),10);
	} 
	public void setGrad(String gra){
		WebElement grad = getGrad();
		grad.clear();
		grad.sendKeys(gra);
	}
	public WebElement getBtnSave(){
		return Utility.waitForElementPresence(driver, By.xpath("//div[@class='modal-footer']/button[@type='submit']"),10);
		
	}
	public void createStudent(String ind,String ime, String prez, String grad){
		setIndeks(ind);
		setIme(ime);
		setPrezime(prez);
		setGrad(grad);
		getBtnSave().click();
	}

}
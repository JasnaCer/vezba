package pages.global;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import pages.helpers.Utility;

public class HomePage {
	
	private WebDriver driver;
	//konstruktor stranice
	public HomePage(WebDriver driver){
		this.driver = driver;
	}
	
	//MENI
	//link Pocetna u meniju
	public WebElement getPocetna(){
		return Utility.waitForElementPresence(driver, By.linkText("Pocetna"),10);
	}
	//link Zgrade u meniju
	public WebElement getZgrade(){
		return Utility.waitForElementPresence(driver, By.linkText("Zgrade"),10);
	}
	//link Stanari u meniju
	public WebElement getStanari(){
		return Utility.waitForElementPresence(driver, By.linkText("Stanari"),10);
	}
	//link Institucije u meniju
	public WebElement getInstitucije(){
		return Utility.waitForElementPresence(driver, By.linkText("Institucije"),10);
	}
	//link Firme u meniju
	public WebElement getFirme(){
		return Utility.waitForElementPresence(driver, By.linkText("Firme"),10);
	}
	// email korisnika koji se ispise na pocetnoj stranici nakon uspesnog logovanja
	public String getTextMsg(){
		return Utility.waitForElementPresence(driver, By.xpath("//*[@id=\"navbarColor02\"]/ul[2]/li[1]/label"),10).getText();
		//return Utility.waitForElementPresence(driver, By.xpath("//label[@class=\"nav-link active\"]"),10).getText();
	}
	//link dugme izloguj se u meniju
	public WebElement getBtnIzlogujSe(){														// 
		return Utility.waitForElementPresence(driver, By.xpath("//*[@class='btn btn-secondary']"),10);
	}
	
	//STRANICA lista 
	public WebElement getListaMeni(){
		return Utility.waitForElementPresence(driver, By.id("opcije"),10);
	}
	
	
}

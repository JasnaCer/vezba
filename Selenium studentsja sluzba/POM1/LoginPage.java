package zadatakPOM1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
	
	//deklarisem driver
	private WebDriver driver;
	
	//konstruktor pom klase
	public LoginPage (WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getUsername(){
		return Utility.waitForElementPresence(driver, By.id("username"),10);
	}
	public void setUsername(String username){
		WebElement userName = getUsername();
		userName.clear();
		userName.sendKeys(username);
	}
	public WebElement getPassword(){
		return Utility.waitForElementPresence(driver, By.id("password"),10);
	}
	public void setPassword(String password){
		WebElement pass = getPassword();
		pass.clear();
		pass.sendKeys(password);
	}
	public WebElement getbtnSignin(){
		return Utility.waitForElementPresence(driver, By.xpath("//button[@class='btn btn-primary ng-scope']"),10);
	}
	//metoda za login(prosledjuje parametre i klikce)
	public void logIn(String username, String password){
		setUsername(username);
		setPassword(password);
		getbtnSignin().click();
	}
}

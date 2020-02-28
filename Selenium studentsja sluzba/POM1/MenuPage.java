package zadatakPOM1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;



public class MenuPage {
	
	private WebDriver driver;
	
	public MenuPage(WebDriver driver) {
		super();
		this.driver = driver;
	}
	//MENU koji se vidi na svakoj stranici, svi njegovi elementi i podelementi
	//geteri i seteri pom klase
	
	//element ACCOUNT u meniju
	public WebElement getAccountMenu(){
		return Utility.waitForElementPresence(driver, By.id("account-menu"),10);
	}
	//element u accounts elementu
	public WebElement getSignUp(){
		return Utility.waitForElementPresence(driver, By.xpath("//a [@ui-sref=\"login\"]"),10);
	}
	//element u accounts elementu
	public WebElement getLogOut(){
		return Utility.waitForElementPresence(driver, By.id("logout"),10);
	}
	//element ENTITIESu meniju
	public WebElement getEntitiesMenu(){
		return Utility.waitForElementPresence(driver, By.xpath("//a[@class='dropdown-toggle']//span[@class='glyphicon glyphicon-th-list']"),10);
		}	
	//element studenti u entities
	public WebElement getStudent(){
		return Utility.waitForElementPresence(driver, By.xpath("//a[@ui-sref='studenti']"),10);
	}
	//element nastavnici u entities 
	public WebElement getNastavnik(){
		return Utility.waitForElementPresence(driver, By.xpath("//a[@ui-sref='nastavnici']"),10);
	}
	//element predmeti u entities 
		public WebElement getPredmet(){
			return Utility.waitForElementPresence(driver, By.xpath("//a[@ui-sref='predmeti']"),10);
		}
	//element ispitni rokovi u entities
		public WebElement getRok(){
			return Utility.waitForElementPresence(driver, By.xpath("//a[@ui-sref='ispitniRokovi']"),10);
		}
		
	//element prjava ispita u entities
		public WebElement getPrijava(){
			return Utility.waitForElementPresence(driver, By.xpath("//a[@ui-sref='ispitnePrijave']"),10);
		}
}

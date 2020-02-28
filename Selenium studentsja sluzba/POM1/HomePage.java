package zadatakPOM1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;



public class HomePage {
	
	private WebDriver driver;
	
	public HomePage(WebDriver driver){
		
		this.driver = driver;
	}
	// poruka o uspesnom logovanju. Kad dodjem na stranucu ulogovana kao admin
	public String getTextMsg(){
		return Utility.waitForElementPresence
				(driver, By.xpath("//div [@translate=\"main.logged.message\"]"),10).getText();
	}
	//Poruka kad se izlogujem this is your home page 
		public String getHomePageMsg(){
			return Utility.waitForElementPresence(driver, By.xpath("//p[@class='lead ng-scope']"),10).getText();
		}
}
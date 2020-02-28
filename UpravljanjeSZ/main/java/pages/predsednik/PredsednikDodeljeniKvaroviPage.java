package pages.predsednik;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import pages.helpers.Utility;

public class PredsednikDodeljeniKvaroviPage {
	private WebDriver driver;

	// konstruktor stranice
	public PredsednikDodeljeniKvaroviPage(WebDriver driver) {
		this.driver = driver;
	}

//	// dobavljanje registracija dugmeta
//	public WebElement btnRegistracija() {
//		return Utility.waitForElementPresence(driver,
//				By.xpath("/html/body/app-root/app-stanari/div/div/div/div/ul/li[1]/button/b"), 10);
//	}
//
//	// SELEKT
//	public Select getPrikaz() {
//		return new Select(Utility.waitForElementPresence(driver, By.id("prikaz"), 10));
//	}
//
//	public void setPrikaz(String value) {
//		this.getPrikaz().selectByVisibleText(value);
//	}
	 
}

package pages.predsednik;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import pages.helpers.Utility;

public class PredsednikZgradaKvaroviPage {
	private WebDriver driver;

	// konstruktor stranice
	public PredsednikZgradaKvaroviPage(WebDriver driver) {
		this.driver = driver;
	}

	// SELEKT
	public Select getPrikaz() {
		return new Select(Utility.waitForElementPresence(driver, By.id("prikaz"), 10));
	}

	public void setPrikaz(String value) {
		this.getPrikaz().selectByVisibleText(value);
	}

	public WebElement btnDodaj() {
		return Utility.waitForElementPresence(driver, By.xpath("//*[@id='dodaj']/button"), 10);
	}

	public WebElement getCbZavrseniKvarovi() {
		return Utility.waitForElementPresence(driver,
				By.xpath("/html/body/app-root/app-zgrada/div/div[2]/app-kvarovi/div/div/label/input"), 10);
	}
	public WebElement btnPregledaj() {
		return Utility.waitForElementPresence(driver, By.xpath("//*[@id='kvar_2']/table/tbody/tr[4]/td/a"), 10);
	}
	public WebElement btnIzmeni() {
		return Utility.waitForElementPresence(driver, By.xpath("//*[@id='kvar_1']/table/tbody/tr[4]/td/span[1]"), 10);
	}
	public WebElement btnbrisi() {
		return Utility.waitForElementPresence(driver, By.xpath("//*[@id='kvar_1']/table/tbody/tr[4]/td/span[2]/a"), 10);
	}
}

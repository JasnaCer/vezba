package pages.predsednik;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import pages.helpers.Utility;

public class PredsednikZgradaPredloziTacekePage {
	private WebDriver driver;

	// konstruktor stranice
	public PredsednikZgradaPredloziTacekePage(WebDriver driver) {
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
			return Utility.waitForElementPresence(driver, By.xpath("/html/body/app-root/app-zgrada/div/div[2]/app-tacke/a/button/b"),
					10);
		}
		// SELEKT
		public Select getSkupstinu() {
			return new Select(Utility.waitForElementPresence(driver, By.xpath("/html/body/app-root/app-zgrada/div/div[2]/app-tacke/select"), 10));
		}

		public void setSkupstinu(int value) {
			this.getSkupstinu().selectByIndex(value);
		}
		
		public WebElement btnDodajPredlogTackeUSkupstinu() {
			return Utility.waitForElementPresence(driver, By.xpath("html/body/app-root/app-zgrada/div/div[2]/app-tacke/div[1]/div/table/tbody/tr[1]/td[2]/button"),
					10);
		}
		
		public WebElement getFormaDodajPredlogTacku() {
			return Utility.waitForElementPresence(driver, By.xpath("/html/body/app-root/app-zgrada/div/div[2]/app-dodaj-ptdr/div/form"),
					10);
		}
		
		public WebElement getFormaDodajPredlogTackuNaslov() {
			return Utility.waitForElementPresence(driver, By.xpath("/html/body/app-root/app-zgrada/div/div[2]/app-dodaj-ptdr/div/form/fieldset/legend"),
					10);
		}
		
		public WebElement getTextpolje() {
			return Utility.waitForElementPresence(driver, By.id("tekstPtdr"), 10);
		}

		public void setTextpolje(String te) {
			WebElement text = getTextpolje();
			text.clear();
			text.sendKeys(te);
		}
		
		public WebElement btnPotvrdi() {
			return Utility.waitForElementPresence(driver, By.xpath("/html/body/app-root/app-zgrada/div/div[2]/app-dodaj-ptdr/div/form/fieldset/div[2]/button"),
					10);
		}
		public WebElement btnIzmeni() {
			return Utility.waitForElementPresence(driver, By.xpath("/html/body/app-root/app-zgrada/div/div[2]/app-tacke/div[1]/div/table/tbody/tr[3]/td/span/a[1]/span"),
					10);
		}
		public WebElement getTextKojiMenjam() {
			return Utility.waitForElementPresence(driver, By.id("noviTekst"), 10);
		}

		public void setTextKojiMenjam(String te) {
			WebElement text = getTextKojiMenjam();
			text.clear();
			text.sendKeys(te);
		}
		

		public WebElement btnPotvrdi2() {
			return Utility.waitForElementPresence(driver,
					By.xpath(
							"/html/body/app-root/app-zgrada/div/div[2]/app-tacke/div[1]/div/table/tbody/tr[3]/td/span/a[2]/span"),
					10);
		}

		public WebElement btnOdustani() {
			return Utility.waitForElementPresence(driver,
					By.xpath(
							"/html/body/app-root/app-zgrada/div/div[2]/app-tacke/div[1]/div/table/tbody/tr[3]/td/span/a[3]/span/font"),
					10);
		}

		public WebElement btnObrisi() {
			return Utility.waitForElementPresence(driver,
					By.xpath(
							"/html/body/app-root/app-zgrada/div/div[2]/app-tacke/div[1]/div/table/tbody/tr[3]/td/span/a[4]/span"),
					10);
		}
}

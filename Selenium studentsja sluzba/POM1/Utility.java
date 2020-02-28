package zadatakPOM1;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Utility {
	
	/**This function will check element presence*/
	public static boolean isPresent(WebDriver webdriver, By selector) {
		// try to find element by specified selector
		try {
			webdriver.findElement(selector);
		} catch (NoSuchElementException e) {
			// if element not exist return false
			return false;
		}
		return true;
	}

		/**Metoda ceka vraca true ako element nije prisutan na stranici
	 * ovo je korisno kod provere da li smo izbrisali neki element
	 * saceka interval vremena i tek onda vraca vrednost, sto omogucava da se asertacija ne odradi pre 
	 * registrovanja da je lement uklonjen sa stranice*/
	public static boolean waitForElementInvisibility(WebDriver driver, By selector, int waitInterval) {
		boolean invisible = (new WebDriverWait(driver,waitInterval))
				.until(ExpectedConditions.invisibilityOfElementLocated(selector));
		return invisible;
	}
	
	/** Metoda ceka da element sa prosledjenim selektorom postane klikabilan (displayed and enabled)
	 * @param driver - web driver
	 * @param selector - selektor elementa koji cekamo
	 * @param waitInterval - vreme koje ce driver da ceka da se element pojavi u DOM stablu
	 * @return WebElement selektovani element */
	public static WebElement waitToBeClickable(WebDriver driver, By selector, int waitInterval) {
		WebElement element = (new WebDriverWait(driver, waitInterval)).until(ExpectedConditions.elementToBeClickable(selector));
		return element;
	}
	
	/**
	 * Metoda ceka da se element sa prosledjenim selektorom pojavi u DOM stablu
	 * @param driver - web driver
	 * @param selector - selektor elementa cije prisustvo cekamo
	 * @param waitInterval - vreme koje ce driver da ceka da se element pojavi u DOM stablu
	 * @return WebElement selektovani element
	 */
	public static WebElement waitForElementPresence(WebDriver driver, By selector, int waitInterval) {
		WebElement element = (new WebDriverWait(driver, waitInterval)).until(ExpectedConditions.presenceOfElementLocated(selector));
		return element;
	}
	

	/**
	 * Metoda ceka da naslov stranice postane jednak prosledjenom stringu
	 * @param driver
	 * @param title - naslov koji cekamo
	 * @param waitInterval - vreme koje ce driver da ceka da se element pojavi u DOM stablu
	 */
	public static void waitForTitle(WebDriver driver, String title, int waitInterval){
		 (new WebDriverWait(driver, waitInterval)).until(ExpectedConditions.titleIs(title));
	}

	//metode za unos stringa
	public static String getNCharacters(int n) {
		StringBuffer outputBuffer = new StringBuffer(n);
		for (int i = 0; i < n; i++) {
			outputBuffer.append("a");
		}
		return outputBuffer.toString();
	}
	
	public static String getNChars(int n) {
		String str = "";
		for (int i = 0; i < n; i++) {
			str += "a";
		}
		return str;
	}
	

}

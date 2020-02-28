package taskOne.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import pac.helpers.Utils;

public class DroppablePage {
	private WebDriver driver;

	public DroppablePage(WebDriver driver) {
		this.driver = driver;
	}

	//Find the drag element
	public WebElement getFrom(){
		return Utils.waitForElementPresence(driver,By.id("draggable"),10);
	 }
	//Find the drop element
	public WebElement getTo(){
		 return Utils.waitForElementPresence(driver,By.id("droppable"),10);
	}	
	//geting the text from the element for assertion 
	public String getText(){
		return Utils.waitForElementPresence(driver,By.id("droppable"),10).getText();
 	}
		
}

package de.selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SeleniumIFramePage {

	WebDriver driver;
	//Hier haben wir die Lokatoren definieren


	// Menu Elemente
	@FindBy(id = "name")
	private WebElement inputName;

	@FindBy(id = "alertbtn")
	private WebElement btnAlert;


	public SeleniumIFramePage(WebDriver driver) {
		this.driver = driver;
		// verwendet, um die WebElemente der Seite zu initialisieren, die im Rahmen des Page Object Modells definiert wurden
		PageFactory.initElements(driver, this);
	}

	// Standard Drag and Drop
	public void wechselZuIframe(){
		driver.switchTo().frame("iframe");
	}
	
	public void nameEingabe(String name) {
		inputName.sendKeys(name);
	}
	
	public void alarmAnklicken() {
		btnAlert.click();
	}
	public String alermNachrichtAuslesen() {
		return driver.switchTo().alert().getText();
	}
	
	public void alarmNachrichtSchliessen() {
		driver.switchTo().alert().accept();
	}
}

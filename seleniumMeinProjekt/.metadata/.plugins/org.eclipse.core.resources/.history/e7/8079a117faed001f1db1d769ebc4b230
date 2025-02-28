package de.selenium.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumHomePage {
	
	WebDriver driver;
	//Hier haben wir die Lokatoren definieren

	// Statusmeldung
	@FindBy(css = "div.portalMessage:nth-child(1)")
	private WebElement statusMeldung;
	
	// Menu button
	@FindBy(id = "portaltab-burger-menu")
	private WebElement btnMenu;
	
	// 
	@FindBy(linkText = "Selenium Testapplikationen")
	private WebElement linkMenuSeleniumApp;
	
	
	public SeleniumHomePage(WebDriver driver) {
		this.driver = driver;
		// verwendet, um die WebElemente der Seite zu initialisieren, die im Rahmen des Page Object Modells definiert wurden
		PageFactory.initElements(driver, this);
	}
	
	public String statusMeldungAuslesen() {
		return statusMeldung.getText();
	}
	
	public void menuAusklappen() {
		btnMenu.click();
	}
	
	public void seleniumTestAppLinkAnklicken() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement link = wait.until(ExpectedConditions.elementToBeClickable(linkMenuSeleniumApp));
		link.click();
	
	}
	
	

}

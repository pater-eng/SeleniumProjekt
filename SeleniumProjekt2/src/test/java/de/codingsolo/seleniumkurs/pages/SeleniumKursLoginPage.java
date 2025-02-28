package de.codingsolo.seleniumkurs.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class SeleniumKursLoginPage {
	
	private WebDriver driver;

	//Eingabefeld Benutzername
	private By inputBenutzername = By.cssSelector("input.form-control[type='text']");
	//Eingabefeld Passwort
	private By inputPasswort = By.cssSelector("input.form-control[type='password']");
	//Button f�r die Anmeldung
	private By btnAnmeldung = By.cssSelector("input.btn-primary");
	// Statusmeldung
	private By statusMeldung = By.cssSelector("div.portalMessage:nth-child(1)");
	
	public SeleniumKursLoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void zugangsdatenEingeben(String benutzername, String passwort) {
		this.driver.findElement(inputBenutzername).sendKeys(benutzername);
		this.driver.findElement(inputPasswort).sendKeys(passwort);
	}
	
	public void loginButtonAnklicken() {
		this.driver.findElement(btnAnmeldung).click();
	}
	
	public String statusMeldungAuslesen() {
		return this.driver.findElement(statusMeldung).getText();
	}

}

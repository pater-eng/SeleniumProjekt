package de.selenium.otto.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class SeleniumZalandoLoginPage {
	
	private WebDriver driver;
	
	//Hier haben wir 4 Lokatoren definieren
	
	//Eingabefeld Benutzername
	private By inputBenutzername = By.cssSelector("input.form-control[type='text']");
	//Eingabefeld Passwort
	private By inputPasswort = By.cssSelector("input.form-control[type='password']");
	//Button für die Anmeldung
	private By btnAnmeldung = By.cssSelector("input.btn-primary");
	// Statusmeldung
	private By statusMeldung = By.cssSelector("div.portalMessage:nth-child(1)");
	
	public SeleniumZalandoLoginPage(WebDriver driver) {
		this.driver = driver;
		// verwendet, um die 4 WebElemente der Seite zu initialisieren, die im Rahmen des Page Object Modells definiert wurden
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

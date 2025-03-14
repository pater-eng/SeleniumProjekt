package de.selenium.pages;


import static org.junit.Assert.assertTrue;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.Random;

public class SeleniumLoginPage {

	private WebDriver driver;

	private WebDriverWait wait;

	//Hier haben wir 4 Lokatoren definieren

	//Eingabefeld Benutzername
	//private By inputBenutzername = By.cssSelector("input.form-control[type='text']");
	private By inputBenutzername = By.id("__ac_name");
	//Eingabefeld Passwort
	//	private By inputPasswort = By.cssSelector("input.form-control[type='password']");
	private By inputPasswort = By.id("__ac_password");

	//Button für die Anmeldung
	private By btnAnmeldung = By.cssSelector("input.btn-primary");
	// Statusmeldung
	//	private By statusMeldung = By.cssSelector("div.portalMessage:nth-child(1)");
	private By statusMeldung = By.cssSelector("div.portalMessage:nth-child(1)");

	private By btnMehrErfahren = By.className("btn-outline-light");


	private By btnOkWeitermachen = By.xpath("//button[@title='Akzeptieren Sie vorgewählte cookies' and @data-cookiefirst-action='accept']"); 

	private By btnAblehnen = By.xpath("//button[@title='Alle verweigern cookies' and @data-cookiefirst-action='reject']");

	private By btnNeinAnpassen = By.xpath("//button[@title='cookie Einstellungen anpassen' and @data-cookiefirst-action='adjust']");

	public SeleniumLoginPage(WebDriver driver) {
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

	public void mehrErfahrenAnklicken() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(btnMehrErfahren));
		element.click();

	}

	public void cookiesOKWeitermachenAnklicken() {

		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement cookiesButton = wait.until(ExpectedConditions.elementToBeClickable(btnOkWeitermachen));
		cookiesButton.click();
	}

	public void cookiesAblehnenAnklicken() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(btnAblehnen));
		element.click();
	}

	public void cookiesNeinAnpassenAnklicken() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(btnNeinAnpassen));
		element.click();
	}

	public WebElement getCookiesOKWeitermachenButton() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		return wait.until(ExpectedConditions.elementToBeClickable(btnOkWeitermachen));
	}


	public WebElement getcookiesAblehnenButton() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		return wait.until(ExpectedConditions.elementToBeClickable(btnAblehnen));
	}

	public WebElement getcookiesNeinAnpassenButton() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		return wait.until(ExpectedConditions.elementToBeClickable(btnNeinAnpassen));
	}



	public void cookiesAuswahl() {
	    // Erzeugen eines Random-Objekts
	    Random random = new Random();
	    // Generieren einer Zufallszahl zwischen 1 und 3 (inklusive)
	    int i = random.nextInt(3) + 1;

	    switch(i) {
	        case 1: 
	            WebElement cookiesOKWeitermachen = getCookiesOKWeitermachenButton();
	            if(cookiesOKWeitermachen.isDisplayed() && cookiesOKWeitermachen.isEnabled()) {
	                cookiesOKWeitermachen.click();
	            }
	            break;
	        case 2:
	            WebElement cookiesAblehnen = getcookiesAblehnenButton();
	            if(cookiesAblehnen.isDisplayed() && cookiesAblehnen.isEnabled()) {
	                cookiesAblehnen.click();
	            }
	            break;
	        case 3:
	            WebElement cookiesNeinAnpassen = getcookiesNeinAnpassenButton();
	            if(cookiesNeinAnpassen.isDisplayed() && cookiesNeinAnpassen.isEnabled()) {
	                cookiesNeinAnpassen.click();
	            }
	            break;
	        default:
	            throw new IllegalStateException("Unerwarteter Wert: " + i);
	    }
	}
 
}

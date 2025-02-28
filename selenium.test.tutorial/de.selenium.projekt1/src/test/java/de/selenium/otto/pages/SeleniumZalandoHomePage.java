package de.selenium.otto.pages;

import static org.junit.Assert.assertTrue;

import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumZalandoHomePage {

	WebDriver driver;

	WebDriverWait wait;



	//Hier haben wir die Lokatoren definieren

	// sucheFeld
	//@FindBy(xpath = "//input[@data-qa-id='my-search-field']")
	//@FindBy(css ="input[placeholder= 'Wonach suchst du?']")
	@FindBy(css ="input[id= 'header-search-input']")
	private WebElement sucheFeld;

	//@FindBy(xpath ="//div[@id='onetrust-banner-sdk']//button[contains(@class, 'onetrust-accept-btn-handler')]")
	//@FindBy(css ="#onetrust-banner-sdk #onetrust-accept-btn-handler")
	@FindBy(css ="#usercentrics-root [data-testid='uc-accept-all-button']")
	private WebElement buttonOK;


	private	By btnMehrInformationen = By.xpath("//button[@data-testid='uc-more-button']");
	private	By btnNurNotwendige = By.xpath("//button[@data-testid='uc-deny-all-button']");
	private	By btnAllesAkzeptieren = By.xpath("//div[@data-testid='uc-buttons-container']//button[@data-testid='uc-accept-all-button']");
	private	By btnAkzeptierenAuswahl = By.xpath("//button[@data-testid='uc-accept-selected-button']");


	@FindBy(id="onetrust-reject-all-handler")
	private WebElement buttonAblehnen;



	public SeleniumZalandoHomePage(WebDriver driver) {
		this.driver = driver;
		// verwendet, um die WebElemente der Seite zu initialisieren, die im Rahmen des Page Object Modells definiert wurden
		PageFactory.initElements(driver, this);
	}

	public void sucheEingeben(String suche) {
		sucheFeld.sendKeys(suche);
	}

	public void acceptCookiesWithCss() {
		//wait = new WebDriverWait(driver, Duration.ofSeconds(50));
		//WebElement userCentricsRoot = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#usercentrics-root")));

		/*	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement shadowHost = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#uc-footer-root")));

		SearchContext shadowRoot = shadowHost.getShadowRoot();
		WebElement acceptButton = new WebDriverWait(driver, Duration.ofSeconds(15))
		    .until(ExpectedConditions.elementToBeClickable(
		        shadowRoot.findElement(By.cssSelector("button[data-testid='uc-accept-all-button']"))));
		acceptButton.click(); */

		// Beispiel: Falls der Cookie-Banner in einem Shadow DOM liegt //  

		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement cookiesButton = wait.until(ExpectedConditions.elementToBeClickable(btnAllesAkzeptieren));
		cookiesButton.click();


		/*
		if(shadowHost.isDisplayed() && shadowHost.isEnabled()) {
			SearchContext shadowRoot = shadowHost.getShadowRoot();

			WebElement acceptButton = new WebDriverWait(driver, Duration.ofSeconds(15))
					.until(ExpectedConditions.elementToBeClickable(shadowRoot.findElement(By.cssSelector("button[data-testid='uc-accept-all-button']"))));
			acceptButton.click();
		}else {

			System.out.println("Shadow wurde nicht identifiziert ");
			assertTrue(false);
		} */





	}

	public void buttonAblehnen() {
		buttonAblehnen.click();
	}



}

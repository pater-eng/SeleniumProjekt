package de.selenium.otto.tests;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import de.selenium.otto.pages.SeleniumZalandoHomePage;
import de.selenium.otto.pages.SeleniumZalandoLoginPage;
import de.selenium.pages.SeleniumAppilcationPage;
import de.selenium.pages.SeleniumHomePage;
import de.selenium.pages.SeleniumLoginPage;
import de.selenium.pages.SeleniumTestForm1Page;

public class TestSeleniumZalandoHomePage {
	WebDriver driver;
	
	@Before
	public void setUp() throws Exception {
		System.out.println("initialisiere Webdriver.");
		System.setProperty("webdriver.chrome.driver", 
				"./drivers/chromedriver.exe");
		driver = new ChromeDriver();
		// Browser auf Maximum vergrößer
		driver.manage();
		//driver.get("https://www.otto.de"); 
		driver.get("https://www.zalando.de/"); 
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("Testfall abgeschlossen. -Aufräumen");	
		//driver.close();
	}

	@Test
	public void test() {
		System.out.println("Starte Test Login mit Erfog");	
		// Arrange
		// Anmeldung ist erfolgreich
		SeleniumZalandoLoginPage loginPage = new SeleniumZalandoLoginPage(driver);
		//loginPage.zugangsdatenEingeben("","");
		//loginPage.loginButtonAnklicken();
		
		SeleniumZalandoHomePage homePage = new SeleniumZalandoHomePage(driver);
		homePage.acceptCookiesWithCss();
		homePage.sucheEingeben("sakko herren");
						
	/*
		// Navigation zum Formular
		SeleniumHomePage homePage = new SeleniumHomePage(driver);
		homePage.menuAusklappen();
		homePage.seleniumTestAppLinkAnklicken();
	
		SeleniumAppilcationPage appPage = new SeleniumAppilcationPage(driver);
		appPage.seleniumTestFrom1LinkAnklicken();
		
		// Starte Formular
		SeleniumTestForm1Page testForme1Page = new SeleniumTestForm1Page(driver);
		testForme1Page.betreffEingeben("Automatischer Test");
		testForme1Page.nameEingeaben("Pater");
		
		// Erster SelectBox
		testForme1Page.selectAuswaehlen1("Selenium Automatisierung mit Dieter");
		testForme1Page.selectAuswaelen2From(new int[] {0,2,5,6}); // Alfreds Futterkiste(0), Ernst Handel(2), Sony(5), Volkswagen(6)
		testForme1Page.firmenUebernehmen();
		
		// Navigation: Zweiter SelectElement oder Multiselect
		testForme1Page.selectAuswaelen2To(new int[] {2});
		testForme1Page.ausgewaehlteFirmaNachObenVerschieben();
		
		// Act
		testForme1Page.formularSpeichern();
		
		// Assert
		 String erfolgMeldung = testForme1Page.statusMeldungAuslesen(); // 
		//Vergleich 
		assertEquals(erfolgMeldung, "Hallo Pater, Danke das du den Kurs Selenium Automatisierung mit Dieter besuchst!");
		assertTrue(erfolgMeldung.contains("Selenium Automatisierung"));
		
		// Prüfen wir auf Liste, ob Element 2 als Erstes ist
		
		String erstesElement = testForme1Page.erstesElementDerListeAuslesen();
		assertEquals(erstesElement, "Ernst Handel");
		*/
	}

}

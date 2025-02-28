package de.selenium.pages.tests;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.Duration;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import de.selenium.pages.SeleniumAppilcationPage;
import de.selenium.pages.SeleniumHomePage;
import de.selenium.pages.SeleniumIFramePage;
import de.selenium.pages.SeleniumLoginPage;

public class TestLogingIFramePage {
	WebDriver driver;

	@Before
	public void setUp() throws Exception {
		System.out.println("initialisiere Webdriver.");
		System.setProperty("webdriver.chrome.driver", 
				"./drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://seleniumkurs.codingsolo.de"); 
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("Testfall abgeschlossen. -Aufräumen");	
		//driver.close();
	}

	@Test
	public void testAlert() {
		System.out.println("Starte Test Login mit Erfog");	
		// Arrange
		// Anmeldung ist erfolgreich
		SeleniumLoginPage loginPage = new SeleniumLoginPage(driver);
		loginPage.zugangsdatenEingeben("selenium42","R5vxI0j60");
		loginPage.loginButtonAnklicken();


		// Navigation zum Formular
		SeleniumHomePage homePage = new SeleniumHomePage(driver);
		homePage.menuAusklappen();
		homePage.seleniumTestAppLinkAnklicken();

		SeleniumAppilcationPage appPage = new SeleniumAppilcationPage(driver);
		appPage.seleniumLinkDragAndDropBeispielAnklicken();

		// Starte IFrame
		SeleniumIFramePage iframePage = new SeleniumIFramePage(driver);
		iframePage.wechselZuIframe();
		
		
		// Act
		iframePage.nameEingabe("Pater");
		iframePage.alarmAnklicken();

		// Assert
		// assertTrue, um zu überprüfen, ob der Text eines JavaScript-Alerts die Zeichenfolge "42" enthält
		// WebDriver angewiesen, zum aktuell geöffneten Alert zu wechseln und den darin enthaltenen Text abzurufen
		assertTrue(iframePage.alermNachrichtAuslesen().contains("42"));
		iframePage.alarmNachrichtSchliessen();
	}

}

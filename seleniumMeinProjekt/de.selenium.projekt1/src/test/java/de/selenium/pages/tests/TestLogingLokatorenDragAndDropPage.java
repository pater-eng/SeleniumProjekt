package de.selenium.pages.tests;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import de.selenium.pages.SeleniumAppilcationPage;
import de.selenium.pages.SeleniumDragDropPage;
import de.selenium.pages.SeleniumHomePage;
import de.selenium.pages.SeleniumLoginPage;

public class TestLogingLokatorenDragAndDropPage {
	WebDriver driver;

	@Before
	public void setUp() throws Exception {
		System.out.println("initialisiere Webdriver.");
		System.setProperty("webdriver.chrome.driver", 
				"./drivers/chromedriver.exe");
		driver = new ChromeDriver();
		// Browser auf Maximum vergrößer
		driver.manage().window().maximize();
		driver.get("https://seleniumkurs.codingsolo.de"); 
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
		SeleniumLoginPage loginPage = new SeleniumLoginPage(driver);
		loginPage.zugangsdatenEingeben("selenium42","R5vxI0j60");
		loginPage.loginButtonAnklicken();


		// Navigation zum Formular
		SeleniumHomePage homePage = new SeleniumHomePage(driver);
		homePage.menuAusklappen();
		homePage.seleniumTestAppLinkAnklicken();

		SeleniumAppilcationPage appPage = new SeleniumAppilcationPage(driver);
		appPage.seleniumLinkDragAndDropBeispielAnklicken();

		// Navigation: Startet Drap and Drop
		SeleniumDragDropPage dragDropPage = new SeleniumDragDropPage(driver);

		// Act
		// Hier werden nur 3 Element Drag and Drop. Mit perform() wird die komplette Aktion dann tatsächlich ausgeführt.
		dragDropPage.moveWhiteLogoToBox();
		dragDropPage.moveBlueLogoToBox();
		
		dragDropPage.moveRedLogoToPoint(250, 0);
		dragDropPage.moveGreenLogoToBoxManuell();
		
		dragDropPage.moveAllLogosToBox();
		

		// Assert
		String erfolgMeldung = dragDropPage.getStatusMeldung();

		// Blue als letztes Element wird abgelegt
		//assertTrue(erfolgMeldung.contains("green-logo"));
		assertTrue(erfolgMeldung.contains("coding-logo"));

	}

}

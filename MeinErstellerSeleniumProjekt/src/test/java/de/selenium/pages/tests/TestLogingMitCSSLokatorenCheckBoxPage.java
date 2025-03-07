package de.selenium.pages.tests;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import de.selenium.pages.SeleniumAppilcationPage;
import de.selenium.pages.SeleniumHomePage;
import de.selenium.pages.SeleniumLoginPage;
import de.selenium.pages.SeleniumWebElementCheckboxPage;

public class TestLogingMitCSSLokatorenCheckBoxPage {
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
	public void testCheckBoxDoubleClick() {
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
		appPage.seleniumLinkWebElementeAnklicken();

		// Checkbox startet: 
		SeleniumWebElementCheckboxPage webElementPage = new SeleniumWebElementCheckboxPage(driver);
		
		// Act
		webElementPage.checkBox1Aktivieren();
		webElementPage.checkBox2Aktivieren();
		webElementPage.checkBox3Aktivieren();
		


		// Assert
		System.out.println("Box1: "+webElementPage.checkBox1StatusAuslesen());
		assertEquals(webElementPage.checkBox1StatusAuslesen(), false);
		assertEquals(webElementPage.checkBox2StatusAuslesen(), true);
		assertEquals(webElementPage.checkBox3StatusAuslesen(), true);

	}

}

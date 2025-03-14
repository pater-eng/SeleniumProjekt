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
import de.selenium.pages.SeleniumWebElementRadioButtonPage;

public class TestLogingMitCSSLokatorenRadioButtonsPage {
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
	public void testRadioButton() {
		System.out.println("Starte Test Login mit Erfog mit RadioButton");	
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


		// RadioButton startet: 
		SeleniumWebElementRadioButtonPage webElementPage = new SeleniumWebElementRadioButtonPage(driver);

		webElementPage.radio1Aktivieren();
		assertEquals(webElementPage.radioButton1StatusAuslesen("value"),"radio1");
		webElementPage.radio2Aktivieren();
		assertEquals(webElementPage.radioButton2StatusAuslesen("value"),"radio2");
		webElementPage.radio3Aktivieren();
		assertEquals(webElementPage.radioButton3StatusAuslesen("value"),"radio3");

		
	}

}

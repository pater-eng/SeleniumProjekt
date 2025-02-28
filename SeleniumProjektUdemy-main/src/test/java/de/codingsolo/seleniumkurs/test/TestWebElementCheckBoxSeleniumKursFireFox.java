package de.codingsolo.seleniumkurs.test;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import de.codingsolo.seleniumkurs.pages.SeleniumKursHomePage;
import de.codingsolo.seleniumkurs.pages.SeleniumKursLoginPage;
import de.codingsolo.seleniumkurs.pages.SeleniumKursTestApplikationenPage;
import de.codingsolo.seleniumkurs.pages.SeleniumKursWebElementePage;

public class TestWebElementCheckBoxSeleniumKursFireFox {

	WebDriver driver;

	@Before
	public void setUp() throws Exception {
		System.out.println("Initialisiere Webdriver");
		System.setProperty("webdriver.gecko.driver", "./drivers/geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("https://seleniumkurs.codingsolo.de");
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("Test abgeschlossen- ich räume");
		// driver.close();
	}

	@Test
	public void testCheckBox() {
		System.out.println("Starte Test CheckBox der Web Elemente Beispielseite");

		// Arrange

		// Login
		SeleniumKursLoginPage loginPage = new SeleniumKursLoginPage(driver);
		loginPage.zugangsdatenEingeben("selenium101", "codingsolo");
		loginPage.loginButtonAnklicken();

		// Navigation
		SeleniumKursHomePage homePage = new SeleniumKursHomePage(driver);
		homePage.menuAusklappen();
		homePage.seleniumTestAppLinkAnklicken();

		SeleniumKursTestApplikationenPage testAppPage = new SeleniumKursTestApplikationenPage(driver);
		testAppPage.webElementeBeispielAnklicken();

		SeleniumKursWebElementePage webElementPage = new SeleniumKursWebElementePage(driver);

		// Act

		webElementPage.checkBox1Anklicken();
		webElementPage.checkBox1Anklicken();

		webElementPage.checkBox2Anklicken();
		webElementPage.checkBox3Anklicken();

		// Assert

		assertEquals(webElementPage.checkBox1StatusAuslesen(), false);
		assertEquals(webElementPage.checkBox2StatusAuslesen(), true);
		assertEquals(webElementPage.checkBox3StatusAuslesen(), true);
	}

}

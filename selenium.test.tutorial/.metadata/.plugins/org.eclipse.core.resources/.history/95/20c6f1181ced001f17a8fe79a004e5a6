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

public class TestWebElementRadioButtonsSeleniumKursFireFox {

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
	public void testRadioButton() {
		System.out.println("Starte Test RadioButton");

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

		webElementPage.radioButton1Anklicken();

		assertEquals(webElementPage.radioButton1getAttribute("value"), "radio1");

		webElementPage.radioButton2Anklicken();

		assertEquals(webElementPage.radioButton2getAttribute("value"), "radio2");

		webElementPage.radioButton3Anklicken();

		assertEquals(webElementPage.radioButton3getAttribute("value"), "radio3");

	}

}

package de.codingsolo.seleniumkurs.test;

import static org.junit.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import de.codingsolo.seleniumkurs.pages.SeleniumKursHomePage;
import de.codingsolo.seleniumkurs.pages.SeleniumKursKatzenSuchenPage;
import de.codingsolo.seleniumkurs.pages.SeleniumKursLoginPage;
import de.codingsolo.seleniumkurs.pages.SeleniumKursTestApplikationenPage;

public class TestKatzenSucheImplizitAsyncTestSeleniumKursFireFox {

	WebDriver driver;

	@Before
	public void setUp() throws Exception {
		System.out.println("Initialisiere Webdriver");
		System.setProperty("webdriver.gecko.driver", "./drivers/geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://seleniumkurs.codingsolo.de");
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("Test abgeschlossen- ich räume");
		// driver.close();
	}

	@Test
	public void testImplizitWait() {
		System.out.println("Starte Test AJAX Anwendung mit Implizit Wait");

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
		testAppPage.katzenSucheBeispielAnklicken();

		SeleniumKursKatzenSuchenPage katzenPage = new SeleniumKursKatzenSuchenPage(driver);
		String beschreibung = katzenPage.beschreibungAuslesen();
		String srcLinkKatzenBild1 = katzenPage.srcLinkImgKatze1Auslesen();

		// Act

		katzenPage.nextPage();
		katzenPage.anzahlBilderEingeben("6");
		String srcLinkKatzenBild2 = katzenPage.srcLinkImgKatze2Auslesen();

		// Assert

		assertTrue(beschreibung.contains("Lieblingskatze"));
		assertTrue(srcLinkKatzenBild1.contains("-ssxkBCAy"));
		assertTrue(srcLinkKatzenBild2.contains("29RH1pQb5"));

	}

}

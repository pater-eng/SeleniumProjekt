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

public class TestKatzenSucheExplizitAsyncTestSeleniumKursFireFox {

	WebDriver driver;

	@Before
	public void setUp() throws Exception {
		System.out.println("Initialisiere Webdriver");
		System.setProperty("webdriver.gecko.driver", "./drivers/geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		driver.get("https://seleniumkurs.codingsolo.de");
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("Test abgeschlossen- ich räume");
		// driver.close();
	}

	@Test
	public void testExplizitWait() {
		System.out.println("Starte Test AJAX Anwendung mit Explizit Wait");

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

		SeleniumKursKatzenSuchenPage katzenSuchPage = new SeleniumKursKatzenSuchenPage(driver);

		String srcLinkKatzenImg1 = katzenSuchPage.srcLinkImgKatze1Auslesen();

		// ACT
		katzenSuchPage.nextPage();
		String srcLinkKatzenImg2 = katzenSuchPage.srcLinkImgKatze3Auslesen();

		katzenSuchPage.sortierungEingeben("Asc");
		String srcLinkKatzenImg3 = katzenSuchPage.srcLinkImgKatze4Auslesen();

		// Assert
		assertTrue(srcLinkKatzenImg1.contains("-ssxkBCAy"));
		assertTrue(srcLinkKatzenImg2.contains("IRb9aOk6K"));
		assertTrue(srcLinkKatzenImg3.contains("h6"));

	}

}

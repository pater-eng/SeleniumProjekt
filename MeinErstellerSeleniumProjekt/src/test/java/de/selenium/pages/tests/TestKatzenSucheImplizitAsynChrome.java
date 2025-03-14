package de.selenium.pages.tests;

import static org.junit.Assert.assertTrue;

import java.time.Duration;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import de.selenium.exception.MeineException;
import de.selenium.pages.SeleniumAppilcationPage;
import de.selenium.pages.SeleniumHomePage;
import de.selenium.pages.SeleniumKatzenSuchenPage;
import de.selenium.pages.SeleniumLoginPage;


public class TestKatzenSucheImplizitAsynChrome {
	WebDriver driver;

	@Before
	public void setUp() throws Exception {
		System.out.println("initialisiere Webdriver.");
		System.setProperty("webdriver.chrome.driver", 
				"./drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2)); // Für jede Element 2 Secunde warten.
		driver.get("https://seleniumkurs.codingsolo.de"); 
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("Test abgeschlossen- ich räume");
		// driver.close();
	}

	@Test
	public void testImplizitWait() throws MeineException {
		System.out.println("Starte Test AJAX Anwendung mit Implizit Wait");

		// Arrange

		// Login
		// Anmeldung ist erfolgreich
		SeleniumLoginPage loginPage = new SeleniumLoginPage(driver);
		loginPage.zugangsdatenEingeben("selenium42","R5vxI0j60");
		loginPage.loginButtonAnklicken();


		// Navigation zum Formular
		SeleniumHomePage homePage = new SeleniumHomePage(driver);
		homePage.menuAusklappen();
		homePage.seleniumTestAppLinkAnklicken();

		SeleniumAppilcationPage appPage = new SeleniumAppilcationPage(driver);
		appPage.seleniumLinkKatzensucheTestseiteAJAXAnklicken();

		SeleniumKatzenSuchenPage katzenPage = new SeleniumKatzenSuchenPage(driver);
		String beschreibung = katzenPage.beschreibungAuslesen();
		System.out.println("Beschreibung: "+beschreibung);
		String srcLinkKatzenBild1 = katzenPage.srcLinkImgKatze1Auslesen();
		System.out.println("Bild1: "+srcLinkKatzenBild1);

		// Act

		
		String srcLinkKatzenBild2 = katzenPage.srcLinkImgKatze2Auslesen();
		System.out.println("Bild2: "+srcLinkKatzenBild2);
		String srcLinkKatzenBild3 = katzenPage.srcLinkImgKatze3Auslesen();
		System.out.println("Bild3: "+srcLinkKatzenBild3);
	
		/*
		String srcLinkKatzenBild5 = katzenPage.srcLinkImgKatze5Auslesen();
		System.out.println("Bild5: "+srcLinkKatzenBild5);
		String srcLinkKatzenBild6 = katzenPage.srcLinkImgKatze6Auslesen();
		System.out.println("Bild6: "+srcLinkKatzenBild6);
		String srcLinkKatzenBild7 = katzenPage.srcLinkImgKatze7Auslesen();
		System.out.println("Bild7: "+srcLinkKatzenBild7);
		*/
		//katzenPage.nextPage();
		katzenPage.anzahlBilderEingeben("9");

		// Assert

		assertTrue(beschreibung.contains("Lieblingskatze"));
		//assertTrue(srcLinkKatzenBild1.contains("-ssxkBCAy")); 
		assertTrue(srcLinkKatzenBild1.contains("ECqe13G5B"));
		//assertTrue(srcLinkKatzenBild2.contains("29RH1pQb5"));
		assertTrue(srcLinkKatzenBild2.contains("LR5DtaA8M"));
		assertTrue(srcLinkKatzenBild3.contains("GVR6HHxv-"));
	//	assertTrue(srcLinkKatzenBild5.contains("OxdwIl870"));
	//	assertTrue(srcLinkKatzenBild6.contains("Znj6KEDRX"));
	//	assertTrue(srcLinkKatzenBild7.contains("2ECqypnRY"));

	}

}

package de.selenium.pages.tests;


import static org.junit.Assert.assertTrue;

import java.time.Duration;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import de.selenium.pages.SeleniumAppilcationPage;
import de.selenium.pages.SeleniumHomePage;
import de.selenium.pages.SeleniumKatzenSuchenPage;
import de.selenium.pages.SeleniumLoginPage;


public class TestKatzenSucheExplizitAsyncTestSeleniumChrome {

	WebDriver driver;

	@Before
	public void setUp() throws Exception {
		System.out.println("initialisiere Webdriver.");
		System.setProperty("webdriver.chrome.driver", 
				"./drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5)); // Für jede Element 2 Secunde warten.
		driver.get("https://seleniumkurs.codingsolo.de"); 
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("Test abgeschlossen- ich r�ume");
		// driver.close();
	}

	@Test
	public void testExplizitWait() {
		System.out.println("Starte Test AJAX Anwendung mit Explizit Wait");

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

		SeleniumKatzenSuchenPage katzenSuchPage = new SeleniumKatzenSuchenPage(driver);

		String srcLinkKatzenImg1 = katzenSuchPage.srcLinkImgKatze1Auslesen();
		System.out.println("IMG1: "+srcLinkKatzenImg1);

		// ACT
		katzenSuchPage.nextPage();
		String srcLinkKatzenImg3 = katzenSuchPage.srcLinkImgKatze3Auslesen();
		System.out.println("IMG3: "+srcLinkKatzenImg3);
		
		String srcLinkKatzenImg2 = katzenSuchPage.srcLinkImgKatze2Auslesen();
		System.out.println("IMG2: "+srcLinkKatzenImg2);
		
		katzenSuchPage.sortierungEingeben("Asc");
		String srcLinkKatzenImg4 = katzenSuchPage.srcLinkImgKatze4Auslesen();
		System.out.println("Sortieren: "+srcLinkKatzenImg4);

		// Assert
		assertTrue(srcLinkKatzenImg1.contains("ECqe13G5B"));
		//assertTrue(srcLinkKatzenImg2.contains("5qNv0jHXW"));
		//assertTrue(srcLinkKatzenImg3.contains("0c9_EEtqQ"));
		assertTrue(srcLinkKatzenImg4.contains("h6"));

	}

}

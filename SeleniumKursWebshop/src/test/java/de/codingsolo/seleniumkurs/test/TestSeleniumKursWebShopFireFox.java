package de.codingsolo.seleniumkurs.test;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import de.codingsolo.seleniumkurs.pages.SeleniumKursHomePage;
import de.codingsolo.seleniumkurs.pages.SeleniumKursLoginPage;
import de.codingsolo.seleniumkurs.pages.SeleniumKursTestApplikationenPage;
import de.codingsolo.seleniumkurs.pages.SeleniumKursWebShopAGB;
import de.codingsolo.seleniumkurs.pages.SeleniumKursWebShopKasse;
import de.codingsolo.seleniumkurs.pages.SeleniumKursWebShopProdukte;

public class TestSeleniumKursWebShopFireFox {
	
	WebDriver driver;

	@Before
	public void setUp() throws Exception {
		System.out.println("Initialisiere WebDriver");
		System.setProperty("webdriver.gecko.driver", "./drivers/geckodriver.exe");
		
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://seleniumkurs.codingsolo.de");
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("Test abgeschlossen - ich räume auf");
//		driver.close();
	}

	@Test
	public void test() {
		System.out.println("Starte Test für den WebShop");
	
		//Arrange
		
		// Login
		SeleniumKursLoginPage loginPage = new SeleniumKursLoginPage(driver);
		loginPage.zugangsdatenEingeben("selenium102", "codingsolo");
		loginPage.loginButtonAnklicken();
		
		// Navigation
		SeleniumKursHomePage homePage = new SeleniumKursHomePage(driver);
		homePage.menuAusklappen();
		homePage.seleniumTestAppLinkAnklicken();
		
		SeleniumKursTestApplikationenPage testAppPage = new SeleniumKursTestApplikationenPage(driver);
		testAppPage.webShopAnklicken();
		
		SeleniumKursWebShopProdukte webShopProdukte = new SeleniumKursWebShopProdukte(driver);
		SeleniumKursWebShopKasse webShopKasse = new SeleniumKursWebShopKasse(driver);
		SeleniumKursWebShopAGB webShopAGB = new SeleniumKursWebShopAGB(driver);
		
		//Act
		
		webShopProdukte.produktSucheAusfuehren("Brems");
		
		webShopProdukte.produktAnzahlAuswaehlen("Bremssattel Hinten Audi", 4);
		webShopProdukte.produktInWarenKorbLegen("Bremssattel Hinten Audi");
		
		webShopProdukte.produktAnzahlAuswaehlen("Bremsscheiben Set Vorne Audi", 2);
		webShopProdukte.produktInWarenKorbLegen("Bremsscheiben Set Vorne Audi");
		
		String preis1 = webShopProdukte.preisAuslesen();
		
		webShopProdukte.warenKorbAnklicken();
		webShopProdukte.zurKasseAnklicken();
		
		webShopKasse.promoCodeEingeben("codingsolo");
		webShopKasse.promoCodeAktivierenAnklicken();
		
		String promoInfo = webShopKasse.promoInfoAuslesen();
		
		String preis2 = webShopKasse.preisAuslesen();
		
		webShopKasse.bestellungAnklicken();
		
		webShopAGB.landAuswählen("Germany");
		
		webShopAGB.aGBAkzeptiert();
		
		webShopAGB.weiterAnklicken();
		
		String danke = driver.findElement(By.className("wrapperTwo")).getText();
		//Assert
		
		
		// preis1 == 760.58
		assertEquals(preis1, "760.58");
		
		// promoinfo == aktiviert
		assertTrue(promoInfo.contains("aktiviert"));
		
		// preis2 == 684
		assertEquals(preis2, "684");
		
		assertTrue(danke.contains("Vielen Dank"));
		
	}

}

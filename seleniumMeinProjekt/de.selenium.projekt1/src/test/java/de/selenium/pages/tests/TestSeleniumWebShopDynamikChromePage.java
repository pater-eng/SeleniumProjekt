package de.selenium.pages.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.Duration;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;

import de.selenium.konfiguration.Config;
import de.selenium.konfiguration.DriverHelper;
import de.selenium.pages.SeleniumAppilcationPage;
import de.selenium.pages.SeleniumHomePage;
import de.selenium.pages.SeleniumLoginPage;
import de.selenium.pages.SeleniumWebShopAGB;
import de.selenium.pages.SeleniumWebShopKasse;
import de.selenium.pages.SeleniumWebShopProdukte;

public class TestSeleniumWebShopDynamikChromePage {
	WebDriver driver;
	

	String testName;
	String username;
	String password;
	String browsername;
	String produktSuche;
	String produktName;
	int[] anzahlProduktAuswaehlen;
	String promoCodeEingeben;
	String landAuswaehlen;
	String ArtikelPreis1;
	String ArtikelPreis2;
	String promoInfo;
	String MessageDanke;
	
	
	// 
	String produktInWarenKorbLegen;
	String zurKasseAnklicken;
	String promoCodeAktivierenAnklicken;
	String promoInfoAuslesen;
	String preisAuslesen;
	String bestellungAnklicken;
	String aGBAkzeptiert;
	String weiterAnklicken;
	
	public TestSeleniumWebShopDynamikChromePage(WebDriver driver, String testName, String username, String password,
			String browsername, String produktSuche, String produktName, int[] anzahlProduktAuswaehlen,
			String promoCodeEingeben, String landAuswaehlen, String artikelPreis1, String artikelPreis2,
			String promoInfo, String messageDanke) {
		super();
		this.driver = driver;
		this.testName = testName;
		this.username = username;
		this.password = password;
		this.browsername = browsername;
		this.produktSuche = produktSuche;
		this.produktName = produktName;
		this.anzahlProduktAuswaehlen = anzahlProduktAuswaehlen;
		this.promoCodeEingeben = promoCodeEingeben;
		this.landAuswaehlen = landAuswaehlen;
		ArtikelPreis1 = artikelPreis1;
		ArtikelPreis2 = artikelPreis2;
		this.promoInfo = promoInfo;
		MessageDanke = messageDanke;
	}

	
	@Before
	public void setUp() throws Exception {

		System.out.println("initialisiere Webdriver.");
		driver = DriverHelper.getDriver(browsername); 
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		// Browser auf Maximum vergrößer
		driver.manage().window().maximize();
		driver.get(Config.getBaseUrl());
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
		appPage.seleniumLinkWebshopTestseiteAnklicken();

		SeleniumWebShopProdukte webShopProdukte = new SeleniumWebShopProdukte(driver);
		SeleniumWebShopKasse webShopKasse = new SeleniumWebShopKasse(driver);
		SeleniumWebShopAGB webShopAGB = new SeleniumWebShopAGB(driver);

		// Act
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
		// Assert

		assertEquals(preis1,"760.58");
		assertTrue(promoInfo.contains("aktiviert"));
		assertEquals(preis2,"684");

		assertTrue(danke.contains("Vielen Dank"));

	}

}

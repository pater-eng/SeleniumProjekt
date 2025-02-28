package de.codingsolo.seleniumkurs.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.openqa.selenium.WebDriver;

import de.codingsolo.seleniumkurs.configuration.ApachePOI;
import de.codingsolo.seleniumkurs.configuration.Config;
import de.codingsolo.seleniumkurs.configuration.DriverHelper;
import de.codingsolo.seleniumkurs.pages.SeleniumKursHomePage;
import de.codingsolo.seleniumkurs.pages.SeleniumKursLoginPage;
import de.codingsolo.seleniumkurs.pages.SeleniumKursTestApplikationenPage;
import de.codingsolo.seleniumkurs.pages.SeleniumKursTestForm3Page;

@RunWith(Parameterized.class)
public class TestForm3ParameterizedSeleniumKursFireFox {

	WebDriver driver;

	String browsername;
	String username;
	String password;
	String bezeichnung;
	String kennung;
	String anschrift;
	String strasse;
	String telefon;
	String plz;
	String ort;
	String auswahl1;
	String name;
	String vorname;
	String geburtsdatum;
	String strassePerson;
	String telefonPerson;
	String plzPerson;
	String ortPerson;
	String assert1;
	String assert2;

	public TestForm3ParameterizedSeleniumKursFireFox(String testName, String browsername, String username,
			String password, String bezeichnung, String kennung, String anschrift, String strasse, String telefon,
			String plz, String ort, String auswahl1, String name, String vorname, String geburtsdatum,
			String strassePerson, String telefonPerson, String plzPerson, String ortPerson, String assert1,
			String assert2) {
		this.browsername = browsername;
		this.username = username;
		this.password = password;
		this.bezeichnung = bezeichnung;
		this.kennung = kennung;
		this.anschrift = anschrift;
		this.strasse = strasse;
		this.telefon = telefon;
		this.plz = plz;
		this.ort = ort;
		this.auswahl1 = auswahl1;
		this.name = name;
		this.vorname = vorname;
		this.geburtsdatum = geburtsdatum;
		this.strassePerson = strassePerson;
		this.telefonPerson = telefonPerson;
		this.plzPerson = plzPerson;
		this.ortPerson = ortPerson;
		this.assert1 = assert1;
		this.assert2 = assert2;
	}

	@Before
	public void setUp() throws Exception {
		System.out.println("Initialisiere Webdriver");
		driver = DriverHelper.getDriver(browsername);
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(Config.getBasURL());
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("Test abgeschlossen- ich räume");
		driver.close();
	}

	@Test
	public void testForm3() {
		System.out.println("Starte TestForm3 Testseite");

		// Arrange

		// Login
		SeleniumKursLoginPage loginPage = new SeleniumKursLoginPage(driver);
		loginPage.zugangsdatenEingeben(username, password);
		loginPage.loginButtonAnklicken();

		// Navigation zum Formular
		SeleniumKursHomePage homePage = new SeleniumKursHomePage(driver);
		homePage.menuAusklappen();
		homePage.seleniumTestAppLinkAnklicken();
		SeleniumKursTestApplikationenPage testAppPage = new SeleniumKursTestApplikationenPage(driver);
		testAppPage.testForm3Anklicken();

		SeleniumKursTestForm3Page testform3Page = new SeleniumKursTestForm3Page(driver);

		// Act
		testform3Page.versicherungsBezeichnungEingeben(bezeichnung);
		testform3Page.versicherungsKennungEingeben(kennung);
		testform3Page.versicherungsAnschriftEingeben(anschrift);
		testform3Page.versicherungsStrasseEingeben(strasse);
		testform3Page.versicherungsTelefonNummerEingeben(telefon);
		testform3Page.versicherungsPostleitZahlEingeben(plz);
		testform3Page.versicherungsOrtEingeben(ort);

		testform3Page.auswahl1Eingeben(auswahl1);

		testform3Page.personenNamenEingeben(name);
		testform3Page.personenVornameEingeben(vorname);
		testform3Page.personenGeburtsDatumEingeben(geburtsdatum);
		testform3Page.personenStrasseEingeben(strassePerson);
		testform3Page.personenTelefonEingeben(telefonPerson);
		testform3Page.personenPostleitzahlEingeben(plzPerson);
		testform3Page.personenOrtEingeben(ortPerson);

		testform3Page.speichernAnklicken();
		// Assert

		assertTrue(testform3Page.status1TextAuslesen().contains(assert1));
		assertEquals(testform3Page.status2TextAuslesen(), assert2);

	}

	@Parameters(name = "{0}")
	public static Collection<Object[]> provideTestData() throws Exception {

		Collection<Object[]> collection;

//		Object[][] daten = {
//				{ "Test TestForm3 Testfall 1 FireFox", "firefox", "selenium102", "codingsolo", "Fragebogen 42",
//						"9288282", "AOK Hamburg", "2131233", "Landwehr 23", "22119", "Hamburg", "Selbststaendiger",
//						"Blomberg", "Hans", "02.04.1967", "12312312", "Reeperbarhn 222", "20537", "Hamburg", "Blomberg",
//						"Fragebogen 42" },
//				{ "Test TestForm3 Testfall 2 FireFox", "chrome", "selenium102", "codingsolo", "Fragebogen 42",
//						"9288282", "AOK Hamburg", "2131233", "Landwehr 23", "22119", "Hamburg", "Selbststaendiger",
//						"Blomberg", "Hans", "02.04.1967", "12312312", "Reeperbarhn 222", "20537", "Hamburg", "Blomberg",
//						"Fragebogen 42" } };

		//List<Object[]> listObjects = Arrays.asList(daten);
		ApachePOI excelReader = new ApachePOI();
		
		List<Object[]> listObjects = excelReader.getExcelData("./TestCaseTestform3.xlsx");
		collection = new ArrayList<Object[]>(listObjects);

		return collection;
	}

}

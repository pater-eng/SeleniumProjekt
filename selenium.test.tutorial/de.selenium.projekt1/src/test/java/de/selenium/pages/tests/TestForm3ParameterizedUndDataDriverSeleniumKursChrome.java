package de.selenium.pages.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.openqa.selenium.WebDriver;

import de.selenium.auslesen.config.EineExcelFileAuslesenApachePOI;
import de.selenium.auslesen.config.MehrereExcelFileAuslesenMitApachePOI;
import de.selenium.konfiguration.Config;
import de.selenium.konfiguration.DriverHelper;
import de.selenium.pages.SeleniumAppilcationPage;
import de.selenium.pages.SeleniumHomePage;
import de.selenium.pages.SeleniumLoginPage;
import de.selenium.pages.SeleniumTestform3DataDrivenPage;


@RunWith(Parameterized.class)
public class TestForm3ParameterizedUndDataDriverSeleniumKursChrome {

	WebDriver driver;

	String testName;
	String username;
	String password;
	String browsername;
	String bezeichnung;
	String vorname;
	String name;
	String kennung;
	String anschrift;
	String telefon;
	String str;
	String plz ;
	String ort;
	String select_auswahl1;
	String geburt;
	String telefonv;
	String strv;
	String plzv;
	String ortv;
	String btn_speicher;
	String text_status;
	String text_erstesElement;
	String assert1;
	String assert2;

	
	
	public TestForm3ParameterizedUndDataDriverSeleniumKursChrome(String testName, String browsername, String username, String password, 
			String bezeichnung, String kennung, String anschrift, String telefon, String str, String plz, String ort,
			String select_auswahl1, String name, String vorname, String geburt, String telefonv, String strv, 
			String plzv, String ortv, String assert1, String assert2 ) {
		super();
		this.browsername = browsername;
		this.bezeichnung = bezeichnung;
		this.vorname = vorname;
		this.name = name;
		this.kennung = kennung;
		this.anschrift = anschrift;
		this.telefon = telefon;
		this.str = str;
		this.plz = plz;
		this.ort = ort;
		this.geburt = geburt;
		this.telefonv = telefonv;
		this.strv = strv;
		this.plzv = plzv;
		this.ortv = ortv;
		this.text_erstesElement = select_auswahl1;
		this.assert1 = assert1;
		this.assert2 = assert2;
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
		System.out.println("Test abgeschlossen- ich räume");
		//driver.close();
	}

	@Test
	public void testForm3() {
		System.out.println("Starte TestForm1 Testseite");

		// Arrange

		// Login
		SeleniumLoginPage loginPage = new SeleniumLoginPage(driver);
		loginPage.zugangsdatenEingeben("selenium42","R5vxI0j60");
		loginPage.loginButtonAnklicken();

		// Navigation zum Formular
		SeleniumHomePage homePage = new SeleniumHomePage(driver);
		homePage.menuAusklappen();
		homePage.seleniumTestAppLinkAnklicken();

		SeleniumAppilcationPage appPage = new SeleniumAppilcationPage(driver);
		appPage.testform3DataDrivenAnklicken();

		// Starte Formular
		// Act
		SeleniumTestform3DataDrivenPage testForm3Page = new SeleniumTestform3DataDrivenPage(driver);
		testForm3Page.bezeichnungEingeben(bezeichnung);
		testForm3Page.kennunggEingeben(kennung);
		testForm3Page.anschriftEingeben(anschrift);
		testForm3Page.strgEingeben(str);
		testForm3Page.telefonEingeben(telefon);
		testForm3Page.plzEingeben(plz);
		testForm3Page.ortEingeben(ort);
		
		//testForm3Page.select_auswahl1Eingeben(select_auswahl1);
		
		testForm3Page.namegEingeben(name);
		testForm3Page.vornameEingeben(vorname);
		testForm3Page.geburtEingeben(geburt);
		testForm3Page.strVersicherterEingeben(strv);
		testForm3Page.telefonVersicherterEingeben(telefonv);
		testForm3Page.plzVersichterEingeben(plzv);
		testForm3Page.ortVersicherterEingeben(ortv);
		
		testForm3Page.speicherAnklicken();
	
		// Assert

		String erfolgsMeldung = testForm3Page.statusAuslesen();
		System.out.println("Status: "+erfolgsMeldung);
		assertTrue(erfolgsMeldung.contains(assert1));

		String erstesElement = testForm3Page.erstesElementAuslesen();
		assertEquals(erstesElement, assert2);
	}

	@Parameters(name = "{0}")
	public static Collection<Object[]> provideTestData() throws Exception {

		Collection<Object[]> collection;

		// Daten werden hier direkt gesetzt
		/*Object[][] daten = {
				{ "Test TestForm3 Testfall 1 Chrome", "chrome", "selenium102", "codingsolo", "Fragenbogen 42", "98545",
					"AOK Witten", "26568565", "ObenStr 54", "45989", "Witten", "Selbstaendiger", "Blomber", "Paul", "04.05.1988",
					"2656555654","Reeperbarhn 122","20578", "Hamburg", "Blomber", "Fragenbogen 42"},
				{ "Test TestForm3 Testfall 2 Chrome", "chrome", "selenium102", "codingsolo", "Kotoyo 01", "98545",
						"AOK Witten", "26568565", "ObenStr 54", "45989", "Witten", "Selbstaendiger", "Ezaba", "Paul", "04.05.1988",
						"2656555654","Reeperbarhn 122","20578", "Hamburg", "Ezaba", "Kotoyo 01"} 
				
			 };*/

		// Daten in einer Excel-Datei auslesen 
		//List<Object[]> listObjects = Arrays.asList(daten);
		/*ApachePOI excelReader = new ApachePOI();
		List<Object[]> listObjects = excelReader.getExcelData("C:\\Users\\engoulou\\Selenium\\Daten\\datadriven\\TestCaseTestform3.xlsx");
		collection = new ArrayList<Object[]>(listObjects);*/
		
		// Daten aus unterschiedlichen  Excel Dateien auslesen
		MehrereExcelFileAuslesenMitApachePOI excelReader = new MehrereExcelFileAuslesenMitApachePOI();
        List<Object[]> data = excelReader.getExcelDataFromDirectory("C:\\Users\\engoulou\\Selenium\\Daten\\datadriven");
      	collection = new ArrayList<Object[]>(data);
		return collection; 
	}


}

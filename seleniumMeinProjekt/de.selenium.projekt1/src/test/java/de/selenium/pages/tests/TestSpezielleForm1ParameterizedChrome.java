package de.selenium.pages.tests;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.openqa.selenium.WebDriver;

import de.selenium.auslesen.config.AuslesenMehrereCSVFile;
import de.selenium.konfiguration.Config;
import de.selenium.konfiguration.DriverHelper;
import de.selenium.pages.SeleniumAppilcationPage;
import de.selenium.pages.SeleniumHomePage;
import de.selenium.pages.SeleniumLoginPage;
import de.selenium.pages.SeleniumTestForm1Page;

@RunWith(Parameterized.class)
public class TestSpezielleForm1ParameterizedChrome {

    WebDriver driver;

    String browsername;
    String username;
    String password;
    String betreff;
    String name;
    String kursTitel;
    int[] firmenBox1;
    int[] firmenBox2;
    String assert1;
    String assert2;

    public TestSpezielleForm1ParameterizedChrome(String testName, String browsername, String username, String password,
            String betreff, String name, String kursTitel, int[] firmenBox1, int[] firmenBox2, String assert1, String assert2) {

        this.browsername = browsername;
        this.username = username;
        this.password = password;
        this.betreff = betreff;
        this.name = name;
        this.kursTitel = kursTitel;
        this.firmenBox1 = firmenBox1;
        this.firmenBox2 = firmenBox2;
        this.assert1 = assert1;
        this.assert2 = assert2;
    }

    @Before
    public void setUp() throws Exception {
        System.out.println("initialisiere Webdriver.");
        driver = DriverHelper.getDriver(browsername);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
        driver.get(Config.getBaseUrl());
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("Test abgeschlossen - ich räume auf");
        driver.close();
    }

    @Test
    public void testForm1() {
        System.out.println("Starte TestForm1 Testseite");

        // Login
        SeleniumLoginPage loginPage = new SeleniumLoginPage(driver);
        loginPage.zugangsdatenEingeben("selenium42", "R5vxI0j60");
        loginPage.loginButtonAnklicken();

        // Navigation zum Formular
        SeleniumHomePage homePage = new SeleniumHomePage(driver);
        homePage.menuAusklappen();
        homePage.seleniumTestAppLinkAnklicken();

        SeleniumAppilcationPage appPage = new SeleniumAppilcationPage(driver);
        appPage.seleniumTestFrom1LinkAnklicken();

        // Formular ausfüllen
        SeleniumTestForm1Page testForm1Page = new SeleniumTestForm1Page(driver);
        testForm1Page.betreffEingeben(betreff);
        testForm1Page.nameEingeaben(name);
        testForm1Page.kursAuswaehlen(kursTitel);
        testForm1Page.firmaInBox1Auswaehlen(firmenBox1);
        testForm1Page.firmenUerbernehmen();
        testForm1Page.firmaInBox2Auswaehlen(firmenBox2);
        testForm1Page.ausgewählteFirmenNachObenVerschieben();

        // Formular speichern und Ergebnisse prüfen
        testForm1Page.formularSpeichern();
        String erfolgsMeldung = testForm1Page.statusMeldungAuslesen();
        System.out.println("Meldung: "+erfolgsMeldung);
        assertTrue(erfolgsMeldung.contains(assert1));

        String erstesElement = testForm1Page.erstesElementDerListeAuslesen();
        System.out.println("Erstes Element: "+erstesElement);
        assertEquals(erstesElement, assert2);
        
    }
 

	// ---------------------------
    // Parameterized Test-Daten
    // ---------------------------
    @Parameters(name = "{0}")
    public static Collection<Object[]> provideTestData() throws Exception {
        String folderPath = "C:/Users/engoulou/Selenium/Daten/daten_csv";
        List<Object[]> allTestData = new ArrayList<>();

        // Alle CSV-Dateien im Verzeichnis einlesen
        Files.list(Paths.get(folderPath))
             .filter(path -> path.toString().endsWith(".csv"))
             .forEach(path -> {
                 try {
                     List<Object[]> fileData = AuslesenMehrereCSVFile.readTestDataFromCsv(path.toString());
                     allTestData.addAll(fileData);
                 } catch (IOException e) {
                     e.printStackTrace();
                 }
             });
        return allTestData;
    }

}

package de.codingsolo.seleniumkurs.test;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import de.codingsolo.seleniumkurs.pages.SeleniumKursLoginPage;

public class TestLoginFehlschlagSeleniumKursRemote {

	WebDriver driver;

	@Before
	public void setUp() throws Exception {
		System.out.println("Initialisiere Webdriver");

		URL linkHub = new URL("http://localhost:4444/wd/hub");
		
		driver = new RemoteWebDriver(linkHub, DesiredCapabilities.chrome());
		
		driver.get("https://seleniumkurs.codingsolo.de");
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("Test abgeschlossen- ich räume");
		driver.quit();
	}

	@Test
	public void testLogin(){
		System.out.println("Starte Test Login mit Fehlschlag");

		// Arrange

		SeleniumKursLoginPage loginPage = new SeleniumKursLoginPage(driver);
		loginPage.zugangsdatenEingeben("Benutzer", "test");

		// Act
		loginPage.loginButtonAnklicken();

		// Assert

		String fehlerMeldung = loginPage.statusMeldungAuslesen();
		System.out.println(fehlerMeldung);

		assertTrue(fehlerMeldung.contains("Anmeldung fehlgeschlagen"));
	}

}

package de.codingsolo.seleniumkurs.test;

import static org.junit.Assert.*;

import java.net.MalformedURLException;
import java.net.URL;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import de.codingsolo.seleniumkurs.pages.SeleniumKursHomePage;
import de.codingsolo.seleniumkurs.pages.SeleniumKursLoginPage;
import de.codingsolo.seleniumkurs.pages.SeleniumKursTestApplikationenPage;
import de.codingsolo.seleniumkurs.pages.SeleniumKursTestForm1Page;

public class TestNavigationSeleniumKursRemoteParallel {
	
	WebDriver driver1;
	WebDriver driver2;

	@Before
	public void setUp() throws Exception {
		System.out.println("Initialisiere Webdriver");
		//System.setProperty("webdriver.gecko.driver", "./drivers/geckodriver.exe");
		//driver = new FirefoxDriver();
		URL remoteWebDriver = new URL("http://192.168.178.60:4444/wd/hub");
		
		driver1 = new RemoteWebDriver(remoteWebDriver, DesiredCapabilities.firefox());
		driver2 = new RemoteWebDriver(remoteWebDriver, DesiredCapabilities.firefox());

		driver1.manage().window().maximize();
		driver1.get("https://seleniumkurs.codingsolo.de");
		driver2.manage().window().maximize();
		driver2.get("https://seleniumkurs.codingsolo.de");
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("Test abgeschlossen- ich räume");
		driver1.close();
		driver2.close();
	}

	@Test
	public void testNavigationDriver1() {
		System.out.println("Starte Test Navigation zum TestForm1");
		
		//Arrange
		
		SeleniumKursLoginPage loginPage = new SeleniumKursLoginPage(driver1);
		loginPage.zugangsdatenEingeben("selenium101", "codingsolo");
		loginPage.loginButtonAnklicken();
		
		//Act

		SeleniumKursHomePage homePage = new SeleniumKursHomePage(driver1);
		homePage.menuAusklappen();
		homePage.seleniumTestAppLinkAnklicken();

		SeleniumKursTestApplikationenPage testAppPage = new SeleniumKursTestApplikationenPage(driver1);
		testAppPage.testForm1anklicken();

		//Assert
		
		SeleniumKursTestForm1Page testForm1Page = new SeleniumKursTestForm1Page(driver1);
		
		String erfolgsMeldung = testForm1Page.ueberschriftAuslesen();
		assertEquals(erfolgsMeldung, "Selenium Test Form1");
	}
	
	@Test
	public void testNavigationDriver2() {
		System.out.println("Starte Test Navigation zum TestForm1");
		
		//Arrange
		
		SeleniumKursLoginPage loginPage = new SeleniumKursLoginPage(driver2);
		loginPage.zugangsdatenEingeben("selenium101", "codingsolo");
		loginPage.loginButtonAnklicken();
		
		//Act

		SeleniumKursHomePage homePage = new SeleniumKursHomePage(driver2);
		homePage.menuAusklappen();
		homePage.seleniumTestAppLinkAnklicken();

		SeleniumKursTestApplikationenPage testAppPage = new SeleniumKursTestApplikationenPage(driver2);
		testAppPage.testForm1anklicken();

		//Assert
		
		SeleniumKursTestForm1Page testForm1Page = new SeleniumKursTestForm1Page(driver2);
		
		String erfolgsMeldung = testForm1Page.ueberschriftAuslesen();
		assertEquals(erfolgsMeldung, "Selenium Test Form1");
	}

}

package de.codingsolo.seleniumkurs.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import de.codingsolo.seleniumkurs.pages.SeleniumKursDragDropPage;
import de.codingsolo.seleniumkurs.pages.SeleniumKursHomePage;
import de.codingsolo.seleniumkurs.pages.SeleniumKursLoginPage;
import de.codingsolo.seleniumkurs.pages.SeleniumKursTestApplikationenPage;

public class TestDragDropSeleniumKursFireFox {

	WebDriver driver;

	@Before
	public void setUp() throws Exception {
		System.out.println("Initialisiere Webdriver");
		System.setProperty("webdriver.gecko.driver", "./drivers/geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("https://seleniumkurs.codingsolo.de");
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("Test abgeschlossen- ich räume");
		// driver.close();
	}

	@Test
	public void testDragDrop() {
		System.out.println("Starte Test Drag and Drop Beispiel");

		// Arrange

		// Login
		SeleniumKursLoginPage loginPage = new SeleniumKursLoginPage(driver);
		loginPage.zugangsdatenEingeben("selenium101", "codingsolo");
		loginPage.loginButtonAnklicken();

		// Navigation zum Formular

		SeleniumKursHomePage homePage = new SeleniumKursHomePage(driver);
		homePage.menuAusklappen();
		homePage.seleniumTestAppLinkAnklicken();

		SeleniumKursTestApplikationenPage testAppPage = new SeleniumKursTestApplikationenPage(driver);
		testAppPage.dragAndDropTestAnklicken();

		// Starte Drag and Drop
		SeleniumKursDragDropPage dragDropPage = new SeleniumKursDragDropPage(driver);

		// Act

		dragDropPage.moveWhiteLogoToBox();
		dragDropPage.moveBlueLogoToBox();

		dragDropPage.moveRedLogoToPoint(250, 0);

		dragDropPage.moveGreenLogoToBoxManuell();

		dragDropPage.moveAllLogosToBox();

		// Assert

		String erfolgsMeldung = dragDropPage.printStatusMessage();
		assertTrue(erfolgsMeldung.contains("coding-logo"));

	}

}

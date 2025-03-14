package de.selenium.pages.tests;


import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import de.selenium.pages.SeleniumLoginPageMitAnnotation;



public class TestLoginSeleniumChromeMitAnnotaton {
	
	WebDriver driver;

	@Before
	public void setUp() throws Exception {
		System.out.println("initialisiere Webdriver.");
		System.setProperty("webdriver.chrome.driver", 
				"./drivers/chromedriver.exe");
		driver = new ChromeDriver();
		// Browser auf Maximum vergrößer
		driver.manage().window().maximize();
		driver.get("https://seleniumkurs.codingsolo.de");
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("Test abgeschlossen- ich räume");
		//driver.close();
	}

	@Test
	public void testLogin() {
		System.out.println("Starte Test Login mit Fehlschlag");
		
		//Arrange
		
		SeleniumLoginPageMitAnnotation loginPage = new SeleniumLoginPageMitAnnotation(driver);
		loginPage.zugangsdatenEingeben("selenium101", "codingsolo");
	    

		//Act
		loginPage.loginButtonAnklicken();

		//Assert
		
		String erfolgsMeldung = loginPage.statusMeldungAuslesen();
		assertTrue(erfolgsMeldung.contains("Willkommen"));
	}

}

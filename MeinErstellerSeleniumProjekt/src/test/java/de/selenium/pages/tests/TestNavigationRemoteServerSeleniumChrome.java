package de.selenium.pages.tests;


import static org.junit.Assert.assertEquals;

import java.net.URL;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import de.selenium.pages.SeleniumAppilcationPage;
import de.selenium.pages.SeleniumHomePage;
import de.selenium.pages.SeleniumLoginPage;

public class TestNavigationRemoteServerSeleniumChrome {
	
	WebDriver driver;

	@Before
	public void setUp() throws Exception {
		System.out.println("initialisiere Webdriver.");
		System.setProperty("webdriver.chrome.driver", 
				"./drivers/chromedriver.exe");
		 // URL des RemoteWebDriver-Servers
		// Befeh um den Server über den Console zu starten:  .\startSeleniumServer.bat
        URL remoteUrl = new URL("http://localhost:4444/wd/hub");

        // ChromeOptions anstelle von DesiredCapabilities verwenden
        ChromeOptions options = new ChromeOptions();
        options.setCapability("browserName", "chrome");

        // RemoteWebDriver mit den angegebenen Optionen initialisieren
        driver = new RemoteWebDriver(remoteUrl, options);

		//driver = new ChromeDriver();
		// Browser auf Maximum vergrößer
		driver.manage().window().maximize();
		driver.get("https://seleniumkurs.codingsolo.de");
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("Test abgeschlossen- ich r�ume");
		//driver.close();
	}

	@Test
	public void testLogin() {
		System.out.println("Starte Test Login mit Erfolg");
		
		//Arrange
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
		
		//Assert
		String erfolgsMeldung = driver.findElement(By.tagName("h1")).getText();
		assertEquals(erfolgsMeldung, "Selenium Test Form1");
	}

}

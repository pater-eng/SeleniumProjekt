package de.selenium.pages.tests;

import java.time.Duration;
import java.util.function.Function;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import de.selenium.pages.SeleniumAppilcationPage;
import de.selenium.pages.SeleniumHomePage;
import de.selenium.pages.SeleniumLoginPage;


public class TestFluentWaitSeleniumKursChrome {

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
		// driver.close();
	}

	@Test
	public void testFluentWait() {
		System.out.println("Starte Test für den Fluent Wait");

		// Arrange

		SeleniumLoginPage loginPage = new SeleniumLoginPage(driver);
		loginPage.zugangsdatenEingeben("selenium42","R5vxI0j60");
		loginPage.loginButtonAnklicken();


		// Navigation zum Formular
		SeleniumHomePage homePage = new SeleniumHomePage(driver);
		homePage.menuAusklappen();
		homePage.seleniumTestAppLinkAnklicken();

		SeleniumAppilcationPage appPage = new SeleniumAppilcationPage(driver);
		appPage.fluentWaitTestseiteAnklicken();

		// Act
		
		driver.findElement(By.cssSelector(".btn-primary")).click();
		
//		String status = driver.findElement(By.cssSelector("#status")).getText();
//		System.out.println(status);
		
//		WebDriverWait wait = new WebDriverWait(driver, 15);
//		String status = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#status"))).getText();
//		System.out.println(status);
		// PollingEvery: ist die intervalle zu prüfen, ob das Element schon vorhanden ist.
		// ignoring(): ignoriert wenn das Element noch nicht gefunden wurde. 
		// // FluentWait mit einer Timeout von 15 Sekunden und einer Abfrage alle 5 Sekunden
		Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(15)) // Maximale Wartezeit: 15 Sekunden
				.pollingEvery(Duration.ofSeconds(5))  // Alle 5 Sekunden wird überprüft, ob die Bedingung erfüllt ist
				.ignoring(NoSuchElementException.class); // Wenn das Element nicht gefunden wird, wird die Ausnahme ignoriert
		
		// Erwartungstext ausgeliefert bekommen
		// Warten, bis das Element mit dem CSS-Selektor '#status' sichtbar ist, und den Text ausgeben
	
		fluentWait.until(new Function<WebDriver, WebElement>(){
			public WebElement apply(WebDriver driver) {
				WebElement status = driver.findElement(By.cssSelector("#status"));
				System.out.println(status.getText());
				
				return null;
			}
		}); 

		// Assert

		
		
		
	}

}


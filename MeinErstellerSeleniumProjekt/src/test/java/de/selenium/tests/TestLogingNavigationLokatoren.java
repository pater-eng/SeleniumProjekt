package de.selenium.tests;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.Duration;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestLogingNavigationLokatoren {
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
		System.out.println("Testfall abgeschlossen. -Aufräumen");	
		//driver.close();
	}

	@Test
	public void test() {
		System.out.println("Starte Test Login mit Erfog");	
		// Arrange
		// Anmeldung ist erfolgreich
		WebElement inputUsername=driver.findElement(By.cssSelector("input.form-control[type='text']"));
		inputUsername.sendKeys("selenium42");
		WebElement inputPassword = driver.findElement(By.cssSelector("input.form-control[type='password']"));
		inputPassword.sendKeys("R5vxI0j60");
		
		// Hier ist RelativPath immer besser
		WebElement btnLogin = driver.findElement(By.cssSelector("input.btn-primary[type='submit']"));
		btnLogin.click();
		
		// Act
		// Link 1 wird geklickt
		WebElement linkMenu = driver.findElement(By.id("portaltab-burger-menu"));
		linkMenu.click();	
		// Danach wird Link 2 geklickt
		// Verwende einen expliziten Wait (z.B. WebDriverWait), um darauf zu warten, dass das Element sichtbar und interaktiv ist.
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement link = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Selenium Testapplikationen")));
		link.click();
		
		// Zum Schluss wird Link 3 geklickt
		WebElement linkSeleniumTestForm1 = driver.findElement(By.linkText("Selenium Test Form1"));
		linkSeleniumTestForm1.click();
	
		// Assert
		String erfolgMeldung = driver.findElement(By.tagName("h1")).getText();
		//Vergleich 
		assertEquals(erfolgMeldung, "Selenium Test Form1");
	}

}

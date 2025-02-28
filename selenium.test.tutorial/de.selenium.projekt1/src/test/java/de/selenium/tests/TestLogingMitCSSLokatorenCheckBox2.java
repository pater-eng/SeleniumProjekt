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
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestLogingMitCSSLokatorenCheckBox2 {
	WebDriver driver;
	
	@Before
	public void setUp() throws Exception {
		System.out.println("initialisiere Webdriver.");
		System.setProperty("webdriver.chrome.driver", 
				"./drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://seleniumkurs.codingsolo.de"); 
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("Testfall abgeschlossen. -Aufräumen");	
		//driver.close();
	}

	@Test
	public void testCheckBoxDoubleClick() {
		System.out.println("Starte Test Login mit Erfog");	
		// Arrange
		WebElement inputUsername = driver.findElement(By.cssSelector("input.form-control[type='text']"));
		inputUsername.sendKeys("selenium42");
		WebElement inputPassword = driver.findElement(By.cssSelector("input.form-control[type='password']"));
		inputPassword.sendKeys("R5vxI0j60");
		// Hier ist RelativPath immer besser
		WebElement inputButtonLogin = driver.findElement(By.cssSelector("input.btn-primary[type='submit']"));
		inputButtonLogin.click();
		
		// Navigation: Link 1 wird geklickt
		WebElement navLink1 = driver.findElement(By.id("portaltab-burger-menu"));
		navLink1.click();	
		// Navigation: Danach wird Link 2 geklickt
		// Verwende einen expliziten Wait (z.B. WebDriverWait), um darauf zu warten, dass das Element sichtbar und interaktiv ist.
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement navLink2 = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Selenium Testapplikationen")));
		navLink2.click();
		
		//
		WebElement linkWebElement = driver.findElement(By.linkText("Web Elemente"));
		linkWebElement.click();
		
		WebElement checkBox1 = driver.findElement(By.id("checkBoxOption1"));
		WebElement checkBox2 = driver.findElement(By.id("checkBoxOption2"));
		WebElement checkBox3 = driver.findElement(By.id("checkBoxOption3"));
		
		// Initialisieren der Actions-Klasse
		Actions actions = new Actions(driver);
			
		// Act
		
		// Ausführen des Doppelklicks auf das WebElement
		actions.doubleClick(checkBox1).perform();
			
		checkBox2.click();
		checkBox3.click();
		
		
		// Assert
		assertEquals(checkBox1.isSelected(), false);
		assertEquals(checkBox2.isSelected(), true);
		assertEquals(checkBox3.isSelected(), true);
		
	}

}

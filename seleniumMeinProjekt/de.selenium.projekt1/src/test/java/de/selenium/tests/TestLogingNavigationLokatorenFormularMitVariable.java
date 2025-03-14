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
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestLogingNavigationLokatorenFormularMitVariable {
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
		WebElement inputUsername = driver.findElement(By.cssSelector("input.form-control[type='text']"));
		inputUsername.sendKeys("selenium42");
		WebElement inputPassword = driver.findElement(By.cssSelector("input.form-control[type='password']"));
		inputPassword.sendKeys("R5vxI0j60");
		// Hier ist ein AbsolutePath
		//driver.findElement(By.xpath("/html/body/section/div[2]/div/div[2]/div/div[1]/form/input[3]")).click();
		// Hier ist RelativPath immer besser
		WebElement inputButtonLogin = driver.findElement(By.cssSelector("input.btn-primary[type='submit']"));
		inputButtonLogin.click();
		
		
		
		
		
		// Act
		// Navigation: Link 1 wird geklickt
		WebElement navLink1 = driver.findElement(By.id("portaltab-burger-menu"));
		navLink1.click();	
		// Navigation: Danach wird Link 2 geklickt
		// Verwende einen expliziten Wait (z.B. WebDriverWait), um darauf zu warten, dass das Element sichtbar und interaktiv ist.
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement navLink2 = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Selenium Testapplikationen")));
		navLink2.click();
		
		// Navigation: Weiter wird Link 3 geklickt
		WebElement navLink3 = driver.findElement(By.linkText("Selenium Test Form1"));
		navLink3.click();
	
		// Navigation:  TextFeld
		WebElement formularElement1 = driver.findElement(By.id("form-widgets-betreff"));
		formularElement1.sendKeys("Automatischer Test");
		WebElement formularElement2 = driver.findElement(By.id("form-widgets-name"));
		formularElement2.sendKeys("Pater");
		// Navigation: Erster SelectBox
		Select selectAuswahl1 = new Select(driver.findElement(By.id("form-widgets-auswahl1")));
		selectAuswahl1.selectByVisibleText("Selenium Automatisierung mit Dieter");
		
		// Navigation: Zweiter SelectElement oder Multiselect
		Select selectAuswahl2 = new Select(driver.findElement(By.id("form-widgets-auswahl2-from")));
		selectAuswahl2.selectByIndex(0); // Alfreds Futterkiste
		selectAuswahl2.selectByIndex(2); // Ernst Handel
		selectAuswahl2.selectByIndex(5); // Sony
		selectAuswahl2.selectByIndex(6); // Volkswagen
		
		//Navigation: Mit Click auf Button Element nach Rechts schieben. 
		WebElement navButtonElementNachRechtSchieben = driver.findElement(By.name("from2toButton"));
		navButtonElementNachRechtSchieben.click();
		
				
		// Navigation: Dritter SelectElement oder Multiselect. Hier wollen wir die Element 2 als Erstes Element haben.
		Select selectAuswahl3 = new Select(driver.findElement(By.id("form-widgets-auswahl2-to")));
		//selectAuswahl3.selectByIndex(6);
		selectAuswahl3.selectByIndex(2); // Ernst Handel
		//selectAuswahl3.selectByIndex(5);
		//selectAuswahl3.selectByIndex(0);
		// Nach dem Click des Buttons wird die Reihefolge sortiert, wie wir definiert haben.
		WebElement navButtonIndex2AlsErstesElement = driver.findElement(By.name("upButton"));
		navButtonIndex2AlsErstesElement.click();
		
		
		
		
		
		// Assert
		WebElement buttonSpeichern= driver.findElement(By.name("form.buttons.speichern"));
		buttonSpeichern.click();
		 //String erfolgMeldung = driver.findElement(By.tagName("h1")).getText(); // 
		 String erfolgMeldung = driver.findElement(By.id("message")).getText();
		//Vergleich 
		assertEquals(erfolgMeldung, "Hallo Pater, Danke das du den Kurs Selenium Automatisierung mit Dieter besuchst!");
		assertTrue(erfolgMeldung.contains("Hallo Pater"));
		
		// Prüfen wir auf Liste, ob Element 2 als Erstes ist
		//String erstesElement = driver.findElement(By.cssSelector("ul#companies > li:first-of-type")).getText();
		String erstesElement = driver.findElement(By.xpath("//ul[@id='companies']/li[1]")).getText();
		assertEquals(erstesElement, "Ernst Handel");
	}

}

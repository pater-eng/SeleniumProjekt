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

public class TestLogingMitXPathLokatorenRadioButtons {
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
	public void testRadioButton() {
		System.out.println("Starte Test Login mit Erfog");	
		// Arrange  // //input[@value='Anmelden']
		WebElement inputUsername = driver.findElement(By.xpath("//input[@name='__ac_name']"));
		inputUsername.sendKeys("selenium42");
		WebElement inputPassword = driver.findElement(By.xpath("//input[@name='__ac_password']"));
		inputPassword.sendKeys("R5vxI0j60");
		// Hier ist RelativPath immer besser
		WebElement inputButtonLogin = driver.findElement(By.xpath("//input[@value='Anmelden']"));
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
		WebElement radioButton1 = driver.findElement(By.xpath("//input[@value='radio1']"));
		WebElement radioButton2 = driver.findElement(By.xpath("//input[@value='radio2']"));
		WebElement radioButton3 = driver.findElement(By.xpath("//input[@value='radio3']"));
		
		
		// Act
		
		radioButton1.click();
		// Finden des <input>-Elements mit dem Namen 'radioButton' und dem Wert 'radio1' 
		WebElement element1 = driver.findElement(By.xpath("//input[@name='radioButton' and @value='radio1']"));
		// Mit getDomAttribute wird das Value-Attribut ausgelesen.
		String value1 = element1.getDomAttribute("value");
		assertEquals(value1, "radio1");
		
		radioButton2.click();
		WebElement element2 = driver.findElement(By.xpath("//input[@name='radioButton' and @value='radio2']"));
		String value2 = element2.getDomAttribute("value");
		assertEquals(value2, "radio2");
		
		radioButton3.click();
		WebElement element3 = driver.findElement(By.xpath("//input[@name='radioButton' and @value='radio3']"));
		String value3 = element3.getDomAttribute("value");
		assertEquals(value3, "radio3");
		
		
		// Assert
		//String erfolgMeldung = driver.findElement(By.cssSelector("div.portalMessage")).getText();
		//assertTrue(erfolgMeldung.contains("Willkommen"));
	}

}

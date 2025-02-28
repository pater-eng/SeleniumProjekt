package de.selenium.tests;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestLogingMitLokatorenFehler {
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
	public void test() {
		System.out.println("Starte Test Login mit Fehlschlag");	
		// Arrange
		driver.findElement(By.id("__ac_name")).sendKeys("Benutzer");
		driver.findElement(By.name("__ac_password")).sendKeys("test");
		
		// Act
		// Hier ist ein AbsolutePath
		driver.findElement(By.xpath("/html/body/section/div[2]/div/div[2]/div/div[1]/form/input[3]")).click();
		// Hier ist RelativPath
		//driver.findElement(By.xpath("//input[@value='Anmelden']")).click();
	
		// Assert
		String fehlerMeldung = driver.findElement(By.cssSelector("#global_statusmessage > div")).getText();
		assertTrue(fehlerMeldung.contains("Anmeldung fehlgeschlagen"));
	}

}

package de.codingsolo.seleniumkurs.test;


import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class TestForm1SeleniumKursFireFox {
	
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
		System.out.println("Test abgeschlossen- ich r�ume");
		//driver.close();
	}

	@Test
	public void testLogin() {
		System.out.println("Starte Test Login mit Fehlschlag");
		
		//Arrange
		
		
		//Login
		driver.findElement(By.cssSelector("input.form-control[type='text']")).sendKeys("selenium101");
		driver.findElement(By.cssSelector("input.form-control[type='password']")).sendKeys("codingsolo");
		driver.findElement(By.cssSelector("input.btn-primary")).click();
		//Navigation zum Formular
		driver.findElement(By.id("portaltab-burger-menu")).click();
		driver.findElement(By.linkText("Selenium Testapplikationen")).click();
		driver.findElement(By.linkText("Selenium Test Form1")).click();
		
		// Starte Formular
		driver.findElement(By.id("form-widgets-betreff")).sendKeys("Automatischer Test");
		driver.findElement(By.id("form-widgets-name")).sendKeys("Dieter");
		
		Select selectAuswahl1 = new Select(driver.findElement(By.id("form-widgets-auswahl1")));
		selectAuswahl1.selectByVisibleText("Java Grundlagen Kurs mit Dieter");
		
		Select selectAuswahl2 = new Select(driver.findElement(By.id("form-widgets-auswahl2-from")));
		selectAuswahl2.selectByIndex(2);
		selectAuswahl2.selectByIndex(4);
		selectAuswahl2.selectByIndex(6);
		
		driver.findElement(By.name("from2toButton")).click();
		
		Select selecAuswahl3 = new Select(driver.findElement(By.id("form-widgets-auswahl2-to")));
		selecAuswahl3.selectByIndex(2);
		
		driver.findElement(By.name("upButton")).click();
		
		//Act

		driver.findElement(By.name("form.buttons.speichern")).click();

		//Assert
		
		String erfolgsMeldung = driver.findElement(By.id("message")).getText();
		assertTrue(erfolgsMeldung.contains("Java Grundlagen Kurs"));
		
		String erstesElement = driver.findElement(By.xpath("//ul[@id='companies']/li[1]")).getText();
		assertEquals(erstesElement, "Magazzini Alimentari Riuniti");
	}

}

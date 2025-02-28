package de.selenium.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

class TestfallIExplorer{
	
	WebDriver driver;
	
	@BeforeEach
	void initTest() {
		System.out.println("initialisiere Webdriver.");
		System.setProperty("webdriver.ie.driver", 
				"./drivers/IEDriverServer.exe");
		driver = new InternetExplorerDriver();
		driver.get("https://www.calculator.net/gas-mileage-calculator.html"); 
		 
		
		
	}
	
	@AfterEach
	void endTests() {
		System.out.println("Testfall abgeschlossen. -Aufräumen");	
		driver.close();
		driver.quit();
		
	}
	
		
	@Test
	void testTitelPrüfen() {
		System.out.println("Menge wird berechnet.");	
		//assertEquals("Gas Mileage Calculator", driver.getTitle());
		assertEquals("Gas Mileage Calculator", driver.getTitle());
	}

}

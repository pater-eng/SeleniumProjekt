package de.selenium.pages.tests;


import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class TestDragDropSeleniumChrome {
	
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
		System.out.println("Test abgeschlossen- ich r�ume");
		//driver.close();
	}

	@Test
	public void testLogin() {
		System.out.println("Starte Test Login mit Fehlschlag");
		
		//Arrange
		
		
		//Login
		driver.findElement(By.cssSelector("input.form-control[type='text']")).sendKeys("selenium42");
	    driver.findElement(By.cssSelector("input.form-control[type='password']")).sendKeys("R5vxI0j60");
	    driver.findElement(By.cssSelector("input.btn-primary")).click();
		//Navigation zum Formular
		driver.findElement(By.id("portaltab-burger-menu")).click();
		driver.findElement(By.linkText("Selenium Testapplikationen")).click();
		driver.findElement(By.linkText("Drag and Drop Beispiel")).click();
		
		// Starte Drag and Drop
		
		WebElement drgLogoNormal = driver.findElement(By.id("white-logo"));
		WebElement drgLogoBlue = driver.findElement(By.id("blue-logo"));
		WebElement drgLogoRed = driver.findElement(By.id("red-logo"));
		WebElement drgLogoGreen = driver.findElement(By.id("green-logo"));
		
		WebElement drpBox = driver.findElement(By.id("droppable"));
		
		Actions action = new Actions(driver);
		
		//Act

		action.dragAndDrop(drgLogoNormal, drpBox).build().perform();
		action.dragAndDrop(drgLogoBlue, drpBox).build().perform();
		
		action.dragAndDropBy(drgLogoRed, 250, 0).build().perform();
		
		action.clickAndHold(drgLogoGreen).perform();
		action.moveByOffset(250, 0).perform();
		action.release(drgLogoGreen).perform();
		
		//action.clickAndHold(drgLogoGreen).moveByOffset(250, 0).release(drgLogoGreen).perform();
		
		//Assert
		
		String erfolgsMeldung = driver.findElement(By.cssSelector("#droppable > p")).getText();
		assertTrue(erfolgsMeldung.contains("green-logo"));
		
	}

}

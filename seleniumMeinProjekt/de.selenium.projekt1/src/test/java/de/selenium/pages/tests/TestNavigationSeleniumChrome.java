package de.selenium.pages.tests;


import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestNavigationSeleniumChrome {
	
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
		System.out.println("Starte Test Login mit Erfolg");
		
		//Arrange
		
		WebElement inputUsername=driver.findElement(By.cssSelector("input.form-control[type='text']"));
		inputUsername.sendKeys("selenium42");
		
		WebElement inputPassword = driver.findElement(By.cssSelector("input.form-control[type='password']"));
		inputPassword.sendKeys("R5vxI0j60");
		
		WebElement btnLogin = driver.findElement(By.cssSelector("input.btn-primary"));
		btnLogin.click();
		
		//Act

		WebElement btnMenu = driver.findElement(By.id("portaltab-burger-menu"));
		btnMenu.click();
		
		WebElement linkSideMenuSelenium = driver.findElement(By.linkText("Selenium Testapplikationen"));
		linkSideMenuSelenium.click();
		
		WebElement linkSeleniumTestApp = driver.findElement(By.linkText("Selenium Test Form1"));
		linkSeleniumTestApp.click();

		//Assert
		
		String erfolgsMeldung = driver.findElement(By.tagName("h1")).getText();
		assertEquals(erfolgsMeldung, "Selenium Test Form1");
	}

}

package de.selenium.pages.tests;



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

public class TestCookies {


		
		WebDriver driver;

	@Before
	public void setUp() throws Exception {
		System.out.println("initialisiere Webdriver.");
		System.setProperty("webdriver.chrome.driver", 
				"./drivers/chromedriver.exe");
		driver = new ChromeDriver();
		// Browser auf Maximum vergrößer
		driver.manage().window();
		driver.get("https://www.codingsolo.de/");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement cookiesButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@title='Akzeptieren Sie vorgewählte cookies' and @data-cookiefirst-action='accept']")));
		cookiesButton.click();

		
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("Test abgeschlossen- ich räume");
		//driver.close();
	}

	@Test
	public void testLogin() {
		System.out.println("Starte Test Login mit Erfolg");
	}
}

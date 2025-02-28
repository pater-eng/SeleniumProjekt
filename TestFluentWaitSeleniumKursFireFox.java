package de.codingsolo.seleniumkurs.test;

import static org.junit.Assert.*;

import java.time.Duration;
import java.util.function.Function;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import de.codingsolo.seleniumkurs.pages.SeleniumKursHomePage;
import de.codingsolo.seleniumkurs.pages.SeleniumKursLoginPage;
import de.codingsolo.seleniumkurs.pages.SeleniumKursTestApplikationenPage;

public class TestFluentWaitSeleniumKursFireFox {

	WebDriver driver;

	@Before
	public void setUp() throws Exception {
		System.out.println("Initialisiere Webdriver");
		System.setProperty("webdriver.gecko.driver", "./drivers/geckodriver.exe");
		driver = new FirefoxDriver();
		//driver.manage().window().maximize();
		driver.get("https://seleniumkurs.codingsolo.de");
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("Test abgeschlossen- ich räume");
		// driver.close();
	}

	@Test
	public void testFluentWait() {
		System.out.println("Starte Test für den Fluent Wait");

		// Arrange

		SeleniumKursLoginPage loginPage = new SeleniumKursLoginPage(driver);
		loginPage.zugangsdatenEingeben("selenium102", "codingsolo");
		loginPage.loginButtonAnklicken();

		SeleniumKursHomePage homePage = new SeleniumKursHomePage(driver);
		homePage.menuAusklappen();
		homePage.seleniumTestAppLinkAnklicken();

		SeleniumKursTestApplikationenPage testAppPage = new SeleniumKursTestApplikationenPage(driver);
		testAppPage.fluentWaitBeispielAnklicken();

		// Act
		
		driver.findElement(By.cssSelector(".btn-primary")).click();
		
//		String status = driver.findElement(By.cssSelector("#status")).getText();
//		System.out.println(status);
		
//		WebDriverWait wait = new WebDriverWait(driver, 15);
//		String status = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#status"))).getText();
//		System.out.println(status);
		
		
		Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(15))
				.pollingEvery(Duration.ofSeconds(5))
				.ignoring(NoSuchElementException.class);
		
		fluentWait.until(new Function<WebDriver, WebElement>(){
			public WebElement apply(WebDriver driver) {
				WebElement status = driver.findElement(By.cssSelector("#status"));
				System.out.println(status.getText());
				
				return null;
			}
		});

		// Assert

		
		
		
	}

}

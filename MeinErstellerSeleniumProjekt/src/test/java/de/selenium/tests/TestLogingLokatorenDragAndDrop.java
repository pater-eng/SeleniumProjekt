package de.selenium.tests;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.Duration;
import java.util.Arrays;

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

public class TestLogingLokatorenDragAndDrop {
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

	@SuppressWarnings("unlikely-arg-type")
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
		
		// Navigation: Link 1 wird geklickt
		WebElement navLink1 = driver.findElement(By.id("portaltab-burger-menu"));
		navLink1.click();	
		// Navigation: Danach wird Link 2 geklickt
		// Verwende einen expliziten Wait (z.B. WebDriverWait), um darauf zu warten, dass das Element sichtbar und interaktiv ist.
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement navLink2 = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Selenium Testapplikationen")));
		navLink2.click();
		
		// Navigation: Startet Drap and Drop
		WebElement navDragAndDrop = driver.findElement(By.linkText("Drag and Drop Beispiel"));
		navDragAndDrop.click();
		
		// Hier hole die Element anhand deren ID
		WebElement whiteElement = driver.findElement(By.id("white-logo"));
		WebElement redElement = driver.findElement(By.id("red-logo"));
		WebElement greeElement = driver.findElement(By.id("green-logo"));
		WebElement blueElement = driver.findElement(By.id("blue-logo"));
		WebElement codingElement = driver.findElement(By.id("coding-logo"));
		
	
	
		WebElement dropBox = driver.findElement(By.id("droppable"));
		Actions action = new Actions(driver);
		
		// Act
		// Hier werden nur 3 Element Drag and Drop 
		action.dragAndDrop(whiteElement, dropBox).build().perform();
		action.dragAndDrop(redElement, dropBox).build().perform();
		action.dragAndDrop(blueElement, dropBox).build().perform();
		
		
		
		// Assert
		// Anhang der Id(droppable greife ich auf P-Element und hole ich den Text)
		String erfolgMeldung = driver.findElement(By.cssSelector("#droppable > p")).getText();
	
		// Blue als letztes Element wird abgelegt
		assertTrue(erfolgMeldung.contains("blue-logo"));
		
		
	}

}

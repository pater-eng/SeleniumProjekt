package de.selenium.pages.tests;



import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.Duration;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestCookiesDialog {



	WebDriver driver;
	WebDriverWait wait;

	@FindBy(css = "//*[@id='dialog_de_dias:Vmnr']")
	WebElement element1;

	@Before
	public void setUp() throws Exception {
		System.out.println("initialisiere Webdriver.");
		System.setProperty("webdriver.chrome.driver", 
				"./drivers/chromedriver.exe");
		driver = new ChromeDriver();
		// Browser auf Maximum vergrößer
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5)); // Für jede Element 2 Secunde warten.
		driver.get("https://www.dialog-versicherung.de/");




	}

	@After
	public void tearDown() throws Exception {
		System.out.println("Test abgeschlossen- ich räume");
		//driver.close();
	}

	@Test
	public void testLogin() {
		System.out.println("Starte Test Login mit Erfolg");

		// Cookies anklicken
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement cookiesButton = 
				wait.until(ExpectedConditions.elementToBeClickable(By.id("onetrust-accept-btn-handler")));
		cookiesButton.click();

		//Link: Rechner anklicken
		driver.findElement(By.xpath("//a[contains(text(),'Rech') and contains(text(),'ner')]")).click();

		// Link: Privatkunden Leben
		driver.findElement(By.xpath("//a[@href='/rechner/privatkunden-leben']")).click();

		// Link: Tarifrechner
		driver.findElement(By.cssSelector("a[data-wta='dialog_vers.content.pk-lv-tarifrechner-link.clickout']")).click();

		// Dialog:
		 
		WebElement dialogBezeichnung = driver.findElement(By.xpath("//*[@id='dialog_de_dias:page']/header/img[1]"));
		System.out.println(dialogBezeichnung.getText()); // Ausgabe: "Angebot erstellen"
		assertEquals(dialogBezeichnung, "Dialog");
		
		// Vermittlerdaten:
//		String vermittelnMessage = driver.findElement(By.xpath("//span[@class='ui-panel-title' and text()='Vermittlerdaten']")).getText();
//		WebElement angebotErstellen = driver.findElement(By.cssSelector("li.breadcrumb-wizard-step-active"));
//		System.out.println(angebotErstellen.getText()); // Ausgabe: "Angebot erstellen"
//		assertEquals(angebotErstellen, "Angebot erstellen");
		
//		WebElement angebotErstellen1 = driver.findElement(By.xpath("//ul[@class='breadcrumb-wizard']/li[1]"));
//		System.out.println(angebotErstellen1.getText()); // Ausgabe: "Angebot erstellen"
//		assertEquals(angebotErstellen1, "Angebot erstellen");

		//		driver.findElement(By.id("input[@id='dialog_de_dias:Vmnr']")).sendKeys("051234");
		//		driver.findElement(By.cssSelector("input#dialog_de_dias:Vmnr")).sendKeys("051234");
		//		driver.findElement(By.xpath("//*[@id='dialog_de_dias:Vmnr']")).sendKeys("051234");
		//				wait.until(ExpectedConditions.visibilityOf(element1)).sendKeys("051234");
		//		driver.findElement(By.xpath("//div[@id='dialog_de_dias:vermittlerPanelId_content']/input[@id='dialog_de_dias:Vmnr' and  @name='dialog_de_dias:Vmnr']")).sendKeys("051234");
		//		driver.findElement(By.xpath("//div[@id='dialog_de_dias:vermittlerPanelId_content']/input[@id='dialog_de_dias:Vmname']")).sendKeys("VERS12345");
	}
}

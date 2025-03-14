package de.selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SeleniumAppilcationPage {

	WebDriver driver;
	//Hier haben wir 4 Lokatoren definieren


	// Menu button
	@FindBy(css = "portaltab-burger-menu")
	private WebElement btnMenu;

	// Link Testfrom1
	@FindBy(linkText = "Selenium Test Form1")
	private WebElement linkMenuSeleniumTestForm1;

	// Link Drag and Drop Beispiel
	@FindBy(linkText = "Drag and Drop Beispiel")
	private WebElement linkMenuDragAndDropBeispiel;

	// IFrame
	@FindBy(linkText = "IFrame Beispiel")
	private WebElement linkMenuIFrameBeispiel;

	// WebElement: Checkbox und RadioButtton
	@FindBy(linkText = "Web Elemente")
	private WebElement linkWebElemente;
	
	
	@FindBy(linkText = "Katzensuche Testseite (AJAX)")
	private WebElement linkKatzensucheTestseiteAJAX;
	

	@FindBy(linkText = "Webshop Testseite")
	private WebElement linkWebshopTestseite;
	

	@FindBy(linkText = "Fluent Wait Testseite")
	private WebElement linkFluentWaitTestseite;
	
	@FindBy(linkText = "Testform3 DataDriven")
	private WebElement linkTestform3DataDriven;

	public SeleniumAppilcationPage(WebDriver driver) {
		this.driver = driver;
		// verwendet, um die WebElemente der Seite zu initialisieren, die im Rahmen des Page Object Modells definiert wurden
		PageFactory.initElements(driver, this);
	}

	public void menuAusklappen() {
		btnMenu.click();
	}

	public void seleniumTestFrom1LinkAnklicken() {
		linkMenuSeleniumTestForm1.click();
	}

	public void seleniumLinkDragAndDropBeispielAnklicken() {
		linkMenuIFrameBeispiel.click();
	}

	public void seleniumLinkIFrameBeispielAnklicken() {
		linkMenuDragAndDropBeispiel.click();
	}
	
	public void seleniumLinkWebElementeAnklicken() {
		linkWebElemente.click();
	}
	
	public void seleniumLinkKatzensucheTestseiteAJAXAnklicken() {
		linkKatzensucheTestseiteAJAX.click();
	}
	
	public void seleniumLinkWebshopTestseiteAnklicken() {
		linkWebshopTestseite.click();
	}

	public void fluentWaitTestseiteAnklicken() {
		linkFluentWaitTestseite.click();
		
	}
	public void testform3DataDrivenAnklicken() {
		linkTestform3DataDriven.click();
		
	}
	
}

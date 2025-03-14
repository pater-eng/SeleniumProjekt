package de.selenium.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class SeleniumTestForm1Page {
	WebDriver driver;

	@FindBy(tagName = "h1")
	private WebElement testFromeHeadline;

	@FindBy(id = "form-widgets-betreff")
	private WebElement inputBetreff;

	@FindBy(id = "form-widgets-name")
	private WebElement inputName;

	@FindBy(id = "form-widgets-auswahl1")
	private WebElement selectKurs;

	@FindBy(id = "form-widgets-auswahl2-from")
	private WebElement selectFirmaBox1;

	@FindBy(name = "from2toButton")
	private WebElement btnAuswahlFirmaBox1;

	@FindBy(id = "form-widgets-auswahl2-to")
	private WebElement selectFirmaBox2;

	@FindBy(name = "upButton")
	private WebElement btnAuswahlObenBox2;

	@FindBy(name = "form.buttons.speichern")
	private WebElement btnSpeichern;

	@FindBy(id = "message")
	private WebElement statusMeldung;


	@FindBy(xpath = "//ul[@id='companies']/li[1]")
	private WebElement erstesElementDerListe;

	
	public SeleniumTestForm1Page(WebDriver driver) {
		super();
		this.driver = driver;
		// verwendet, um die 4 WebElemente der Seite zu initialisieren, die im Rahmen des Page Object Modells definiert wurden
		PageFactory.initElements(driver, this);
	}

	public String ueberschriftAuslesen() {
		return testFromeHeadline.getText();
	}
	
	
	public void betreffEingeben(String betreff) {
		inputBetreff.sendKeys(betreff);
	}

	public void nameEingeaben(String name) {
		inputName.sendKeys(name);
	}

	public void kursAuswaehlen(String kursName) {
		Select selectKurs = new Select(this.selectKurs);
		selectKurs.selectByVisibleText(kursName);
	}

	public void firmaInBox1Auswaehlen(int[] auswahl) {
		Select selectFirma = new Select(this.selectFirmaBox1);
		for (int i : auswahl) {
			selectFirma.selectByIndex(i);
		}
	}

	public void firmenUerbernehmen() {
		btnAuswahlFirmaBox1.click();
	}

	// Vor dem Auswählen prüfen, ob der Index innerhalb der Grenze liegt.
	public void firmaInBox2Auswaehlen(int[] auswahl) {
	    Select selectFirma = new Select(this.selectFirmaBox2);
	    List<WebElement> options = selectFirma.getOptions();
	    for (int i : auswahl) {
	        if (i < options.size()) {
	            selectFirma.selectByIndex(i);
	        } else {
	            System.err.println("Option mit Index " + i + " ist nicht verfügbar. (Anzahl der Optionen: " + options.size() + ")");
	        }
	    }
	}
	
	public void ausgewählteFirmenNachObenVerschieben() {
		btnAuswahlObenBox2.click();
	}
	
	public void formularSpeichern() {
		btnSpeichern.click();
	}
	
	public String statusMeldungAuslesen() {
		return statusMeldung.getText();
		
	}
	
	public String erstesElementDerListeAuslesen() {
		return erstesElementDerListe.getText();
		
	}
	
}

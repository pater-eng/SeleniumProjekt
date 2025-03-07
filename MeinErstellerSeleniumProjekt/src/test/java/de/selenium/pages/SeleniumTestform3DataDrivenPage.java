package de.selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import de.selenium.exception.FehlerTyp;
import de.selenium.exception.MeineException;

public class SeleniumTestform3DataDrivenPage {
	WebDriver driver;
	//Hier haben wir die Lokatoren definieren

	@FindBy(id = "form-widgets-bezeichnung")
	private WebElement bezeichnung;

	@FindBy(id = "form-widgets-kennung")
	private WebElement kennung;

	@FindBy(id = "form-widgets-anschrift")
	private WebElement anschrift;

	@FindBy(id = "form-widgets-telefon")
	private WebElement telefon;

	@FindBy(id = "form-widgets-str")
	private WebElement str;

	@FindBy(id = "form-widgets-plz")
	private WebElement plz ;

	@FindBy(id = "form-widgets-ort")
	private WebElement ort;

	@FindBy(id = "form-widgets-auswahl1")
	private WebElement select_auswahl1;

	@FindBy(id = "form-widgets-name")
	private WebElement name;

	@FindBy(id = "form-widgets-vorname")
	private WebElement vorname;

	@FindBy(id = "form-widgets-geburt")
	private WebElement geburt;

	@FindBy(id = "form-widgets-telefonv")
	private WebElement telefonv;

	@FindBy(id = "form-widgets-strv")
	private WebElement strv;

	@FindBy(id = "form-widgets-plzv")
	private WebElement plzv;

	@FindBy(id = "form-widgets-ortv")
	private WebElement ortv;

	@FindBy(name="form.buttons.speichern") 
	private WebElement btn_speicher;

	@FindBy(id = "message")
	private WebElement text_status;

	//@FindBy(id = "//*[@id='auswahl']//li[1]")
	@FindBy(css = "section[id='portal-content'] li:nth-child(1)")
	private WebElement text_erstesElement;

	public SeleniumTestform3DataDrivenPage(WebDriver driver) {
		this.driver = driver;
		// verwendet, um die WebElemente der Seite zu initialisieren, die im Rahmen des Page Object Modells definiert wurden
		PageFactory.initElements(driver, this);
	}
	public void bezeichnungEingeben(String bezeichnung) {
		this.bezeichnung.sendKeys(bezeichnung);

	}

	public void kennunggEingeben(String kennung) {
		this.kennung.sendKeys(kennung);

	}

	public void anschriftEingeben(String anschrift) {
		this.anschrift.sendKeys(anschrift);

	}
	public void telefonEingeben(String telefon) {
		this.telefon.sendKeys(telefon);

	}
	public void strgEingeben(String str) {
		this.str.sendKeys(str);

	}
	public void plzEingeben(String plz) {
		this.plz.sendKeys(plz);

	}
	public void ortEingeben(String ort) {
		this.ort.sendKeys(ort);

	}
	public void select_auswahl1Eingeben(String select_auswahl1) throws MeineException {
		if(text_erstesElement.isDisplayed() && text_erstesElement.isEnabled()) {
			Select auswahl = new Select(text_erstesElement);
			auswahl.selectByValue(select_auswahl1);
		}else {
			throw new MeineException(FehlerTyp.ElementExistiertNicht, "Element wurde nicht gefunden!");
		}

	}
	public void namegEingeben(String name) {
		this.name.sendKeys(name);

	}
	public void vornameEingeben(String vorname) {
		this.vorname.sendKeys(vorname);

	}

	public void geburtEingeben(String geburt) {
		this.geburt.sendKeys(geburt);

	}

	public void telefonVersicherterEingeben(String telefonv) {
		this.telefonv.sendKeys(telefonv);

	}

	public void strVersicherterEingeben(String strv) {
		this.strv.sendKeys(strv);

	}

	public void plzVersichterEingeben(String plzv) {
		this.plzv.sendKeys(plzv);

	}

	public void ortVersicherterEingeben(String ortv) {
		this.ortv.sendKeys(ortv);

	}
	public void speicherAnklicken() {
		this.btn_speicher.click();

	}

	public String statusAuslesen() {
		return text_status.getText();

	}

	public String erstesElementAuslesen() {
		return text_erstesElement.getText();

	}


}

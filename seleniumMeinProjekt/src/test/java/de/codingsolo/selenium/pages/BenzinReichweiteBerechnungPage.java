package de.codingsolo.selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BenzinReichweiteBerechnungPage {

	private WebDriver driver;
	private WebDriverWait wait;


	// Fields
	@FindBy(id = "kilometerstandAktuell")
	private WebElement kilometerstandAktuellInput;

	@FindBy(id = "kilometerstandBevor")
	private WebElement kilometerstandBevorInput;

	@FindBy(id = "benzinmenge")
	private WebElement benzinmengeInput;

	@FindBy(id = "benzinPreis")
	private WebElement benzinPreisInput;

	// Button
	@FindBy(id = "berechnung")
	private WebElement berechnungBtn;

	// Result

	@FindBy(id = "reichweite")
	private WebElement reichweiteText;

	public BenzinReichweiteBerechnungPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

		this.wait = new WebDriverWait(driver, 4);
	}

	public void executeCalculation() {
		wait.until(ExpectedConditions.elementToBeClickable(this.berechnungBtn));
		this.berechnungBtn.click();

	}

	public String getResult() {
		wait.until(ExpectedConditions.elementToBeClickable(this.reichweiteText));

		return this.reichweiteText.getText();
	}

	public void setKilometerstandAktuell(String kilometerstandAktuell) {
		wait.until(ExpectedConditions.elementToBeClickable(this.kilometerstandAktuellInput));
		this.kilometerstandAktuellInput.clear();
		this.kilometerstandAktuellInput.sendKeys(kilometerstandAktuell);
	}

	public void setKilometerstandBevor(String kilometerstandBevor) {
		wait.until(ExpectedConditions.elementToBeClickable(this.kilometerstandBevorInput));
		this.kilometerstandBevorInput.clear();
		this.kilometerstandBevorInput.sendKeys(kilometerstandBevor);
	}

	public void setBenzinmenge(String benzinmenge) {
		wait.until(ExpectedConditions.elementToBeClickable(this.benzinmengeInput));
		this.benzinmengeInput.clear();
		this.benzinmengeInput.sendKeys(benzinmenge);
	}

	public void setBenzinPreis(String benzinPreis) {
		wait.until(ExpectedConditions.elementToBeClickable(this.benzinPreisInput));
		this.benzinPreisInput.clear();
		this.benzinPreisInput.sendKeys(benzinPreis);
	}

}

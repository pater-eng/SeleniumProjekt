package de.codingsolo.seleniumkurs.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumKursWebShopProdukte {

	private WebDriver driver;
	private WebDriverWait wait;

	@FindBy(xpath = "//input[contains(@placeholder, 'Hier')]")
	private WebElement inputProduktSuche;
	
	@FindBy(xpath = "//tbody/tr[last()]//strong")
	private WebElement textPreis;
	
	@FindBy(css = ".cart-icon")
	private WebElement btnWarenKorb;
	
	@FindBy(css = "div.cart-preview > div.action-block > button")
	private WebElement btnZurKasse;

	public SeleniumKursWebShopProdukte(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, 5);
		PageFactory.initElements(driver, this);
	}

	public void produktSucheAusfuehren(String name) {
		inputProduktSuche.sendKeys(name);
	}

	public void produktAnzahlAuswaehlen(String name, int anzahl) {
		WebElement btnPlus = driver
				.findElement(By.xpath(String.format("//*[text() = '%s']/..//*[@class='increment']", name)));

		for (int i = 1; i < anzahl; i++) {
			btnPlus.click();
		}
	}
	
	public void produktInWarenKorbLegen(String name) {
		driver.findElement(By.xpath(String.format("//*[text() = '%s']/..//button", name))).click();
	}
	
	public String preisAuslesen() {
		return textPreis.getText();
	}
	
	public void warenKorbAnklicken() {
		btnWarenKorb.click();
	}
	
	public void zurKasseAnklicken() {
		btnZurKasse.click();
	}

}

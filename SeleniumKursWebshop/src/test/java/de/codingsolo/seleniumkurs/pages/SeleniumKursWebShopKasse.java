package de.codingsolo.seleniumkurs.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumKursWebShopKasse {

	private WebDriver driver;
	private WebDriverWait wait;

	@FindBy(className = "promoCode")
	private WebElement inputPromoCode;

	@FindBy(className = "promoBtn")
	private WebElement btnPromoCodeAktivieren;
	
	@FindBy(className = "promoInfo")
	private WebElement textPromoInfo;
	
	@FindBy(className = "discountAmt")
	private WebElement textPreis;
	
	@FindBy(css = "div >button:last-child")
	private WebElement btnBestellen;

	public SeleniumKursWebShopKasse(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, 5);
		PageFactory.initElements(driver, this);
	}
	
	public void promoCodeEingeben(String code) {
		inputPromoCode.sendKeys(code);
	}

	public void promoCodeAktivierenAnklicken() {
		btnPromoCodeAktivieren.click();
	}
	
	public String promoInfoAuslesen() {
		wait.until(ExpectedConditions.elementToBeClickable(textPromoInfo));
		return textPromoInfo.getText();
	}
	
	public String preisAuslesen() {
		return textPreis.getText();
	}
	
	public void bestellungAnklicken() {
		btnBestellen.click();
	}
}

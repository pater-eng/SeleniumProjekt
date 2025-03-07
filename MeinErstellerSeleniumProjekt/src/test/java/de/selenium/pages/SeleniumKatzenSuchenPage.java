package de.selenium.pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import de.selenium.exception.FehlerTyp;
import de.selenium.exception.MeineException;

public class SeleniumKatzenSuchenPage {
	WebDriver driver;
	WebDriverWait wait;

	@FindBy(css = "p.lead")
	private WebElement textParagraph;

	@FindBy(id = "ECqe13G5B")
	private WebElement imgKatze1;

	@FindBy(id = "0c9_EEtqQ")
	private WebElement imgKatze2;

	@FindBy(id = "5qNv0jHXW")
	private WebElement imgKatze3;

	@FindBy(id = "h6")
	private WebElement imgKatze4;

	@FindBy(id = "OxdwIl870")
	private WebElement imgKatze5;

	@FindBy(id = "Znj6KEDRX")
	private WebElement imgKatze6;

	@FindBy(id = "2ECqypnRY")
	private WebElement imgKatze7;

	@FindBy(id = "usj_vstvO")
	private WebElement imgKatze8;

	@FindBy(id = "Vcf2l8tKO")
	private WebElement imgKatze9;

	@FindBy(linkText = "Next")
	private WebElement linkNext;

	@FindBy(linkText = "Previous")
	private WebElement linkPrevious;

	@FindBy(id = "anzahlSelect")
	private WebElement selectAnzahl;

	@FindBy(id = "sortSelect")
	private WebElement selectSortierung;

	public SeleniumKatzenSuchenPage(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofMinutes(5));
		PageFactory.initElements(driver, this);
	}

	public String beschreibungAuslesen() {
		return textParagraph.getText();
	}

	public String srcLinkImgKatze1Auslesen() {
		return imgKatze1.getDomAttribute("src");
	}

	public String srcLinkImgKatze2Auslesen() throws MeineException {
		if (imgKatze2.isDisplayed() && imgKatze2.isEnabled()) {
			System.out.println("IMAGE2 ist sichtbar");
			return imgKatze2.getDomAttribute("src");
		}else {
			throw new MeineException(FehlerTyp.IMAGENICHTSichtbar, "IMAGE3 ist NICHT sichtbar!");
		}
	}

	public String srcLinkImgKatze3Auslesen() throws MeineException {
		if (imgKatze3.isDisplayed() && imgKatze3.isEnabled()) {
			System.out.println("IMAGE3 ist sichtbar");
			return imgKatze3.getDomAttribute("src");
		}else {
			throw new MeineException(FehlerTyp.IMAGENICHTSichtbar, "IMAGE3 ist NICHT sichtbar!");
		}
	}

	public String srcLinkImgKatze4Auslesen() {
		wait.until(ExpectedConditions.elementToBeClickable(imgKatze4));
		return imgKatze4.getDomAttribute("src");
	}

	public String srcLinkImgKatze5Auslesen() {
		return imgKatze5.getDomAttribute("src");
	}

	public String srcLinkImgKatze6Auslesen() {
		return imgKatze6.getDomAttribute("src");
	}

	public String srcLinkImgKatze7Auslesen() {
		return imgKatze7.getDomAttribute("src");
	}

	public String srcLinkImgKatze8Auslesen() {
		return imgKatze8.getDomAttribute("src");
	}

	public String srcLinkImgKatze9Auslesen() {
		return imgKatze9.getDomAttribute("src");
	}

	public void nextPage() {
		linkNext.click();
	}

	public void previousPage() {
		linkPrevious.click();
	}

	public void anzahlBilderEingeben(String anzahlWert) {
		Select anzahl = new Select(selectAnzahl);
		anzahl.selectByVisibleText(anzahlWert);
	}

	public void sortierungEingeben(String sortierWert) {
		Select sortierung = new Select(selectSortierung);
		sortierung.selectByValue(sortierWert);
	}	

}



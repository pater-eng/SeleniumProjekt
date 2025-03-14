package de.selenium.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumWebShopAGB {

	private WebDriver driver;
	private WebDriverWait wait;
	
	@FindBy(css = "div > select")
	private WebElement selectLand;

	@FindBy(className = "chkAgree")
	private WebElement checkAGBAkzeptiert;

	@FindBy(css = "div > button")
	private WebElement btnWeiter;
	
	public SeleniumWebShopAGB(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		PageFactory.initElements(driver, this);
	}
	
	public void landAuswählen(String land) {
		Select landAuswahl = new Select(selectLand);
		landAuswahl.selectByValue(land);
	}
	
	public void aGBAkzeptiert() {
		checkAGBAkzeptiert.click();
	}
	
	public void weiterAnklicken() {
		btnWeiter.click();
	}
}

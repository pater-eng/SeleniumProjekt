package de.selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SeleniumWebElementRadioButtonPage {

	WebDriver driver;
	//Hier haben wir die Lokatoren definieren
	
	// Menu Radio
	@FindBy(css = "input[value='radio1']")
	private WebElement radioButton1;

	@FindBy(css = "input[value='radio2']")
	private WebElement radioButton2;

	@FindBy(xpath = "//input[@value='radio3']")
	private WebElement radioButton3;

	public SeleniumWebElementRadioButtonPage(WebDriver driver) {
		this.driver = driver;
		// verwendet, um die WebElemente der Seite zu initialisieren, die im Rahmen des Page Object Modells definiert wurden
		PageFactory.initElements(driver, this);
	}

	public void radio1Aktivieren() {
		radioButton1.click();
	}
	public void radio2Aktivieren() {
		radioButton2.click();
	}
	public void radio3Aktivieren() {
		radioButton3.click();
	}

	public String radioButton1StatusAuslesen(String attributename) {
		return radioButton1.getDomAttribute(attributename);
	}
	public String radioButton2StatusAuslesen(String attributename) {
		return radioButton2.getDomAttribute(attributename);
	}
	public String radioButton3StatusAuslesen(String attributename) {
		return radioButton3.getDomAttribute(attributename);
	}
}

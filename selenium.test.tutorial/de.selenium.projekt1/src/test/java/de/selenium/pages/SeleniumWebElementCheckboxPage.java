package de.selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SeleniumWebElementCheckboxPage {

	WebDriver driver;
	//Hier haben wir die Lokatoren definieren


	// Menu Checkbox
	@FindBy(id = "checkBoxOption1")
	private WebElement checkBox1;

	@FindBy(id = "checkBoxOption2")
	private WebElement checkBox2;

	@FindBy(id = "checkBoxOption3")
	private WebElement checkBox3;

	public SeleniumWebElementCheckboxPage(WebDriver driver) {
		this.driver = driver;
		// verwendet, um die WebElemente der Seite zu initialisieren, die im Rahmen des Page Object Modells definiert wurden
		PageFactory.initElements(driver, this);
	}

	public void checkBox1Aktivieren() {
		// Doppelclick um den Checkbox zu deaktivieren
		checkBox1.click();
		checkBox1.click();

	}
	public void checkBox2Aktivieren() {
		checkBox2.click();
	}
	public void checkBox3Aktivieren() {
		checkBox3.click();
	}

	public boolean checkBox1StatusAuslesen() {
		System.out.println("CHECKBOX1: "+checkBox1.isSelected());
		return checkBox1.isSelected();
	}
	public boolean checkBox2StatusAuslesen() {
		return checkBox2.isSelected();
	}
	public boolean checkBox3StatusAuslesen() {
		return checkBox3.isSelected();
	}
}

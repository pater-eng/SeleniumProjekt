package de.selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SeleniumDragDropPage {

	WebDriver driver;
	//Hier haben wir 4 Lokatoren definieren


	// Menu Elemente
	@FindBy(id = "white-logo")
	private WebElement whiteElement;

	@FindBy(id = "red-logo")
	private WebElement redElement;

	@FindBy(id = "green-logo")
	private WebElement greenElement;

	@FindBy(id = "blue-logo")
	private WebElement blueElement;
	
	@FindBy(id = "coding-logo")
	private WebElement codeLogo;

	@FindBy(id = "droppable")
	private WebElement dropBox;
	
	@FindBy(css ="#droppable > p")
	private WebElement statusMeldung;

	public SeleniumDragDropPage(WebDriver driver) {
		this.driver = driver;
		// verwendet, um die 4 WebElemente der Seite zu initialisieren, die im Rahmen des Page Object Modells definiert wurden
		PageFactory.initElements(driver, this);
	}
	
	// alle
	public void moveAllLogosToBox() {
		Actions actions = new Actions(driver);
		actions.dragAndDrop(whiteElement, dropBox).build().perform();
		actions.dragAndDrop(redElement, dropBox).build().perform();
		actions.dragAndDrop(greenElement, dropBox).build().perform();
		actions.dragAndDrop(blueElement, dropBox).build().perform();
		actions.dragAndDrop(codeLogo, dropBox).build().perform();
	}
	
	
	// Standard Drag and Drop
	public void moveWhiteLogoToBox(){
		Actions actions = new Actions(driver);
		actions.dragAndDrop(whiteElement, dropBox).build().perform();
	}
	public void moveRedLogoToBox(){
		Actions actions = new Actions(driver);
		actions.dragAndDrop(redElement, dropBox).build().perform();
	}
	public void moveGreenLogoToBox(){
		Actions actions = new Actions(driver);
		actions.dragAndDrop(greenElement, dropBox).build().perform();
	}
	public void moveBlueLogoToBox(){
		Actions actions = new Actions(driver);
		actions.dragAndDrop(blueElement, dropBox).build().perform();
	}
	
	
	// Drag and Drog by Offset
	public void moveWhiteLogoToPoint(int x, int y){
		Actions actions = new Actions(driver);
		actions.dragAndDropBy(whiteElement, x, y).build().perform();
	}
	public void moveRedLogoToPoint(int x, int y){
		Actions actions = new Actions(driver);
		actions.dragAndDropBy(redElement, x, y).build().perform();
	}
	public void moveGreenLogoToPoint(int x, int y){
		Actions actions = new Actions(driver);
		actions.dragAndDropBy(greenElement, x, y).build().perform();
	}
	public void moveBlueLogoToPoint(int x, int y){
		Actions actions = new Actions(driver);
		actions.dragAndDropBy(blueElement, x, y).build().perform();
	}
	
	
	// Drag and Drop Manuell
	public void moveWhiteLogoToBoxManuell(){
		Actions actions = new Actions(driver);
		actions.clickAndHold(whiteElement).build().perform();
		actions.moveByOffset(250, 0).perform();
		actions.release(whiteElement).perform();
	}
	public void moveRedLogoToBoxManuell(){
		Actions actions = new Actions(driver);
		actions.clickAndHold(redElement).build().perform();
		actions.moveByOffset(250, 0).perform();
		actions.release(redElement).perform();
	}
	public void moveGreenLogoToBoxManuell(){
		Actions actions = new Actions(driver);
		actions.clickAndHold(greenElement).build().perform();
		actions.moveByOffset(250, 0).perform();
		actions.release(greenElement).perform();
	}
	public void moveBlueLogoToBoxManuell(){
		Actions actions = new Actions(driver);
		actions.clickAndHold(blueElement).build().perform();
		actions.moveByOffset(250, 0).perform();
		actions.release(blueElement).perform();
	}
	
	public String getStatusMeldung() {
		return statusMeldung.getText();
		
	}
}

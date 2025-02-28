package de.selenium.projekt1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SelenuimStartWithFirefox{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Test Begin !!!");
		System.setProperty("webdriver.gecko.driver", 
				"./drivers/geckodriver.exe");
		
		System.out.println("Test 2 !!!");
		// Instance von FirefexDriver erzeugen
		WebDriver driver= new FirefoxDriver(); // Firefox sucht den Wert oben im Verzeichnis
		driver.get("https://www.calculator.net/gas-mileage-calculator.html"); // "https://www.google.com"
		System.out.println(driver.getTitle());
		driver.close();
		driver.quit();
	

	}

}

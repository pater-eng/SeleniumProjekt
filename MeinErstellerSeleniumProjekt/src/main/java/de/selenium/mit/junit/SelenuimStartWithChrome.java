package de.selenium.mit.junit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SelenuimStartWithChrome {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Test Begin !!!");
		System.setProperty("webdriver.chrome.driver", 
				"./drivers/chromedriver.exe");
		
		System.out.println("Test 2 !!!");
		// Instance von FirefexDriver erzeugen
		WebDriver driver= new ChromeDriver(); // Firefox sucht den Wert oben im Verzeichnis
		driver.get("https://www.calculator.net/gas-mileage-calculator.html"); // "https://www.google.com"
		//driver.get("https://codingsolo.de"); 
		System.out.println(driver.getTitle());
	//	driver.close();
	//	driver.quit();

	}

}

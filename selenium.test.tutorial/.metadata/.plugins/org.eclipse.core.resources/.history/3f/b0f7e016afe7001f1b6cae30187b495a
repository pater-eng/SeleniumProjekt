package de.selenium.projekt1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class SelenuimStartWithExplorer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Test Begin !!!");
		System.setProperty("webdriver.ie.driver", 
				"./drivers/IEDriverServer.exe");
		
		System.out.println("Test 2 !!!");
		// Instance von FirefexDriver erzeugen
		WebDriver driver= new InternetExplorerDriver(); // Firefox sucht den Wert oben im Verzeichnis
		driver.get("https://www.calculator.net/gas-mileage-calculator.html"); // "https://www.google.com"
		System.out.println(driver.getTitle());
		driver.close();
		driver.quit();
	}

}

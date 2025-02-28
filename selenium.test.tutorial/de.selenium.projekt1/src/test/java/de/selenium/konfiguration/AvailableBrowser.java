package de.selenium.konfiguration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
/*
 * 
 * @author engoulou
 *	Klasse AvailableBrowser ist ein Java-Enum, 
 *	das verschiedene Browsertypen definiert und für jeden eine Methode zur Erstellung eines entsprechenden WebDriver-Objekts bereitstellt.
 *  Es handelt sich um eine Strategy Design Pattern, das ermöglicht, je nach Bedarf unterschiedliche Browserinstanzen für automatisierte Tests mit Selenium zu erzeugen.
 */
public enum AvailableBrowser {
	/*
	 * Enum-Konstanten: Die Enum enthält drei Konstanten: FIREFOX, CHROME und IE. Jede dieser Konstanten repräsentiert einen unterstützten Browser.
	 */
	FIREFOX {

		@Override
		public WebDriver createDriver() {
			System.setProperty("webdriver.gecko.driver", "./drivers/geckodriver.exe");
			WebDriver driver = new FirefoxDriver();

			return driver;
		}
	},
	CHROME {

		@Override
		public WebDriver createDriver() {
			System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
			WebDriver driver = new ChromeDriver();

			return driver;
		}
	},
	IE {

		@Override
		public WebDriver createDriver() {
			System.setProperty("webdriver.ie.driver", "./drivers/IEDriverServer.exe");
			WebDriver driver = new InternetExplorerDriver();

			return driver;
		}
	};

	/*
	 * Abstrakte Methode createDriver(): Diese Methode muss von jeder Enum-Konstanten implementiert werden und gibt ein WebDriver-Objekt zurück, 
	 * das den jeweiligen Browser steuert.
	 * */
	public abstract WebDriver createDriver();
}


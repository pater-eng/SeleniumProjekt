package de.selenium.konfiguration;

import org.openqa.selenium.WebDriver;

import de.selenium.exception.FehlerTyp;
import de.selenium.exception.MeineException;

public class DriverHelper {

	/*
	 * Die private Methode throwExceptionWhenNull(String browser) prüft, ob der übergebene Browser-String null ist. 
	 * Falls ja, wird eine RuntimeException mit einer entsprechenden Fehlermeldung ausgelöst.
	 * */
	private static void throwExceptionWhenNull(String browser) throws MeineException {
		if (browser == null) {
			//DER_WEBDRIVER_NICHT_VORHANDEN
			throw new MeineException(FehlerTyp.DER_WEBDRIVER_NICHT_VORHANDEN, "Es wurde kein WebDriver angegeben.");
//			throw new RuntimeException("Es wurde kein WebDriver angegeben.");
		}
	}

	/*	Die öffentliche statische Methode getDriver(String browser) übernimmt den Namen des Browsers als String, 
	 * überprüft diesen auf null und erstellt anschließend eine entsprechende WebDriver-Instanz.
	 * */
	public static WebDriver getDriver(String browser) throws MeineException {
		throwExceptionWhenNull(browser);
		// Der Browser-String wird in Großbuchstaben umgewandelt (browser.toUpperCase()) und anschließend in das entsprechende Enum AvailableBrowser konvertiert.
		AvailableBrowser currentBrowser = AvailableBrowser.valueOf(browser.toUpperCase());
		// Über die Methode createDriver() des entsprechenden Enum-Wertes wird eine neue WebDriver-Instanz erstellt
		WebDriver driver = currentBrowser.createDriver();
		return driver;
	}

}

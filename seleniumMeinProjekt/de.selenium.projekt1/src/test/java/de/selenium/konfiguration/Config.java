package de.selenium.konfiguration;

import java.io.InputStream;
import java.util.Properties;

public class Config {
	// Der Name der zu ladenden Properties-Datei, standardmäßig
	private static String configfile = "meinConfig.properties";
	// Ein statisches Properties-Objekt, das die geladenen Konfigurationseinstellungen enthält.
	private static Properties properties = loadProperties();
	/*
	 - Liest den Wert der Eigenschaft baseurl aus der Properties-Datei.
	 - Überprüft, ob der gelesene Wert null ist, und wirft in diesem Fall eine Laufzeitausnahme.
	 - Gibt die gelesene Basis-URL zurück.
	*/
	public static String getBaseUrl() {
		String baseURL = (String) properties.get("baseurl");
		throwExceptionWhenNull("baseURL", baseURL);
		return baseURL;
	}

	/*
	 * - Liest den Wert der angegebenen Browser-Eigenschaft aus der Properties-Datei.
	   - Überprüft, ob der gelesene Wert null ist, und wirft in diesem Fall eine Laufzeitausnahme.
	   - Gibt den gelesenen Browser-Namen zurück.
	*/
	public static String getBrowserName(String browsername) {
		String browser = (String) properties.get(browsername);
		throwExceptionWhenNull(browsername, browser);
		return browser; 
	}
	
	/*
	- Liest den Wert der angegebenen Browser-Treiber-Eigenschaft aus der Properties-Datei.
	- Überprüft, ob der gelesene Wert null ist, und wirft in diesem Fall eine Laufzeitausnahme.
	- Gibt den Pfad zum Browser-Treiber zurück. 
	*/
	public static String getBrowserDriver(String browserdriver) {
		String browserDriver = (String) properties.get(browserdriver);
		throwExceptionWhenNull(browserdriver, browserDriver);
		return browserDriver; 
	}
	
	/*
	- Private Hilfsmethode, die überprüft, ob ein gegebener Parameter null ist.
	- Falls ja, wird eine RuntimeException mit einer entsprechenden Fehlermeldung ausgelöst.
	*/
	private static void throwExceptionWhenNull(String property, String parameter) {
		if(parameter == null) {
			throw new RuntimeException("Parameter: "+property+" nicht in der Konfigurationsdatei gefunden.");
		}
	}
	
	
	/*
	- Private statische Methode, die die Properties-Datei lädt und die enthaltenen Einstellungen in ein Properties-Objekt einliest.
	- Verwendet den Klassenlader, um die Datei als Ressourcenstrom zu öffnen.
	- Falls die Datei nicht gefunden wird oder ein anderer Fehler auftritt, wird eine RuntimeException ausgelöst.
	*/
	@SuppressWarnings("static-access")
	private static Properties loadProperties() {
		
		try {
			ClassLoader loader = Thread.currentThread().getContextClassLoader();
			
			Properties props = new Properties();
			InputStream is = loader.getSystemResourceAsStream(configfile);
			props.load(is);
			return props;
			
		}catch(Exception e) {
			throw new RuntimeException("keine Konfigurationsdatei gefunden", e);
		}
	}
}

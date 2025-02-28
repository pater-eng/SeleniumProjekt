package de.selenium.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import de.selenium.auto.Auto;

class TestfallAuto {
	
	Auto vw;
	
	@BeforeEach
	void initTest() {
		System.out.println("Testfall wird initialisiert.");
		// Initialisierung und Auslagerung der Daten
		 vw = new Auto(1500, 1000, 50);
	}
	
	@AfterEach
	void endTests() {
		System.out.println("Testfall beendet.");	
		
	}
	
	@Test
	void testBerechnung() {
		System.out.println("Testfall wird berechnet.");	
		// asserEquals prüft, dass das Erwartete Ergebnis 10.0 gleich die vw.berechnberechneBenzinVerbrauch() ist
		assertEquals(10.0, vw.berechneBenzinVerbrauch());
		vw.setLiter(400);
	}
	
	@Test
	void testBenzinMenge() {
		System.out.println("Menge wird berechnet.");	
		// asserEquals prüft, dass das Erwartete Ergebnis 10.0 gleich die vw.berechnberechneBenzinVerbrauch() ist
		assertEquals(50, vw.getLiter());
	}

}

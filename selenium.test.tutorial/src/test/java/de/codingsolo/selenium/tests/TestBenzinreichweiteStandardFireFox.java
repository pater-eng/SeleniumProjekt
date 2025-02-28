package de.codingsolo.selenium.tests;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import de.codingsolo.selenium.pages.BenzinReichweiteBerechnungPage;

@RunWith(Parameterized.class)
public class TestBenzinreichweiteStandardFireFox {

	WebDriver driver;

	String kilometerstandAktuell;
	String kilometerstandBevor;
	String benzinmenge;
	String benzinPreis;
	String reichweite;

	public TestBenzinreichweiteStandardFireFox(String testName, String kilometerstandAktuell,
			String kilometerstandBevor, String benzinmenge, String benzinPreis, String reichweite) {
		super();

		this.kilometerstandAktuell = kilometerstandAktuell;
		this.kilometerstandBevor = kilometerstandBevor;
		this.benzinmenge = benzinmenge;
		this.benzinPreis = benzinPreis;
		this.reichweite = reichweite;
	}

	@Before
	public void beforeCalculationTest() throws Exception {
		System.out.println("Vor dem Benzinreichweite Berechnung Test");

		System.setProperty("webdriver.gecko.driver", "./drivers/firefox/geckodriver.exe");

		driver = new FirefoxDriver();
		driver.manage().window().fullscreen();
		driver.get("http://localhost:8080/calculator");
	}

	@After
	public void afterCalclulationTest() throws Exception {
		System.out.println("Nach dem Benzinreichweite Berechnung Test");
//		driver.close();
		driver.quit();
	}

	@Test
	public void testCalculationTest() throws Exception {
		System.out.println("Test der Benzinreichweite Berechnung");
		
		Thread.sleep(5000);

		// ARRANGE
		BenzinReichweiteBerechnungPage BenzinReichweitePage = new BenzinReichweiteBerechnungPage(driver);
		BenzinReichweitePage.setKilometerstandAktuell(this.kilometerstandAktuell);
		Thread.sleep(2000);
		BenzinReichweitePage.setKilometerstandBevor(this.kilometerstandBevor);
		Thread.sleep(2000);
		BenzinReichweitePage.setBenzinmenge(this.benzinmenge);
		Thread.sleep(2000);
		BenzinReichweitePage.setBenzinPreis(this.benzinPreis);

		// ACT
		Thread.sleep(4000);
		BenzinReichweitePage.executeCalculation();

		// ASSERT
		Thread.sleep(4000);
		String result = BenzinReichweitePage.getResult();
		System.out.println(result);

		assertThat(result).contains(this.reichweite);

	}

	@Parameters(name = "{0}")
	public static Collection<Object[]> provideTestData() throws Exception {

		Collection<Object[]> collection;

		Object[][] daten = {
				{ "Benzinreichweiten-Rechner Test - FireFox", "1500", "1000", "50", "1.40", "Reichweite: 10 km/L" } };
		List<Object[]> listObjects = Arrays.asList(daten);
		collection = new ArrayList<Object[]>(listObjects);

		return collection;
	}

}

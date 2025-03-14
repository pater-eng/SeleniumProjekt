package de.selenium.auto;

public class Auto {

	private int kilometerStandAktuell;
	private int kilometerStandBevor;
	private double liter;

	
	public Auto(int kilometerStandAktuell, int kilometerStandBevor, double liter) {
		this.kilometerStandAktuell = kilometerStandAktuell;
		this.kilometerStandBevor = kilometerStandBevor;
		this.liter = liter;
		
		
	}
	
	public double berechneBenzinVerbrauch() {
		return (kilometerStandAktuell- kilometerStandBevor)/liter;
				
	}
	
	public static String getEinheit() {
		return "kilometer";
		
		
	}
	public int getKilometerStandAktuell() {
		return kilometerStandAktuell;
	}

	public void setKilometerStandAktuell(int kilometerStandAktuell) {
		this.kilometerStandAktuell = kilometerStandAktuell;
	}

	public int getKilometerStandBevor() {
		return kilometerStandBevor;
	}

	public void setKilometerStandBevor(int kilometerStandBevor) {
		this.kilometerStandBevor = kilometerStandBevor;
	}

	public double getLiter() {
		return liter;
	}

	public void setLiter(double liter) {
		this.liter = liter;
	}
}

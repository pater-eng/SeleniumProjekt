package de.selenium.auto;

public class Demo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int zahl1 = 3;
		int zahl2 = 8;
		
		Auto vw = new Auto(1500, 1000, 50);
		vw.setKilometerStandAktuell(1950);
		System.out.println("Benzinverbrauch: "+vw.berechneBenzinVerbrauch());
		System.out.println("Einheit: "+Auto.getEinheit());

	}

}

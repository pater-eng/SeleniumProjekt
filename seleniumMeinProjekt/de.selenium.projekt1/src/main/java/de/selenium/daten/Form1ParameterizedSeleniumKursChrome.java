package de.selenium.daten;

import java.util.Arrays;

public class Form1ParameterizedSeleniumKursChrome {


	private String testName;
	private String browsername;
	private String username;
	private String password;
	private String betreff;
	private String name;
	private String kursTitel;
	private int[] firmenBox1;
	private int[] firmenBox2;
	private String assert1;
	private String assert2;

	public Form1ParameterizedSeleniumKursChrome(String testName, String browsername, String username, String password, String betreff,
			String name, String kursTitel, int[] firmenBox1, int[] firmenBox2, String assert1, String assert2) {
		
		this.testName = testName;
		this.browsername = browsername;
		this.username = username;
		this.password = password;
		this.betreff = betreff;
		this.name = name;
		this.kursTitel = kursTitel;
		this.firmenBox1 = firmenBox1;
		this.firmenBox2 = firmenBox2;
		this.assert1 = assert1;
		this.assert2 = assert2;
	}
	
	

	public Form1ParameterizedSeleniumKursChrome() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getTestName() {
		return testName;
	}

	public void setTestName(String testName) {
		this.testName = testName;
	}

	public String getBrowsername() {
		return browsername;
	}

	public void setBrowsername(String browsername) {
		this.browsername = browsername;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getBetreff() {
		return betreff;
	}

	public void setBetreff(String betreff) {
		this.betreff = betreff;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getKursTitel() {
		return kursTitel;
	}

	public void setKursTitel(String kursTitel) {
		this.kursTitel = kursTitel;
	}

	public int[] getFirmenBox1() {
		return firmenBox1;
	}

	public void setFirmenBox1(int[] firmenBox1) {
		this.firmenBox1 = firmenBox1;
	}

	public int[] getFirmenBox2() {
		return firmenBox2;
	}

	public void setFirmenBox2(int[] firmenBox2) {
		this.firmenBox2 = firmenBox2;
	}

	public String getAssert1() {
		return assert1;
	}

	public void setAssert1(String assert1) {
		this.assert1 = assert1;
	}

	public String getAssert2() {
		return assert2;
	}

	public void setAssert2(String assert2) {
		this.assert2 = assert2;
	}



	@Override
	public String toString() {
		return "Form1ParameterizedSeleniumKursChrome [testName=" + testName + ", browsername=" + browsername
				+ ", username=" + username + ", password=" + password + ", betreff=" + betreff + ", name=" + name
				+ ", kursTitel=" + kursTitel + ", firmenBox1=" + Arrays.toString(firmenBox1) + ", firmenBox2="
				+ Arrays.toString(firmenBox2) + ", assert1=" + assert1 + ", assert2=" + assert2 + "]";
	}

}

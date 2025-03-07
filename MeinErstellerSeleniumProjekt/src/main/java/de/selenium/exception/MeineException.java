package de.selenium.exception;

//Benutzerdefinierte Ausnahme, die den Fehlertyp verwendet
public class MeineException extends Exception {
	private final FehlerTyp fehlerTyp;

	public MeineException(FehlerTyp fehlerTyp, String nachricht) {
		super(nachricht);
		this.fehlerTyp = fehlerTyp;
	}

	public FehlerTyp getFehlerTyp() {
		return fehlerTyp;
	}
}
/*	
 * Beispielprojekt / Wirkungsabschätzung
 * Sommersemester 2017
 */

package de.unistuttgart.iwb.lci;

/**
 * @author Dr.-Ing. Joachim Schwarte
 * @version 0.910
 */

public class CharakterFaktor {
	
	// Diese Klasse besitzt keine Klassenvariablen
	
	// Instanzvariablen:
	
	private String name;
	private Fluss fluss;
	private Wirkungskategorie wirkung;
	private Double wert;
	
	// Konstruktor basierend auf den Instanzvariablen:
	
	public CharakterFaktor(String name, Fluss fluss, Wirkungskategorie wirkung, Double wert) {
		super();
		this.name = name;
		this.fluss = fluss;
		this.wirkung = wirkung;
		this.wert = wert;
	}
	
	// Methoden (Getter für die Instanzvariablen):

	public String getName() {
		return name;
	}

	public Fluss getFluss() {
		return fluss;
	}

	public Wirkungskategorie getWirkung() {
		return wirkung;
	}

	public Double getWert() {
		return wert;
	}	

}

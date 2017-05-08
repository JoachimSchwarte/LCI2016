/*	
 * Beispielprojekt / Wirkungsabschätzung
 * Sommersemester 2017
 */

package de.unistuttgart.iwb.lci;

/**
 * @author Dr.-Ing. Joachim Schwarte
 * @version 0.910
 */

public class Wirkungskategorie {
	
	// Diese Klasse besitzt keine Klassenvariablen
	
	// Instanzvariablen:
	
	private String name;
	private Wirkungsindikator einheit;
	
	// Konstruktor basierend auf den Instanzvariablen:
	
	public Wirkungskategorie(String name, Wirkungsindikator einheit) {
		super();
		this.name = name;
		this.einheit = einheit;
	}
	
	// Methoden (Getter für die Instanzvariablen):

	public String getName() {
		return name;
	}

	public Wirkungsindikator getEinheit() {
		return einheit;
	}

}

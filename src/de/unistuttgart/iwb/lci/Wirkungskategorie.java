/*	
 * Beispielprojekt / Wirkungsabschätzung
 * Sommersemester 2017
 */

package de.unistuttgart.iwb.lci;

/**
 * Diese Klasse dient zur Erzeugung von Objekten, die
 * Wirkungskategorien repräsentieren.
 * 
 * @author Dr.-Ing. Joachim Schwarte
 * @version 0.924
 */

public class Wirkungskategorie {
	
	// Diese Klasse besitzt keine Klassenvariablen
	
	// Instanzvariablen:
	
	private String name;
	private Wirkungsindikator einheit;
	
	// Konstruktor basierend auf den Instanzvariablen:
	
	/**
	 * Der zweiparametrige Konstruktor erzeugt ein 
	 * vollständiges Objekt Klasse Wirkungskategorie.
	 * @param name
	 * kann frei gewählt werden.
	 * Auf Anwendungsebene ist Namenseindeutigkeit anzustreben. 
	 * @param einheit
	 * legt die Einheit fest, in der die Wirkungskategorie
	 * quantifiziert wird.
	 */
	
	public Wirkungskategorie(String name, Wirkungsindikator einheit) {
		super();
		this.name = name;
		this.einheit = einheit;
	}
	
	// Methoden (Getter für die Instanzvariablen):

	/**
	 * @return
	 * ... den Namen der Wirkungskategorie.
	 */
	
	public String getName() {
		return name;
	}
	
	/**
	 * @return
	 * ... die Einheit, in der die Wirkungskategorie
	 * quantifiziert wird.
	 */

	public Wirkungsindikator getEinheit() {
		return einheit;
	}
}

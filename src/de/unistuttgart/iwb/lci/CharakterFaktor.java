/*	
 * Beispielprojekt / Wirkungsabschätzung
 * Sommersemester 2017
 */

package de.unistuttgart.iwb.lci;

/**
 * Diese Klasse dient zur Erzeugung von Objekten, die
 * Charakterisierungsfaktoren repräsentieren.
 * Durch diese Objekte wird der quantitative Zusammenhang
 * zwischen Flüssen und Wirkungskategorien hergestellt.
 * 
 * @author Dr.-Ing. Joachim Schwarte
 * @version 0.924
 */

public class CharakterFaktor {
	
	// Diese Klasse besitzt keine Klassenvariablen
	
	// Instanzvariablen:
	
	private String name;
	private Fluss fluss;
	private Wirkungskategorie wirkung;
	private Double wert;
	
	// Konstruktor:
	
	/**
	 * Der vierparametrige Konstruktor erzeugt ein 
	 * vollständiges CharakterFaktor-Objekt.
	 * @param name
	 * kann frei gewählt werden.
	 * Auf Anwendungsebene ist Namenseindeutigkeit anzustreben. 
	 * @param fluss
	 * ist ein Objekt der Klasse Fluss.
	 * @param wirkung
	 * ist ein Objekt der Klasse Wirkungskategorie.
	 * @param wert
	 * quantifiziert die Wirkung des Flusses bzgl. der angegebenen
	 * Kategorie.
	 */
	
	public CharakterFaktor(String name, Fluss fluss, Wirkungskategorie wirkung, Double wert) {
		super();
		this.name = name;
		this.fluss = fluss;
		this.wirkung = wirkung;
		this.wert = wert;
	}
	
	// Methoden (Getter für die Instanzvariablen):
	
	/**
	 * @return
	 * ... den Namen des CharakterFaktor-Objekts.
	 */

	public String getName() {
		return name;
	}
	
	/**
	 * @return
	 * ... das Flussobjekt.
	 */

	public Fluss getFluss() {
		return fluss;
	}
	
	/**
	 * @return
	 * ... die Wirkungskategorie.
	 */

	public Wirkungskategorie getWirkung() {
		return wirkung;
	}
	
	/**
	 * @return
	 * ... den Zahlenwert der Wirkung des Flusses bzgl. der 
	 * angegebenen Kategorie.
	 */

	public Double getWert() {
		return wert;
	}	

}

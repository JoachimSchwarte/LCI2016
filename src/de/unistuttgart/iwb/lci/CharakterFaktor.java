/*	
 * Beispielprojekt / Wirkungsabsch�tzung
 * Sommersemester 2017
 */

package de.unistuttgart.iwb.lci;

import java.util.HashMap;

/**
 * Diese Klasse dient zur Erzeugung von Objekten, die
 * Charakterisierungsfaktoren repr�sentieren.
 * Durch diese Objekte wird der quantitative Zusammenhang
 * zwischen Fl�ssen und Wirkungskategorien hergestellt.
 * 
 * @author Dr.-Ing. Joachim Schwarte
 * @version 0.935
 */

public class CharakterFaktor {
	
	// Klassenvariable:
	
	private static HashMap<String, CharakterFaktor> allInstances = new HashMap<String, CharakterFaktor>();
	
	// Instanzvariablen:
	
	private String name;
	private Fluss fluss;
	private Wirkungskategorie wirkung;
	private Double wert;
	
	// Konstruktor:

	private CharakterFaktor(String name, Fluss fluss, Wirkungskategorie wirkung, Double wert) {
		super();
		this.name = name;
		this.fluss = fluss;
		this.wirkung = wirkung;
		this.wert = wert;
		allInstances.put(name, this);
	}
	
	// Methoden:
	
	/**
	 * L�scht alle Klassenvariablen
	 */
	
	public static void clear() {
		allInstances.clear();
	}
	
	/**
	 * �berpr�ft, ob bereits ein Charakterisierungsfaktor
	 * des gegebenen Namens existiert.
	 * @param string
	 * ist der zu pr�fende Name
	 * @return
	 * ... den Wahrheitswert, den die �berpr�fung liefert
	 */
	
	public static boolean containsName(String string) {
		return allInstances.containsKey(string);
	}
	
	/**
	 * @return
	 * ... alle vorhandenen Charakterisierungsfaktoren
	 */
	
	public static HashMap<String, CharakterFaktor> getAllInstances() {
		return allInstances;
	}
	
	/**
	 * Liefert einen Charakterisierungsfaktor zur�ck
	 * @param string
	 * Name des gew�nschten Charakterisierungsfaktors
	 * @return
	 * ... den gesuchten Charakterisierungsfaktor
	 */
	
	public static CharakterFaktor getInstance(String string) {
		return allInstances.get(string);
	}
	
	/**
	 * Erzeugt einen neuen Charakterisierungsfaktor
	 * @param name
	 * kann frei gew�hlt werden.
	 * @param fluss
	 * ist ein Objekt der Klasse Fluss.
	 * @param wirkung
	 * ist ein Objekt der Klasse Wirkungskategorie.
	 * @param wert
	 * quantifiziert die Wirkung des Flusses bzgl. der angegebenen
	 * Kategorie.
	 * @return
	 * ... den Charakterisierungsvektor
	 */
	
	public static CharakterFaktor instance(String name, Fluss fluss, Wirkungskategorie wirkung, Double wert) {
		return new CharakterFaktor(name, fluss, wirkung, wert);
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
	 * ... den Namen des CharakterFaktor-Objekts.
	 */

	public String getName() {
		return name;
	}
	
	/**
	 * @return
	 * ... den Zahlenwert der Wirkung des Flusses bzgl. der 
	 * angegebenen Kategorie.
	 */

	public Double getWert() {
		return wert;
	}

	/**
	 * @return
	 * ... die Wirkungskategorie.
	 */

	public Wirkungskategorie getWirkung() {
		return wirkung;
	}
}

/*	
 * Beispielprojekt / Wirkungsabsch�tzung
 * Sommersemester 2017
 */

package de.unistuttgart.iwb.lci;

import java.util.HashSet;

/**
 * Diese Klasse dient zur Erzeugung von Objekten, die
 * Wirkungskategorien repr�sentieren.
 * 
 * @author Dr.-Ing. Joachim Schwarte
 * @version 0.926
 */

public class Wirkungskategorie {
	
	// Klassenvariable:
	
	private static HashSet<String> allNames = new HashSet<String>();
	
	// Instanzvariablen:
	
	private String name;
	private Wirkungsindikator einheit;
	
	// Konstruktor basierend auf den Instanzvariablen:
	
	/**
	 * Der zweiparametrige Konstruktor erzeugt ein 
	 * vollst�ndiges Objekt Klasse Wirkungskategorie.
	 * @param name
	 * kann frei gew�hlt werden.
	 * Auf Anwendungsebene ist Namenseindeutigkeit anzustreben. 
	 * @param einheit
	 * legt die Einheit fest, in der die Wirkungskategorie
	 * quantifiziert wird.
	 */
	
	public Wirkungskategorie(String name, Wirkungsindikator einheit) {
		super();
		this.name = name;
		this.einheit = einheit;
		allNames.add(name);
	}
	
	// Methoden (Getter f�r die Instanzvariablen):

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
	
	/**
	 * �berpr�ft, ob bereits eine Wirkungskategorie
	 * des gegebenen Namens existiert.
	 * @param string
	 * ist der zu pr�fende Name
	 * @return
	 * ... den Wahrheitswert, den die �berpr�fung liefert
	 */
	
	public static boolean containsName(String string) {
		return allNames.contains(string);
	}
}

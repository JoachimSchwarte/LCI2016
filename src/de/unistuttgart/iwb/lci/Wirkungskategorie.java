/*	
 * Beispielprojekt / Wirkungsabschätzung
 * Sommersemester 2017
 */

package de.unistuttgart.iwb.lci;

import java.util.HashMap;

/**
 * Diese Klasse dient zur Erzeugung von Objekten, die
 * Wirkungskategorien repräsentieren.
 * 
 * @author Dr.-Ing. Joachim Schwarte
 * @version 0.93
 */

public class Wirkungskategorie {
	
	// Klassenvariable:
	
	private static HashMap<String, Wirkungskategorie> allInstances = new HashMap<String, Wirkungskategorie>();
	
	// Instanzvariablen:
	
	private String name;
	private Wirkungsindikator einheit;
	
	// Konstruktor basierend auf den Instanzvariablen:
	
	private Wirkungskategorie(String name, Wirkungsindikator einheit) {
		super();
		this.name = name;
		this.einheit = einheit;
		allInstances.put(name, this);
	}
	
	// Methoden (Getter für die Instanzvariablen):
	
	/**
	 * Erzeugt eine neue Wirkungskategorie.
	 * @param name
	 * der Name der neuen Wirkungskategorie.
	 * @param einheit
	 * legt die Einheit fest, in der die Wirkungskategorie
	 * quantifiziert wird.
	 * @return
	 * ... die neue Wirkungskategorie
	 */
	
	public static Wirkungskategorie instance(String name, Wirkungsindikator einheit) {
		Wirkungskategorie wk = new Wirkungskategorie(name, einheit);
		return wk;	
	}

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
	 * Überprüft, ob bereits eine Wirkungskategorie
	 * des gegebenen Namens existiert.
	 * @param string
	 * ist der zu prüfende Name
	 * @return
	 * ... den Wahrheitswert, den die Überprüfung liefert
	 */
	
	public static boolean containsName(String string) {
		return allInstances.keySet().contains(string);
	}
	
	/**
	 * Löscht alle Klassenvariablen
	 */
	
	public static void clear() {
		allInstances.clear();
	}
	
	public static HashMap<String, Wirkungskategorie> getAllInstances() {
		return allInstances;
	}
}

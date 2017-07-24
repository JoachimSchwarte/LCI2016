/*	
 * Beispielprojekt / Wirkungsabschätzung
 * Sommersemester 2017
 */

package de.unistuttgart.iwb.lci;

import java.util.HashSet;

/**
 * Diese Klasse dient zur Erzeugung von Objekten, die
 * Bewertungsmethoden repräsentieren.
 * Objekte dieser Art fassen alle Charakterisierungfaktoren,
 * die zu einer Bewertungsmethode gehören, zusammen.
 * 
 * @author Dr.-Ing. Joachim Schwarte
 * @version 0.926
 */

public class Bewertungsmethode {
	
	// Klassenvariable:
	
	private static HashSet<String> allNames = new HashSet<String>();
	
	// Instanzvariablen:
	
	private String name;
	private HashSet<CharakterFaktor> faktorSet = 
			new HashSet<CharakterFaktor>();
	private HashSet<Wirkungskategorie> wkl = 
			new HashSet<Wirkungskategorie>();
	
	// Konstruktor:
	
	/**
	 * Der einparametrige Konstruktor erzeugt eine benannte 
	 * Bewertungsmethode, die noch keine Charakterisierungsfaktoren
	 * beinhaltet.
	 * @param name
	 * ist der Name der neuen Bewertungsmethode.
	 */

	public Bewertungsmethode(String name) {
		super();
		this.name = name;
		allNames.add(name);
	}
	
	// Methoden:
	
	/**
	 * @return
	 * ... den Namen des Bewertungsmethode.
	 */
	
	public String getName() {
		return name;
	}
	
	/**
	 * Fügt der Bewertungsmethode einen weiteren
	 * Charakterisierungsfaktor hinzu.
	 * @param cv
	 * Der Charakterisierungsfaktor, der der Bewertungsmethode 
	 * hinzugefügt werden soll
	 */
	
	public void addFaktor(CharakterFaktor cv) {
		faktorSet.add(cv);
		wkl.add(cv.getWirkung());
	}
	
	/**
	 * Fügt der Liste der Wirkungskategorien einen Eintrag
	 * hinzu.
	 * @param wk
	 * Die Wirkungskategorie, die der Liste hinzugefügt werden 
	 * soll.
	 */
	
	public void addWK(Wirkungskategorie wk) {
		wkl.add(wk);
	}
	
	/**
	 * @return
	 * ... Liste derjenigen Wirkungskategorien, denen durch die
	 * vorhandenen Charakterisierungsfaktoren Flüsse quantifiziert
	 * zugeordnet sind oder die durch Verwendung der Methode
	 * addWK(...) explizit der Liste hinzugefügt wurden.
	 */
	
	public HashSet<Wirkungskategorie> kategorieListe() {	
		return wkl;
	}
	
	/**
	 * @return
	 * ... Liste aller vorhandenen Charakterisierungsfaktoren
	 */
	
	public HashSet<CharakterFaktor> getFaktorSet() {
		return faktorSet;
	}
	
	/**
	 * Überprüft, ob bereits eine Bewertungsmethode
	 * des genannten Namens existiert.
	 * @param string
	 * ist der zu prüfende Name
	 * @return
	 * ... den Wahrheitswert, den die Überprüfung liefert
	 */
	
	public static boolean constainsName(String string) {
		return allNames.contains(string);
	}
}

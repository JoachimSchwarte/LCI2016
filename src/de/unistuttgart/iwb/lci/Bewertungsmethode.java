/*	
 * Beispielprojekt / Wirkungsabsch�tzung
 * Sommersemester 2017
 */

package de.unistuttgart.iwb.lci;

import java.util.HashMap;

/**
 * Diese Klasse dient zur Erzeugung und
 * Verwaltung von Objekten, die
 * Bewertungsmethoden repr�sentieren.
 * Objekte dieser Art fassen alle Charakterisierungfaktoren,
 * die zu einer Bewertungsmethode geh�ren, zusammen.
 * 
 * @author Dr.-Ing. Joachim Schwarte
 * @version 0.926
 */

public class Bewertungsmethode {
	
	// Klassenvariable:
	
	private static HashMap<String, Bewertungsmethode> allBWs = new HashMap<String, Bewertungsmethode>();
	
	// Instanzvariablen:
	
	private String name;
	private HashMap<String, CharakterFaktor> faktorSet = 
			new HashMap<String, CharakterFaktor>();
	private HashMap<String, Wirkungskategorie> wkl = 
			new HashMap<String, Wirkungskategorie>();

	// Konstruktor:
	
	private Bewertungsmethode(String name) {
		super();
		this.name = name;
		allBWs.put(name, this);
	}
	
	// Methoden:
	
	/**
	 * Die instance-Methode erzeugt unter Verwendung des
	 * privaten Konstruktors eine neue Bewertungsmethode
	 * oder gibt eine bereits existierende Bewertungsmethode
	 * zur�ck.
	 * @param name
	 * ist der Name der Bewertungsmethode.
	 * @return
	 * ... neue oder bereits zuvor existierende
	 * Bewertungsmethode
	 */
	
	public static Bewertungsmethode instance(String name) {
		if (allBWs.containsKey(name) == false) {
			new Bewertungsmethode(name);
		} 
		return allBWs.get(name);
	}
	
	/**
	 * @return
	 * ... den Namen der Bewertugsmethode
	 */
	
	public String getName() {
		return name;
	}
	
	/**
	 * F�gt der Bewertungsmethode einen weiteren
	 * Charakterisierungsfaktor hinzu.
	 * @param cv
	 * Der Charakterisierungsfaktor, der der Bewertungsmethode 
	 * hinzugef�gt werden soll
	 */
	
	public void addFaktor(CharakterFaktor cv) {
		faktorSet.put(cv.getName(), cv);
		wkl.put(cv.getWirkung().getName(), cv.getWirkung());	
	}
	
	/**
	 * F�gt der Liste der Wirkungskategorien einen Eintrag
	 * hinzu.
	 * @param wk
	 * Die Wirkungskategorie, die der Liste hinzugef�gt werden 
	 * soll.
	 */
	
	public void addWK(Wirkungskategorie wk) {
		wkl.put(wk.getName(), wk);
	}	
	
	/**
	 * @return
	 * ... Liste derjenigen Wirkungskategorien, denen durch die
	 * vorhandenen Charakterisierungsfaktoren Fl�sse quantifiziert
	 * zugeordnet sind oder die durch Verwendung der Methode
	 * addWK(...) explizit der Liste hinzugef�gt wurden.
	 */
	
	public HashMap<String, Wirkungskategorie> kategorieListe() {	
		return wkl;
	}
	
	/**
	 * @return
	 * ... Liste aller vorhandenen Charakterisierungsfaktoren
	 */
	
	public HashMap<String, CharakterFaktor> getFaktorSet() {
		return faktorSet;
	}
	
	/**
	 * �berpr�ft, ob bereits eine Bewertungsmethode
	 * des genannten Namens existiert.
	 * @param string
	 * ist der zu pr�fende Name
	 * @return
	 * ... den Wahrheitswert, den die �berpr�fung liefert
	 */
	
	public static boolean containsName(String string) {
		return allBWs.containsKey(string);
	}
	
	/**
	 * @return
	 * ... alle vorhandenen Bewertungsmethoden
	 */
	 
	public static HashMap<String, Bewertungsmethode> getAllBWs() {
		return allBWs;
	}
}

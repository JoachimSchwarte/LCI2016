/*	
 * Beispielprojekt / Wirkungsabsch�tzung
 * Sommersemester 2017
 */

package de.unistuttgart.iwb.lci;

import java.util.HashSet;
import java.util.LinkedList;

/**
 * Diese Klasse dient zur Erzeugung von Objekten, die
 * Bewertungsmethoden repr�sentieren.
 * Objekte dieser Art fassen alle Charakterisierungfaktoren,
 * die zu einer Bewertungsmethode geh�ren, zusammen.
 * 
 * @author Dr.-Ing. Joachim Schwarte
 * @version 0.925
 */

public class Bewertungsmethode {
	
	// Diese Klasse besitzt keine Klassenvariablen
	
	// Instanzvariablen:
	
	private String name;
	private LinkedList<CharakterFaktor> faktorSet = 
			new LinkedList<CharakterFaktor>();
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
	 * F�gt der Bewertungsmethode einen weiteren
	 * Charakterisierungsfaktor hinzu.
	 * @param cv
	 * Der Charakterisierungsfaktor, der der Bewertungsmethode 
	 * hinzugef�gt werden soll
	 */
	
	public void addFaktor(CharakterFaktor cv) {
		faktorSet.add(cv);
		wkl.add(cv.getWirkung());
	}
	
	/**
	 * F�gt der Liste der Wirkungskategorien einen Eintrag
	 * hinzu.
	 * @param wk
	 * Die Wirkungskategorie, die der Liste hinzugef�gt werden 
	 * soll.
	 */
	
	public void addWK(Wirkungskategorie wk) {
		wkl.add(wk);
	}
	
	/**
	 * @return
	 * ... Liste derjenigen Wirkungskategorien, denen durch die
	 * vorhandenen Charakterisierungsfaktoren Fl�sse quantifiziert
	 * zugeordnet sind oder die durch Verwendung der Methode
	 * addWK(...) explizit der Liste hinzugef�gt wurden.
	 */
	
	public HashSet<Wirkungskategorie> kategorieListe() {	
		return wkl;
	}
	
	/**
	 * @return
	 * ... Liste aller vorhandenen Charakterisierungsfaktoren
	 */
	
	public LinkedList<CharakterFaktor> getFaktorSet() {
		return faktorSet;
	}

}

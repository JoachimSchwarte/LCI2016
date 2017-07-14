/*	
 * Beispielprojekt / Wirkungsabschätzung
 * Sommersemester 2017
 */

package de.unistuttgart.iwb.lci;

import java.util.HashSet;
import java.util.LinkedList;

/**
 * Diese Klasse dient zur Erzeugung von Objekten, die
 * Bewertungsmethoden repräsentieren.
 * Objekte dieser Art fassen alle Charakterisierungfaktoren,
 * die zu einer Bewertungsmethode gehören, zusammen.
 * 
 * @author Dr.-Ing. Joachim Schwarte
 * @version 0.924
 */

public class Bewertungsmethode {
	
	// Diese Klasse besitzt keine Klassenvariablen
	
	// Instanzvariablen:
	
	private String name;
	private LinkedList<CharakterFaktor> faktorSet 
	= new LinkedList<CharakterFaktor>();
	
	// Konstruktor:
	
	/**
	 * Der einparametrige Konstruktor erzeugt ein benannte 
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
	 * Fügt der Bewertungsmethode einen weiteren
	 * Charakterisierungsfaktor hinzu.
	 * @param cv
	 * Der Charakterisierungsfaktor, der der Bewertungsmethode 
	 * hinzugefügt werden soll
	 */
	
	public void addFaktor(CharakterFaktor cv) {
		faktorSet.add(cv);
	}
	
	/**
	 * @return
	 * ... Liste derjenigen Wirkungskategorien, denen durch die
	 * vorhandenen Charakterisierungsfaktoren Flüsse quantifiziert
	 * zugeordnet sind.
	 */
	
	public HashSet<Wirkungskategorie> kategorieListe() {
		HashSet<Wirkungskategorie> kl = new HashSet<Wirkungskategorie>();
		for (CharakterFaktor cvl : faktorSet) {
			kl.add(cvl.getWirkung());		
		}		
		return kl;
	}
	
	/**
	 * @return
	 * ... Liste aller vorhandenen Charakterisierungsfaktoren
	 */
	
	public LinkedList<CharakterFaktor> getFaktorSet() {
		return faktorSet;
	}

}

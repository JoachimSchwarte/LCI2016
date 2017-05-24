/*	
 * Beispielprojekt / Wirkungsabschätzung
 * Sommersemester 2017
 */

package de.unistuttgart.iwb.lci;

import java.util.HashSet;
import java.util.LinkedList;

/**
 * @author Dr.-Ing. Joachim Schwarte
 * @version 0.912
 */

public class Bewertungsmethode {
	
	// Diese Klasse besitzt keine Klassenvariablen
	
	// Instanzvariablen:
	
	private String name;
	private LinkedList<CharakterFaktor> faktorSet 
	= new LinkedList<CharakterFaktor>();
	
	// Konstruktor:

	public Bewertungsmethode(String name) {
		super();
		this.name = name;
	}
	
	// Methoden:
	
	public String getName() {
		return name;
	}
	
	public void addFaktor(CharakterFaktor cv) {
		faktorSet.add(cv);
	}
	
	public HashSet<Wirkungskategorie> kategorieListe() {
		HashSet<Wirkungskategorie> kl = new HashSet<Wirkungskategorie>();
		for (CharakterFaktor cvl : faktorSet) {
			kl.add(cvl.getWirkung());		
		}		
		return kl;
	}
	
	public LinkedList<CharakterFaktor> getFaktorSet() {
		return faktorSet;
	}

}

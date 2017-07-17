/*	
 * Beispielprojekt 
 * Sommersemester 2017
 */

package de.unistuttgart.iwb.lci;
import java.util.HashMap;
import java.util.LinkedList;

/**
 * Diese Klasse dient zur Erzeugung von Produktkompositionen.
 * 
 * @author Dr.-Ing. Joachim Schwarte
 * @version 0.924
 */

public class Produktkomposition implements Wirkungsvektor {
	
	// Diese Klasse besitzt keine Klassenvariablen
	
	// Instanzvariablen:
	
	private String name;
	private LinkedList<Wirkungsvektor> zusammensetzung 
			= new LinkedList<Wirkungsvektor>();
	
	// Konstruktor:
	
	/**
	 * Der einparametrige Konstruktor erzeugt eine benanntes 
	 * Produktkomposition, die noch keine Komponenten
	 * enthält.
	 * @param name
	 * ist der Name der Produktkomposition.
	 */
	
	public Produktkomposition(String name) {
		super();
		this.name = name;
	}
	
	// Methoden:
	
	/**
	 * @return
	 * ... den Namen der Produktpomposition.
	 */
	
	public String getName() {
		return name;
	}
	
	/**
	 * Ergänzt die Produktkomposition um eine weitere
	 * Komponente. 
	 * @param teilprodukt
	 * ... ist die zu ergänzende Komponente. Dies kann
	 * ein beliebiges Objekt einer Klasse, die das Interface
	 * Wirkungsvektor implementiert, sein.
	 */
	
	public void addKomponente(Wirkungsvektor teilprodukt) {
		zusammensetzung.add(teilprodukt);
	}

	@Override
	public HashMap<Wirkungskategorie, Double> getWirkungsvektor(Bewertungsmethode bm) {
		HashMap<Wirkungskategorie, Double> wv =
				new HashMap<Wirkungskategorie, Double>();
		for (Wirkungskategorie wk : bm.kategorieListe()){
			wv.put(wk, 0.);
		}
		for (Wirkungsvektor wvKomponente : zusammensetzung){
			for (Wirkungskategorie kategorie : wvKomponente.getWirkungsvektor(bm).keySet()){
				wv.put(kategorie, wv.get(kategorie) + wvKomponente.getWirkungsvektor(bm).get(kategorie));
			}
		}
		return wv;
	}
}

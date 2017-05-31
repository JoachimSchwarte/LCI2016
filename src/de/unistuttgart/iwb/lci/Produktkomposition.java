/*	
 * Beispielprojekt 
 * Sommersemester 2017
 */

package de.unistuttgart.iwb.lci;
import java.util.HashMap;
import java.util.LinkedList;

/**
 * @author Dr.-Ing. Joachim Schwarte
 * @version 0.92
 */

public class Produktkomposition implements Wirkungsvektor {
	
	// Diese Klasse besitzt keine Klassenvariablen
	
	// Instanzvariablen:
	
	private String name;
	private LinkedList<Wirkungsvektor> zusammensetzung 
			= new LinkedList<Wirkungsvektor>();
	
	// Konstruktor:
	
	public Produktkomposition(String name) {
		super();
		this.name = name;
	}
	
	// Methoden:
	
	public String getName() {
		return name;
	}
	
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

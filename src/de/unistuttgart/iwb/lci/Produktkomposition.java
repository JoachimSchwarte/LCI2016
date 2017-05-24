/*	
 * Beispielprojekt 
 * Sommersemester 2017
 */

package de.unistuttgart.iwb.lci;
import java.util.HashMap;

/**
 * @author Dr.-Ing. Joachim Schwarte
 * @version 0.914
 */

public class Produktkomposition implements Wirkungsvektor {
	
	// Diese Klasse besitzt keine Klassenvariablen
	
	// Instanzvariablen:
	
	private String name;
	private HashMap<Wirkungsvektor, Double> zusammensetzung 
			= new HashMap<Wirkungsvektor, Double>();
	
	// Konstruktor:
	
	public Produktkomposition(String name) {
		super();
		this.name = name;
	}
	
	// Methoden:
	
	public String getName() {
		return name;
	}
	
	public void addKomponente(Wirkungsvektor teilprodukt,
			Double menge) {
		zusammensetzung.put(teilprodukt, menge);
	}

	@Override
	public HashMap<Wirkungskategorie, Double> getWirkungsvektor(Bewertungsmethode bm) {
		HashMap<Wirkungskategorie, Double> wv =
				new HashMap<Wirkungskategorie, Double>();
		for (Wirkungskategorie wk : bm.kategorieListe()){
			wv.put(wk, 0.);
		}
		for (Wirkungsvektor wvKomponente : zusammensetzung.keySet()){
			for (Wirkungskategorie kategorie : wvKomponente.getWirkungsvektor(bm).keySet()){
				wv.put(kategorie, wv.get(kategorie) + 
						zusammensetzung.get(wvKomponente)*wvKomponente.getWirkungsvektor(bm).get(kategorie));
			}
		}
		return wv;
	}

}

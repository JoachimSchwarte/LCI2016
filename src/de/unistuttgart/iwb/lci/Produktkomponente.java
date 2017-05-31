/*	
 * Beispielprojekt 
 * Sommersemester 2017
 */

package de.unistuttgart.iwb.lci;

import java.util.HashMap;

/**
 * @author Dr.-Ing. Joachim Schwarte
 * @version 0.92
 */

public class Produktkomponente implements Wirkungsvektor {
	
	// Diese Klasse besitzt keine Klassenvariablen
	
	// Instanzvariablen:
	
	private String name;
	private Wirkungsvektor komponente;
	private double menge;
	
	// Konstruktor:

	public Produktkomponente(String name, Wirkungsvektor komponente, double menge) {
		super();
		this.name = name;
		this.komponente = komponente;
		this.menge = menge;
	}

	// Methoden:

	@Override
	public HashMap<Wirkungskategorie, Double> getWirkungsvektor(Bewertungsmethode bm) {
		HashMap<Wirkungskategorie, Double> wvKomponente = komponente.getWirkungsvektor(bm);
		for (Wirkungskategorie wk : bm.kategorieListe()){
			wvKomponente.put(wk, wvKomponente.get(wk)*menge);
		}
		return wvKomponente;
	}
	
	public String getName() {
		return name;
	}

	public Wirkungsvektor getKomponente() {
		return komponente;
	}

	public double getMenge() {
		return menge;
	}
}

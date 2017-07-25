/*	
 * Beispielprojekt 
 * Sommersemester 2017
 */

package de.unistuttgart.iwb.lci;

import java.util.HashMap;

/**
 * Diese Klasse dient zur Erzeugung von Produktkomponenten.
 * Diese basieren auf Objekten einer beliebigen Klasse,
 * die das Interface Wirkungsvektor implementiert, und ergänzen
 * diese durch eine Mengenangabe.
 * 
 * @author Dr.-Ing. Joachim Schwarte
 * @version 0.924
 */

public class Produktkomponente implements Wirkungsvektor {
	
	// Diese Klasse besitzt keine Klassenvariablen
	
	// Instanzvariablen:
	
	private String name;
	private Wirkungsvektor komponente;
	private double menge;
	
	// Konstruktor:
	
	/**
	 * Der dreiparametrige Konstruktor erzeugt eine vollständige
	 * Produktkomponente.
	 * @param name
	 * übergibt der Namen der Produktkomponente. Dieser kann frei 
	 * gewählt werden.
	 * Auf Anwendungsebene ist Namenseindeutigkeit anzustreben.
	 * @param komponente
	 * ist ein bliebiges Objekt einer Klasse, die das Interface
	 * Wirkungsvektor implementiert.
	 * @param menge
	 * ist die zugehörige Mengenangabe. 
	 */

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
		for (String wkName : bm.kategorieListe().keySet()){
			Wirkungskategorie wk = bm.kategorieListe().get(wkName);
			wvKomponente.put(wk, wvKomponente.get(wk)*menge);
		}
		return wvKomponente;
	}
	
	/**
	 * @return
	 * ... den Namen der Produktkomponente.
	 */
	
	public String getName() {
		return name;
	}
	
	/**
	 * @return
	 * ... das Objekt des Interface-Typs Wirkungsvektor,
	 * dass durch die Produktkomponente quantifiziert wird.
	 */

	public Wirkungsvektor getKomponente() {
		return komponente;
	}
	
	/**
	 * @return
	 * ... die Mengenangabe.
	 */

	public double getMenge() {
		return menge;
	}
}

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
 * @version 0.927
 */

public class Produktkomponente implements Wirkungsvektor {
	
	// Klassenvariable:
	
	private static HashMap<String, Produktkomponente> allPKentes = new HashMap<String, Produktkomponente>();
	
	// Instanzvariablen:
	
	private String name;
	private Wirkungsvektor komponente;
	private double menge;
	
	// Konstruktor:

	private Produktkomponente(String name, Wirkungsvektor komponente, double menge) {
		super();
		this.name = name;
		this.komponente = komponente;
		this.menge = menge;
		allPKentes.put(name, this);
	}

	// Methoden:
	
	/**
	 * Der dreiparametrige Methode newInstance erzeugt 
	 * unter Verwendung des privaten Konstruktors eine vollständige
	 * Produktkomponente.
	 * @param name
	 * übergibt der Namen der Produktkomponente. 
	 * Dieser muss eindeutig sein
	 * @param komponente
	 * ist ein bliebiges Objekt einer Klasse, die das Interface
	 * Wirkungsvektor implementiert.
	 * @param menge
	 * ist die zugehörige Mengenangabe. 
	 * @return
	 * ... die neue Produktkomponente
	 */
	
	public static Produktkomponente newInstance(String name, Wirkungsvektor komponente, double menge) {
		if (allPKentes.containsKey(name) == false) {
			new Produktkomponente(name, komponente, menge);	
		} 
		return allPKentes.get(name);
	}
	
	/**
	 * Gibt eine bereits vorhandene Produktkomponente zurück.
	 * @param name
	 * Name der gesuchten Produktkomponente
	 * @return
	 * ... die gesuchte Produktkomponente
	 */
	
	public static Produktkomponente getInstance(String name) { 
		return allPKentes.get(name);
	}
	
	/**
	 * Dient vorläufig zum Aktualisieren des Wirkungsvektors.
	 * @param name
	 * der Name der Produktkomponente. 
	 * @param komponente
	 * ist ein bliebiges Objekt einer Klasse, die das Interface
	 * Wirkungsvektor implementiert.
	 * @param menge
	 * ist die zugehörige Mengenangabe. 
	 * @return
	 * ... die Produktkomponente
	 */
	
	public static Produktkomponente updateInstance(String name, Wirkungsvektor komponente, double menge) { 		
		allPKentes.put(name, new Produktkomponente(name, komponente, menge));
		return allPKentes.get(name);
	}

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

/*	
 * Beispielprojekt / Wirkungsabsch�tzung
 * Sommersemester 2017
 */

package de.unistuttgart.iwb.lci;
import java.util.HashMap;

/**
 * Diese Klasse dient zur Erzeugung von Objekten, die
 * einzelne Produkte repr�sentieren, f�r die Daten aus einer
 * Wirkungsabsch�tzung bereits vorliegen (= "bilanziertes
 * Produkt").
 * 
 * @author Dr.-Ing. Joachim Schwarte
 * @version 0.924
 */

public class ProduktBilanziert 
implements Wirkungsvektor {
	
	// Diese Klasse besitzt keine Klassenvariablen
	
	// Instanzvariablen:
	
	private String name;
	private HashMap<Wirkungskategorie, Double> wvAlle = new HashMap<Wirkungskategorie, Double>();
	
	// Konstruktor:
	
	/**
	 * Der einparametrige Konstruktor erzeugt ein benanntes 
	 * Produktobjekt, das noch keine Daten aus einer 
	 * Wirkungsabsch�tzung enth�lt.
	 * @param name
	 * ist der Name der Name des bilanzierten Produkts.
	 */

	public ProduktBilanziert(String name) {
		super();
		this.name = name;
	}

	// Methoden:
	
	/**
	 * F�gt dem bilanzierten Produkt eine Wirkungskategorie und
	 * den dieser Kategorie zugeordneten Wert zu.
	 * @param wk
	 * Die hinzuzuf�gende Wirkungskategorie
	 * @param wert
	 * Der zur Wirkungskategorie geh�rige Wert
	 */
	
	public void addWirkung(Wirkungskategorie wk, Double wert){
		wvAlle.put(wk, wert);
		}
	
	/**
	 * @return
	 * ... den Namen des bilanzierten Produkts.
	 */

	public String getName() {
		return name;
	}

	@Override
	public HashMap<Wirkungskategorie, Double> getWirkungsvektor(Bewertungsmethode bm1) {
		HashMap<Wirkungskategorie, Double> wvAktuell =
				new HashMap<Wirkungskategorie, Double>();
		for(Wirkungskategorie key : wvAlle.keySet()) {
			if (bm1.kategorieListe().contains(key)) {
				wvAktuell.put(key, wvAlle.get(key));
			}
		}
		return wvAktuell;	
	}
}

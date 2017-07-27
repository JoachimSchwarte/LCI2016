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
 * @version 0.927
 */

public class ProduktBilanziert 
implements Wirkungsvektor {
	
	// Klassenvariable:
	
	private static HashMap<String, ProduktBilanziert> allPBs = new HashMap<String, ProduktBilanziert>();
	
	// Instanzvariablen:
	
	private String name;
	private Bewertungsmethode bm;
	private HashMap<Wirkungskategorie, Double> wvAlle = new HashMap<Wirkungskategorie, Double>();
	
	// Konstruktor:
	
	/**
	 * Der einparametrige Konstruktor erzeugt ein benanntes 
	 * Produktobjekt, das noch keine Daten aus einer 
	 * Wirkungsabsch�tzung enth�lt.
	 * @param name
	 * ist der Name des bilanzierten Produkts.
	 */

	public ProduktBilanziert(String name) {
		super();
		this.name = name;
		NameCheck.getInstance().addWVName(name);
		allPBs.put(name, this);
	}

	// Methoden:
	
	/**
	 * Legt die (wesentliche) Bewertungsmethode fest.
	 * @param bm1
	 * Die (wesentliche) Bewertungsmethode
	 */
	
	public void setBM(Bewertungsmethode bm1) {
		bm = bm1;
	}
	
	/**
	 * @return
	 * ... die (wesentliche) Bewertungsmethode f�r das vorliegende
	 * bilanzierte Produkt (= Produktdeklaration)
	 */
	
	public Bewertungsmethode getBM() {
		return bm;
	}
	
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
			if (bm1.kategorieListe().keySet().contains(key.getName())) {
				wvAktuell.put(key, wvAlle.get(key));
			}
		}
		return wvAktuell;	
	}
	
	/**
	 * �berpr�ft, ob bereits eine Produktdeklaration
	 * des genannten Namens existiert.
	 * @param string
	 * ist der zu pr�fende Name
	 * @return
	 * ... den Wahrheitswert, den die �berpr�fung liefert
	 */
	
	public static boolean containsName(String string) {
		return allPBs.containsKey(string);
	}
	
	/**
	 * @return
	 * ... alle vorhandenen Produktdeklarationen
	 */
	
	public static HashMap<String, ProduktBilanziert> getAll() {
		return allPBs;
	}
	
	/**
	 * Liefert eine Produktdeklaration
	 * @param string
	 * Name des bilanzierten Produkts
	 * @return
	 * ... die gesuchte Produktdeklaration
	 */
	
	public static ProduktBilanziert get(String string) {
		return allPBs.get(string);		
	}
}

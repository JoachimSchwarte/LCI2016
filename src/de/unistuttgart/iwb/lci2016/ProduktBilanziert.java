/*	
 * Beispielprojekt / Wirkungsabschätzung
 * Sommersemester 2017
 */

package de.unistuttgart.iwb.lci2016;
import java.util.HashMap;

/**
 * Diese Klasse dient zur Erzeugung von Objekten, die
 * einzelne Produkte repräsentieren, für die Daten aus einer
 * Wirkungsabschätzung bereits vorliegen (= "bilanziertes
 * Produkt").
 * 
 * @author Dr.-Ing. Joachim Schwarte
 * @version 0.936
 */

public class ProduktBilanziert 
implements Wirkungsvektor {
	
	// Klassenvariable:
	
	private static HashMap<String, ProduktBilanziert> allInstances = new HashMap<String, ProduktBilanziert>();
	
	// Instanzvariablen:
	
	private String name;
	private Bewertungsmethode bm;
	private HashMap<Wirkungskategorie, Double> wvAlle = new HashMap<Wirkungskategorie, Double>();
	
	// Konstruktor:

	private ProduktBilanziert(String name) {
		super();
		this.name = name;
		NameCheck.getInstance().addWVName(name);
		allInstances.put(name, this);
	}

	// Methoden:
	
	/**
	 * Löscht alle Klassenvariablen
	 */
	
	public static void clear() {
		allInstances.clear();
	}
	
	/**
	 * Überprüft, ob bereits eine Produktdeklaration
	 * des genannten Namens existiert.
	 * @param string
	 * ist der zu prüfende Name
	 * @return
	 * ... den Wahrheitswert, den die Überprüfung liefert
	 */
	
	public static boolean containsName(String string) {
		return allInstances.containsKey(string);
	}
	
	/**
	 * @return
	 * ... alle vorhandenen Produktdeklarationen
	 */
	
	public static HashMap<String, ProduktBilanziert> getAllInstances() {
		return allInstances;
	}
	
	/**
	 * Liefert eine Produktdeklaration
	 * @param string
	 * Name des bilanzierten Produkts
	 * @return
	 * ... die gesuchte Produktdeklaration
	 */
	
	public static ProduktBilanziert getInstance(String string) {
		return allInstances.get(string);		
	}
	
	/**
	 * Erzeugt ein benanntes 
	 * Produktobjekt, das noch keine Daten aus einer 
	 * Wirkungsabschätzung enthält.
	 * @param name
	 * ist der Name des bilanzierten Produkts.
	 * @return
	 * ... das Produktobjekt
	 */
	
	public static ProduktBilanziert instance(String name) {
		return new ProduktBilanziert(name);
	}
	
	/**
	 * Fügt dem bilanzierten Produkt eine Wirkungskategorie und
	 * den dieser Kategorie zugeordneten Wert zu.
	 * @param wk
	 * Die hinzuzufügende Wirkungskategorie
	 * @param wert
	 * Der zur Wirkungskategorie gehörige Wert
	 */
	
	public void addWirkung(Wirkungskategorie wk, Double wert){
		wvAlle.put(wk, wert);
	}
	
	/**
	 * @return
	 * ... die (wesentliche) Bewertungsmethode für das vorliegende
	 * bilanzierte Produkt (= Produktdeklaration)
	 */
	
	public Bewertungsmethode getBM() {
		return bm;
	}
	
	@Override
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
	 * Legt die (wesentliche) Bewertungsmethode fest.
	 * @param bm1
	 * Die (wesentliche) Bewertungsmethode
	 */
	
	public void setBM(Bewertungsmethode bm1) {
		bm = bm1;
	}

	@Override
	public void setName(String string) {
		NameCheck.removeWVName(this.name);
		NameCheck.getInstance().addWVName(string);
		this.name = string;		
	}
}
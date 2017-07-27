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
 * @version 0.927
 */

public class Produktkomposition implements Wirkungsvektor {
	
	// Klassenvariable:
	
	private static HashMap<String, Produktkomposition> allPKtions = new HashMap<String, Produktkomposition>();

	// Instanzvariablen:
	
	private String name;
	private LinkedList<Wirkungsvektor> zusammensetzung 
			= new LinkedList<Wirkungsvektor>();
	
	// Konstruktor:

	private Produktkomposition(String name) {
		super();
		this.name = name;
		allPKtions.put(name, this);
		NameCheck.getInstance().addWVName(name);
	}
	
	// Methoden:
	
	/**
	 * Die instance-Methode erzeugt unter Verwendung des
	 * privaten Konstruktors eine neue Produktkomposition
	 * oder gibt eine bereits existierende Produktkomposition
	 * zur�ck.
	 * @param name
	 * ist der Name der Produktkomposition.
	 * @return
	 * ... neue oder bereits zuvor existierende
	 * Produktkomposition
	 */
	
	public static Produktkomposition instance(String name) {
		if (allPKtions.containsKey(name) == false) {
			new Produktkomposition(name);
		} 
		return allPKtions.get(name);
	}
	
	/**
	 * @return
	 * ... den Namen der Produktkomposition.
	 */
	
	public String getName() {
		return name;
	}
	
	/**
	 * Erg�nzt die Produktkomposition um eine weitere
	 * Komponente. 
	 * @param teilprodukt
	 * ... ist die zu erg�nzende Komponente. Dies kann
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
		for (String wkName : bm.kategorieListe().keySet()){
			Wirkungskategorie wk = bm.kategorieListe().get(wkName);
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

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
 * @version 0.935
 */

public class Produktkomponente implements Wirkungsvektor {
	
	// Klassenvariable:
	
	private static HashMap<String, Produktkomponente> allPKentes = new HashMap<String, Produktkomponente>();
	
	// Instanzvariablen:
	
	private String name;
	private Wirkungsvektor komponente;
	private Double menge;
	
	// Konstruktor:

	private Produktkomponente(String name, Wirkungsvektor komponente, double menge) {
		super();
		this.name = name;
		this.komponente = komponente;
		this.menge = menge;
		allPKentes.put(name, this);
		NameCheck.getInstance().addWVName(name);
	}

	// Methoden:
	
	/**
	 * Löscht alle Klassenvariablen
	 */
	
	public static void clear() {
		allPKentes.clear();
	}
	
	/**
	 * Überprüft, ob bereits eine Produktkomponente
	 * des genannten Namens existiert.
	 * @param string
	 * ist der zu prüfende Name
	 * @return
	 * ... den Wahrheitswert, den die Überprüfung liefert
	 */
	
	public static boolean containsName(String string) {
		return allPKentes.containsKey(string);
	}
	
	/**
	 * @return
	 * ... alle vorhandenen Produktkomponenten
	 */
	
	public static HashMap<String, Produktkomponente> getAllInstances() {
		return allPKentes;
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
	 * Erzeugt eine Produktkomponente
	 * @param name
	 * übergibt der Namen der Produktkomponente. 
	 * Dieser muss eindeutig sein.
	 * @param kompoName
	 * ist der Name eines Objekt einer Klasse, die das Interface
	 * Wirkungsvektor implementiert.
	 * @param menge
	 * ist die zugehörige Mengenangabe.
	 * @return
	 * ... die neue Produktkomponente
	 */
	
	public static Produktkomponente newInstance(String name, String kompoName, double menge) {
		Wirkungsvektor kompo = Prozessmodul.instance("dummy"); 
		Prozessmodul.removeInstance("dummy");
		kompo.setName(kompoName);
		if (allPKentes.containsKey(name) == false) {
			new Produktkomponente(name, kompo, menge);	
		} 
		return allPKentes.get(name);
	}
	
	/**
	 * Die dreiparametrige Methode newInstance erzeugt 
	 * unter Verwendung des privaten Konstruktors eine vollständige
	 * Produktkomponente.
	 * @param name
	 * übergibt der Namen der Produktkomponente. 
	 * Dieser muss eindeutig sein.
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

	public Double getMenge() {
		return menge;
	}
	
	@Override
	public String getName() {
		return name;
	}

	@Override
	public HashMap<Wirkungskategorie, Double> getWirkungsvektor(Bewertungsmethode bm) {
		String kompoName = komponente.getName();
		if (Prozessmodul.containsName(kompoName)) {
			komponente = Prozessmodul.getInstance(kompoName);					
		}
		if (Produktsystem.containsName(kompoName)) {
			komponente = Produktsystem.getInstance(kompoName);					
		}
		if (ProduktBilanziert.containsName(kompoName)) {
			komponente = ProduktBilanziert.getInstance(kompoName);					
		}
		if (Produktkomponente.containsName(kompoName)) {
			komponente = Produktkomponente.getInstance(kompoName);					
		}
		if (Produktkomposition.containsName(kompoName)) {
			komponente = Produktkomposition.getInstance(kompoName);					
		}
		HashMap<Wirkungskategorie, Double> wvKomponente = komponente.getWirkungsvektor(bm);
		for (String wkName : bm.kategorieListe().keySet()){
			Wirkungskategorie wk = bm.kategorieListe().get(wkName);
			wvKomponente.put(wk, wvKomponente.get(wk)*menge);
		}
		return wvKomponente;
	}

	@Override
	public void setName(String string) {
		name = string;		
	}
}

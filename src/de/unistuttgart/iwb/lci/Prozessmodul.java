/*	
 * Beispielprojekt LCI (Sachbilanz)
 * Wintersemester 2016/2017
 */

package de.unistuttgart.iwb.lci;
import java.util.HashMap;

/**
 * Diese Klasse dient zur Erzeugung von Prozessmodulen.
 * 
 * @author Dr.-Ing. Joachim Schwarte
 * @version 0.93
 */

public class Prozessmodul 
implements Flussvektoren, Wirkungsvektor {
	
	// Klassenvariable:
	
	private static HashMap<String, Prozessmodul> allInstances = new HashMap<String, Prozessmodul>();
	
	// Instanzvariablen:
	
	private String name;
	private HashMap<Fluss, Double> efv = 
			new HashMap<Fluss, Double>(); //Elementarflüsse
	private HashMap<Fluss, Double> pfv = 
			new HashMap<Fluss, Double>(); //Produktflüsse
	
	// Konstruktor:
			
	private Prozessmodul(String name) {
		super();
		setName(name);
		NameCheck.getInstance().addFVName(getName());
		NameCheck.getInstance().addWVName(getName());
		allInstances.put(getName(), this);
	}
	
	// Methoden:
	
	/**
	 * Erzeugt ein leeres benanntes Prozessmodul durch Aufruf des
	 * privaten Konstruktors sofern noch kein Prozessmodul gleichem
	 * Namens existiert. Ansonsten wird das existierende Prozessmodul
	 * zurückgegeben.
	 * @param name
	 * Der Name des Prozessmoduls
	 * @return
	 * ... das Prozessmodul
	 */
	
	public static Prozessmodul instance(String name) {
		if (allInstances.containsKey(name) == false) {
			new Prozessmodul(name);
		}
		return allInstances.get(name);
	}
	
	@Override
	public HashMap<Fluss, Double> getElementarflussvektor() {
		return efv; 
	}	
	
	@Override
	public HashMap<Fluss, Double> getProduktflussvektor() {
		return pfv; 
	}
	
	/**
	 * Fügt dem Prozessmodul einen quantifizierten Fluss hinzu.
	 * Die Methode kann für alle Flusstypen verwendet werden.
	 * @param fluss
	 * Der Fluss, der dem Prozessmodul hinzugefügt werden soll
	 * @param wert
	 * Die Menge, die in das Prozessmodul hinein (negatives
	 * Vorzeichen) oder aus dem Prozessmodul hinaus (positives 
	 * Vorzeichen) fliest.
	 */
	
	public void addFluss(Fluss fluss,Double wert) {
		if (fluss.getTyp() == FlussTyp.Elementar) {
			efv.put(fluss, wert);
		} else {
			pfv.put(fluss, wert);
		}
	}
	
	@Override
	public HashMap<Wirkungskategorie, Double> getWirkungsvektor(Bewertungsmethode bm) {
		HashMap<Wirkungskategorie, Double> wv =
				new HashMap<Wirkungskategorie, Double>();
		for (String wk : bm.kategorieListe().keySet()){
			wv.put(bm.kategorieListe().get(wk), 0.);
		}
		for (String cfName : bm.getFaktorSet().keySet()){
			CharakterFaktor cf = bm.getFaktorSet().get(cfName);
			if (efv.containsKey(cf.getFluss())) {
				wv.put(cf.getWirkung(), wv.get(cf.getWirkung())+
						cf.getWert()*efv.get(cf.getFluss()));
			}			
		}
		return wv;
	}
	
	/**
	 * Entfernt einen Fluss aus dem betroffenen Flussvektor.
	 * 
	 * @param fluss
	 * der zu entfernende Fluß
	 */
	
	public void removeFluss(Fluss fluss) {
		efv.remove(fluss);
		pfv.remove(fluss);
	}
	
	/**
	 * @return
	 * ... den Namen des Prozessmoduls
	 */

	public String getName() {
		return name;
	}
	
	/**
	 * Überschreibt den Namen des Prozessmoduls
	 * @param name
	 * Der neue Name
	 */

	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * Überprüft, ob bereits ein Prozessmodul
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
	 * ... alle vorhandenen Prozessmodule
	 */
	
	public static HashMap<String, Prozessmodul> getAllInstances() {
		return allInstances;
	}
	
	/**
	 * Liefert ein Prozessmodul
	 * @param string
	 * Name des Prozessmoduls
	 * @return
	 * ... das gesuchte Prozessmodul
	 */
	
	public static Prozessmodul getInstance(String string) {
		return allInstances.get(string);		
	}
	
	/**
	 * Löscht ein Prozessmodul
	 * @param string
	 * Name des zu löschenden Prozessmoduls
	 */
	
	public static void removeInstance(String string) {
		allInstances.remove(string);
	}
	
	/**
	 * Löscht alle Klassenvariablen
	 */
	
	public static void clear() {
		allInstances.clear();
	}
}


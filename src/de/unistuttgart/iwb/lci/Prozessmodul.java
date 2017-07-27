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
 * @version 0.927
 */

public class Prozessmodul 
implements Flussvektoren, Wirkungsvektor {
	
	// Klassenvariable:
	
	private static HashMap<String, Prozessmodul> allPMs = new HashMap<String, Prozessmodul>();
	
	// Instanzvariablen:
	
	private String name;
	private HashMap<Fluss, Double> efv = 
			new HashMap<Fluss, Double>(); //Elementarfl�sse
	private HashMap<Fluss, Double> pfv = 
			new HashMap<Fluss, Double>(); //Produktfl�sse
	
	// Konstruktor:
	
	/**
	 * Der parameterlose Konstruktor erzeugt ein leeres und
	 * unbenanntes Prozessmodul.
	 */
	
	public Prozessmodul() {
		super();
		setName(("PM" + NameCheck.sizeWVName()));
		NameCheck.getInstance().addFVName(getName());
		NameCheck.getInstance().addWVName(getName());
		allPMs.put(getName(), this);
	}
	
	/**
	 * Der einparametrige Konstruktor erzeugt ein leeres 
	 * benanntes Prozessmodul.
	 * @param name
	 * Der Name des Prozessmoduls
	 */
	
	public Prozessmodul(String name) {
		super();
		setName(name);
		NameCheck.getInstance().addFVName(getName());
		NameCheck.getInstance().addWVName(getName());
		allPMs.put(getName(), this);
	}
	
	// Methoden:
	
	@Override
	public HashMap<Fluss, Double> getElementarflussvektor() {
		return efv; 
	}	
	
	@Override
	public HashMap<Fluss, Double> getProduktflussvektor() {
		return pfv; 
	}
	
	/**
	 * F�gt dem Prozessmodul einen quantifizierten Fluss hinzu.
	 * Die Methode kann f�r alle Flusstypen verwendet werden.
	 * @param fluss
	 * Der Fluss, der dem Prozessmodul hinzugef�gt werden soll
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
	 * der zu entfernende Flu�
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
	 * �berschreibt den Namen des Prozessmoduls
	 * @param name
	 * Der neue Name
	 */

	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * �berpr�ft, ob bereits ein Prozessmodul
	 * des genannten Namens existiert.
	 * @param string
	 * ist der zu pr�fende Name
	 * @return
	 * ... den Wahrheitswert, den die �berpr�fung liefert
	 */
	
	public static boolean containsName(String string) {
		return allPMs.containsKey(string);
	}
	
	/**
	 * @return
	 * ... alle vorhandenen Prozessmodule
	 */
	
	public static HashMap<String, Prozessmodul> getAll() {
		return allPMs;
	}
	
	/**
	 * Liefert ein Prozessmodul
	 * @param string
	 * Name des Prozessmoduls
	 * @return
	 * ... das gesuchte Prozessmodul
	 */
	
	public static Prozessmodul get(String string) {
		return allPMs.get(string);		
	}
}

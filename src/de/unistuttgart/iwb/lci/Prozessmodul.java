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
 * @version 0.924
 */

public class Prozessmodul 
implements Flussvektoren, Wirkungsvektor {
	
	// Diese Klasse besitzt keine Klassenvariablen
	
	// Instanzvariablen:
	
	private HashMap<Fluss, Double> efv = 
			new HashMap<Fluss, Double>(); //Elementarflüsse
	private HashMap<Fluss, Double> pfv = 
			new HashMap<Fluss, Double>(); //Produktflüsse
	
	// Konstruktor:
	
	/**
	 * Der parameterlose Konstruktor erzeugt ein leeres und
	 * unbenanntes Prozessmodul.
	 */
	
	public Prozessmodul() {
		super();
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
		for (Wirkungskategorie wk : bm.kategorieListe()){
			wv.put(wk, 0.);
		}
		for (CharakterFaktor cf : bm.getFaktorSet()){
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
}

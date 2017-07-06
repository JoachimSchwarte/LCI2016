/*	
 * Beispielprojekt LCI (Sachbilanz)
 * Wintersemester 2016/2017
 */

package de.unistuttgart.iwb.lci;
import java.util.HashMap;

/**
 * @author Dr.-Ing. Joachim Schwarte
 * @version 0.912
 */

public class Prozessmodul 
implements Flussvektoren, Wirkungsvektor {
	
	// Diese Klasse besitzt keine Klassenvariablen
	
	// Instanzvariablen:
	
	private HashMap<Fluss, Double> efv = 
			new HashMap<Fluss, Double>(); //Elementarflüsse
	private HashMap<Fluss, Double> pfv = 
			new HashMap<Fluss, Double>(); //Produktflüsse
	
	// Diese Klasse besitzt keinen expliziten Konstruktor, 
	// d. h. Objekte dieser Klassen können nur mit dem parameterlosen
	// Standardkonstrukter Fluss() erzeugt werden.
	// Die beiden Flussvektoren sind hierbei zunächst leer.
	
	// Methoden:
	
	public HashMap<Fluss, Double> getElementarflussvektor() {
		return efv; 
	}	
	public HashMap<Fluss, Double> getProduktflussvektor() {
		return pfv; 
	}
	public void addFluss(Fluss fluss,Double wert) {
		if (fluss.getTyp() == FlussTyp.Elementar) {
			efv.put(fluss, wert);
		} else {
			pfv.put(fluss, wert);
		}
	}
	
	/*
	 * neue Methoden Version 0.912 (24.05.2017)
	 */
	
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
	
	/*
	 * neue Methoden Version 0.922 (06.07.2017)
	 */
	
	public void removeFluss(Fluss fluss) {
		efv.remove(fluss);
		pfv.remove(fluss);
	}
}

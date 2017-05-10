/*	
 * Beispielprojekt / Wirkungsabschätzung
 * Sommersemester 2017
 */

package de.unistuttgart.iwb.lci;
import java.util.HashMap;

/**
 * @author Dr.-Ing. Joachim Schwarte
 * @version 0.910
 */

public class ProduktBilanziert 
implements Wirkungsvektor {
	
	// Diese Klasse besitzt keine Klassenvariablen
	
	// Instanzvariablen:
	
	private String name;
	private HashMap<Wirkungskategorie, Double> wv;
	private Bewertungsmethode bm;
	
	// Konstruktor:

	public ProduktBilanziert(String name, HashMap<Wirkungskategorie, Double> wv) {
		super();
		this.name = name;
		this.wv = wv;
	}

	// Methoden:
	
	
	public void addWirkung(Wirkungskategorie wk, Double wert){
		wv.put(wk, wert);
		}

	public String getName() {
		return name;
	}

	public Bewertungsmethode getBm() {
		return bm;
	}

	@Override
	public HashMap<Wirkungskategorie, Double> getWirkungsvektor(Bewertungsmethode bm1) {
		if (bm.equals(bm1)) {
			return wv;
		} else {
			return null;
		}		
	}
}

/*	
 * Beispielprojekt / Wirkungsabschätzung
 * Sommersemester 2017
 */

package de.unistuttgart.iwb.lci;
import java.util.HashMap;

/**
 * @author Dr.-Ing. Joachim Schwarte
 * @version 0.911
 */

public class ProduktBilanziert 
implements Wirkungsvektor {
	
	// Diese Klasse besitzt keine Klassenvariablen
	
	// Instanzvariablen:
	
	private String name;
	private HashMap<Wirkungskategorie, Double> wvAlle = new HashMap<Wirkungskategorie, Double>();
	
	// Konstruktor:

	public ProduktBilanziert(String name) {
		super();
		this.name = name;
	}

	// Methoden:
	
	public void addWirkung(Wirkungskategorie wk, Double wert){
		wvAlle.put(wk, wert);
		}

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

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

public interface Wirkungsvektor {
	public HashMap<Wirkungskategorie, Double> getWirkungsvektor(Bewertungsmethode bm);
}

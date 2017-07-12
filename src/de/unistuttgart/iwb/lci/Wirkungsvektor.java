/*	
 * Beispielprojekt / Wirkungsabschätzung
 * Sommersemester 2017
 */

package de.unistuttgart.iwb.lci;
import java.util.HashMap;

/**
 * Dieses Interface muss von all jenen Klassen implementiert werden,
 * zu deren Objekten jeweils ein Wirkungsvektor angeben oder 
 * berechnet werden kann, so dass diese Objekte als Komponenten 
 * innerhalb einer Produktkomposition auftreten können.
 * 
 * @author Dr.-Ing. Joachim Schwarte
 * @version 0.924
 */

public interface Wirkungsvektor {
	
	/**
	 * @param bm
	 * bezeichnet die für die Wirkungsabschätzung zu verwendende
	 * Bewertungsmethode
	 * @return
	 * ... den Wirkungsvektor des Objekts.
	 */
	
	public HashMap<Wirkungskategorie, Double> getWirkungsvektor(Bewertungsmethode bm);
}

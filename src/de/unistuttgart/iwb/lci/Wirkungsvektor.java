/*	
 * Beispielprojekt / Wirkungsabsch�tzung
 * Sommersemester 2017
 */

package de.unistuttgart.iwb.lci;
import java.util.HashMap;

/**
 * Dieses Interface muss von all jenen Klassen implementiert werden,
 * zu deren Objekten jeweils ein Wirkungsvektor angeben oder 
 * berechnet werden kann, so dass diese Objekte als Komponenten 
 * innerhalb einer Produktkomposition auftreten k�nnen.
 * 
 * @author Dr.-Ing. Joachim Schwarte
 * @version 0.927
 */

public interface Wirkungsvektor {
	
	/**
	 * @param bm
	 * bezeichnet die f�r die Wirkungsabsch�tzung zu verwendende
	 * oder bereits verwendete Bewertungsmethode.
	 * @return
	 * ... den Wirkungsvektor des aktuellen Objekts.
	 */
	
	public HashMap<Wirkungskategorie, Double> getWirkungsvektor(Bewertungsmethode bm);
	
	public String getName();
}

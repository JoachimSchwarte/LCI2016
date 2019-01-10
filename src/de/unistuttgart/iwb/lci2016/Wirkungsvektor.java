/*	
 * Beispielprojekt / Wirkungsabschätzung
 * Sommersemester 2017
 */

package de.unistuttgart.iwb.lci2016;
import java.util.HashMap;

/**
 * Dieses Interface muss von all jenen Klassen implementiert werden,
 * zu deren Objekten jeweils ein Wirkungsvektor angegeben oder 
 * berechnet werden kann, so dass diese Objekte als Komponenten 
 * innerhalb einer Produktkomposition auftreten können.
 * 
 * @author Dr.-Ing. Joachim Schwarte
 * @version 0.935
 */

public interface Wirkungsvektor {
	
	/**
	 * @return
	 * ... den Namen des Objektes vom Interface-Typ Wirkungsvektor
	 */
	
	public String getName();
	
	/**
	 * @param bm
	 * bezeichnet die für die Wirkungsabschätzung zu verwendende
	 * oder bereits verwendete Bewertungsmethode.
	 * @return
	 * ... den Wirkungsvektor des aktuellen Objekts.
	 */
	
	public HashMap<Wirkungskategorie, Double> getWirkungsvektor(Bewertungsmethode bm);
	
	/**
	 * Überschreibt den Namen eines Objektes vom Interface-Typ
	 * Wirkungsvektor
	 * @param string
	 * der neue Name des Objekts
	 */
	
	public void setName(String string);
}

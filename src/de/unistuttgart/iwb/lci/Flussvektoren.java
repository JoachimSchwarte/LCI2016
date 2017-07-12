/*	
 * Beispielprojekt LCI (Sachbilanz)
 * Wintersemester 2016/2017
 */

package de.unistuttgart.iwb.lci;
import java.util.HashMap;

/**
 * Dieses Interface muss von all jenen Klassen implementiert werden,
 * zu deren Objekten jeweils ein Elementarflussvektor 
 * und ein Produktflussvektor angeben oder berechnet werden kann, so 
 * dass diese Objekte als Prozessmodule innerhalb eines Produktsystems
 * auftreten können.
 * 
 * @author Dr.-Ing. Joachim Schwarte
 * @version 0.924
 */

public interface Flussvektoren {
	
	/**
	 * @return
	 * ... den Elementarflussvektor des Objekts.
	 */
	
	public HashMap<Fluss, Double> getElementarflussvektor();
	
	/**
	 * @return
	 * ... den Produktflussvektor des Objekts.
	 */
	
	public HashMap<Fluss, Double> getProduktflussvektor();
}

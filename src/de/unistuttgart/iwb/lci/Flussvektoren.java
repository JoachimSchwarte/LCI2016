/*	
 * Beispielprojekt LCI (Sachbilanz)
 * Wintersemester 2016/2017
 */

package de.unistuttgart.iwb.lci;
import java.util.HashMap;

/**
 * @author Dr.-Ing. Joachim Schwarte
 * @version 0.9
 */

public interface Flussvektoren {
	public HashMap<Fluss, Double> getElementarflussvektor();
	public HashMap<Fluss, Double> getProduktflussvektor();

}

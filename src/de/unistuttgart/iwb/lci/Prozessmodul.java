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

public class Prozessmodul implements Flussvektoren {
	
	// Diese Klasse besitzt keine Klassenvariablen
	
	// Instanzvariablen:
	
	private HashMap<Fluss, Double> efv = 
			new HashMap<Fluss, Double>(); //Elementarfl�sse
	private HashMap<Fluss, Double> pfv = 
			new HashMap<Fluss, Double>(); //Produktfl�sse
	
	// Diese Klasse besitzt keinen expliziten Konstruktor, 
	// d. h. Objekte dieser Klassen k�nnen nur mit dem parameterlosen
	// Standardkonstrukter Fluss() erzeugt werden.
	// Die beiden Flussvektoren sind hierbei zun�chst leer.
	
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
}

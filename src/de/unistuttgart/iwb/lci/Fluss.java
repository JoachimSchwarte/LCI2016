/*	
 * Beispielprojekt LCI (Sachbilanz)
 * Wintersemester 2016/2017
 */

package de.unistuttgart.iwb.lci;

/**
 * @author Dr.-Ing. Joachim Schwarte
 * @version 0.9
 */

public class Fluss {	
	
	// Diese Klasse besitzt keine Klassenvariablen
	
	// Instanzvariablen:
	
	private String name;
	private FlussTyp typ; 
	private FlussEinheit einheit;
	
	// Konstruktor basierend auf den Instanzvariablen:
	
	public Fluss(String name, FlussTyp typ, FlussEinheit einheit) {
		this.name = name;
		this.typ = typ;
		this.einheit = einheit;
	}
	
	// Methoden (Getter für die Instanzvariablen):
	
	public String getName() {
		return name;
	}
	public FlussTyp getTyp() {
		return typ;
	}
	public FlussEinheit getEinheit() {
		return einheit;
	}
}

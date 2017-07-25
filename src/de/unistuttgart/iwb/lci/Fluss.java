/*	
 * Beispielprojekt LCI (Sachbilanz)
 * Wintersemester 2016/2017
 */

package de.unistuttgart.iwb.lci;

import java.util.HashSet;

/**
 * Diese Klasse dient zur Erzeugung von Flussobjekten.
 * Es stehen Zugriffsmethoden zur Abfrage der privaten
 * Instanzvariablen zur Verf�gung.
 * 
 * @author Dr.-Ing. Joachim Schwarte
 * @version 0.926
 */

public class Fluss {	
	
	// Klassenvariable:
	
	private static HashSet<String> allNames = new HashSet<String>();
	
	// Instanzvariablen:	

	private String name;
	private FlussTyp typ; 
	private FlussEinheit einheit;
	
	// Konstruktor:
	
	/**
	 * Der dreiparametrige Konstruktor erzeugt ein 
	 * vollst�ndiges Flussobjekt.
	 * @param name
	 * kann frei gew�hlt werden.
	 * Auf Anwendungsebene ist Namenseindeutigkeit anzustreben. 
	 * @param typ
	 * dient vorrangig zur Unterscheidung von Elementar- 
	 * und Produktfl�ssen.
	 * @param einheit
	 * legt die physikalische Einheit fest, in der der
	 * Fluss quantifiziert wird.
	 */
	
	public Fluss(String name, FlussTyp typ, FlussEinheit einheit) {
		this.name = name;
		this.typ = typ;
		this.einheit = einheit;
		allNames.add(name);
	}
	
	// Methoden (Getter f�r die Instanzvariablen):
	
	/**
	 * @return
	 * ... den Namen des Flussobjektes.
	 */
	
	public String getName() {
		return name;
	}
	
	/**
	 * @return
	 * ... den Typ des Flussobjektes.
	 */
	
	public FlussTyp getTyp() {
		return typ;
	}
	
	/**
	 * @return
	 * ... die physikalische Einheit, in der die zugeh�rigen
	 * Fl�sse quantifiziert werden.
	 */
	
	public FlussEinheit getEinheit() {
		return einheit;
	}
	
	/**
	 * �berpr�ft, ob bereits ein Fluss-Objekt des gegebenen
	 * Namens existiert.
	 * @param string
	 * ist der zu pr�fende Name
	 * @return
	 * ... den Wahrheitswert, den die �berpr�fung liefert
	 */
	
	public static boolean containsName(String string) {
		return allNames.contains(string);
	}
}

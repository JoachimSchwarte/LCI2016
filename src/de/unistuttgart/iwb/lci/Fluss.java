/*	
 * Beispielprojekt LCI (Sachbilanz)
 * Wintersemester 2016/2017
 */

package de.unistuttgart.iwb.lci;

import java.util.HashSet;

/**
 * Diese Klasse dient zur Erzeugung von Flussobjekten.
 * Es stehen Zugriffsmethoden zur Abfrage der privaten
 * Instanzvariablen zur Verfügung.
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
	 * vollständiges Flussobjekt.
	 * @param name
	 * kann frei gewählt werden.
	 * Auf Anwendungsebene ist Namenseindeutigkeit anzustreben. 
	 * @param typ
	 * dient vorrangig zur Unterscheidung von Elementar- 
	 * und Produktflüssen.
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
	
	// Methoden (Getter für die Instanzvariablen):
	
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
	 * ... die physikalische Einheit, in der die zugehörigen
	 * Flüsse quantifiziert werden.
	 */
	
	public FlussEinheit getEinheit() {
		return einheit;
	}
	
	/**
	 * Überprüft, ob bereits ein Fluss-Objekt des gegebenen
	 * Namens existiert.
	 * @param string
	 * ist der zu prüfende Name
	 * @return
	 * ... den Wahrheitswert, den die Überprüfung liefert
	 */
	
	public static boolean containsName(String string) {
		return allNames.contains(string);
	}
}

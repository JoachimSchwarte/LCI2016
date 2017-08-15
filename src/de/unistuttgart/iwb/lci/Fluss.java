/*	
 * Beispielprojekt LCI (Sachbilanz)
 * Wintersemester 2016/2017
 */

package de.unistuttgart.iwb.lci;

import java.util.HashMap;
import java.util.Set;

/**
 * Diese Klasse dient zur Erzeugung von Flussobjekten.
 * Es stehen Zugriffsmethoden zur Abfrage der privaten
 * Instanzvariablen zur Verf�gung.
 * 
 * @author Dr.-Ing. Joachim Schwarte
 * @version 0.935
 */

public class Fluss {	
	
	// Klassenvariable:
	
	private static HashMap<String,Fluss> allInstances = new HashMap<String,Fluss>();
	
	// Instanzvariablen:	

	private String name;
	private FlussTyp typ; 
	private FlussEinheit einheit;
	
	// Konstruktor:
	
	private Fluss(String name, FlussTyp typ, FlussEinheit einheit) {
		this.name = name;
		this.typ = typ;
		this.einheit = einheit;
		allInstances.put(name, this);
	}
	
	// Methoden:
	
	/**
	 * L�scht alle Klassenvariablen
	 */
	
	public static void clear() {
		allInstances.clear();
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
		return allInstances.keySet().contains(string);
	}
	
	/**
	 * @return
	 * ... alle vorhandenen Flussobjekte
	 */
	
	public static HashMap<String,Fluss> getAllInstances() {
		return allInstances;
	}
	
	/**
	 * @return
	 * ... die Namen aller vorhandenen Flussobjekte
	 */
	
	public static Set<String> getAllNames() {
		return allInstances.keySet();
	}
	
	/**
	 * @param name
	 * Name des gesuchten Flusses
	 * @return
	 * ... ein Flussobjekt
	 */
	
	public static Fluss getInstance(String name) {
		return allInstances.get(name);
	}
	
	/**
	 * Erzeugt ein vollst�ndiges Flussobjekt durch Aufruf des
	 * privaten Konstruktors sofern noch kein Fluss gleichem
	 * Namens existiert. Ansonsten wird der existierende Fluss
	 * zur�ckgegeben.
	 * @param name
	 * kann frei gew�hlt werden.
	 * Auf Anwendungsebene ist Namenseindeutigkeit anzustreben. 
	 * @param typ
	 * dient vorrangig zur Unterscheidung von Elementar- 
	 * und Produktfl�ssen.
	 * @param einheit
	 * legt die physikalische Einheit fest, in der der
	 * Fluss quantifiziert wird.
	 * @return
	 * ... das Flussobjekt
	 */
	
	public static Fluss instance(String name, FlussTyp typ, FlussEinheit einheit) {
		if (allInstances.containsKey(name) == false) {
			new Fluss(name, typ, einheit);
		}
		return allInstances.get(name);
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
}

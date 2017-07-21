/*	
 * Beispielprojekt LCI (Sachbilanz)
 * ab Wintersemester 2016/2017
 */

package de.unistuttgart.iwb.lci;

import java.util.HashSet;

/**
 * Diese Klasse ist ein Singleton und dient
 * zur Verwaltung aller vergebenen Objekt-Namen,
 * f�r die Eindeutigkeit gew�hrleistet werden
 * muss.
 * 
 * @author Dr.-Ing. Joachim Schwarte
 * @version 0.926
 */

public class NameCheck {
	
	// Diese Klasse besitzt keine Klassenvariablen
	
	// Instanzvariablen:	

	private static NameCheck instance;
	private HashSet<String>fvNames = new HashSet<String>();
	private HashSet<String>wvNames = new HashSet<String>();
	
	// Konstruktor:
	
	private NameCheck() {}
	
	// Methoden
	
	/**
	 * Erzeugt eine Instanz der Klasse, sofern diese nicht
	 * bereits existiert.
	 * @return
	 * ... Instanz der Klasse NameCheck
	 */
	
	public static synchronized NameCheck getInstance() {
	    if (NameCheck.instance == null) {
	    	NameCheck.instance = new NameCheck();
	    }
	    return NameCheck.instance;
	  }
	
	/**
	 * F�gt den Namen eines Objekts vom Interfacetyp
	 * Flussvektoren der entsprechenden Liste hinz.
	 * @param name
	 * Name eines Objekts vom Interfacetyp
	 * Flussvektoren
	 */
	
	public void addFVName(String name) {
	    fvNames.add(name);		
	}
	
	/**
	 * F�gt den Namen eines Objekts vom Interfacetyp
	 * Wirkungsvektor der entsprechenden Liste hinzu.
	 * @param name
	 * Name eines Objekts vom Interfacetyp
	 * Wirkungsvektor
	 */
	
	public void addWVName(String name) {
	    wvNames.add(name);		
	}
	
	/**
	 * Entfernt den Namen eines Objekts vom Interfacetyp
	 * Flussvektoren aus der entsprechenden Liste.
	 * @param name
	 * Name eines Objekts vom Interfacetyp
	 * Flussvektoren
	 */

	public void removeFVName(String name) {
	    fvNames.remove(name);		
	}
	
	/**
	 * Entfernt den Namen eines Objekts vom Interfacetyp
	 * Wirkungsvektor aus der entsprechenden Liste.
	 * @param name
	 * Name eines Objekts vom Interfacetyp
	 * Wirkungsvektor
	 */
	
	public void removeWVName(String name) {
	    wvNames.remove(name);			    
	}
	
	/**
	 * �berpr�ft, ob der Namen eines Objekts vom Interfacetyp
	 * Flussvektoren in der entsprechenden Liste vorhanden ist.
	 * @param name
	 * Name eines Objekts vom Interfacetyp
	 * Flussvektoren
	 * @return
	 * ... den Wahrheitswert, den die �berpr�fung liefert
	 */
	
	public boolean containsFVName(String name) {
	    return fvNames.contains(name);		
	}
	
	/**
	 * �berpr�ft, ob der Namen eines Objekts vom Interfacetyp
	 * Wirkungsvektor in der entsprechenden Liste vorhanden ist.
	 * @param name
	 * Name eines Objekts vom Interfacetyp
	 * Wirkungsvektor
	 * @return
	 * ... den Wahrheitswert, den die �berpr�fung liefert
	 */
	
	public boolean containsWVName(String name) {
	    return wvNames.contains(name);			    
	}
	
	/**
	 * @return
	 * ... die Anzahl der Namen der Objekts vom Interfacetyp
	 * Flussvektoren, die in der entsprechenden Liste vorhanden.
	 * sind
	 */
	
	public int sizeFVName() {
	    return fvNames.size();
	}
	
	/**
	 * @return
	 * ... die Anzahl der Namen der Objekts vom Interfacetyp
	 * Wirkungsvektor, die in der entsprechenden Liste vorhanden.
	 * sind
	 */
	
	public int sizeWVName() {
	    return wvNames.size();			    
	}
}

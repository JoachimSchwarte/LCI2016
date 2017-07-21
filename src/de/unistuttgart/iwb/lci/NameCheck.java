/*	
 * Beispielprojekt LCI (Sachbilanz)
 * ab Wintersemester 2016/2017
 */

package de.unistuttgart.iwb.lci;

import java.util.HashSet;

/**
 * Diese Klasse ist ein Singleton und dient
 * zur Verwaltung aller vergebenen Objekt-Namen,
 * für die Eindeutigkeit gewährleistet werden
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
	
	public static synchronized NameCheck getInstance() {
	    if (NameCheck.instance == null) {
	    	NameCheck.instance = new NameCheck();
	    }
	    return NameCheck.instance;
	  }
	
	public void addFVName(String name) {
	    fvNames.add(name);		
	}
	
	public void addWVName(String name) {
	    wvNames.add(name);		
	}

	public void removeFVName(String name) {
	    fvNames.remove(name);		
	}
	
	public void removeWVName(String name) {
	    wvNames.remove(name);			    
	}
	
	public boolean containsFVName(String name) {
	    return fvNames.contains(name);		
	}
	
	public boolean containsWVName(String name) {
	    return wvNames.contains(name);			    
	}
	
	public int sizeFVName() {
	    return fvNames.size();
	}
	
	public int sizeWVName() {
	    return wvNames.size();			    
	}
}

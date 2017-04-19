package de.unistuttgart.iwb.lcigui;

import java.io.Serializable;
import java.util.HashMap;

import de.unistuttgart.iwb.lci.Fluss;

class Bedarfsvektor implements Serializable {

	private static final long serialVersionUID = -9206176756512553316L;
	
	public HashMap<Fluss, Double> bv = new HashMap<Fluss, Double>(); 
	
	public HashMap<Fluss, Double> getBV() {
		return bv;
	}

	public void setBV(HashMap<Fluss, Double> bv) {
		this.bv = bv;
	}

	public void addFluss(Fluss f, Double w) {
		bv.put(f, w);
	}
}

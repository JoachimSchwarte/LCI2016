package de.unistuttgart.iwb.lcigui;

import java.io.Serializable;
import java.util.LinkedList;

import de.unistuttgart.iwb.lci.Fluss;

class VorUndKoppelprodukte implements Serializable {
	
	private static final long serialVersionUID = 7052124570943701568L;
	
	public LinkedList<Fluss> vk = new LinkedList<Fluss>();

	public LinkedList<Fluss> getVk() {
		return vk;
	}

	public void setVk(LinkedList<Fluss> vk) {
		this.vk = vk;
	}

	public void addFluss(Fluss f) {
		vk.add(f);
	}
}

package de.unistuttgart.iwb.lcigui;

import java.io.Serializable;
import java.util.LinkedList;

class ModulNamenListe implements Serializable {

	private static final long serialVersionUID = -6658594756739592073L;
	
	public LinkedList<String> mnl = new LinkedList<String>();

	public LinkedList<String> getMnl() {
		return mnl;
	}

	public void setMnl(LinkedList<String> vk) {
		this.mnl = vk;
	}

	public void addName(String m) {
		mnl.add(m);
	}
}

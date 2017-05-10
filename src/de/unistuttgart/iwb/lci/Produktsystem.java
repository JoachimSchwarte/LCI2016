/*	
 * Beispielprojekt LCI (Sachbilanz)
 * Wintersemester 2016/2017
 */

package de.unistuttgart.iwb.lci;
import java.util.HashMap;
import java.util.LinkedList;
import Jama.Matrix;

/**
 * @author Dr.-Ing. Joachim Schwarte
 * @version 0.901
 */

public class Produktsystem 
implements Flussvektoren {
	
	// Diese Klasse besitzt keine Klassenvariablen
	
	// Instanzvariablen:
	
	private String name;
	private LinkedList<Flussvektoren> modulliste 
			= new LinkedList<Flussvektoren>();
	private HashMap<Fluss, Double> bedarfsvektor 
			= new HashMap<Fluss, Double>();
	private LinkedList<Fluss> vorUndKoppelProdukte 
			= new LinkedList<Fluss>();
	private HashMap<Fluss, Double> efv 
			= new HashMap<Fluss, Double>();
	private HashMap<Fluss, Double> pfv 
			= new HashMap<Fluss, Double>();
	private boolean aktuell = false;
	
	// Konstruktor:

	public Produktsystem(String string, 
			HashMap<Fluss, Double> f,
			LinkedList<Fluss> vk) {
		name = string;
		bedarfsvektor = f;
		vorUndKoppelProdukte = vk;
	}
	
	// Methoden:
	
	public String getName() {
		return name;
	}
	public void addProzessmodul(Flussvektoren modul) {
		modulliste.add(modul);
		aktuell = false;
	}
	private void aktualisiere() throws ArithmeticException {
		LinkedList<Fluss> produktFlussliste = new LinkedList<Fluss>();
		for(Flussvektoren m : modulliste){
			HashMap<Fluss, Double> modulVektor = m.getProduktflussvektor();
			for (Fluss key : modulVektor.keySet()) {		
				if ((produktFlussliste.contains(key) == false) &
					(vorUndKoppelProdukte.contains(key) == false))	{
					produktFlussliste.add(key);					
				}				
			}
		}
		double[][] arrayA = new double[produktFlussliste.size()][modulliste.size()];
		for(Flussvektoren m : modulliste){
			HashMap<Fluss, Double> modulVektor = m.getProduktflussvektor();
			for (Fluss key : modulVektor.keySet()) {
 				if (produktFlussliste.contains(key)) {
					arrayA[produktFlussliste.indexOf(key)][modulliste.indexOf(m)]=modulVektor.get(key);	
 				}							
			}
		}
		LinkedList<Fluss> elementarFlussliste = new LinkedList<Fluss>();
		for(Flussvektoren m : modulliste){
			HashMap<Fluss, Double> modulVektor = m.getElementarflussvektor();
			for (Fluss key : modulVektor.keySet()) {
				if (elementarFlussliste.contains(key) == false){
					elementarFlussliste.add(key);					
				}				
			}
		}
		double[][] arrayB = new double[elementarFlussliste.size()][modulliste.size()];
		for(Flussvektoren m : modulliste){
			HashMap<Fluss, Double> modulVektor = m.getElementarflussvektor();
			for (Fluss key : modulVektor.keySet()) {
				arrayB[elementarFlussliste.indexOf(key)][modulliste.indexOf(m)]=modulVektor.get(key);				
			}
		}
		double[][] arrayF = new double[produktFlussliste.size()][1];
		for(Fluss pf : produktFlussliste) {
			if (bedarfsvektor.containsKey(pf)){
				arrayF[produktFlussliste.indexOf(pf)][0]=bedarfsvektor.get(pf);
			} 
			else {
				arrayF[produktFlussliste.indexOf(pf)][0]=0;
			}		
		}
		Matrix matrixA = new Matrix(arrayA);
		Matrix matrixB = new Matrix(arrayB);
		Matrix matrixF = new Matrix(arrayF);
		Matrix matrixS = matrixA.solve(matrixF);
		Matrix matrixG = matrixB.times(matrixS);
		double[][] arrayS = matrixS.getArray();
		for (Integer i=0; i<arrayS.length; i++){
			if (arrayS[i][0]<0){
				throw new ArithmeticException("Vorzeichenfehler im Skalierungsvektor");			
			}
		}

		for(Fluss ef : elementarFlussliste) {
			efv.put(ef, matrixG.get(elementarFlussliste.indexOf(ef),0));
		}	
		produktFlussliste.addAll(vorUndKoppelProdukte);
		double[][] arrayA1 = new double[produktFlussliste.size()][modulliste.size()];
		for(Flussvektoren m : modulliste){
			HashMap<Fluss, Double> modulVektor = m.getProduktflussvektor();
			for (Fluss key : modulVektor.keySet()) {
				arrayA1[produktFlussliste.indexOf(key)][modulliste.indexOf(m)]=modulVektor.get(key);				
			}
		}
		Matrix matrixA1 = new Matrix(arrayA1);
		Matrix matrixG1 = matrixA1.times(matrixS);
		for(Fluss pf : produktFlussliste) {
			pfv.put(pf, matrixG1.get(produktFlussliste.indexOf(pf),0));
		}			
		aktuell = true;
	}
	
	public HashMap<Fluss, Double> getElementarflussvektor() {
		if (aktuell == false) aktualisiere();
		return efv;
	}

	public HashMap<Fluss, Double> getProduktflussvektor() {
		if (aktuell == false) aktualisiere();
		return pfv;
	}
	
	/*
	 * neue Methoden für die GUI-Kommunikation (09.03.2017)
	 */
	
	public int getModulAnzahl() {
		return modulliste.size();
	}
	
	public void setBedarfsvektor(HashMap<Fluss, Double> bv) {
		bedarfsvektor = bv;
	}
	
	public void setVorUndKoppelProdukte(LinkedList<Fluss> vk) {
		vorUndKoppelProdukte = vk;
	}

}

/*	
 * Beispielprojekt 
 * Sommersemester 2017
 */

package de.unistuttgart.iwb.lcitest;

/**
 * @author Dr.-Ing. Joachim Schwarte
 * @version 0.912
 */

import static org.junit.Assert.*;
import java.util.HashMap;
import java.util.LinkedList;

import org.junit.Test;
import de.unistuttgart.iwb.lci.*;

public class IwbLciTest {
	Fluss a = new Fluss("A", FlussTyp.Elementar, FlussEinheit.kg);
	Fluss b = new Fluss("B", FlussTyp.Elementar, FlussEinheit.kg);
	Fluss c = new Fluss("C", FlussTyp.Elementar, FlussEinheit.kg);
	Fluss d = new Fluss("D", FlussTyp.Elementar, FlussEinheit.g);
	Fluss e = new Fluss("E", FlussTyp.Elementar, FlussEinheit.Stk);
	Fluss f = new Fluss("F", FlussTyp.Elementar, FlussEinheit.Stk);
	Fluss x = new Fluss("X", FlussTyp.Produkt, FlussEinheit.kg);
	Fluss y = new Fluss("Y", FlussTyp.Produkt, FlussEinheit.kg);
	Fluss z = new Fluss("Z", FlussTyp.Produkt, FlussEinheit.Stk);
	Fluss w = new Fluss("W", FlussTyp.Produkt, FlussEinheit.Stk);
	Fluss v = new Fluss("V", FlussTyp.Produkt, FlussEinheit.Stk);
	Prozessmodul Modul1 = new Prozessmodul();
	Prozessmodul Modul2 = new Prozessmodul();
	Prozessmodul Modul3 = new Prozessmodul();
	Prozessmodul Modul4 = new Prozessmodul();
	Prozessmodul Modul5 = new Prozessmodul();
	Prozessmodul Modul6 = new Prozessmodul();
	Prozessmodul Modul7 = new Prozessmodul();
	Prozessmodul Modul8 = new Prozessmodul();
	HashMap<Fluss, Double> f123 = new HashMap<Fluss, Double>();
	HashMap<Fluss, Double> f12 = new HashMap<Fluss, Double>();
	HashMap<Fluss, Double> f3 = new HashMap<Fluss, Double>();
	HashMap<Fluss, Double> f23 = new HashMap<Fluss, Double>();
	HashMap<Fluss, Double> f1u23 = new HashMap<Fluss, Double>();
	HashMap<Fluss, Double> fkp = new HashMap<Fluss, Double>();
	HashMap<Fluss, Double> f34 = new HashMap<Fluss, Double>();
	HashMap<Fluss, Double> f2 = new HashMap<Fluss, Double>();
	LinkedList<Fluss>vkp = new LinkedList<Fluss>();
	LinkedList<Fluss>vkp23 = new LinkedList<Fluss>();
	LinkedList<Fluss>vkp1u23 = new LinkedList<Fluss>();
	LinkedList<Fluss>vkp1 = new LinkedList<Fluss>();
	LinkedList<Fluss>vkp2 = new LinkedList<Fluss>();
	Produktsystem ProduktZ1 = new Produktsystem("EinsZweiDrei", f123, vkp);
	Produktsystem ProduktY = new Produktsystem("EinsZwei", f12, vkp);
	Produktsystem ProduktZ2 = new Produktsystem("EinsZwei-Drei", f3, vkp);
	Produktsystem ProduktZ3a = new Produktsystem("ZweiDrei", f23, vkp23);
	Produktsystem ProduktZ3 = new Produktsystem("Eins-ZweiDrei", f1u23, vkp1u23);
	Produktsystem EinsBisFuenf = new Produktsystem("", fkp, vkp);
	Produktsystem DreiUndVier = new Produktsystem("", f34, vkp1);
	Produktsystem Gesamt = new Produktsystem("", f2, vkp2);
	Wirkungskategorie W1 = new Wirkungskategorie("Klimawandel", Wirkungsindikator.kgCO2Aeqv);
	Wirkungskategorie W2 = new Wirkungskategorie("Versauerung", Wirkungsindikator.kgSO2Aeqv);
	Wirkungskategorie W3 = new Wirkungskategorie("Ozonloch", Wirkungsindikator.kgR11Aeqv);
	CharakterFaktor C11 = new CharakterFaktor("c11", a, W1, 1.);
	CharakterFaktor C22 = new CharakterFaktor("c22", b, W2, 1.);
	CharakterFaktor C33 = new CharakterFaktor("c33", c, W3, 1.);
	CharakterFaktor C12 = new CharakterFaktor("c12", a, W2, 0.15);
	CharakterFaktor C23 = new CharakterFaktor("c23", b, W3, 0.25);
	Bewertungsmethode BM1 = new Bewertungsmethode("TestMethode1");
	Bewertungsmethode BM2 = new Bewertungsmethode("TestMethode2");
	ProduktBilanziert PB1 = new ProduktBilanziert("TestProdukt1");
	private void initialize1() {
		Modul1.addFluss(a, 50.);
		Modul1.addFluss(c, -300.);
		Modul1.addFluss(x, 100.);
		Modul2.addFluss(a, 30.);
		Modul2.addFluss(b, 15.);
		Modul2.addFluss(c, -150.);
		Modul2.addFluss(x, -25.);
		Modul2.addFluss(y, 100.);
		Modul3.addFluss(a, 10.);
		Modul3.addFluss(b, 15.);
		Modul3.addFluss(d, -5.);
		Modul3.addFluss(y, -200.);
		Modul3.addFluss(z, 1.);
		Modul4.addFluss(a, 1.);
		Modul4.addFluss(b, 1.);
		Modul4.addFluss(e, -1.);
		Modul4.addFluss(x, 1.);
		Modul5.addFluss(a, 1.);
		Modul5.addFluss(c, 1.);
		Modul5.addFluss(f, -1.);
		Modul5.addFluss(x, -20.);
		Modul5.addFluss(z, 1.);
		Modul6.addFluss(a, 1.);
		Modul6.addFluss(d, 1.);
		Modul6.addFluss(f, -2.);
		Modul6.addFluss(x, 1.);
		Modul6.addFluss(y, 1.);
		Modul7.addFluss(c, 1.);
		Modul7.addFluss(d, 1.);
		Modul7.addFluss(e, -2.);
		Modul7.addFluss(y, -2.);
		Modul7.addFluss(w, 1.);
		Modul8.addFluss(b, 1.);
		Modul8.addFluss(c, 1.);
		Modul8.addFluss(e, -1.);
		Modul8.addFluss(f, -1.);
		Modul8.addFluss(z, -2.);
		Modul8.addFluss(w, -3.);
		Modul8.addFluss(v, 1.);
		f123.put(z, 1.);
		f12.put(y, 100.);
		f3.put(z, 1.);
		f23.put(z, 1.);
		f1u23.put(z, 1.);
		f34.put(w, 1.);
		fkp.put(v, 1.);
		f2.put(v, 1.);
		vkp23.add(x);
		vkp1.add(x);
		ProduktZ1.addProzessmodul(Modul1);
		ProduktZ1.addProzessmodul(Modul2);
		ProduktZ1.addProzessmodul(Modul3);
		ProduktY.addProzessmodul(Modul1);
		ProduktY.addProzessmodul(Modul2);
		ProduktZ2.addProzessmodul(ProduktY);
		ProduktZ2.addProzessmodul(Modul3);
		ProduktZ3a.addProzessmodul(Modul2);
		ProduktZ3a.addProzessmodul(Modul3);
		ProduktZ3.addProzessmodul(Modul1);
		ProduktZ3.addProzessmodul(ProduktZ3a);
		EinsBisFuenf.addProzessmodul(Modul4);
		EinsBisFuenf.addProzessmodul(Modul5);
		EinsBisFuenf.addProzessmodul(Modul6);
		EinsBisFuenf.addProzessmodul(Modul7);
		EinsBisFuenf.addProzessmodul(Modul8);
		DreiUndVier.addProzessmodul(Modul6);
		DreiUndVier.addProzessmodul(Modul7);
		Gesamt.addProzessmodul(Modul4);
		Gesamt.addProzessmodul(Modul5);
		Gesamt.addProzessmodul(Modul8);
		Gesamt.addProzessmodul(DreiUndVier);
	}
	private void initialize2() {
		BM1.addFaktor(C11);
		BM1.addFaktor(C22);
		BM1.addFaktor(C33);
		BM1.addFaktor(C12);
		BM1.addFaktor(C23);
		BM2.addFaktor(C12);
		BM2.addFaktor(C22);
		PB1.addWirkung(W1, 3.);
		PB1.addWirkung(W2, 5.);
		PB1.addWirkung(W3, 7.);
	}	

	
	@Test
	public void ProzessModulTest() {
		initialize1();
		HashMap<Fluss, Double> H1 = Modul1.getElementarflussvektor();
		HashMap<Fluss, Double> H2 = Modul1.getProduktflussvektor();
		assertEquals(2, H1.size());
		assertEquals(1, H2.size());		
	}

	@Test
	public void ProduktsystemTest1() {
		initialize1();
		HashMap<Fluss, Double> g = ProduktZ1.getElementarflussvektor();
		assertEquals(95., g.get(a), 0.01);
		assertEquals(45., g.get(b), 0.01);
		assertEquals(-450., g.get(c), 0.01);
		assertEquals(-5., g.get(d), 0.01);	
	}
	
	@Test
	public void ProduktsystemTest2() {
		initialize1();
		HashMap<Fluss, Double> g = ProduktZ2.getElementarflussvektor();
		assertEquals(95., g.get(a), 0.01);
		assertEquals(45., g.get(b), 0.01);
		assertEquals(-450., g.get(c), 0.01);
		assertEquals(-5., g.get(d), 0.01);	
	}
	
	@Test
	public void ProduktsystemTest3() {
		initialize1();
		HashMap<Fluss, Double> g = ProduktZ3.getElementarflussvektor();
		assertEquals(95., g.get(a), 0.01);
		assertEquals(45., g.get(b), 0.01);
		assertEquals(-450., g.get(c), 0.01);
		assertEquals(-5., g.get(d), 0.01);	
	}
	
	@Test
	public void VorUndKoppelprodukteTest() {
		initialize1();
		HashMap<Fluss, Double> g = 
				EinsBisFuenf.getElementarflussvektor();
		double uA = g.get(a);
		double uB = g.get(b);
		double uC = g.get(c);
		double uD = g.get(d);
		double uE = g.get(e);
		double uF = g.get(f);
		assertEquals(42., uA, 0.01);
		assertEquals(35., uB, 0.01);
		assertEquals(6., uC, 0.01);
		assertEquals(9., uD, 0.01);
		assertEquals(-41., uE, 0.01);
		assertEquals(-15., uF, 0.01);
		HashMap<Fluss, Double> g2 = Gesamt.getElementarflussvektor();
		assertEquals(uA, g2.get(a), 0.01);
		assertEquals(uB, g2.get(b), 0.01);
		assertEquals(uC, g2.get(c), 0.01);
		assertEquals(uD, g2.get(d), 0.01);
		assertEquals(uE, g2.get(e), 0.01);
		assertEquals(uF, g2.get(f), 0.01);
	}
	
	@Test
	public void BewertungsmethodeTest() {
		initialize2();
		assertEquals(3, BM1.kategorieListe().size());
		assertEquals(1, BM2.kategorieListe().size());
		assertEquals("Klimawandel", W1.getName());
	}
	
	@Test
	public void ProduktBilanziertTest() {
		initialize2();
		assertEquals("TestProdukt1", PB1.getName());
		assertEquals(3, PB1.getWirkungsvektor(BM1).size());
		assertEquals(1, PB1.getWirkungsvektor(BM2).size());
		assertEquals(5., PB1.getWirkungsvektor(BM1).get(W2), .001);
	}
	
	@Test
	public void ProzessmodulWVTest1() {
		initialize1();
		initialize2();
		HashMap<Wirkungskategorie, Double> wv = Modul2.getWirkungsvektor(BM1);
		assertEquals(3, wv.size());
		assertEquals(30., wv.get(W1), .001);
		assertEquals(19.5, wv.get(W2), .001);
		assertEquals(-146.25, wv.get(W3), .001);		
	}
	
	@Test
	public void ProzessmodulWVTest2() {
		initialize1();
		initialize2();
		HashMap<Wirkungskategorie, Double> wv = Modul2.getWirkungsvektor(BM2);
		assertEquals(1, wv.size());
		assertEquals(19.5, wv.get(W2), .001);		
	}
	
	@Test
	public void ProzessmodulWVTest3() {
		initialize1();
		initialize2();
		HashMap<Wirkungskategorie, Double> wv = Modul1.getWirkungsvektor(BM1);
		assertEquals(3, wv.size());
		assertEquals(50., wv.get(W1), .001);
		assertEquals(7.5, wv.get(W2), .001);
		assertEquals(-300., wv.get(W3), .001);		
	}
}

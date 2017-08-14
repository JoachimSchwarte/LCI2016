/*	
 * Beispielprojekt 
 * Sommersemester 2017
 */

package de.unistuttgart.iwb.lcitest;

/**
 * @author Dr.-Ing. Joachim Schwarte
 * @version 0.93
 */

import static org.junit.Assert.*;
import java.util.HashMap;
import java.util.LinkedList;

import org.junit.Test;
import de.unistuttgart.iwb.lci.*;

public class IwbLciTest {
	Fluss a = Fluss.instance("A", FlussTyp.Elementar, FlussEinheit.kg);
	Fluss b = Fluss.instance("B", FlussTyp.Elementar, FlussEinheit.kg);
	Fluss c = Fluss.instance("C", FlussTyp.Elementar, FlussEinheit.kg);
	Fluss d = Fluss.instance("D", FlussTyp.Elementar, FlussEinheit.g);
	Fluss e = Fluss.instance("E", FlussTyp.Elementar, FlussEinheit.Items);
	Fluss f = Fluss.instance("F", FlussTyp.Elementar, FlussEinheit.Items);
	Fluss x = Fluss.instance("X", FlussTyp.Produkt, FlussEinheit.kg);
	Fluss y = Fluss.instance("Y", FlussTyp.Produkt, FlussEinheit.kg);
	Fluss z = Fluss.instance("Z", FlussTyp.Produkt, FlussEinheit.Items);
	Fluss w = Fluss.instance("W", FlussTyp.Produkt, FlussEinheit.Items);
	Fluss v = Fluss.instance("V", FlussTyp.Produkt, FlussEinheit.Items);
	Prozessmodul Modul1 = Prozessmodul.instance("M1");
	Prozessmodul Modul2 = Prozessmodul.instance("M2");
	Prozessmodul Modul3 = Prozessmodul.instance("M3");
	Prozessmodul Modul4 = Prozessmodul.instance("M4");
	Prozessmodul Modul5 = Prozessmodul.instance("M5");
	Prozessmodul Modul6 = Prozessmodul.instance("M6");
	Prozessmodul Modul7 = Prozessmodul.instance("M7");
	Prozessmodul Modul8 = Prozessmodul.instance("M8");
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
	Produktsystem ProduktZ1 = Produktsystem.instance("EinsZweiDrei", f123, vkp);
	Produktsystem ProduktY = Produktsystem.instance("EinsZwei", f12, vkp);
	Produktsystem ProduktZ2 = Produktsystem.instance("EinsZwei-Drei", f3, vkp);
	Produktsystem ProduktZ3a = Produktsystem.instance("ZweiDrei", f23, vkp23);
	Produktsystem ProduktZ3 = Produktsystem.instance("Eins-ZweiDrei", f1u23, vkp1u23);
	Produktsystem EinsBisFuenf = Produktsystem.instance("EinsBisFuenf", fkp, vkp);
	Produktsystem DreiUndVier = Produktsystem.instance("DreiUndVier", f34, vkp1);
	Produktsystem Gesamt = Produktsystem.instance("Gesamt", f2, vkp2);
	Wirkungskategorie W1 = Wirkungskategorie.instance("Klimawandel", Wirkungsindikator.kgCO2Aeqv);
	Wirkungskategorie W2 = Wirkungskategorie.instance("Versauerung", Wirkungsindikator.kgSO2Aeqv);
	Wirkungskategorie W3 = Wirkungskategorie.instance("Ozonloch", Wirkungsindikator.kgR11Aeqv);
	CharakterFaktor C11 = CharakterFaktor.instance("c11", a, W1, 1.);
	CharakterFaktor C22 = CharakterFaktor.instance("c22", b, W2, 1.);
	CharakterFaktor C33 = CharakterFaktor.instance("c33", c, W3, 1.);
	CharakterFaktor C12 = CharakterFaktor.instance("c12", a, W2, 0.15);
	CharakterFaktor C23 = CharakterFaktor.instance("c23", b, W3, 0.25);
	Bewertungsmethode BM1 = Bewertungsmethode.instance("TestMethode1");
	Bewertungsmethode BM2 = Bewertungsmethode.instance("TestMethode2");
	ProduktBilanziert PB1 = ProduktBilanziert.instance("TestProdukt1");
	Produktkomponente Komponente1 = Produktkomponente.newInstance("Modul3doppelt", Modul3, 2.);
	Produktkomponente Komponente2 = Produktkomponente.newInstance("Modul4vierfach", Modul4, 4.);
	Produktkomponente Komponente3 = Produktkomponente.newInstance("GesamtDreifach", Gesamt, 3.);
	Produktkomponente Komponente4 = Produktkomponente.newInstance("PB1fünffach", PB1, 5.);
	Produktkomposition PK1 = Produktkomposition.instance("TestKomposition1");
	Produktkomponente Komponente5 = Produktkomponente.newInstance("PK1sechsfach", PK1, 6.);
	Produktkomponente Komponente6 = Produktkomponente.newInstance("EinsBisFuenfDoppelt", EinsBisFuenf, 2.);
	private void initialize1() {
		Produktsystem.clear();
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
		ProduktZ1 = Produktsystem.instance("EinsZweiDrei", f123, vkp);
		ProduktY = Produktsystem.instance("EinsZwei", f12, vkp);
		ProduktZ2 = Produktsystem.instance("EinsZwei-Drei", f3, vkp);
		ProduktZ3a = Produktsystem.instance("ZweiDrei", f23, vkp23);
		ProduktZ3 = Produktsystem.instance("Eins-ZweiDrei", f1u23, vkp1u23);
		EinsBisFuenf = Produktsystem.instance("EinsBisFuenf", fkp, vkp);
		DreiUndVier = Produktsystem.instance("DreiUndVier", f34, vkp1);
		Gesamt = Produktsystem.instance("Gesamt", f2, vkp2);
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
		Komponente1 = Produktkomponente.updateInstance("Modul3doppelt", Modul3, 2.);
		Komponente2 = Produktkomponente.updateInstance("Modul4vierfach", Modul4, 4.);
		Komponente3 = Produktkomponente.updateInstance("GesamtDreifach", Gesamt, 3.);
		Komponente4 = Produktkomponente.updateInstance("PB1fünffach", PB1, 5.);
		
	}
	private void initialize3() {
		Komponente4 = Produktkomponente.updateInstance("PB1fünffach", PB1, 5.);
		Komponente6 = Produktkomponente.updateInstance("EinsBisFuenfDoppelt", EinsBisFuenf, 2.);
		PK1.addKomponente(Komponente4);
		PK1.addKomponente(Komponente6);
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
	public void BewertungsNamesTest() {
		initialize2();
		assertEquals(BM1.getName(), "TestMethode1");
		assertEquals(BM2.getName(), "TestMethode2");
	}
	
	@Test
	public void BewertungsmethodeTest() {
		initialize2();
		assertEquals(3, BM1.kategorieListe().size());
		assertEquals(1, BM2.kategorieListe().size());
		assertEquals("Klimawandel", W1.getName());
		assertEquals(5, BM1.getFaktorSet().size());
		assertEquals(2, BM2.getFaktorSet().size());
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
	
	@Test
	public void ProduktsystemWVTest3() {
		initialize1();
		initialize2();
		HashMap<Wirkungskategorie, Double> wv = EinsBisFuenf.getWirkungsvektor(BM1);
		assertEquals(3, wv.size());
		assertEquals(42., wv.get(W1), .001);
		assertEquals(35.+0.15*42., wv.get(W2), .001);
		assertEquals(6.+0.25*35., wv.get(W3), .001);		
	}
	
	@Test
	public void PKentesNamesTest() {
		initialize2();
		assertEquals(Komponente1.getName(), "Modul3doppelt");
		assertEquals(Komponente2.getName(), "Modul4vierfach");
		assertEquals(Komponente3.getName(), Produktkomponente.getInstance("GesamtDreifach").getName());		
	}
	
	@Test
	public void PKentesMengenTest() {
		initialize2();
		assertEquals(Komponente1.getMenge(), 
				Produktkomponente.getInstance("Modul3doppelt").getMenge(), 0.001);
		assertEquals(Komponente2.getMenge(), 
				Produktkomponente.getInstance("Modul4vierfach").getMenge(), 0.001);
		assertEquals(Komponente3.getMenge(), 
				Produktkomponente.getInstance("GesamtDreifach").getMenge(), 0.001);	
		assertEquals(Komponente1.getMenge(), 2.0, 0.001);
		assertEquals(Produktkomponente.getInstance("Modul3doppelt").getMenge(), 2.0, 0.001);
	}
	
	@Test
	public void ProduktkomponenteTest1() {
		initialize1();
		initialize2();
		HashMap<Wirkungskategorie, Double> wv1a = Modul3.getWirkungsvektor(BM1);
		HashMap<Wirkungskategorie, Double> wv1b = Komponente1.getWirkungsvektor(BM1);
		assertEquals(3, wv1a.size());
		assertEquals(3, wv1b.size());
		assertEquals(wv1a.get(W1)*Komponente1.getMenge(), 20.0, .001);
		assertEquals(wv1b.get(W1), 20.0, .001);
		assertEquals(wv1a.get(W1)*Komponente1.getMenge(), wv1b.get(W1), .001);
		assertEquals(wv1a.get(W2)*2., wv1b.get(W2), .001);
		assertEquals(wv1a.get(W3)*Komponente1.getMenge(), wv1b.get(W3), .001);
		HashMap<Wirkungskategorie, Double> wv1c = Modul3.getWirkungsvektor(BM2);
		HashMap<Wirkungskategorie, Double> wv1d = Komponente1.getWirkungsvektor(BM2);
		assertEquals(1, wv1c.size());
		assertEquals(1, wv1d.size());
		assertEquals(wv1c.get(W2)*2., wv1d.get(W2), .001);		
	}
	
	@Test
	public void ProduktkomponenteTest2() {
		initialize1();
		initialize2();
		HashMap<Wirkungskategorie, Double> wv1a = Modul4.getWirkungsvektor(BM1);
		HashMap<Wirkungskategorie, Double> wv1b = Komponente2.getWirkungsvektor(BM1);
		assertEquals(3, wv1a.size());
		assertEquals(3, wv1b.size());
		assertEquals(wv1a.get(W1)*Komponente2.getMenge(), wv1b.get(W1), .001);
		assertEquals(wv1a.get(W2)*4., wv1b.get(W2), .001);
		assertEquals(wv1a.get(W3)*Komponente2.getMenge(), wv1b.get(W3), .001);
		HashMap<Wirkungskategorie, Double> wv1c = Modul4.getWirkungsvektor(BM2);
		HashMap<Wirkungskategorie, Double> wv1d = Komponente2.getWirkungsvektor(BM2);
		assertEquals(1, wv1c.size());
		assertEquals(1, wv1d.size());
		assertEquals(wv1c.get(W2)*4., wv1d.get(W2), .001);		
	}
	
	@Test
	public void ProduktkomponenteTest3() {
		initialize1();
		initialize2();
		HashMap<Wirkungskategorie, Double> wv1a = Gesamt.getWirkungsvektor(BM1);
		HashMap<Wirkungskategorie, Double> wv1b = Komponente3.getWirkungsvektor(BM1);
		assertEquals(3, wv1a.size());
		assertEquals(3, wv1b.size());
		assertEquals(wv1a.get(W1)*Komponente3.getMenge(), wv1b.get(W1), .001);
		assertEquals(wv1a.get(W2)*3., wv1b.get(W2), .001);
		assertEquals(wv1a.get(W3)*Komponente3.getMenge(), wv1b.get(W3), .001);
		HashMap<Wirkungskategorie, Double> wv1c = Gesamt.getWirkungsvektor(BM2);
		HashMap<Wirkungskategorie, Double> wv1d = Komponente3.getWirkungsvektor(BM2);
		assertEquals(1, wv1c.size());
		assertEquals(1, wv1d.size());
		assertEquals(wv1c.get(W2)*3., wv1d.get(W2), .001);		
	}
	
	@Test
	public void ProduktkomponenteTest4() {
		initialize1();
		initialize2();
		HashMap<Wirkungskategorie, Double> wv1a = PB1.getWirkungsvektor(BM1);
		HashMap<Wirkungskategorie, Double> wv1b = Komponente4.getWirkungsvektor(BM1);
		assertEquals(3, wv1a.size());
		assertEquals(3, wv1b.size());
		assertEquals(wv1a.get(W1)*Komponente4.getMenge(), wv1b.get(W1), .001);
		assertEquals(wv1a.get(W2)*5., wv1b.get(W2), .001);
		assertEquals(wv1a.get(W3)*Komponente4.getMenge(), wv1b.get(W3), .001);
		HashMap<Wirkungskategorie, Double> wv1c = PB1.getWirkungsvektor(BM2);
		HashMap<Wirkungskategorie, Double> wv1d = Komponente4.getWirkungsvektor(BM2);
		assertEquals(1, wv1c.size());
		assertEquals(1, wv1d.size());
		assertEquals(wv1c.get(W2)*5., wv1d.get(W2), .001);		
	}
	
	@Test
	public void ProduktkompositionTest1() {
		initialize1();
		initialize2();
		initialize3();
		HashMap<Wirkungskategorie, Double> wv = PK1.getWirkungsvektor(BM1);
		assertEquals(3, wv.size());
		assertEquals(2*42.+5*3., wv.get(W1), .001);
		assertEquals(2*(35.+0.15*42.)+5*5., wv.get(W2), .001);
		assertEquals(2*(6.+0.25*35.)+5*7., wv.get(W3), .001);
	}
}
